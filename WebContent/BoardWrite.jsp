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
<form action="BoardWriteProcCtrl.do" method="post">
<table width=600 border=1 bordercolor="gray" bgcolor="skyblue">
<tr height=40>
	<td width=150 align="center">�ۼ���</td>
	<td width=450><input type="text" name="writer" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">����</td>
	<td width=450><input type="text" name="subject" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">�̸���</td>
	<td width=450><input type="email" name="email" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">��й�ȣ</td>
	<td width=450><input type="password" name="password" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">�� ����</td>
	<td width=450><textarea rows=10 cols=60 name="content"></textarea></td>
</tr>
<tr height=40>
	<td align="center" colspan=2>
		<input type="submit" value="�� ����"> &nbsp;&nbsp;
		<input type="reset" value="�ٽ� �ۼ�"> &nbsp;&nbsp;
		<button onclick="location.href='BoardListCtl.do'">��ü �Խñ� ����</button>
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>