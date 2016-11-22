package base.components;

import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.components.SelectTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by bulat.garipov on 04.03.2016.
 */
public class Diagnosis extends SelectTree {
    private static final String OPEN_FLAG_SELECTOR=".n2o-std-open-flag";

    public Diagnosis(ApplicationManager app, WebElement parent, String id) {
        super(app, parent, id);
    }

    /*
    * Выбор значения
    * метод back() вызывается для очистки сохраненного значения при открытии записи на редактирование
    * */
    public void setValue(List<String> nodesName){
        open();
        back();
        chooseNode(nodesName);
        clickOk();
    }

    public void searchValue(String nodesName) {
        open();
        findElement(By.id("n2o-std-typeahead-search"), takeContainer()).clear();
        sleep(3);
        findElement(By.id("n2o-std-typeahead-search"), takeContainer()).sendKeys(nodesName);
        waitForNetworkAndJsIdle();
        chooseNode(nodesName, true);
        clickOk();
    }

    private void back()
    {
        //click(findElement(By.cssSelector(".n2o-std-tree-back"), takeContainer()));
        while (findElements(By.cssSelector(".n2o-std-open-flag.open"), takeContainer()).size()>0) {
            List<WebElement> elements = findElements(By.cssSelector(".n2o-std-open-flag.open"), takeContainer());
            click(elements.get(elements.size()-1));
        }
    }

    /*
    * Выбор диагноза, если диагноз с характеристиками, то по умолчанию выбираются первые значения всех характеристик.
    * @param names    последовательность названий узлов которые надо открыть чтобы выбрать диагноз, последнее значение диагноз
    * */
    @Override
    public void chooseNode(List<String> names) {
        chooseNode(names, true);
    }

    @Override
    public void chooseNode(List<String> names, boolean isSelected) {
        if (names.size() == 0 || names == null) {
            return;
        }
        if (names.size() > 1) {
            openNode(this.takeContainer(), names.get(0));
            WebElement parent = getNode(names.get(0));
            for (int i = 1; i < names.size() - 1; i++) {
                openNode(parent, names.get(i), names.get(i-1));
                parent = getNode(getNode(names.get(i-1)), names.get(i));
            }
            chooseNode(parent, names.get(names.size() - 1), isSelected);
        } else {
            chooseNode(names.get(0), isSelected);
        }
    }

    @Override
    public void openNode(WebElement parent, String name) {
        parent.getTagName();
        Boolean open = true;
        WebElement root = getNode(parent, name);
        waitForNetworkAndJsIdle();
        WebElement i = findElement(By.cssSelector(OPEN_FLAG_SELECTOR), root);
        Pattern pattern = Pattern.compile("\\sopen");
        Matcher matcher = pattern.matcher(i.getAttribute("class"));
        if (matcher.find() != open) {
            click(i);
            root = getNode(parent, name);
            i = findElement(By.cssSelector(OPEN_FLAG_SELECTOR), root);
            Matcher matcher1 = pattern.matcher(i.getAttribute("class"));
            assertThat("Error open/close node", matcher1.find(), is(open));
        }
    }

    private void openNode(WebElement parent, String name, String pname) {
        Boolean open = true;
        WebElement root = getNode(parent, name);
        waitForNetworkAndJsIdle();
        WebElement i = findElement(By.cssSelector(OPEN_FLAG_SELECTOR), root);
        Pattern pattern = Pattern.compile("\\sopen");
        Matcher matcher = pattern.matcher(i.getAttribute("class"));
        if (matcher.find() != open) {
            click(i);
            parent = getNode(pname);
            root = getNode(parent, name);
            i = findElement(By.cssSelector(OPEN_FLAG_SELECTOR), root);
            Matcher matcher1 = pattern.matcher(i.getAttribute("class"));
            assertThat("Error open/close node", matcher1.find(), is(open));
        }
    }

    @Override
    public void chooseNode(WebElement parent, String name, Boolean isSelected) {
        WebElement root = getNode(parent, name);
        WebElement a = findElement(By.cssSelector("a"), root);
        click(a);
    }

    public void clickOk(){
        if(this.isOpen()) {
            click(getOkButton());
        }
        this.assertSelectOpened(false);
    }

    private WebElement getOkButton() {
        return this.findElement(By.cssSelector(".n2o-std-tree-save"), this.takeContainer());
    }
}
