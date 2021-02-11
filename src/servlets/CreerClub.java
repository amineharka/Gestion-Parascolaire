package servlets;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.ResponsableClub;
import services.CreerClubForm;
import services.UpdateProfilForm;


@WebServlet("/CreerClub")
public class CreerClub extends HttpServlet {
	private static final long serialVersionUID = 1L;	
       
	   public void init() throws ServletException {
	   

	    }
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());	
		  
        request.setAttribute( "clubs", daoClub.lister());
        
 		 this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/creerClub.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());	
		
        if(request.getParameter("submit") != null)
        {	
        	
           	  CreerClubForm form = new CreerClubForm(daoClub);
        	  Club club = form.creerClub(request);
        	  request.setAttribute( "Erreur", form.Erreur );
        	  
        	  if(club != null)
        	  {
                  request.setAttribute( "clubs", daoClub.lister());
                  this.getServletContext().setAttribute("club", daoClub.lister());
           		  this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/creerClub.jsp").forward(request, response);
        	  }
        	  else {
                  request.setAttribute( "clubs", daoClub.lister());

           		 this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/creerClub.jsp").forward(request, response);
        	  }
        }
        
        else {
      
            request.setAttribute( "clubs", daoClub.lister());

      		 this.getServletContext().getRequestDispatcher("/WEB-INF/Administrateur/creerClub.jsp").forward(request, response);

        	
        }
		
	}



}
