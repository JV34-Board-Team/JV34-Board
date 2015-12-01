<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板(´・ω・`)</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<!-- =============== ヘッダー =============== -->
<div id="header">

	<h1>掲示板(´・ω・`)</h1>
	
	<ul id="menu">
		<!-- メニュー内容 -->
		<li>
		  <input type="checkbox" id="panel" class="onoff">
		  <form action="" method="POST">
		  	ID:<input type="text" name="userid">
		  	PW:<input type="text" name="userpw">
		  	<input type="submit" value="ログイン">
		  </form>
		</li><br />
		<li><a href="t_member_reg.jsp">新規登録</a></li>
		<li>
			<form action="#" method="POST" style="display:inline"><input type="text" name="search">
				<input type="submit" value="検索">
			</form>
		</li>
	</ul>
	
</div>

<!-- =============== メイン =============== -->

<div id="board_main">

	<!-- コメント -->
	<div class="res">
		<div class="res_head">
			<span class="res_number">1</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">2</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">3</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">3</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">3</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">3</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">3</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>コメント</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
	
	<div class="res">
		<div class="res_head">
			<span class="res_number">4</span>:
			<span class="res_name">投稿者名</span>
		</div>
		<div class="res_body">
			<p>最後</p>
		</div>
		<div class="res_foot">
			<span class="res_day">投稿日</span>
		</div>
	</div>
</div>
	
<!-- =============== フッター =============== -->
<div id="footer">

	<div id="comment_form">
		<form action="">
			<div id="comment_an">アンカー:<input type="number" name="anchor"></div>
			<div id="comment_co">コメント:<input type="text" name="comment" id="post_comment"></div>
			<input id="post_button" type="submit" name="action" value="投稿">
		</form>
	</div>

</div>

</body>
</html>