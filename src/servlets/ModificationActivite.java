package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Club;
import services.ActiviteManager;

/**
 * Servlet implementation class ModificationActivite
 */
@WebServlet("/modifierActivite")
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class ModificationActivite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationActivite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoActivite daoActivite = new DaoActiviteImpl(JPAUtil.getEntityManagerFactory());
		Activite activite = daoActivite.find(8);
		request.setAttribute("activite",activite);
		
		request.getRequestDispatcher("WEB-INF/Responsable/modificationActivite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActiviteManager activiteManager = new ActiviteManager();
		String chemin = (String) this.getServletContext().getAttribute("chemin");
		Activite activite = activiteManager.modifierActivite(request, chemin);
		if(activite == null)
		{
			request.setAttribute("am",activiteManager);
			activite = activiteManager.getActivite();
			request.setAttribute("activite",activite);
			request.getRequestDispatcher("WEB-INF/Responsable/modificationActivite.jsp").forward(request, response);
		}
			
		else
			request.getRequestDispatcher("WEB-INF/Responsable/modificationActivite.jsp").forward(request, response);	
		
		
		}
		
	

}
