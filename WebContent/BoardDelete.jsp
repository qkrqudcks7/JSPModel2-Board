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
<h2>게시글 삭제</h2>
<form action="BoardDeleteProcCtrl.do" method="post">
<table width=600 border=1 bgcolor="skyblue">

<tr height=40>
	<td width=120 align="center">패스워드</td>
	<td align="center" colspan="3"><input type="password" name="password" size=60></td>
</tr>
<tr height=40>
	<td align="center" colspan="4">
	<input type="hidden" name="num" value="${bean.num }">
	<input type="hidden" name="pass" value="${bean.password }">
	<input type="submit" value="글 삭제">&nbsp;&nbsp;
	<input type="button" value="취소" onclick="location.href='BoardList.jsp'">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>