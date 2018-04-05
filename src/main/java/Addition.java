import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Addition extends JFrame {
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;
    private JTable table1;

    private static final String url = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String user = "root";
    private static final String password = "belax";

    public Addition() {
        super("Add to database");
        this.setBounds(0, 0, 400, 500);
        this.getContentPane().add(panel1);
        button1.addActionListener(new MyButtonListener());
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String str1, str2, str3, str4, str5, str6;
            str1 = textField1.getText();
            str2 = textField2.getText();
            str3 = textField3.getText();
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
            } catch (SQLException e) {
                System.out.printf("Can`t make driver");
            }
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                String query=("INSERT INTO users (name, age, email) VALUES ('" + str1 + "','" + str2 + "','" + str3 + "')");
                statement.execute(query);
                textField1.setText(null);
                textField2.setText(null);
                textField3.setText(null);
                //statement.execute("DELETE FROM users WHERE id=8");
                System.out.printf("It`s good");
            } catch (SQLException e) {
                System.out.printf("Can`t connection driver");
            }
        }

    }
}
