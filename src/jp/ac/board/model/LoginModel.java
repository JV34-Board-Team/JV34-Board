package jp.ac.board.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginModel {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		//���N�G�X�g�̕����R�[�h�ݒ�
		request.setCharacterEncoding("UTF-8");
		
		//���N�G�X�g������͕����擾
		String getString = request.getParameter("input");
		
		//���͂̊m�F
		if(getString == null || getString.isEmpty()){
			getString = "���͂���Ă��܂���";
		}
		
		//���X�|���X�̃R���e���c����ѕ����R�[�h�ݒ�
		response.setContentType("text/html;charset=UTF-8");
		
		//���X�|���X�o�̓I�u�W�F�N�g�쐬
		PrintWriter out = response.getWriter();
	}
}
