

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pojo.railwayCrossingData;
import com.dao.railwayCrossingDataDAO;

/**
 * Servlet implementation class deleteController
 */
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int crossingId = Integer.parseInt(request.getParameter("id"));
	    railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
	    railwayCrossingData data = new railwayCrossingData();
	   
	    data.setCrossingId(crossingId);
	    dao.deleteRailwayCrossingData(data);
	   
	    response.sendRedirect("adminHomePage.jsp");	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int crossingId = Integer.parseInt(request.getParameter("id"));
	    railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
	    railwayCrossingData data = new railwayCrossingData();
	   
	    data.setCrossingId(crossingId);
	    dao.deleteRailwayCrossingData(data);
	   
	    response.sendRedirect("adminHomePage.jsp");	
		
		
	}

}
