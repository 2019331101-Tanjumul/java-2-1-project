package com.example.mahin;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class logsDB {
    private static logsDB instance = null;

    private Connection connection;
    private Statement statement;

    private logsDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Sustcse_19");
            statement = connection.createStatement();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public static logsDB getInstance() {
        if (instance == null) {
            instance = new logsDB();
        }

        return instance;
    }
}
