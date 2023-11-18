

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.railwayCrossingData;
import com.dao.railwayCrossingDataDAO;
import java.time.*;


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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
		railwayCrossingData crossingData = new railwayCrossingData();



		crossingData.setCrossingName(request.getParameter("name"));
		crossingData.setAddress(request.getParameter("address"));
		crossingData.setLandmark(request.getParameter("landmark"));

		String crossingTime = request.getParameter("schedule");
		LocalTime trainSchedule = LocalTime.parse(crossingTime);
		crossingData.setTrainSchedule(trainSchedule);

		crossingData.setPersonInCharge(request.getParameter("person"));
		crossingData.setStatusCrossing(request.getParameter("status"));




		int recordRow = dao.addRailwayCrossingData(crossingData);
		if(recordRow>0){
			response.sendRedirect("adminHomePage.jsp");			
		}
		else{
			response.sendRedirect("fail.jsp");
		}


	}

}
