package jp.ac.board.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jp.ac.board.dao.User;

public class Register {

	private ArrayList<String> errCode;
	
	public Register() {
		errCode = new ArrayList<>();
	}
	
	public boolean userRegister(HttpServletRequest request) {

		if(!Validation.create(request, "name", "require")) {
			errCode.add("ユーザ名が入力されていません。");
		}
		
		if(!Validation.create(request, "passwd", "require")) {
			errCode.add("パスワードが入力されていません。");
		}
		
		if(!Validation.create(request, "again_passwd", "require")) {
			errCode.add("確認用パスワードが入力されていません。");
		}

		if(!Validation.create(request, "passwd", "confirm")) {
			errCode.add("確認用パスワードが一致しません。");
		}
		
		if(!Validation.create(request, "gender", "require") || !Validation.create(request, "gender", "number")) {
			errCode.add("性別が不正な値です。");
		}
		
		if(errCode.isEmpty()) {
			User user = new User();
			user.setUserName(request.getParameter("name"));
			user.setPasswd(request.getParameter("passwd"));
			user.setSex(Integer.parseInt(request.getParameter("gender")));
			user.insert();
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<String> getErrCode() {
		return errCode;
	}
}
