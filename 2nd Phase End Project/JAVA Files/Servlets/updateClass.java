

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ClassDAO;
import com.project.pojo.Classes;

/**
 * Servlet implementation class updateClass
 */
public class updateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateClass() {
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
		
		int classID = Integer.parseInt(request.getParameter("id"));
			
		classes.setClassId(classID);
		
		String ClassName = request.getParameter("className");
		
		classes.setClassName(ClassName);	
		
		dao.updateClasses(classes);		
		
		request.setAttribute("Classname", ClassName);

		//response.sendRedirect("updateSubjectValues.jsp");	
		
		request.getRequestDispatcher("updateClassValues.jsp").forward(request, response);
		
	}

}
