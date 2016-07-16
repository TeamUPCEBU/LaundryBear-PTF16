package teamgwapro.laundrybear_ptf16.models;

import java.util.List;

/**
 * Created by coderschool on 7/5/16.
 */
public class Transaction {
    private int id;
    private int paws;
    private int status;
    private String requestDate;
    private String deliveryDate;
    private String province;
    private String city;
    private String barangay;
    private String street;
    private String building;
    private String price;
    private int client;
    private List<Order> orders;
    private int fee;
    private String comment;



    //trial constructor, delete when api is done
    public Transaction(int id,int status,String shop, String requestDate, String deliveryDate, int fee, String price){
        this.id = id;
        this.status = status;
        this.requestDate = requestDate;
        this.deliveryDate = deliveryDate;
        this.fee = fee;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
