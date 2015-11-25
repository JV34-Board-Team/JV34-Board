package jp.ac.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Board extends Dao {
	
	private String id;
	private String userName;
	private String comment;
	private String createdAt;
	private ResultSet result;
	
	
	public Board(String id, String userName, String comment, String createdAt) {
		super();
		this.id = id;
		this.userName = userName;
		this.comment = comment;
		this.createdAt = createdAt;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public ArrayList<Board> getAll() {
		ArrayList<Board> boards = new ArrayList<>();
		open();
		try {
			result = selectAll("SELECT * FROM v_board;");
			while(result.next()) {
				boards.add(new Board(
							result.getString("id"),
							result.getString("userName"),
							result.getString("comment"),
							result.getString("createdAt")
						));
			}
		} catch(SQLException e) {
			System.out.println("Board Bean : " + e.getMessage());
		} finally {
			close();
		}
		return boards;
	}
	
	public ArrayList<Board> getSelect(String where) {
		ArrayList<Board> boards = new ArrayList<>();
		open();
		try {
			result = selectWhere("SELECT * FROM v_board where userName=?;", where);
			while(result.next()) {
				boards.add(new Board(
							result.getString("id"),
							result.getString("userName"),
							result.getString("comment"),
							result.getString("createdAt")
						));
			}
		} catch(SQLException e) {
			System.out.println("Board Bean : " + e.getMessage());
		} finally {
			close();
		}
		return boards;
	}
}
