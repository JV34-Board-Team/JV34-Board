package jp.ac.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Model {
	/**
	 * ���������s����N���X
	 * @param request �T�[�u���b�g���N�G�X�g
	 * @param response �T�[�u���b�g���X�|���X
	 * @return �J�ڐ��URL
	 */
	public String execute(HttpServletRequest 
			request,HttpServletResponse response);

}
