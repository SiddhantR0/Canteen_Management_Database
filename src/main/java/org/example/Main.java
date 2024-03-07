package org.example;

import org.example.models.Food;
import org.example.models.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String CANTEEN_TABLE = "canteen";
    public static final String ACCOUNT_ID = "id";
    public static final String NAME = "name";
    public static final String FOOD_PRICE = "price";
    public static final String FOOD_QUANTITY = "quantity";
    public static void main(String[] args) {


        Food f1 = new Food("Keema Noodles",200, 1);

        String url = "jdbc:sqlite:canteen.db";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + CANTEEN_TABLE + "( id integer PRIMARY KEY NOT NULL," +
                " name text," +
                " price integer," +
                " quantity integer);";

        System.out.println(createTableSQL);

        String insertRecordSQL = "INSERT INTO " + CANTEEN_TABLE + "(name, price, quantity) values(?,?,?)";
        System.out.println(insertRecordSQL);

        String selectData = "SELECT * FROM " + CANTEEN_TABLE;
        System.out.println(selectData);

        try {

            Connection c = DriverManager.getConnection(url);
            System.out.println("Connected");

            Statement stm = c.createStatement();
            stm.execute(createTableSQL);


            PreparedStatement preparedStatement = c.prepareStatement(insertRecordSQL);

            preparedStatement.setString(1, f1.getName());
            preparedStatement.setDouble(2, f1.getFoodPrice());
            preparedStatement.setInt(3, f1.getQuantity());


            preparedStatement.execute();
            System.out.println("Inserted");
            List<Food> foodList = new ArrayList<>();
            ResultSet rs = stm.executeQuery(selectData);
            while (rs.next()) {
                int id = rs.getInt(ACCOUNT_ID);
                String name = rs.getString(NAME);
                int price = rs.getInt(FOOD_PRICE);
                String quantity  = rs.getString(FOOD_QUANTITY);

                foodList.add(f1);

            }

            c.close();
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }
}

