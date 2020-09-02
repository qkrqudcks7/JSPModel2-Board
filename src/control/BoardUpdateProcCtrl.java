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
		// ������ �Ѿ�� �����͸� �޾��� �� bean�Ἥ �� �޾Ƶ� ��
		int num=Integer.parseInt(request.getParameter("num"));
		String password=request.getParameter("password"); // ����ڷκ��� �Է¹޴� �н�����
		String pass=request.getParameter("pass"); // ���� �����ͺ��̽��� ����� �н�����
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		// �н����� ���� �н� ���� ����
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
