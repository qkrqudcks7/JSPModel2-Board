<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>게시글 쓰기</h2>
<form action="BoardWriteProcCtrl.do" method="post">
<table width=600 border=1 bordercolor="gray" bgcolor="skyblue">
<tr height=40>
	<td width=150 align="center">작성자</td>
	<td width=450><input type="text" name="writer" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">제목</td>
	<td width=450><input type="text" name="subject" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">이메일</td>
	<td width=450><input type="email" name="email" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">비밀번호</td>
	<td width=450><input type="password" name="password" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">글 내용</td>
	<td width=450><textarea rows=10 cols=60 name="content"></textarea></td>
</tr>
<tr height=40>
	<td align="center" colspan=2>
		<input type="submit" value="글 쓰기"> &nbsp;&nbsp;
		<input type="reset" value="다시 작성"> &nbsp;&nbsp;
		<button onclick="location.href='BoardListCtl.do'">전체 게시글 보기</button>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>