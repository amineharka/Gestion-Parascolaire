package listener;


import java.util.List;



import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.jsp.JspApplicationContext;
import javax.websocket.Session;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Club;

/**
 * Application Lifecycle Listener implementation class Initialization
 *
 */
@WebListener
public class Initialization implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Initialization() {
        // TODO Auto-generated constructor stub

    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent event)  {
    	       
    	DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());	
		  
    	event.getServletContext().setAttribute( "club", daoClub.lister());
    	
    	
    	String chemin = "C:\\Users\\toshiba\\Desktop\\here\\GestionParascolaire\\gestionParascolaire\\WebContent\\images\\";
    	event.getServletContext().setAttribute("chemin",chemin);
    	

    }
	
}
