package jp.ac.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Model {
	/**
	 * 処理を実行するクラス
	 * @param request サーブレットリクエスト
	 * @param response サーブレットレスポンス
	 * @return 遷移先のURL
	 */
	public String execute(HttpServletRequest 
			request,HttpServletResponse response);

}
