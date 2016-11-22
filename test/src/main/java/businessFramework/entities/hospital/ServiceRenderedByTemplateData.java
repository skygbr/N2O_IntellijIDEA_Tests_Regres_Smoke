package businessFramework.entities.hospital;

import java.util.List;

/**
 * Created by bulat.garipov on 01.02.2016.
 */
public class ServiceRenderedByTemplateData {
    private String bdate;
    private String template;
    private List<String> serviceNameList;
    private List<String> columnNameList;

    public ServiceRenderedByTemplateData() {
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<String> getServiceNameList() {
        return serviceNameList;
    }

    public void setServiceNameList(List<String> serviceNameList) {
        this.serviceNameList = serviceNameList;
    }

    public List<String> getColumnNameList() {
        return columnNameList;
    }

    public void setColumnNameList(List<String> columnNameList) {
        this.columnNameList = columnNameList;
    }
}
