package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class BoardListCtl
 */
@WebServlet("/BoardListCtl.do")
public class BoardListCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		// 현재 보여지고 있는 페이지의 넘버 값을 읽음 , 당연히 맨 처음에는 값이 x
		String pageNum=request.getParameter("pageNum");
		// 따라서 null처리
		if(pageNum==null) {
			pageNum="1"; // 따라서 페이지 1
		}
		// 화면에 보여질 게시글 개수 지정
		int pageSize=10;
		// 전체 게시글의 개수를 파악
		int count=0;
		// jsp페이지 내에서 보여질 넙버링 숫자 값을 저장하는 변수
		int number=0;
		// 현재 보여지고 있는 페이지 문자를 숫자로 변형
		int currentPage=Integer.parseInt(pageNum);
		// 전체 게시글 개수를 가져와야 하기에, DB 객체 생성
		BoardDAO b= new BoardDAO();
		count=b.getAllCount();
		
		// 현재 보여질 페이지 시작 번호를 설정한다.
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		
		// 최신글 10개 기준으로 게시글을 리턴 받아주는 메소드 호출
		Vector<BoardBean> v= b.getAllBoard(startRow,endRow);
		// 화면에 보여질 number 설정
		number=count-(currentPage-1)*pageSize;
		
		////////////////////////수정 삭제시 비밀번호 틀렸다면 
		String msg=(String)request.getAttribute("msg");
		
		/////////////////////////////////BoardList.jsp 쪽으로 request 객체에 담아서 넘겨줌
		
		request.setAttribute("v", v);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("msg", msg);

		
		RequestDispatcher dis=request.getRequestDispatcher("BoardList.jsp");
		dis.forward(request, response);
	}

}
