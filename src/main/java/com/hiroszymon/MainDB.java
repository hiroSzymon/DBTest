package com.hiroszymon;

import org.postgresql.Driver;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDB {
    private static DataSource ds;

    static {
        try {
            //This line causes the app to fail with org.postgresql:postgresql >= 42.2.13
            Class.forName("org.postgresql.Driver");
            System.out.println(Driver.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public static void main(String[] args) throws SQLException {
        //Just a placeholder to check if anything works
        ds= new PGSimpleDataSource();
        Connection c = ds.getConnection("postgres", "postgres");
        Statement s = c.createStatement();
        s.execute("select * from information_schema.tables");
        System.out.println(s.getResultSet());
    }
}
