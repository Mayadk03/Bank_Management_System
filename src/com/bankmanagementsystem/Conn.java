package com.bankmanagementsystem;

import java.lang.classfile.CodeBuilder.CatchBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {
Connection con;
PreparedStatement stmt;
String url = "jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=system";
public Conn() {
	try {
		con = DriverManager.getConnection(url);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
