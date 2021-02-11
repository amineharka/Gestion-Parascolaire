package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;
import services.ActiviteManager;
import services.FilesManager;
import services.FilesManagerImpl;

/**
 * Servlet implementation class CreationActivite
 */
@WebServlet("/ajouterActivite")
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class CreationActivite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationActivite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.getRequestDispatcher("WEB-INF/Responsable/creationActivite.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chemin = (String)this.getServletContext().getAttribute("chemin");
		ActiviteManager activiteManager = new ActiviteManager();
		Activite activite = activiteManager.creerActivite(request, chemin);
		if(activite == null)
		{
			request.setAttribute("am",activiteManager);
			request.getRequestDispatcher("WEB-INF/Responsable/creationActivite.jsp").forward(request, response);
		}
			
		else
			request.getRequestDispatcher("WEB-INF/Responsable/creationActivite.jsp").forward(request, response);	
		}
		
		

}
