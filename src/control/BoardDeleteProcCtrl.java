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
 * Servlet implementation class BoardDeleteProcCtrl
 */
@WebServlet("/BoardDeleteProcCtrl.do")
public class BoardDeleteProcCtrl extends HttpServlet {
	
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
		// 사용자로부터 넘어온 데이터 3개를 받아줌
		int num=Integer.parseInt(request.getParameter("num"));
		String password=request.getParameter("password");
		String pass=request.getParameter("pass");
		
		if(password.equals(pass)) {
			BoardDAO b= new BoardDAO();
			b.delete(num);
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
