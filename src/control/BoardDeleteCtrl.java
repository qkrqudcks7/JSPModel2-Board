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
 * Servlet implementation class BoardDeleteCtrl
 */
@WebServlet("/BoardDeleteCtrl.¾Ö")
public class BoardDeleteCtrl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		reqPrc(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPrc(request, response);
	}
	protected void reqPrc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardDAO b= new BoardDAO();
		BoardBean bean=b.getOneUpdate(num);
		
		request.setAttribute("bean", bean);
		RequestDispatcher dis=request.getRequestDispatcher("BoardDelete.jsp");
		dis.forward(request, response);
	}

}
