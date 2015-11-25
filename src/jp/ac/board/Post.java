package jp.ac.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.ac.board.dao.*;

public class Post {

	public boolean Post(String anchor, String comment, HttpServletRequest request) {
		return insertPost(anchor, comment, request);
	}
	
	private boolean insertPost(String anchor, String comment, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Board board = new Board(0, user.getUserId(), user.getUserName(), comment, "");
		int ret = board.insert();
		
		if(ret > 0) {
			return true;
		} else {
			return false;
		}
	}
}
