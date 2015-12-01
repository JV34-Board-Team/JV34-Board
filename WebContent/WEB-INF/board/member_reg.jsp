<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員登録</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reg_style.css" type="text/css">
</head>
<body>

<!-- =============== ヘッダー =============== -->
<div id="header">

	<h1>掲示板(´・ω・`)</h1>

</div>


<!-- =============== メイン =============== -->

<div id="reg_main">
	<h2>会員登録</h2>
	
	<!-- 情報を入力するフォーム -->
	<form action="${pageContext.request.contextPath}/BoardController" method="POST" name="form">
		<table class="reg_information">
			<tr>
				<th>ユーザー名</th>
				<td><input type="text" name="name" size="30"></td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="ID">
				</td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="passwd" id="passwd"></td>
			</tr>
			<tr>
				<th>パスワード再入力</th>
				<td><input type="password" name="again_passwd" id="again_passwd"></td>
			</tr>
			<tr>
				<th>性別</th>
				<td>
					<input type="radio" name="gender" value="0">男性
					<input type="radio" name="gender" value="1">女性
				</td>
			</tr>
		</table>
			
		<div id="submit_button">
			<p><input type="submit" value="登録"></p>
		</div>
		
	</form>
</div>


<!-- =============== フッタ =============== -->




</body>
</html>