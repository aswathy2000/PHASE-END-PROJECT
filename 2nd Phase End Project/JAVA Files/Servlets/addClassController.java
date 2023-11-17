

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ClassDAO;
import com.project.pojo.Classes;

/**
 * Servlet implementation class addClassController
 */
public class addClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addClassController() {
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
		
		
		ClassDAO dao = new ClassDAO();
		Classes classes = new Classes();
		
		
		classes.setClassName(request.getParameter("className"));
		int recordRow = dao.addClasses(classes);
		if(recordRow>0){
			response.sendRedirect("dashboard.jsp");			
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	
	}

}
