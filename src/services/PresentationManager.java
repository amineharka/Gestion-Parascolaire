package services;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DaoClub;
import dao.DaoClubImpl;
import dao.JPAUtil;
import entities.Club;
import entities.ResponsableClub;

public class PresentationManager {
	
	final static String CHAMP_LOGO="logo";
	final static String CHAMP_IMG1="image1";
	final static String CHAMP_IMG2="image2";
	final static String CHAMP_IMG3="image3";
	final static String CHAMP_PARAGRAPHE="paragraphe";
	final static String CHAMP_DESCRIPTION="description";
	
	private Club club ;
	
	private Map<String,String> erreurs = new HashMap<String,String>();
	
	
	
	
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public Club managePresentation(HttpServletRequest request,String chemin,int id)
	{
		
		club = null;
		Part partLogo=null;
		Part partImg1 = null;
		Part partImg2 = null;
		Part partImg3 = null;
		try {
			partLogo = request.getPart(CHAMP_LOGO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			partImg1 = request.getPart(CHAMP_IMG1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			partImg2 = request.getPart(CHAMP_IMG2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			partImg3 = request.getPart(CHAMP_IMG3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String paragraphe = request.getParameter(CHAMP_PARAGRAPHE);
		String description = request.getParameter(CHAMP_DESCRIPTION);
		
		try {
			this.textValidation(paragraphe);
		}
		catch(Exception e){
			erreurs.put(CHAMP_PARAGRAPHE, e.getMessage());
		}
		try {
			this.textValidation(description);
		}
		catch(Exception e){
			erreurs.put(CHAMP_DESCRIPTION, e.getMessage());
		}
		
		try {
			this.imageValidation(partLogo);
		}
		catch(Exception e){
			erreurs.put(CHAMP_LOGO, e.getMessage());
		}
		try {
			this.imageValidation(partImg1);
		}
		catch(Exception e){
			erreurs.put(CHAMP_IMG1, e.getMessage());
		}
		
		
		try {
			this.imageValidation(partImg2);
		}
		catch(Exception e){
			erreurs.put(CHAMP_IMG2, e.getMessage());
		}
		
		try {
			this.imageValidation(partImg3);
		}
		catch(Exception e){
			erreurs.put(CHAMP_IMG3, e.getMessage());
		}
		
		DaoClub daoClub = new DaoClubImpl(JPAUtil.getEntityManagerFactory());
		
		club = daoClub.find(id);
		club.setParagraphe(paragraphe);
		club.setDescription(description);
		
		if(erreurs.isEmpty())
		{
			
			FilesManager filesManager = new FilesManagerImpl();
			if(club.getLogoPath()!=null)
			{
				filesManager.delete(chemin,club.getLogoPath());
				filesManager.delete(chemin,club.getImg1Path());
				filesManager.delete(chemin,club.getImg2Path());
				filesManager.delete(chemin,club.getImg3Path());
			}
			
			
			club.setLogoPath(filesManager.ecrireFichier(partLogo, chemin));
			club.setImg1Path(filesManager.ecrireFichier(partImg1, chemin));
			club.setImg2Path(filesManager.ecrireFichier(partImg2, chemin));
			club.setImg3Path(filesManager.ecrireFichier(partImg3, chemin));
			daoClub.update(club);
			return club;
			
			
		}
					
		return null;
		
		
		
		
	}
	
	private void textValidation(String text) throws Exception
	{
		if(text.trim().length()==0 || text == null)
			throw new Exception("*required");
	}
	
	private void imageValidation(Part part) throws Exception
	{
		String type = part.getContentType();
		if(!type.contains("image"))
			throw new Exception("image required");
	}
	

}
