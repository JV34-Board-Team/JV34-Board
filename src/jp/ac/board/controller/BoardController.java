package jp.ac.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jp.ac.board.*;
import jp.ac.board.dao.Board;
import jp.ac.board.dao.User;
import jp.ac.board.model.Login;
import jp.ac.board.model.Register;
import jp.ac.board.model.Search;
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
		
		Board board = new Board();
		ArrayList<Board> boards = board.getAll();
		request.setAttribute("boards", boards);
	
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
		String respPage = "/WEB-INF/board/index.jsp";
		Login login = new Login();
		Search search = new Search();
		
		if(request.getParameter("type") != null && !request.getParameter("type").isEmpty()){
			methodType = request.getParameter("type");
		}
		
		if(methodType.equals("login")){
			
			int id = 0;
			String pass = "";
			if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
				id = Integer.parseInt(request.getParameter("id"));
			}
			if(request.getParameter("pass") != null && !request.getParameter("pass").isEmpty()){
				pass = request.getParameter("pass");
			}
			boolean b = login.login(id, pass, request);
			System.out.println(b);
			request.setAttribute("status",b);
			
			
		} else if(methodType.equals("logout")){
			
			boolean b = login.logout(request);
			System.out.println(b);
			request.setAttribute("status",b);

		}else if(methodType.equals("register")){
			
			Register register = new Register();
			boolean flg = register.userRegister(request);
			if(flg) {
				User user = new User();
				ArrayList<User> users = user.getAll();
				request.setAttribute("msg", new ArrayList<String>(Arrays.asList("登録が完了しました！あなたのIDは" + users.size() + "です")));

			} else {
				request.setAttribute("msg", register.getErrCode());
			}
			
			respPage = "/WEB-INF/board/member_reg.jsp";
		
		}else if(methodType.equals("posting")){

			String anchor = (request.getParameter("anchor") != null && !request.getParameter("anchor").isEmpty()) ?
					request.getParameter("anchor") : "";
			String comment = (request.getParameter("comment") != null && !request.getParameter("comment").isEmpty()) ?
					request.getParameter("comment") : "";
					
			HttpSession session = request.getSession();
			if(session.getAttribute("User") != null) {
				Post post = new Post();
				boolean b = post.insertPost(anchor, comment, request);
			} else {
				request.setAttribute("msg", new ArrayList<String>(Arrays.asList("ログインしてください。")));
			}
			
		}else if(methodType.equals("search")){
			String searchwd = "";
			if(request.getParameter("searchwd") != null && request.getParameter("searchwd").isEmpty()){
				searchwd = request.getParameter("searchwd");
			}
		boolean b = search.search(searchwd, request);
		request.setAttribute("search_status",b);
		}
		
		Board board = new Board();
		ArrayList<Board> boards = board.getAll();
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher(respPage).forward(request,response);
	}
}
