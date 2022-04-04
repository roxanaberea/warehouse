package model;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class Order {
    private int ID;
    private int clientID;
    private int productID;
    private int quantity;
    public Order(int ID, int clientID, int productID, int quantity){
        this.ID = ID;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    /**
     * @use getter pentru quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @use getter pentru ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @use getter pentru clientID
     * @return
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @use getter pentru productID
     * @return
     */
    public int getProductID() {
        return productID;
    }
}

