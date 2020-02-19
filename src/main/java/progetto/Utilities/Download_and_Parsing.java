package progetto.Utilities;

import progetto.Model.*;

import java.io.BufferedReader; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class Download_and_Parsing {
	
	private String link ="";
	private List<Produz_Agricola> productionlist;
	
	public Download_and_Parsing()
	{
		this.productionlist = new ArrayList<Produz_Agricola> ; 
	}
	
	/**
	 * Metodo che effettua il download del dataset estraendo il link del tsv 
	 * 
	 * @param url stringa che contiene l'url del dataset assegnatoci
	 * @return l'url del tsv desiderato e viene salvato su una variabile di tipo String
	 */
	
	public String download(String url)
	{
		try
		{
			URLConnection openConnection = new URL(url).openConnection();  // crea una connesione tra applicazioe e url
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = openConnection.getInputStream();  // crea il flusso di input
			String data = "";
			String line = "";
			try
			{
				InputStreamReader inputReader = new InputStreamReader(input);  // legge i byte e li decodifica in caratteri
				BufferedReader br = new BufferedReader(inputReader);  // legge un file di testo
				
				while ((line = br.readLine())!=null)  // legge fino a che il file e' vuoto
				{
					data += line; // ad ogni passo viene aggiunta a data una nuova linea di caratteri
					//System.out.println(line);  //stampa il dataset in una righa per il debug
				}
			}
			finally
			{
				input.close();
			} 
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data.toString());// converte il dataset in oggetto json
            JSONObject objI = (JSONObject) (obj.get("result")); // assegna alla variabile objI il json del dataset denominato result
            JSONArray objA = (JSONArray) (objI.get("resources")); // assegna al vettore json objA il valore di resources che contiene l'url del tsv da estrarre

            for (Object o : objA) {
                if (o instanceof JSONObject) {
                    JSONObject o1 = (JSONObject) o;
                    String format = (String) o1.get("format");
                    //System.out.println(format + " | " + urlDataset);
                    if (format.equals("http://publications.europa.eu/resource/authority/file-type/TSV")) {
                        link = (String)o1.get("url");
                    }
                }
            }	
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println( "\nDownload completato." );
		return link;
	}
	
	/**
	 * Metodo per effetuare il parsing
	 * 
	 * @param link stringa che contiene l'url del dataset 
	 * @return lista oggetti di Produzione Agricola
	 */
	
	public List<Produz_Agricola> parsing(String link) 
	{
		InputStream in = null;
		try {
            URLConnection openConnection = new URL(link).openConnection();
            openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            in = openConnection.getInputStream();
            
            String line;
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            
            while ((line = buf.readLine()) != null) 
            {
            	String[] fields = line.split("[,\t]");//si usa il metodo split per dividere la stringa, i caratteri separatori che si passano sono la virgola e il tab
                if (fields.length != 11){
                	System.out.println("Il record e' errato");
                	continue;
                }
                /*
                 * non so come scrivere questa parte, dove si organizza la lettura dei dati ???
                 */
                else {
                	
                	
                }
                
            }
		}
            	
        catch (FileNotFoundException e) {
    	   		e.printStackTrace();
    	  } 
        catch (IOException e) {
        	e.printStackTrace();
    	   	} 
        finally 
         {
           try {
               if (in != null) in.close();
               }         	 
    	    catch (IOException e) {
    	       e.printStackTrace();
    	   	   }
    	 }
		
    	System.out.println("Parsing completato.\n");  
        return productionlist;        	
	}
	
}
