package DAO;

import connection.ConnectionFactory;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Roxana Berea
 * @Since: 27.06.2021
 */
public class ProductDAO {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO product (ID,name,price,quantity)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM product where id = ?";
    private final static String selectAllString = "SELECT * FROM product";

    /**
     * @use gaseste un produs din baza de date pe baza id ului
     * @param productID
     * @return
     */
    public static Product findById(int productID) {
        Product toReturn = null;

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, productID);
            rs = findStatement.executeQuery();
            rs.next();

            int ID = rs.getInt("ID");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");
            toReturn = new Product(ID, name, price, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @use insereaza un produs in baza de date
     * @param product
     * @return
     */
    public static int ins(Product product) {
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, product.getID());
            insertStatement.setString(2, product.getName());
            insertStatement.setInt(3, product.getPrice());
            insertStatement.setInt(4, product.getQuantity());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @use modifica un produs din baza de date
     * @param field
     * @param value
     * @param ID
     */
    public static void upd(String field, String value, int ID) {
        String editStatementString = "UPDATE " + "product" + " SET " + field + " = ? WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, value);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use sterge un produs din baza de date
     * @param ID
     */
    public static void del(int ID) {
        String editStatementString = "DELETE FROM product" + " WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use afiseaza produsele din baza de date
     * @return
     */
    public static List<Object> see()
    {
        Product toReturn = null;
        List<Object> products = new ArrayList<>();

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(selectAllString);
            rs = findStatement.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                toReturn = new Product(ID,name,price, quantity);
                products.add(toReturn);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return products;
    }
}
