package Shared;

public class Flat {
    @Id
    private int flatId;
    private String district;
    private String address;
    private int area;
    private int roomsNumber;
    private int price;

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatId='" + flatId + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", roomsNumber=" + roomsNumber +
                ", price=" + price +
                '}';
    }

    public Flat(){

    }

    public Flat(int flatId, String district, String address, int area, int roomsNumber, int price) {
        this.flatId = flatId;
        this.district = district;
        this.address = address;
        this.area = area;
        this.roomsNumber = roomsNumber;
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
