

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;

/**
 * Servlet implementation class adminValidate
 */
public class adminValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminValidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		AdminDAO dao = new AdminDAO();

		try {

			boolean value = dao.validateAdmin(userEmail, userPassword);

			if(value)
			{
				response.sendRedirect("adminHomePage.jsp");
			}
			else
			{
				response.sendRedirect("failedLogin.jsp");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}





}
