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
<table width=600 border=1 bgcolor="skyblue">
<tr height=40>
	<td align="center" width=120>�۹�ȣ</td>
	<td align="center" width=180>${bean.num }</td>
	<td align="center" width=120>��ȸ��</td>
	<td align="center" width=180>${bean.readcount }</td>
</tr>
<tr height=40>
	<td align="center" width=120>�ۼ���</td>
	<td align="center" width=180>${bean.writer }</td>
	<td align="center" width=120>�ۼ���</td>
	<td align="center" width=180>${bean.reg_date }</td>
</tr>
<tr height=40>
	<td align="center" width=120>�̸���</td>
	<td align="center" colspan="3">${bean.email }</td>
</tr>
<tr height=40>
	<td align="center" width=120>����</td>
	<td align="center" colspan="3">${bean.subject }</td>
</tr>
<tr height=100>
	<td align="center" width=120>�� ����</td>
	<td align="center" colspan="3">${bean.content }</td>
</tr>
<tr height=40>
	<td align="center" colspan="4">												<!--ref re_step ��� �� ����ϰ� �Ѱ���� �ǹǷ�  --> <!-- �ٵ� �� �̷��� get������� �� �ص� �ǰ� ���� ���������� �޾ƿ͵� ��  -->
	<input type="button" value="��۾���" onclick="location.href='BoardReWriteCtrl.do?num=${bean.num }&ref=${bean.ref }&re_step=${bean.re_step }&re_level=${bean.re_level }'">
	<input type="button" value="�����ϱ�" onclick="location.href='BoardUpdateCtrl.do?num=${bean.num }'">
	<input type="button" value="�����ϱ�" onclick="location.href='BoardDeleteCtrl.do?num=${bean.num }'">
	<input type="button" value="��Ϻ���" onclick="location.href='BoardListCtl.do'">
	</td>
	
</tr>
</table>
</center>
</body>
</html>