package jp.ac.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class Dao {

	private Connection conn;
	private Statement state;
	private PreparedStatement prepare;
	private ResultSet result;
	
	public void open(String url, String userName, String passWord) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, userName, passWord);
	}
	
	protected ResultSet selectAll(String query) throws SQLException {
		state = conn.createStatement();
		result = state.executeQuery(query);
		return result;
	}
	
	protected ResultSet selectWhere(String query, String where) throws SQLException {
		prepare = conn.prepareStatement(query);
		prepare.setString(1, where);
		result = prepare.executeQuery();
		return result;
	}
}
