package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataInserter;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.TableCreator;

import java.sql.SQLException;

public class DatabaseManager {
    private TableCreator tableCreator;
    private DataInserter dataInserter;
    private DataReader dataReader;

    public DatabaseManager(TableCreator tableCreator, DataInserter dataInserter, DataReader dataReader) {
        this.tableCreator = tableCreator;
        this.dataInserter = dataInserter;
        this.dataReader = dataReader;
    }

    public void createTable() throws SQLException {
        tableCreator.createTable();
    }

    public void insertData() throws SQLException {
        dataInserter.insertData();
    }

    public void readData() throws SQLException {
        dataReader.readData();
    }
}