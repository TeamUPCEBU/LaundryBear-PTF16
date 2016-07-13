package teamgwapro.laundrybear_ptf16.models;

import java.util.List;

/**
 * Created by coderschool on 7/13/16.
 */
public class Order {
    private int id;
    private int transaction;
    private int pieces;
    private List<Service> serviceList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaction() {
        return transaction;
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
