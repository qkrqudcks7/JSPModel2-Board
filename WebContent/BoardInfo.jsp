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
<h2>게시글 보기</h2>
<table width=600 border=1 bgcolor="skyblue">
<tr height=40>
	<td align="center" width=120>글번호</td>
	<td align="center" width=180>${bean.num }</td>
	<td align="center" width=120>조회수</td>
	<td align="center" width=180>${bean.readcount }</td>
</tr>
<tr height=40>
	<td align="center" width=120>작성자</td>
	<td align="center" width=180>${bean.writer }</td>
	<td align="center" width=120>작성일</td>
	<td align="center" width=180>${bean.reg_date }</td>
</tr>
<tr height=40>
	<td align="center" width=120>이메일</td>
	<td align="center" colspan="3">${bean.email }</td>
</tr>
<tr height=40>
	<td align="center" width=120>제목</td>
	<td align="center" colspan="3">${bean.subject }</td>
</tr>
<tr height=100>
	<td align="center" width=120>글 내용</td>
	<td align="center" colspan="3">${bean.content }</td>
</tr>
<tr height=40>
	<td align="center" colspan="4">												<!--ref re_step 등등 다 기억하고 넘겨줘야 되므로  --> <!-- 근데 꼭 이렇게 get방식으로 안 해도 되고 다음 페이지에서 받아와도 됨  -->
	<input type="button" value="답글쓰기" onclick="location.href='BoardReWriteCtrl.do?num=${bean.num }&ref=${bean.ref }&re_step=${bean.re_step }&re_level=${bean.re_level }'">
	<input type="button" value="수정하기" onclick="location.href='BoardUpdateCtrl.do?num=${bean.num }'">
	<input type="button" value="삭제하기" onclick="location.href='BoardDeleteCtrl.do?num=${bean.num }'">
	<input type="button" value="목록보기" onclick="location.href='BoardListCtl.do'">
	</td>
	
</tr>
</table>
</center>
</body>
</html>