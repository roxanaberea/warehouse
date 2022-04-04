package DAO;

import connection.ConnectionFactory;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: Roxana Berea
 * @Since: 27.06.2021
 */
public class ClientDAO {

    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (ID,firstName,lastName,age)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where id = ?";
    private final static String selectAllString = "SELECT * FROM client";

    /**
     * @use gaseste un client pe baza id ului
     * @param studentId
     * @return
     */
    public static Client findById(int studentId) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

            int ID = rs.getInt("ID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int age = rs.getInt("age");
            toReturn = new Client(ID, firstName, lastName, age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @use insereaza un client in baza de date
     * @param client
     * @return
     */
    public static int ins(Client client) {
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getID());
            insertStatement.setString(2, client.getFirstName());
            insertStatement.setString(3, client.getLastName());
            insertStatement.setInt(4, client.getAge());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @use modifica un client din baza de date
     * @param field
     * @param value
     * @param ID
     */
    public static void upd(String field, String value, int ID) {
        String editStatementString = "UPDATE " + "client" + " SET " + field + " = ? WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, value);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use sterge un client din baza de date
     * @param ID
     */
    public static void del(int ID) {
        String editStatementString = "DELETE FROM client" + " WHERE id = " + ID;
        Connection dbConnection = ConnectionFactory.getCon();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * @use afiseaza clientii din baza de date
     * @return
     */
    public static List<Object> see()
    {
        Client toReturn = null;
        List<Object> cs = new ArrayList<>();

        Connection dbConnection = ConnectionFactory.getCon();
        PreparedStatement findStatement = null;
        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(selectAllString);
            rs = findStatement.executeQuery();
            while(rs.next()) {
                int ID = rs.getInt("ID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                toReturn = new Client(ID, firstName, lastName, age);
                cs.add(toReturn);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return cs;
    }
}

