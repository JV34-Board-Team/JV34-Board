package jp.ac.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import jp.ac.board.*;
import jp.ac.hal.Model;

/**
 * Servlet implementation class BoardContoroller
 */
@WebServlet("/BoardContoroller")
public class BoardContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public BoardContoroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String methodType = request.getParameter("type");
		
		if(methodType.equals("login")){
			String id = "";
			String pass = "";
			id = request.getParameter("id");
			pass = request.getParameter("pass");
			boolean b = new Login(id,pass);
			request.setAttribute("status",b);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		} else if(methodType.equals("logout")){
			boolean b = new Logout();
			request.setAttribute("status",b);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else if(methodType.equals("register")){
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}else if(methodType.equals("posting")){
			String anchor = "";
			String comment = "";
			anchor = request.getParameter("anchor");
			comment = request.getParameter("comment");
			boolean b = new Post(anchor,comment);
			request.setAttribute("post_status",b);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
}
