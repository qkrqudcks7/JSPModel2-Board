<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${msg==2 }">
	<script>
		alert("비밀번호가 일치하지 않습니다.")
		history.go(-1)
	</script>
</c:if>
<center>
<h2>전체 글보기</h2>
<table width=700 border=1>
<tr height=40>
	<td align="right" colspan="5">
	<button onclick="location.href='BoardWrite.jsp'">글 쓰기</button>
	</td>
</tr>
<tr height=40>
	<td width=50 align="center">번호</td>
	<td width=320 align="center">제목</td>
	<td width=100 align="center">작성자</td>
	<td width=150 align="center">작성일</td>
	<td width=70 align="center">조회수</td>
</tr>
<c:set var="number" value="${number }"></c:set>
<c:forEach var="bean" items="${v }">
	<tr height=40>
		<td width=50 align="center">${number }</td>
		<td width=320 align="left">
			<c:if test="${bean.re_step>1 }">
			<c:forEach var="j" begin="1" end="${(bean.re_step-1)*5 }">
				&nbsp;
			</c:forEach>
			</c:if>
			<a href="BoardInfoControl.do?num=${bean.num }">
			${bean.subject }
			</a>
		</td>
		<td width=100 align="center">${bean.writer }</td>
		<td width=150 align="center">${bean.reg_date }</td>
		<td width=70 align="center">${bean.readcount }</td>
	</tr>
	<c:set var="number" value="${number-1 }"></c:set>
</c:forEach>
</table>
<p>
<!--페이지 카운터링 소스 작성  -->
<c:if test="${count>0 }">
	<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0 ? 0:1) }"></c:set>
	<c:set var="startPage" value="${1 }"></c:set>
	<c:if test="${currentPage%10 !=0 }">
		<!-- 결과를 int로 리턴 받아야 하기에 fmt태그 사용 -->
		<fmt:parseNumber var="result" value="${currentPage/10 }" integerOnly="true"></fmt:parseNumber> <!-- result라고 선언 -->
		<c:set var="startPage" value="${result*10+1 }"></c:set>
	</c:if>
	<c:if test="${currentPage%10 ==0 }">
		<!-- 결과를 int로 리턴 받아야 하기에 fmt태그 사용 -->
		<c:set var="startPage" value="${(result-1)*10+1 }"></c:set>
	</c:if>
	
	<!--화면에 보여질 페이지 처리 숫자를 표현  -->
	<c:set var="pageBlock" value="${10 }"></c:set>
	<c:set var="endPage" value="${startPage+pageBlock-1 }"></c:set>
	
	<c:if test="${endPage>pageCount }">
		<c:set var="endPage" value="${pageCount }"></c:set>
	</c:if>
	
	<!-- 이전 링크를 걸지 파악 -->
	<c:if test="${startPage>10 }">
		<a href="BoardListCtl.do?pageNum=${startPage-10 }">[이전] </a>
	</c:if>
	
	<!--페이징 처리  -->
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<a href="BoardListCtl.do?pageNum=${i } ">[${i }]</a>
	</c:forEach>
	
	<!-- 다음 링크  -->
	<c:if test="${endPage<pageCount }">
		<a href="BoardListCtl.do?pageNum=${startPage+10 }">[다음]</a>
	</c:if>
</c:if>
</center>
</body>
</html>