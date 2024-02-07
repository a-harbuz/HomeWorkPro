package de.telran.my001mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        //JDBC (Java Database Connectivity)
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");
//        // работа с базой данных
//        conn.close();
        String url = "jdbc:mysql://localhost:3306/music";
        String user = "root";
        String password = "Zxc123!@#";

        // Запрос SELECT
        String query = "SELECT * FROM tracks";

        try (
                // Подключение к базе данных
                Connection connection = DriverManager.getConnection(url, user, password);
                // Создание объекта для выполнения запросов
                Statement statement = connection.createStatement();
                // Выполнение запроса и получение результата
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            // Обработка результатов запроса
            while (resultSet.next()) {
                // Пример: получение значений из столбцов результата
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Дальнейшая обработка полученных данных
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
