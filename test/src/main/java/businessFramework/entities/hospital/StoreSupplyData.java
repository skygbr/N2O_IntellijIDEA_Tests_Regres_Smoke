package businessFramework.entities.hospital;

public class StoreSupplyData {
    private String holdingName;
    private String comGroup;
    private String fundingSource;
    private int balance;
    private String storeName;

    public String getHoldingName() {
        return holdingName;
    }

    public void setHoldingName(String holdingName) {
        this.holdingName = holdingName;
    }

    public String getComGroup() {
        return comGroup;
    }

    public void setComGroup(String comGroup) {
        this.comGroup = comGroup;
    }

    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
