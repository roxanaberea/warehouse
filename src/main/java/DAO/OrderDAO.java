package DAO;

import connection.ConnectionFactory;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Roxana Berea
 * @Since: 27.06.2021
 */
public class OrderDAO {

    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO orders (ID,clientID,productID,quantity)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM orders where id = ?";
    private final static String selectAllString = "SELECT * FROM orders";

    /**
     * @use gaseste un order din baza de date
     * @param orderID
     * @return
     */
    public static Order findById(int orderID) {
        Order toReturn = null;

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, orderID);
            rs = findStatement.executeQuery();
            rs.next();

            int ID = rs.getInt("ID");
            int clientID = rs.getInt("clientID");
            int productID = rs.getInt("productID");
            int quantity = rs.getInt("quantity");
            toReturn = new Order(ID, clientID, productID, quantity);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @use insereaza un order in baza de date
     * @param order
     * @return
     */
    public static int ins(Order order) {
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, order.getID());
            insertStatement.setInt(2, order.getClientID());
            insertStatement.setInt(3, order.getProductID());
            insertStatement.setInt(4, order.getQuantity());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @use modifica un order din baza de date
     * @param field
     * @param value
     * @param ID
     */
    public static void upd(String field, String value, int ID) {
        String editStatementString = "UPDATE " + "orders" + " SET " + field + " = ? WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, value);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use sterge un order din baza de date
     * @param ID
     */
    public static void del(int ID) {
        String editStatementString = "DELETE FROM orders" + " WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use afiseaza orders din baza de date
     * @return
     */
    public static List<Object> see()
    {
        Order toReturn = null;
        List<Object> or = new ArrayList<>();

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(selectAllString);
            rs = findStatement.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("ID");
                int clientID = rs.getInt("clientID");
                int productID = rs.getInt("productID");
                int quantity = rs.getInt("quantity");
                toReturn = new Order(ID,clientID, productID, quantity);
                or.add(toReturn);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return or;
    }
}

