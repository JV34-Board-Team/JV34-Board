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
	
	final private String url = "localhost";
	final private String userName = "root";
	final private String passWord = "root";
	
	protected void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected ResultSet selectAll(String query) {
		try {
			state = conn.createStatement();
			result = state.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected ResultSet selectWhere(String query, String where) {
		try {
			prepare = conn.prepareStatement(query);
			prepare.setString(1, where);
			result = prepare.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	protected int insert(String query, Dao model) {
		int ret = 0;
		try {
			prepare = conn.prepareStatement(query);
			if(model instanceof Board) {
				prepare.setInt(1, ((Board)model).getUserId());
				prepare.setString(2, ((Board)model).getUserName());
				prepare.setString(3, ((Board)model).getComment());
			} else if(model instanceof User) {
				prepare.setString(1, ((User)model).getUserName());
				prepare.setInt(2, ((User)model).getSex());
			}
			ret = prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	protected void close() {
		try {
			if(result != null) {
				result.close();
			}
			if(prepare != null) {
				prepare.close();
			}
			if(state != null) {
				state.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
