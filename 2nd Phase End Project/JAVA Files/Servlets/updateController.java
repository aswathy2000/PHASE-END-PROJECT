

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.railwayCrossingData;
import com.dao.railwayCrossingDataDAO;
import java.time.*;

/**
 * Servlet implementation class updateController
 */
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateController() {
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
			railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
			railwayCrossingData RC = new railwayCrossingData();
			RC.setCrossingId(Integer.parseInt(request.getParameter("id")));
			RC.setCrossingName(request.getParameter("name"));
			RC.setAddress(request.getParameter("address"));
			RC.setLandmark(request.getParameter("landmark"));
			String trainScheduleStr = request.getParameter("schedule");

			LocalTime trainSchedule = LocalTime.parse(trainScheduleStr); 
			RC.setTrainSchedule(trainSchedule); 

			RC.setPersonInCharge(request.getParameter("person"));
			RC.setStatusCrossing(request.getParameter("status"));

			dao.updateRailwayCrossingData(RC);

			response.sendRedirect("adminHomePage.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
			response.sendRedirect("error.jsp"); 
		}



	}

}
