package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class BoardInfoControl
 */
@WebServlet("/BoardInfoControl.do")
public class BoardInfoControl extends HttpServlet {
	
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
		
		// number값을 리턴
		int num=Integer.parseInt(request.getParameter("num"));
		BoardDAO b= new BoardDAO();
		
		// 하나의 게시글에 대한 정보를 리턴
		
		BoardBean bean=b.getOneBoard(num);
		
		request.setAttribute("bean", bean);
		
		// jsp쪽으로 데이터 넘기기
		RequestDispatcher dis=request.getRequestDispatcher("BoardInfo.jsp");
		dis.forward(request, response);
	}
	

}
