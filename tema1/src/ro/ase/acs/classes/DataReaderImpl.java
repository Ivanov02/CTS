package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataReaderImpl implements DataReader {
    private static final String ID = "id: ";
    private static final String ADDRESS = "address: ";
    private static final String SALARY = "id: ";


    @Override
    public void readData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);
        while(rs.next()) {
            int id = rs.getInt(ID);
            System.out.println("id: " + id);
            String name = rs.getString(2);
            System.out.println("name: " + name);
            String address = rs.getString(ADDRESS);
            System.out.println("address: " + address);
            double salary = rs.getDouble(SALARY);
            System.out.println("salary: " + salary);
        }
        rs.close();
        statement.close();
    }
}

