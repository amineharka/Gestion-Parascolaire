package services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;



public class FilesManagerImpl implements FilesManager{
	
	public static final int TAILLE_TAMPON = 10240;

	@Override
	public String getNomFichier(Part part) {
		 /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	/* Recherche de l'éventuelle présence du paramètre "filename". */
	        if ( contentDisposition.trim().startsWith("filename") ) {
	            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
	        	String nomFichier = contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	        	if ( nomFichier != null && !nomFichier.isEmpty() ) {
	        	   
	        	    nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
	        	            .substring( nomFichier.lastIndexOf( '\\' ) + 1 );
	        	}
	        	return nomFichier;
	        }
	    }
	    /* Et pour terminer, si rien n'a été trouvé... */
	    return null;
	}

	@Override
	public String ecrireFichier(Part part, String chemin) {
		String nomFichier=this.getNomFichier(part);
		 /* Prépare les flux. */
		OutputStream out = null;
	    InputStream filecontent = null;

	    try {
	        out = new FileOutputStream(new File(chemin + File.separator
	                + nomFichier));
	        try {
				filecontent = part.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        try {
				while ((read = filecontent.read(bytes)) != -1) {
				    out.write(bytes, 0, read);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	    } catch (FileNotFoundException fne) {
	        fne.printStackTrace();
	    } finally {
	        if (out != null) {
	            try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        if (filecontent != null) {
	            try {
					filecontent.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	       
	    }
	    return nomFichier;
		
	}
	
	public void delete(String chemin,String imageName)
	{
		Path imagesPath = Paths.get(chemin+imageName);

			try {
			    Files.delete(imagesPath);
			    System.out.println("File "
			            + imagesPath.toAbsolutePath().toString()
			            + " successfully removed");
			} catch (IOException e) {
			    System.err.println("Unable to delete "
			            + imagesPath.toAbsolutePath().toString()
			            + " due to...");
			    e.printStackTrace();
			}
	}

}
