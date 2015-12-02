package jp.ac.board.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jp.ac.board.dao.Board;

public class Search {

	public Search() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public boolean search(String searchwd,HttpServletRequest request){
		Board board = new Board();
		ArrayList<Board> searchboard = board.getSelect(searchwd);
		request.setAttribute("boards", searchboard);
		return true;
	}
}
