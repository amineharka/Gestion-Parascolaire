package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import services.PresentationManager;

/**
 * Servlet implementation class ModificationPresentation
 */
@WebServlet("/modifierPresentation")
@MultipartConfig(location="C:\\Users\\toshiba\\Desktop\\test\\", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class ModificationPresentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationPresentation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		HttpSession session = request.getSession();
		ResponsableClub responsableClub = (ResponsableClub) session.getAttribute("responsable");
		Club club = responsableClub.getClub();
		request.setAttribute("club",club);
		request.getRequestDispatcher("WEB-INF/Responsable/modifierPresentation.jsp").forward(request, response);
		
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
