package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;

/**
 * Servlet implementation class ListeClubs
 */
@WebServlet("/ListeClubs")
public class ListeClubs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeClubs() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		 request.setAttribute("clubs", daoClub.lister());
		 this.getServletContext().getRequestDispatcher( "/WEB-INF/Public/ListeClubs.jsp" ).forward( request, response );
	}



}
