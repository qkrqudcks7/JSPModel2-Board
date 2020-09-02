package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

/**
 * Servlet implementation class BoardUpdateProcCtrl
 */
@WebServlet("/BoardUpdateProcCtrl.do")
public class BoardUpdateProcCtrl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		reqPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		// 폼에서 넘어온 데이터를 받아줌 꼭 bean써서 안 받아도 됨
		int num=Integer.parseInt(request.getParameter("num"));
		String password=request.getParameter("password"); // 사용자로부터 입력받는 패스워드
		String pass=request.getParameter("pass"); // 실제 데이터베이스에 저장된 패스워드
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		// 패스워드 값과 패스 값을 비교함
		if(password.equals(pass)) {
			BoardDAO b= new BoardDAO();
			b.Update(num,subject,content);
			request.setAttribute("msg", "1");
			RequestDispatcher dis=request.getRequestDispatcher("BoardListCtl.do");
			dis.forward(request, response);
		}
		else {
			request.setAttribute("msg", "2");
			RequestDispatcher dis=request.getRequestDispatcher("BoardListCtl.do");
			dis.forward(request, response);
		}
	}

}
