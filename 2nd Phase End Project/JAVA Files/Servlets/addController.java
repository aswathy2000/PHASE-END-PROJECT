

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.TeacherDAO;
import com.project.pojo.Teacher;

/**
 * Servlet implementation class addController
 */
public class addController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TeacherDAO dao = new TeacherDAO();
		Teacher teacher = new Teacher();
		
		
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setTeacherDesignation(request.getParameter("teacherDesignation"));
		
		
		
		int recordRow = dao.addTeacher(teacher);
		if(recordRow>0){
			response.sendRedirect("teacherPage.jsp");			
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

}
