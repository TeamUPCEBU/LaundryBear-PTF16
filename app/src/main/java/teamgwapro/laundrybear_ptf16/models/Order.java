package teamgwapro.laundrybear_ptf16.models;

/**
 * Created by coderschool on 7/13/16.
 */
public class Order {
    private int id;
    private Service service;
    private int transaction;
    private int pieces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
}
