<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.ac.board.dao.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板(´・ω・`)</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<!-- =============== ヘッダー =============== -->
<div id="header">

	<h1>掲示板(´・ω・`)</h1>
	
	<ul id="menu">
		<!-- メニュー内容 -->
		<li>
		  <input type="checkbox" id="panel" class="onoff">
		  <form action="${pageContext.request.contextPath}/BoardController" method="POST">
		  	ID:<input type="text" name="id">
		  	PW:<input type="password" name="pass">
		  	<input type="submit" value="ログイン">
		  <input type="hidden" name="type" value="login">
		  </form>
		  <form action="${pageContext.request.contextPath}/BoardController" method="POST"">
		  <input type="submit" value="ログout">
		  <input type="hidden" name="type" value="logout">
		  </form>
		</li><br>
		<li><a href="${pageContext.request.contextPath}/BoardController?type=registerpage">新規登録</a></li>
		<li>
			<form action="#" method="POST" style="display:inline"><input type="text" name="search">
				<input type="submit" value="検索">
			</form>
		</li>
	</ul>
	
</div>

<!-- =============== メイン =============== -->

<div id="board_main">
	<%
	ArrayList<Board> boards = (ArrayList<Board>)request.getAttribute("boards");
	if(boards != null && boards.size() > 0) {
		for(Board board:boards) {
	%>
	<!-- コメント -->
	<div class="res">
		<div class="res_head">
			<span class="res_number"><%= board.getBoardId() %></span>:
			<span class="res_name"><%= board.getUserName() %></span>
		</div>
		<div class="res_body">
			<p><%= board.getComment() %></p>
		</div>
		<div class="res_foot">
			<span class="res_day"><%= board.getCreatedAt() %></span>
		</div>
	</div>
	<%
		}
	} else {
	%>
	<div class="res">
	<p>投稿はありません</p>
	</div>
	<%
	}
	%>
<!-- =============== フッター =============== -->
<div id="footer">

	<div id="comment_form">
		<form action="${pageContext.request.contextPath}/BoardController" method="post">
			アンカー:<input type="number" name="anchor"><br />
			コメント:<input type="text" name="comment" id="post_comment">	<br />
			<input type="hidden" name="type" value="posting">
			<input type="submit" name="action" value="投稿">
		</form>
	</div>

</div>

</body>
</html>