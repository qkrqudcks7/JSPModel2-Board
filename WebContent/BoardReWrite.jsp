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
<h2>답변글 입력하기</h2>
<form action="BoardReWriteProcCtrl.do" method="post">
<table width=600 border=1 bgcolor="skyblue">
<tr height=40>
	<td width=150 align="center">작성자</td>
	<td width=450><input type="text" name="writer" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">제목</td>
	<td width=450><input type="text" name="subject" value="ㄴ[답글] " size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">이메일</td>
	<td width=450><input type="email" name="email" size=60></td>
</tr>
<tr height=40>
	<td width=150 align="center">비밀번호</td>
	<td width=450><input type="password" name="password" size=60></td>
</tr>
<tr height=100>
	<td width=150 align="center">글내용</td>
	<td width=450><textarea rows=10 cols=60 name="content"></textarea></td>
</tr>
<!-- form에서 사용자로부터 입력받지 않고 데이터를 넘김 -->
<tr height=40>
	<td align="center" colspan="2">
	<!-- num은 안 넘긴다. 왜녀하면 num은 답글이라도 자동증가라서 안 써도 됨  -->
	<input type="hidden" name="ref" value="${ref }">
	<input type="hidden" name="re_step" value="${re_step }">
	<input type="hidden" name="re_level" value="${re_level }">
	<input type="submit" value="답글 쓰기 완료">&nbsp;&nbsp;
	<input type="reset" value="취소">&nbsp;&nbsp;
	<input type="button" onclick="location.href='BoardListCtl.do'" value="전체 글 보기">
	</td>
</tr>
</table>
</form>
</center>
</body>
</html>