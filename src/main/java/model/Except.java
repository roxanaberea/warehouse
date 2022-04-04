package model;

/**
 * @Author Roxana Berea
 * @date 27.06.2021
 */
public class Except extends Exception{

    public Except(String a)
    {
        super(a);
    }
    public Except()
    {
        super("Nu e bine");
    }
}

