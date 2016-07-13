package teamgwapro.laundrybear_ptf16.models;

/**
 * Created by coderschool on 7/5/16.
 */
public class Service {
    private int id;
    private String name;
    private String description;
    private int price;
    private LaundryShop laundryShop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LaundryShop getLaundryShop() {
        return laundryShop;
    }

    public void setLaundryShop(LaundryShop laundryShop) {
        this.laundryShop = laundryShop;
    }
}
