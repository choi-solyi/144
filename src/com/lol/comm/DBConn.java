package com.lol.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {
	private static DBConn instanse = new DBConn();
	public static DBConn getDB() {
		return instanse;
	}
	private DBConn() {}
	
/*	public Connection getConn() throws NamingException, SQLException {
		Context initctx = new InitialContext();
		DataSource ds = (DataSource)initctx.lookup("java:comp/env/jdbc/loling");
		Connection conn = ds.getConnection();
		System.out.println("dbconn-conn:" + conn);
		return conn;
	}
	*/
	
	public Connection getConn() throws NamingException, SQLException {
		Context initctx = new InitialContext();
		DataSource ds = (DataSource)initctx.lookup("java:comp/env/jdbc/jinwoo");
		Connection conn = ds.getConnection();
		System.out.println("dbconn-conn:" + conn);
		return conn;
	}
}
