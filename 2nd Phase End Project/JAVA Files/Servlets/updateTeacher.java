

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.TeacherDAO;
import com.project.pojo.Teacher;

/**
 * Servlet implementation class updateTeacher
 */
public class updateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateTeacher() {
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


		TeacherDAO dao = new TeacherDAO();
		Teacher teacher = new Teacher();
		
		int Teacherid = Integer.parseInt(request.getParameter("id"));
		
		teacher.setTeacherId(Teacherid);
		
		String Teachername = request.getParameter("teachername");
		
		teacher.setTeacherName(Teachername);		
		teacher.setTeacherDesignation(request.getParameter("teacherdesignation"));
		dao.updateTeacher(teacher);
		

		request.setAttribute("TeacherName", Teachername);
		
		//response.sendRedirect("updateTeacherValues.jsp");	
		
		request.getRequestDispatcher("updateTeacherValues.jsp").forward(request, response);

	}

}
