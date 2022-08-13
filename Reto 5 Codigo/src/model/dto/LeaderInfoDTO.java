package model.dto;

public class LeaderInfoDTO {
    private int id;
    private String name;
    private String firstLastName;
    private String residence;

    public LeaderInfoDTO() {
    }
    
    public LeaderInfoDTO(int id, String name, String firstLastName, String residence) {
        this.id = id;
        this.name = name;
        this.firstLastName = firstLastName;
        this.residence = residence;
    }
    
    public int getId() {
        return id;
    }
    /*
    public void setId(int id) {
        this.id = id;
    }
    */
    public String getName() {
        return name;
    }
    /*
    public void setName(String name) {
        this.name = name;
    }
    */
    public String getFirstLastName() {
        return firstLastName;
    }
    /*
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }
    */
    public String getResidence() {
        return residence;
    }
    /*
    public void setResidence(String residence) {
        this.residence = residence;
    } 
    */
}
