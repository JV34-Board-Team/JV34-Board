package jp.ac.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.board.*;

/**
 * Servlet implementation class BoardContoroller
 */
@WebServlet("/BoardContoroller")
public class BoardContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
//	private HashMap<String,Model> map;
	
    public BoardContoroller() {
        super();
        // TODO Auto-generated constructor stub
//        map = new HashMap<String, Model>();
//        //keyÇuriÇ…ÇµÇƒêÿÇËï™ÇØÇÈÇÒÇ‚Ç≈(ÉjÉbÉRÉä)
//        map.put("/FrontControl/control/add", new Add());
//        map.put("/FrontControl/control/sub", new Sub());
//        map.put("/FrontControl/control/mult", new Mult());
//        map.put("/FrontControl/control/div", new Div());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String methodType = request.getParameter("type");
		//
		if(methodType.equals("login")){
			
		} else if(methodType.equals("logout")){
			
		}else if(methodType.equals("register")){
			
		}else if(methodType.equals("posting")){
			
		}
	}
}
