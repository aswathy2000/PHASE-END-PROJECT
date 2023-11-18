

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.railwayCrossingDataDAO;
import com.pojo.railwayCrossingData;

import com.pojo.favouriteCrossing;
import com.dao.favouriteCrossingDAO;
/**
 * Servlet implementation class addfavoriteCrossing
 */
public class addfavoriteCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addfavoriteCrossing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		favouriteCrossingDAO dao = new favouriteCrossingDAO();
	    favouriteCrossing favCrossingData = new favouriteCrossing();
	    
	    int crossingID = Integer.parseInt(request.getParameter("id"));
	    railwayCrossingData crossing = dao.getRailwayCrossingById(crossingID);
	    favCrossingData.setRailwayCrossing(crossing);

	    dao.addfavouriteCrossing(favCrossingData); 
	    request.setAttribute("id", crossingID);
	    request.getRequestDispatcher("addfavoriteCrossing.jsp").forward(request, response);
	    
	}

		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		favouriteCrossingDAO dao = new favouriteCrossingDAO();
	    favouriteCrossing favCrossingData = new favouriteCrossing();
	    
	    int crossingID = Integer.parseInt(request.getParameter("id"));
	    railwayCrossingData crossing = dao.getRailwayCrossingById(crossingID);
	    favCrossingData.setRailwayCrossing(crossing);

	    dao.addfavouriteCrossing(favCrossingData); 
	    request.setAttribute("id", crossingID);
	    request.getRequestDispatcher("addfavoriteCrossing.jsp").forward(request, response);	
			
	}

}
