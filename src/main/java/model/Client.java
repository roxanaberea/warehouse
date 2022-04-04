package model;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class Client {
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    public Client(int ID, String firstName, String lastName, int age){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * @use getter pentru ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * @use getter pentru age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * @use getter pentru first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @use getter pentru last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }
}

