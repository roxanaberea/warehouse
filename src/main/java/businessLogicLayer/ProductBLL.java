package businessLogicLayer;

import model.Product;
import start.Reflection;

import javax.swing.*;
import java.util.NoSuchElementException;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class ProductBLL {
    public ProductBLL() {
    }

    /**
     * @use gaseste un client din baza de date
     * @param id
     * @return
     */
    public Product findClientById(int id) {
        Product st = DAO.ProductDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * @use modifica un client din baza de date
     * @param f1
     * @param v1
     * @param identity_code
     */
    public void updP(String f1, String v1, int identity_code){
        DAO.ProductDAO.upd(f1, v1, identity_code);
    }

    /**
     * @use insereaza un client in baza de date
     * @param product
     * @return
     */
    public int insP(Product product) {
        return DAO.ProductDAO.ins(product);
    }

    /**
     * @use sterge un produs din baza de date
     * @param ID
     */
    public void delP(int ID){
        DAO.ProductDAO.del(ID);
    }

    /**
     * @use afiseaza produsele din baza de date pe baza tehnicii de reflection
     * @return
     */
    public JTable see(){
        return Reflection.retrieveProperties(DAO.ProductDAO.see());
    }
}

