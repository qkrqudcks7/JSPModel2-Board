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
		// ���� �������� �ִ� �������� �ѹ� ���� ���� , �翬�� �� ó������ ���� x
		String pageNum=request.getParameter("pageNum");
		// ���� nulló��
		if(pageNum==null) {
			pageNum="1"; // ���� ������ 1
		}
		// ȭ�鿡 ������ �Խñ� ���� ����
		int pageSize=10;
		// ��ü �Խñ��� ������ �ľ�
		int count=0;
		// jsp������ ������ ������ �ҹ��� ���� ���� �����ϴ� ����
		int number=0;
		// ���� �������� �ִ� ������ ���ڸ� ���ڷ� ����
		int currentPage=Integer.parseInt(pageNum);
		// ��ü �Խñ� ������ �����;� �ϱ⿡, DB ��ü ����
		BoardDAO b= new BoardDAO();
		count=b.getAllCount();
		
		// ���� ������ ������ ���� ��ȣ�� �����Ѵ�.
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		
		// �ֽű� 10�� �������� �Խñ��� ���� �޾��ִ� �޼ҵ� ȣ��
		Vector<BoardBean> v= b.getAllBoard(startRow,endRow);
		// ȭ�鿡 ������ number ����
		number=count-(currentPage-1)*pageSize;
		
		////////////////////////���� ������ ��й�ȣ Ʋ�ȴٸ� 
		String msg=(String)request.getAttribute("msg");
		
		/////////////////////////////////BoardList.jsp ������ request ��ü�� ��Ƽ� �Ѱ���
		
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
