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
<h2>�Խñ� ����</h2>
<form action="BoardDeleteProcCtrl.do" method="post">
<table width=600 border=1 bgcolor="skyblue">

<tr height=40>
	<td width=120 align="center">�н�����</td>
	<td align="center" colspan="3"><input type="password" name="password" size=60></td>
</tr>
<tr height=40>
	<td align="center" colspan="4">
	<input type="hidden" name="num" value="${bean.num }">
	<input type="hidden" name="pass" value="${bean.password }">
	<input type="submit" value="�� ����">&nbsp;&nbsp;
	<input type="button" value="���" onclick="location.href='BoardList.jsp'">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>