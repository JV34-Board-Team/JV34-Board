package jp.ac.board.model;

import javax.servlet.http.HttpServletRequest;

public class Validation {

	public static boolean create(HttpServletRequest request, String key, String rule) {
		
		switch(rule) {
			case "require":
				if(request.getParameter(key) == null || request.getParameter(key).isEmpty())
					return false;
				break;
				
			case "number":
				if(!request.getParameter(key).matches("[0-9]+"))
					return false;
				break;
				
			case "confirm":
				if(!request.getParameter(key).equals(request.getParameter("again_" + key)))
					return false;
		}
		return true;
	}
}
