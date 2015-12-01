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
/**
 * Servlet implementation class BoardContoroller
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String respPage = "/WEB-INF/board/index.jsp";
		String methodType = request.getParameter("type");
	
		if("registerpage".equals(methodType) && methodType != null) {
				respPage = "/WEB-INF/board/member_reg.jsp";
		}
		
		request.getRequestDispatcher(respPage).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String methodType = "hogehoge";
		if(request.getParameter("type") != null && request.getParameter("type").isEmpty()){
			methodType = request.getParameter("type");
		}
		if(methodType.equals("login")){
//			String id = "";
//			String pass = "";
//			if(request.getParameter("id") != null && request.getParameter("id").isEmpty()){
//				id = request.getParameter("id");
//			}
//			if(request.getParameter("pass") != null && request.getParameter("pass").isEmpty()){
//				pass = request.getParameter("pass");
//			}
//			boolean b = new Login(id,pass);
//			request.setAttribute("status",b);
//			request.getRequestDispatcher("/WEB-INF/board/index.jsp").forward(request,response);
		} else if(methodType.equals("logout")){
//			boolean b = new Logout();
//			request.setAttribute("status",b);
//			request.getRequestDispatcher("/WEB-INF/board/index.jsp").forward(request,response);
		}else if(methodType.equals("register")){
			
			request.getRequestDispatcher("/WEB-INF/board/member_reg.jsp").forward(request,response);
		}else if(methodType.equals("posting")){
//			
//			String anchor = (request.getParameter("anchor") != null && request.getParameter("anchor").isEmpty()) ?
//					request.getParameter("anchor") : "";
//			String comment = (request.getParameter("comment") != null && request.getParameter("comment").isEmpty()) ?
//					request.getParameter("comment") : "";
//
//			boolean b = new Post(anchor, comment, request);
//			request.setAttribute("post_status",b);
//			request.getRequestDispatcher("/WEB-INF/board/index.jsp").forward(request,response);

		}else if(methodType.equals("search")){
//			String searchwd = "";
//			if(request.getParameter("searchwd") != null && request.getParameter("searchwd").isEmpty()){
//				searchwd = request.getParameter("searchwd");
//			}
//		boolean b = new Search(searchwd);
//		request.setAttribute("search_status",b);
//		request.getRequestDispatcher("/WEB-INF/board/index.jsp").forward(request,response);
		}else{
//		request.getRequestDispatcher("/WEB-INF/board/index.jsp").forward(request,response);
		}
	}
}
