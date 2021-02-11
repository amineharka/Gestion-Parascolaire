package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.ResponsableClub;
import services.ActiviteManager;

/**
 * Servlet implementation class SuppressionActivite
 */
@WebServlet("/supprimerActivite")
public class SuppressionActivite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionActivite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		ActiviteManager activiteManager = new ActiviteManager();
		String chemin = (String) request.getServletContext().getAttribute("chemin");
		activiteManager.delete(chemin, id);
		response.sendRedirect(request.getContextPath()+"/ajouterActivite");
		
	}

}
