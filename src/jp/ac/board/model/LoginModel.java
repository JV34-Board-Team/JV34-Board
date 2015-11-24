package jp.ac.board.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginModel {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		//リクエストの文字コード設定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストから入力文字取得
		String getString = request.getParameter("input");
		
		//入力の確認
		if(getString == null || getString.isEmpty()){
			getString = "入力されていません";
		}
		
		//レスポンスのコンテンツおよび文字コード設定
		response.setContentType("text/html;charset=UTF-8");
		
		//レスポンス出力オブジェクト作成
		PrintWriter out = response.getWriter();
	}
}
