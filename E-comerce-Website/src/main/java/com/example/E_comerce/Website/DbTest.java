package com.example.E_comerce.Website;

import java.sql.DriverManager;



public class DbTest {

	 public static void main(String[] args) {
	        String jdbcUrl = "jdbc:mysql://localhost:3306/shop";
	        String username = "root";
	        String password = "1234567@";
	       

	        try {
	            // Establish a connection to the database
	        	 DriverManager.getConnection(jdbcUrl, username, password);

	            // You can now use 'connection' to interact with the database

	            // Don't forget to close the connection when done
	            System.out.println("Db CONNECTED");
	        } catch (Exception e) {
	            System.err.println("Database connection error");
	            e.printStackTrace();
	        }
	    }
	}

