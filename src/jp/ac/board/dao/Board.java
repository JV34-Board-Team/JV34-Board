package jp.ac.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Board extends Dao {
	
	private int boardId;
	private int userId;
	private String userName;
	private String comment;
	private String createdAt;
	

	public Board() {}
	
	public Board(int boardId, int userId, String userName, String comment, String createdAt) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.userName = userName;
		this.comment = comment;
		this.createdAt = createdAt;
	}

	
	
	public int getBoardId() {
		return boardId;
	}



	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
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
			ResultSet result = selectAll("SELECT * FROM board;");
			while(result.next()) {
				boards.add(new Board(
							result.getInt("boardId"),
							result.getInt("userId"),
							result.getString("userName"),
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
			ResultSet result = selectWhere("SELECT * FROM board where username=?;", where);
			while(result.next()) {
				boards.add(new Board(
							result.getInt("boardId"),
							result.getInt("userId"),
							result.getString("userName"),
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
	
	public int insert() {
		open();
		int ret = 0;
		
		ret = insert("INSERT INTO board(userId, userName, comment) values(?,?,?);",
				((Dao)new Board(getBoardId(), getUserId(), getUserName(), getComment(), getCreatedAt())));
		
		return ret;
	}
}
