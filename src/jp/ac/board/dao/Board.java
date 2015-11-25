package jp.ac.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Board extends Dao {
	
	private int id;
	private int userId;
	private String userName;
	private String comment;
	private String createdAt;
	
	public Board(int id, int userId, String userName, String comment, String createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.comment = comment;
		this.createdAt = createdAt;
	}
	
	
	public ArrayList<Board> getAll() {
		ArrayList<Board> boards = new ArrayList<>();
		open();
		try {
			ResultSet result = selectAll("SELECT * FROM v_board;");
			while(result.next()) {
				boards.add(new Board(
							result.getInt("id"),
							result.getInt("userid"),
							result.getString("username"),
							result.getString("comment"),
							result.getString("createdat")
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
			ResultSet result = selectWhere("SELECT * FROM v_board where userName=?;", where);
			while(result.next()) {
				boards.add(new Board(
							result.getInt("id"),
							result.getInt("userid"),
							result.getString("username"),
							result.getString("comment"),
							result.getString("createdat")
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
