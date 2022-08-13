package model.dto;

public class ProjectsByClassDTO {
    private int id;
    private String builder;
    private int roomsNumber;
    private String city;

    public ProjectsByClassDTO() {
    }

    public ProjectsByClassDTO(int id, String builder, int roomsNumber, String city) {
        this.id = id;
        this.builder = builder;
        this.roomsNumber = roomsNumber;
        this.city = city;
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
    public int getRoomsNumber() {
        return roomsNumber;
    }
    /*
    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }
    */
    public String getCity() {
        return city;
    }
    /*
    public void setCity(String city) {
        this.city = city;
    }
    */
}
