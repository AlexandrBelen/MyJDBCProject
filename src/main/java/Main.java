import java.sql.*;


public class Main {
    private Connection connection;
    private Driver driver;

    public static void main(String[] args) {
        Addition addition=new Addition();
        addition.pack();
        addition.setSize(500,450);
        addition.setVisible(true);
    }
}
