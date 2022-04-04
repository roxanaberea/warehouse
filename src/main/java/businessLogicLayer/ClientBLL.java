package businessLogicLayer;

import model.Client;
import start.Reflection;

import javax.swing.*;
import java.util.NoSuchElementException;

/**
 * @Author Roxana Berea
 * @Date 27.06.2021
 */
public class ClientBLL {
    public ClientBLL() {
    }

    /**
     * @use gaseste o inregistrare de tip client din baza de date pe baza id ului
     * @param id
     * @return
     */
    public Client findClientById(int id) {
        Client st = DAO.ClientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return st;
    }

    /**
     * @use modifica valorea specificata de campul f1 cu valoarea specificata de campul v1 ,pentru a gasi inregistrarea dorita se foloseste campul code_identity
     * @param f1
     * @param v1
     * @param code_identity
     */
    public void upC(String f1, String v1, int code_identity){
        DAO.ClientDAO.upd(f1, v1, code_identity);
    }

    /**
     * @use insereaza un client in baza de date
     * @param client
     * @return
     */
    public int insC(Client client) {
        return DAO.ClientDAO.ins(client);
    }

    /**
     * @use sterge un client din baza de date
     * @param ID
     */
    public void delC(int ID){
        DAO.ClientDAO.del(ID);
    }

    /**
     * @use afiseaza clientii din baza de date cu tehnica de reflection
     * @return
     */
    public JTable see(){
        return Reflection.retrieveProperties(DAO.ClientDAO.see());
    }
}

