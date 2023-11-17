

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.StudentDAO;
import com.project.pojo.Classes;
import com.project.pojo.Student;

/**
 * Servlet implementation class updateStudent
 */
public class updateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateStudent() {
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



		try {

			StudentDAO dao = new StudentDAO();
			Student student = new Student();

			int StudentID = Integer.parseInt(request.getParameter("studentId"));

			student.setStudentId(StudentID);

			String Namestudent = request.getParameter("studentName");

			student.setStudentName(request.getParameter("studentName"));
			student.setStudentAddress(request.getParameter("studentAddress"));
			student.setStudentPhoneNo(request.getParameter("studentPhoneNo"));

			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date dateOfBirth =dateFormat.parse(request.getParameter("studentDOB"));

			student.setStudentDOB(dateOfBirth);

			Classes classStudent = new Classes();
			classStudent.setClassName(request.getParameter("studentClass"));

			student.setClasses(classStudent);

			dao.updateStudent(student);

			request.setAttribute("Namestudent", Namestudent);
			request.getRequestDispatcher("updateStudentValues.jsp").forward(request, response);				
			//response.sendRedirect("studentPage.jsp");		


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
