package businessLogicLayer;

import java.io.FileWriter;
import java.io.IOException;
public class FileWriterr {

    public static void bill(model.Order order)
    {
        FileWriter myWriter;
        try {
            String filename = "C:\\PT2021_30226_Berea_Roxana_Assignment_3\\src\\main\\resources\\bill.txt";
            myWriter = new FileWriter(filename);
            myWriter.write("ID: " + order.getID()+" client ID: " + order.getClientID() + " product ID: " + order.getProductID() + " quantity: " + order.getQuantity());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
