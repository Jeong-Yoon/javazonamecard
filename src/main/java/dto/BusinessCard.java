package dto;

public class BusinessCard {
    private int id;
    private String name;
    private String phone;
    private String corporationName;

    public BusinessCard() {
    }

    public BusinessCard(String name, String phone, String corporationName) {
        this.name = name;
        this.phone = phone;
        this.corporationName = corporationName;
    }

    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //corporationName
    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    @Override
    public String toString() {
        return "BusinessCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", corporationName='" + corporationName + '\'' +
                '}';
    }
}
