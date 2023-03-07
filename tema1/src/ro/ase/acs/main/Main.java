package ro.ase.acs.main;

import ro.ase.acs.classes.DataInserterImpl;
import ro.ase.acs.classes.DataReaderImpl;
import ro.ase.acs.classes.TableCreatorImpl;
import ro.ase.acs.interfaces.DataInserter;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.TableCreator;
import java.sql.Connection;
import java.sql.DriverManager;


//pare ok
public class Main {
    private static final String  CONEXIUNE = "jdbc:sqlite:database.db";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONEXIUNE);
            connection.setAutoCommit(false);

            TableCreator tableCreator = new TableCreatorImpl();
            tableCreator.createTable(connection);

            DataInserter dataInserter = new DataInserterImpl();
            dataInserter.insertData(connection);

            DataReader dataReader = new DataReaderImpl();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}