

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Admin;
import com.pojo.User;
import com.dao.AdminDAO;
import com.dao.UserDAO;

/**
 * Servlet implementation class RegisterNewUser
 */
public class RegisterNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterNewUser() {
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
		
		UserDAO dao = new UserDAO();
		User user = new User();
		
		user.setUserName(request.getParameter("username"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserPassword(request.getParameter("password"));
		
		int recordRow = dao.addUser(user);
		if(recordRow>0)
		{
			response.sendRedirect("login.jsp");			
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}
		
		
	

}
