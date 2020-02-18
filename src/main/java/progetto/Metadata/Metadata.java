package progetto.Metadata;

import java.lang.reflect.Field;
import java.util.*;


import progetto.Model.*;


public class Metadata {
	
	private List<Map> metadata = new ArrayList<>();
	public Metadata() {
	Field[] fields = Produz_Agricola.class.getDeclaredFields(); // estrae gli attributi dalla classe Produz_Agricola
	
	
	}

}

/*

//metadata di Anna(cercare di comprendere se le parti diverse da quelllo di corrado interessano il mio progetto

public ArrayList<Map> metadata() {
    Field[] fields = DayCareChildren.class.getDeclaredFields(); //estrae gli attributi da DayCareChildren
    ArrayList<Map> metaDati = new ArrayList<>();
    //line = line.replace(",", "\t");
    String[] dividedLine = headerLine.trim().replace("\\", "\t").split("[,\t]"); //divide la stringa sulla prima linea
    for (int i = 0; i < fields.length; i++) {
        Map<String, String> nameAssociation = new HashMap<>(); //creiamo una mappa con le coppie chiave-valore
        nameAssociation.put("alias", fields[i].getName());
        //inseriamo le coppie
        nameAssociation.put("sourcefield", dividedLine[i]);
        nameAssociation.put("type", fields[i].getType().getSimpleName());
        metaDati.add(nameAssociation);//salva i metadati in metaDati
    }
    return metaDati;
}
}


//metadata di Corrado



public Metadata() {
	
	Field[] fields = Erasmus.class.getDeclaredFields();//estrae gli attributi della classe Erasmus

    for (Field f : fields) {
        Map<String, String> map = new HashMap<>();
        //andiamo ad inserire le coppie chiave/valore
        map.put("alias", f.getName());
        map.put("sourceField", f.getName().toUpperCase());//nome del campo in csv
        map.put("type", f.getType().getSimpleName());
        metadata.add(map);
    	}

    }
    
/**
 * Metodo che ritorna la lista di mappe contenente i metadati
 * 
 * @return lista dei metadati
 */
/*
public List<Map> getMetadata() {
	return metadata;
	}

}

*/