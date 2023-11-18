

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.query.Query;
import org.hibernate.Session;
import com.dbUtil.DbUtil;
import com.pojo.User;
import com.dao.UserDAO;


/**
 * Servlet implementation class loginValidate
 */
public class loginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginValidate() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{


		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		UserDAO dao = new UserDAO();
		
		try {

			boolean value = dao.validateUser(userEmail, userPassword);

			if( value==true)
			{
				response.sendRedirect("userHomePage.jsp");
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


