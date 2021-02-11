package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAdministrateur;
import dao.DaoAdministrateurImpl;
import dao.DaoEtudiant;
import dao.DaoEtudiantImpl;
import dao.DaoResponsableClub;
import dao.DaoResponsableClubImpl;
import dao.DaoUtilisateur;
import dao.DaoUtilisateurImpl;
import dao.JPAUtil;
import entities.Administrateur;
import entities.Etudiant;
import entities.ResponsableClub;
import entities.Utilisateur;
import services.ConnexionForm;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil" )
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoUtilisateur daoUtilisateur;
	DaoEtudiant daoEtudiant;
	DaoResponsableClub daoResponsableClub;
	DaoAdministrateur daoAdministrateur;

	@Override
	public void init() throws ServletException {
		EntityManagerFactory factory=JPAUtil.getEntityManagerFactory();
		daoUtilisateur=new DaoUtilisateurImpl(factory);
		daoEtudiant=new DaoEtudiantImpl(factory);
		daoResponsableClub=new DaoResponsableClubImpl(factory);
		daoAdministrateur=new DaoAdministrateurImpl(factory);
		
		Etudiant etudiant1=new Etudiant( "Younes.kellouch@gmail.com", "123456");
		Etudiant etudiant2=new Etudiant( "Younes.kell@gmail.com", "548796");
		Etudiant etudiant3=new Etudiant( "Younes.kellou@gmail.com", "215487");
		Etudiant etudiant4=new Etudiant( "Youn.ke@gmail.com", "0002154");
		
		daoEtudiant.add(etudiant1);
		daoEtudiant.add(etudiant2);
		daoEtudiant.add(etudiant3);
		daoEtudiant.add(etudiant4);
		
		ResponsableClub responsable1=new ResponsableClub("ahmed@gmail.com","1235687");
		ResponsableClub responsable2=new ResponsableClub("ahm@gmail.com","1ALKOI147");
		ResponsableClub responsable3=new ResponsableClub("ahmed12@gmail.com","15487967");
		
		daoResponsableClub.add(responsable1);
		daoResponsableClub.add(responsable2);
		daoResponsableClub.add(responsable3);
		
		
		Administrateur administrateur=new Administrateur("admin12@gmail.com","215487poil");
		
		daoAdministrateur.add(administrateur);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println(daoUtilisateur.getIdByEmail("admin12@gmail.com"));
		System.out.println(daoUtilisateur.getUserType(4));
		System.out.println(daoUtilisateur.getUserType(6));
		System.out.println(daoUtilisateur.getUserType(8));
		this.getServletContext().getRequestDispatcher("/WEB-INF/Public/accueil.jsp").forward(request, response);
	
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		ConnexionForm form=new ConnexionForm(daoUtilisateur);
		Utilisateur utilisateur=form.creerUtilisateur(request);
		if(form.getErreur().size()!=0) {
			request.setAttribute("erreurs",form.getErreur());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Public/accueil.jsp").forward(request, response);
		}
		
		else {
				HttpSession session=request.getSession();
				if(form.getUserType().equals("Etudiant")) {
					session.setAttribute("etudiant", (Etudiant)utilisateur);
					response.sendRedirect(request.getContextPath()+"/Activites");
				}
				else if (form.getUserType().equals("ResponsableClub")) {
					session.setAttribute("responsable", (ResponsableClub)utilisateur);
					response.sendRedirect(request.getContextPath()+"/ajouterActivite");				
				}
				else  {
					session.setAttribute("administrateur", (Administrateur)utilisateur);
					response.sendRedirect(request.getContextPath()+"/CreerClub");			
				}
		}
		
	}



}
