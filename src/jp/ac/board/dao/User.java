package jp.ac.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User extends Dao {
	
	private int userId;
	private String userName;
	private String passwd;
	private int sex;
	private String createdat;
	
	public User() {
	}

	public User(int userId, String userName, String passwd ,int sex, String createdat) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passwd = passwd;
		this.sex = sex;
		this.createdat = createdat;
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
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	
	public ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<>();
		open();
		try {
			ResultSet result = selectAll("SELECT * FROM t_user;");
			while(result.next()) {
				users.add(new User(
							result.getInt("id"),
							result.getString("username"),
							result .getString("passwd"),
							result.getInt("sex"),
							result.getString("createdat")
						));
			}
		} catch(SQLException e) {
			System.out.println("User Bean : " + e.getMessage());
		} finally {
			close();
		}
		return users;
	}
	
	public ArrayList<User> getSelect(String where) {
		ArrayList<User> users = new ArrayList<>();
		open();
		try {
			ResultSet result = selectWhere("SELECT * FROM t_user where username=?;", where);
			while(result.next()) {
				users.add(new User(
							result.getInt("id"),
							result.getString("username"),
							result.getString("passwd"),
							result.getInt("userid"),
							result.getString("createdat")
						));
			}
		} catch(SQLException e) {
			System.out.println("User Bean : " + e.getMessage());
		} finally {
			close();
		}
		return users;
	}
	
	public int insert(User user) {
		Dao model = user;
		return insert("INSERT INTO t_user('username', 'password','sex') values(?,?,?);", model);
	}
}
