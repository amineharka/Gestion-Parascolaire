package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.ResponsableClub;

/**
 * Servlet implementation class SupprimerClub
 */
@WebServlet("/SupprimerClub")
public class SupprimerClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SupprimerClub() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idClub = Integer.parseInt(request.getParameter("id"));
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());	
		

		 request.setAttribute("clubs", daoClub.lister());
		
		if(idClub != 0)
		{
			
		Club club = new Club();
		club = daoClub.find(idClub);		
		daoClub.delete(idClub);
		
		
		DaoResponsableClub daoResp = new DaoResponsableClubImpl(JPAUtil.getEntityManagerFactory());
		daoResp.delete(club.getResponsableClub().getId());
		
		request.setAttribute( "clubs", daoClub.lister());
		
		request.setAttribute( "clubs", daoClub.lister());
		response.sendRedirect( request.getContextPath() + "/CreerClub" );
		 }

		
	}



}
