package ro.ase.acs.main;

import ro.ase.acs.classes.DataInserterImpl;
import ro.ase.acs.classes.DataReaderImpl;
import ro.ase.acs.classes.TableCreatorImpl;
import ro.ase.acs.interfaces.DataInserter;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.TableCreator;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            TableCreator tableCreator = new TableCreatorImpl(connection);
            tableCreator.createTable();

            DataInserter dataInserter = new DataInserterImpl(connection);
            dataInserter.insertData();

            DataReader dataReader = new DataReaderImpl(connection);
            dataReader.readData();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}