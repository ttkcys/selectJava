package jdbcıntro;

import java.sql.*;
import java.util.ArrayList;

public class JdbcIntro {

    static String userName = "root";
    static String password = "Yusudhan11.99*";
    static String dbUrl = "jdbc:mysql://localhost:3306/world";

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select code,name,continent,region from country");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("continent"),
                        resultSet.getString("region")));
            }
            System.out.println(countries.size());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }

}
