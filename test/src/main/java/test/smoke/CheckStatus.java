package test.smoke;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.base.DevToolsClient.Protocol.NetworkEvent.NetworkEventActor;
import net.framework.autotesting.meta.Page;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import javax.net.ssl.SSLContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckStatus
{

    ApplicationManager app;
    Page page;
    boolean is504 = false;

    public CheckStatus()
    {
        this.app    = ApplicationManager.getInstance();
        this.page   = Page.getInstance();
    }

    /**
     * Проверка статуса страницы
     */
    public void checkHTTPStatus(DebugLogs debugLogs)
    {
        debugLogs.chechHTTPStatusStarted();

        HttpContext context          = new BasicHttpContext();
        BasicCookieStore cookieStore = new BasicCookieStore();
        String url                   = app.getProperty("baseUrl");

        HttpGet httpget = new HttpGet(url);
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).setSslcontext(SSLContext.getDefault()).setDefaultCookieStore(cookieStore).build())
        {
            try (CloseableHttpResponse currentResponse = httpClient.execute(httpget, context))
            {
                int statusCode = currentResponse.getStatusLine().getStatusCode();
                EntityUtils.consume(currentResponse.getEntity());

                if (statusCode >= 400)
                {
                    Date nowDate            = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String nowDateString    = format.format(nowDate);

                    debugLogs.forUrlStatusCode(url, statusCode);
                    throw new Exception(String.format("status code is %s \n Time: %s", statusCode, nowDateString));
                }
            }
        }
        catch (Exception e)
        {
            debugLogs.checkHTTPStatusException(e);
            throw new RuntimeException(e);
        }

        debugLogs.chechHTTPStatusEnded();
    }

    /**
     * Проверка статуса страницы.
     */
    public void checkPageStatus(DebugLogs debugLogs) throws Exception
    {
        debugLogs.checkPageStatusStarted();

        List<NetworkEventActor> networkEventActors  = app.getActor().getNetworkEventActorsCopy();
        List<String> messages                       = new ArrayList<String>();

        for (NetworkEventActor actor : networkEventActors)
        {
            actor.waitForCompletion(new Date(new Date().getTime() + 100 * 1000));

            int statusCode      = actor.getResponseStatusCode();
            boolean isAction    = actor.initialInfo.url.contains("data?actionId") && actor.initialInfo.method.equals("POST");

            // in testing
            if (statusCode == 504)
            {
                is504 = true;
            }

            boolean isError = isAction
                    ? statusCode > 400 // 400 пропускаем, т.к. data?actionId возвращает 400 в случае предупреждений
                    : statusCode >= 400;

            //Игнорируются ошибки momentary-messages т.к. на тестовых стендах регионов их регулярно не настраивают
            if (isError && !actor.initialInfo.url.contains("messenger/momentary-messages"))
            {
                debugLogs.errorCheckPageStatus(statusCode);
                messages.add(String.format("Error loading url %s (method %s): status code = %d", actor.initialInfo.url, actor.initialInfo.method, statusCode));
            }
        }

        if (messages.size() > 0)
        {
            StringBuilder message = new StringBuilder();

            for (String value: messages)
            {
                if (message.length() > 0)
                {
                    message.append(", ");
                }
                message.append(value);
            }

            Assert.fail(message.toString());
            debugLogs.errorAfterAssertPageStatus(message);

            throw new Exception(message.toString());
        }
        debugLogs.checkPageStatusEnded();

    }
}
