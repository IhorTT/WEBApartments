package net.ukr.tigor.entity;

import net.ukr.tigor.daoService.Id;

public class Flat {
    @Id
    private int id;
    private String district;
    private String address;
    private double price;
    private double area;
    private int roomsCount;

    public Flat() {
    }

    public Flat(String district, String address, double price, double area, int roomsCount) {
        this.district = district;
        this.address = address;
        this.price = price;
        this.area = area;
        this.roomsCount = roomsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", roomsCount=" + roomsCount +
                '}';
    }
}
