package jp.ac.board.model;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.ac.board.dao.*;


public class Login {
	private int id;
	private String passwd;
	private HttpServletRequest request;
	
	public Login(){
		
	}
	
	public Login(int id,String passwd,HttpServletRequest request) {
		this.id = id;
		this.passwd = passwd;
		this.request = request;
	}
	
	public boolean login(){
		User user = new User();
		ArrayList<User> users = user.getAll();
		for(User u : users){
			if(id == u.getUserId()){
				if(passwd.equals(u.getPasswd())){
					HttpSession session = request.getSession();
					session.setAttribute("User", u);
					return true;
				}
			}			
		}
		return false;
	}
	
	public boolean logout(){
		HttpSession session = request.getSession();
		session.removeAttribute("User");
		return false;
	}

}
