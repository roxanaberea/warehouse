package start;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class Reflection {
    /**
     * @use genereaza un JTable cu ajutorul metodei reflection asupra obiectelor din baza de date
     * @param objects
     * @return
     */
    public static JTable retrieveProperties(List<Object> objects) {
        String[] fs = new String[4];
        Object d[][] = new Object[objects.size()][4];
        int i = 0;
        for (Field field : objects.get(0).getClass().getDeclaredFields()) {
            fs[i] = field.getName();
            i++;
        }
        i = 0;
        for (i = 0; i < objects.size(); i++) {
            int j = 0;
            for (Field ye : objects.get(i).getClass().getDeclaredFields()) {
                ye.setAccessible(true); // set modifier to public
                Object vu;
                try {
                    vu = ye.get(objects.get(i));
                    d[i][j] = vu;
                    j++;

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        JTable dadada = new JTable(d,fs);
        return dadada;
    }
}
