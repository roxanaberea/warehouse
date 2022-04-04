package model;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class Product {
    private int ID;
    private int price;
    private int quantity;
    private String name;
    public  Product(int ID, String name, int price, int quantity){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @use getter pentru ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @use getter pentru price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * @use getter pentru quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @use getter pentru name
     * @return
     */
    public String getName() {
        return name;
    }
}

