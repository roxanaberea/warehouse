package businessLogicLayer;

import model.Except;
import model.Order;
import model.Product;
import start.Reflection;

import javax.swing.*;
import java.util.NoSuchElementException;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class OrderBLL {
    public OrderBLL() {
    }

    /**
     * @use gaseste un order pe baza id ului
     * @param id
     * @return
     */
    public Order findOrderById(int id) {
        Order st = DAO.OrderDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * @use modifica valoarea precizata de campul f1 cu valoarea precizata de campul v1,pentru a gasi orderul se foloseste campul code_identity
     * @param f1
     * @param v1
     * @param code_identity
     */
    public void upO(String f1, String v1, int code_identity){
        DAO.OrderDAO.upd(f1, v1, code_identity);
    }

    /**
     * @use insereaza un order in baza de date
     * @param order
     * @return
     */
    public int insO(Order order) {
        FileWriterr.bill(order);
        Product daTata = DAO.ProductDAO.findById(order.getProductID());
        if(daTata.getQuantity()<order.getQuantity())
        {
            try {
                throw new Except("Nu se poate comanda mai multa cantitate decat e deja in stoc");
            } catch (Except except) {
                except.printStackTrace();
            }
        }
        else {
            DAO.ProductDAO.upd("quantity", String.valueOf(daTata.getQuantity() - order.getQuantity()), order.getProductID());
            return DAO.OrderDAO.ins(order);
        }

        return -1;
    }

    /**
     * @use sterge un order din baza de date
     * @param ID
     */
    public void delO(int ID){
        DAO.OrderDAO.del(ID);
    }
    public JTable see(){
        return Reflection. retrieveProperties(DAO.OrderDAO.see());
    }
}

