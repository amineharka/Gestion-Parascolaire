package servlets;

import java.io.File
;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.ResponsableClub;
import services.FilesManager;
import services.FilesManagerImpl;
import services.PresentationManager;

/**
 * Servlet implementation class GestionPresentationServlet
 */
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/ajouterPresentation")
public class GestionPresentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionPresentationServlet() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/Responsable/presentationClub.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ResponsableClub responsableClub = (ResponsableClub) session.getAttribute("responsable");
		int id = responsableClub.getClub().getId();
		
		PresentationManager presentationManager = new PresentationManager();
		String chemin = (String)this.getServletContext().getAttribute("chemin");
		Club club = presentationManager.managePresentation(request,chemin,id);
		if(club==null)
		{
			request.setAttribute("pm",presentationManager);
			request.getRequestDispatcher("WEB-INF/Responsable/presentationClub.jsp").forward(request, response);
		}
			
		else
			request.getRequestDispatcher("WEB-INF/Responsable/presentationClub.jsp").forward(request, response);
		
	}
	
}
