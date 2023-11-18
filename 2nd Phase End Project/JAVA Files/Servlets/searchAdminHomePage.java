

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.railwayCrossingDataDAO;
import com.pojo.railwayCrossingData;

/**
 * Servlet implementation class searchAdminHomePage
 */
public class searchAdminHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchAdminHomePage() {
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
		
		
		String search = request.getParameter("search");
		
		railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
		
		
		List<railwayCrossingData> listCrossings = dao.searchRailwayCrossingData(search);
		
		request.getRequestDispatcher("searchAdminHomePageResult.jsp").forward(request, response);
		
		
	}

}
