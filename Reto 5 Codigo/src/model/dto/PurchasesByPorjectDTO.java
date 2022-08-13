package model.dto;

public class PurchasesByPorjectDTO {
    private int id;
    private String builder;
    private String linkedBank;

    public PurchasesByPorjectDTO() {
    }
    
    public PurchasesByPorjectDTO(int id, String builder, String linkedBank) {
        this.id = id;
        this.builder = builder;
        this.linkedBank = linkedBank;
    }
    
    public int getId() {
        return id;
    }
    /*
    public void setId(int id) {
        this.id = id;
    }
    */
    public String getBuilder() {
        return builder;
    }
    /*
    public void setBuilder(String builder) {
        this.builder = builder;
    }
    */
    public String getLinkedBank() {
        return linkedBank;
    }
    /*
    public void setLinkedBank(String linkedBank) {
        this.linkedBank = linkedBank;
    }
    */
}
