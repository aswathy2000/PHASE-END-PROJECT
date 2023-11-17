

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.SubjectDAO;
import com.project.pojo.Subject;


/**
 * Servlet implementation class updateSubject
 */
public class updateSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSubject() {
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
		
		
		SubjectDAO dao = new SubjectDAO();
		Subject subject = new Subject();
		
		int SubId = Integer.parseInt(request.getParameter("id"));
			
		subject.setSubjectId(SubId);
		
		String SubName = request.getParameter("subjectName");
		
		subject.setSubjectName(SubName);	
		
		dao.updateSubject(subject);		
		
		request.setAttribute("SubjName", SubName);

		//response.sendRedirect("updateSubjectValues.jsp");	
		
		request.getRequestDispatcher("updateSubjectValues.jsp").forward(request, response);
					
	}

}
