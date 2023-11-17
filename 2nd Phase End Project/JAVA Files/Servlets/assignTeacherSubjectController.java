

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.ClassDAO;
import com.project.pojo.Classes;

import com.project.dao.TeacherDAO;
import com.project.pojo.Teacher;

import com.project.dao.SubjectDAO;
import com.project.pojo.Subject;

/**
 * Servlet implementation class assignTeacherSubjectController
 */
public class assignTeacherSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public assignTeacherSubjectController() {
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



		String selectedTeacherName = request.getParameter("teacherClass");
		String selectedSubjectName = request.getParameter("subjectClass");
		TeacherDAO teacherDAO = new TeacherDAO();
		SubjectDAO subjectDAO = new SubjectDAO();
		Teacher selectedTeacher = teacherDAO.getTeacherByName(selectedTeacherName);
		Subject selectedSubject = subjectDAO.getSubjectsByName(selectedSubjectName);

		String className = request.getParameter("cname");

		ClassDAO classDAO = new ClassDAO();
		List<Classes> classesList = classDAO.getClassesByName(className);

		Classes classData = classesList.get(0);

		classData.setTeacher(selectedTeacher);
		classData.setSubject(selectedSubject);

		classDAO.updateClasses(classData);
		response.sendRedirect("dashboard.jsp");



	}

}
