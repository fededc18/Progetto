package progetto.Metadata;

import java.lang.reflect.Field;
import java.util.*;


import progetto.Model.*;


public class Metadata {
	
	private ArrayList<Map> metadata = new ArrayList<>();
	/*
	 * Costruttore della classe
	 */
	public Metadata() {
	Field[] fields = Produz_Agricola.class.getDeclaredFields(); // estrae gli attributi dalla classe Produz_Agricola
    for (int i = 0; i < fields.length; i++) {
    	Map<String, String> map = new HashMap<>(); //creiamo una mappa con le coppie chiave-valore
    	//andiamo ad inserire le coppie
    	map.put("alias", fields[i].getName());
        map.put("sourceField", fields[i].getName().toUpperCase());//Non mi convinve questa parte
        map.put("type", fields[i].getType().getSimpleName());
        metadata.add(map);
    	}
	 
	}
	
	/*
	 * Metodo che restituisce i metadati 
	 * @return la lista dei metadati
	*/
	
	public ArrayList<Map> getMetadata() 
	{
		return metadata;
	}

}
