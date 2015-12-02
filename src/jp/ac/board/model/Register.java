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
			errCode.add("繝ｦ繝ｼ繧ｶ蜷阪′蜈･蜉帙＆繧後※縺�∪縺帙ｓ縲�");
		}
		
		if(!Validation.create(request, "passwd", "require")) {
			errCode.add("繝代せ繝ｯ繝ｼ繝峨′蜈･蜉帙＆繧後※縺�∪縺帙ｓ縲�");
		}
		
		if(!Validation.create(request, "again_passwd", "require")) {
			errCode.add("遒ｺ隱咲畑繝代せ繝ｯ繝ｼ繝峨′蜈･蜉帙＆繧後※縺�∪縺帙ｓ縲�");
		}

		if(!Validation.create(request, "passwd", "confirm")) {
			errCode.add("遒ｺ隱咲畑繝代せ繝ｯ繝ｼ繝峨′荳��縺励∪縺帙ｓ縲�");
		}
		
		if(!Validation.create(request, "gender", "require") || !Validation.create(request, "gender", "number")) {
			errCode.add("諤ｧ蛻･縺御ｸ肴ｭ｣縺ｪ蛟､縺ｧ縺吶�");
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
