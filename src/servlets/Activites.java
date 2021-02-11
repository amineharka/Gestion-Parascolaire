package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivite;
import dao.DaoActiviteImpl;
import dao.DaoAppartenance;
import dao.DaoAppartenanceImpl;
import dao.DaoClub;
import dao.DaoClubImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.JPAUtil;
import entities.Activite;
import entities.Appartenance;
import entities.Club;
import entities.Etudiant;
import entities.ResponsableClub;
import services.ShowActivites;

/**
 * Servlet implementation class Activites
 */
@WebServlet("/Activites")
public class Activites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoEtudiant daoEtudiant;
	private DaoResponsableClub daoRespo;
	private DaoClub daoClub;
	private DaoActivite daoActivite;
	private DaoAppartenance daoAppartenance;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Activites() {
        super();
        EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
        daoEtudiant = new DaoEtudiantImpl(factory);
        daoRespo = new DaoResponsableClubImpl(factory);
        daoClub = new DaoClubImpl(factory);
        daoActivite = new DaoActiviteImpl(factory);
        daoAppartenance = new DaoAppartenanceImpl(factory);
        
        
        
        Etudiant etd = new Etudiant("login@activites.test", "pwd");
        daoEtudiant.add(etd);
        

        
        
        ResponsableClub respo1 = new ResponsableClub("respo1@club.test", "pwd");
        ResponsableClub respo2 = new ResponsableClub("respo2@club.test", "pwd");
        ResponsableClub respo3 = new ResponsableClub("respo3@club.test", "pwd");
        ResponsableClub respo4 = new ResponsableClub("respo4@club.test", "pwd");
        ResponsableClub respo5 = new ResponsableClub("respo5@club.test", "pwd");
        daoRespo.add(respo1);
        daoRespo.add(respo2);
        daoRespo.add(respo3);
        daoRespo.add(respo4);
        daoRespo.add(respo5);
        
        
        
        Club club1 = new Club();
        club1.setName("Among Us");
        club1.setResponsableClub(daoRespo.find(2));
        daoClub.add(club1);
        
        Club club2 = new Club();
        club2.setName("Social");
        club2.setResponsableClub(daoRespo.find(3));
        daoClub.add(club2);
        
        Club club3 = new Club();
        club3.setName("Apps");
        club3.setResponsableClub(daoRespo.find(4));
        daoClub.add(club3);
        
        Club club4 = new Club();
        club4.setName("Langues");
        club4.setResponsableClub(daoRespo.find(5));
        daoClub.add(club4);
        
        Club club5 = new Club();
        club5.setName("Theatre");
        club5.setResponsableClub(daoRespo.find(6));
        daoClub.add(club5);
        
        
        
        Activite activite1 = new Activite();
        activite1.setNom_activite("Jester Mod");
        activite1.setClub(club1);
        activite1.setLieu_activite("Salle K2");
        activite1.setPrivee(false);
        daoActivite.add(activite1);
        
        Activite activite2 = new Activite();
        activite2.setNom_activite("Mafia Mod");
        activite2.setClub(club1);
        activite2.setLieu_activite("Salle K3");
        activite2.setPrivee(true);
        daoActivite.add(activite2);
        
        Activite activite3 = new Activite();
        activite3.setNom_activite("Conférence Harka");
        activite3.setClub(club2);
        activite3.setLieu_activite("Amphi Younes Kellouch");
        activite3.setPrivee(false);
        daoActivite.add(activite3);
        
        Activite activite4 = new Activite();
        activite4.setNom_activite("Introduction à Spring");
        activite4.setClub(club3);
        activite4.setLieu_activite("Salle H10");
        activite4.setPrivee(false);
        daoActivite.add(activite4);
        
        Activite activite5 = new Activite();
        activite5.setNom_activite("Introduction au Koréan");
        activite5.setClub(club4);
        activite5.setLieu_activite("Salle H11");
        activite5.setPrivee(false);
        daoActivite.add(activite5);
        
        Activite activite6 = new Activite();
        activite6.setNom_activite("Introduction à l'Allemand");
        activite6.setClub(club4);
        activite6.setLieu_activite("Salle H10");
        activite6.setPrivee(false);
        daoActivite.add(activite6);
        
        Activite activite7 = new Activite();
        activite7.setNom_activite("Entrainement");
        activite7.setClub(club5);
        activite7.setLieu_activite("Amphi Hiba Asri");
        activite7.setPrivee(true);
        daoActivite.add(activite7);
        
        
        
        Appartenance appartenance1 = new Appartenance(daoEtudiant.find(1), daoClub.find(1));
        daoAppartenance.add(appartenance1);
        
        Appartenance appartenance2 = new Appartenance(daoEtudiant.find(1), daoClub.find(3));
        daoAppartenance.add(appartenance2);
        
        Appartenance appartenance3 = new Appartenance(daoEtudiant.find(1), daoClub.find(4));
        daoAppartenance.add(appartenance3);
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("clubs", daoClub.lister());
		//normally etd is got from the session
		request.setAttribute("mesClubs", daoAppartenance.listerMesClubs(daoEtudiant.find(1)));
		request.setAttribute("autresClubs", daoAppartenance.listerAutresClubs(daoEtudiant.find(1)));
		
		//MAKE CODE METIER
			//ADD RESTRICTION TO PRIVATE ACTIVITIES (non-member)
			//ADD POSSIBILITE OF TOUT AND TOUSTYPE
		
		//fonction that checks if clubName is a club where etd is membre
		//fonction for when clubName is tout and privee is true

		String clubName = request.getParameter("clubName");
		boolean privee = Boolean.parseBoolean(request.getParameter("privee"));
		
		ShowActivites showActivites = new ShowActivites(daoActivite, daoEtudiant.find(1));
		List<Activite> activites = showActivites.listActivites(clubName, privee);
		String result = showActivites.getResult();

		
		request.setAttribute("activites", activites);
		if(result != null)
			request.setAttribute("result", result);

		this.getServletContext().getRequestDispatcher("/WEB-INF/Etudiant/activites.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
