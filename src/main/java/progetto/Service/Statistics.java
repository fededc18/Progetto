package progetto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Classe che implementa le statistiche
 */

public class Statistics {
	
	/**
	 * Metodo che effettua un conteggio sul numero di elementi di una lista
	 * 
	 * @param lista di valori da contare
	 * @return dimensione della lista
	 */
	public static int count(List lista) {
		return lista.size();
	}
	
	/**
	 * Metodo che restituisce la somma dei valori di una lista numerica
	 * 
	 * @param lista contiene i valori che andranno sommati
	 * @return somma dei valori
	 */
	public static double sum(List<Number> lista) {
		double somma=0;
		for(Number n : lista)
			somma += n.doubleValue();   //scorre la lista e somma tutti i valori
		return somma;
	}
	
	/**
     * Metodo per il calcolo della deviazione standard degli elementi di una lista numerica
     *
     * @param lista valori su cui effettuare il calcolo
     * @return il valore della deviazione standard degli elementi
     */
    public static double devStd(List<Number> lista) { //formula della deviazione standard: DevStd = radice della sommatoria degli (xi-xmedio)^2
        double risultSqrd = 0;
        for (Number n : lista) {
            risultSqrd += Math.pow(n.doubleValue() - avg(lista), 2);
        }
        return Math.sqrt(risultSqrd);
    }

	/**
	 * Metodo che restituisce la media dei valori di una lista numerica
	 * 
	 * @param lista contiene i valori utilizzati per calcolare la media
	 * @return media dei valori
	 */
	public static double avg(List<Number> lista) {
		return sum(lista)/count(lista);  //restituisce la media
	}
	
	/**
     * Metodo che stampa il valore maggiore tra gli elementi presenti nella lista numerica
     *
     * @param lista di elementi di cui trovare il massimo
     * @return valore massimo
     */
    public static double max(List<Number> lista) {
        double max = lista.get(0).doubleValue(); //assegna il primo valore della lista a max
        for (Number n : lista) {
        	if(n.doubleValue() > max) max = n.doubleValue(); //scorre la lista e verifica se il valore  e' maggiore di max
        }
        return max;
    }
	
    /**
	 * Metodo che restituisce il minimo tra gli elementi presenti nella lista numerica
	 * 
	 * @param lista di elementi di cui trovare il minimo
	 * @return valore minimo
	 */
	public static double min(List<Number> lista) {
		double min = lista.get(0).doubleValue();  //assegna il primo valore della lista a min
		for(Number numero : lista) {
			if(numero.doubleValue() < min) min = numero.doubleValue();
		}
		return min;
	}
	
	/**
	 * Metodo che conta le istanze di un elemento all'interno di una lista
	 * 
	 * @param lista contiene i valori da conteggiare
	 * @return restituisce una Map chiave-valore, contenente come chiave l'elemento e come valore il numero di volte in cui compare
	 */
	public static Map<Object, Integer> ElementiUnici(List lista) {
		Map<Object,Integer> mappa = new HashMap<>(); 
		for(Object elem : lista) {  
			if(mappa.containsKey(elem))  //controlla se la chiave e' gia' esiste 
				mappa.replace(elem, mappa.get(elem) + 1);  //se esiste aumenta il suo valore di 1
			else
				mappa.put(elem, 1);  //se non esiste la crea e le assegna il valore 1
		}
		return mappa;
	}
	
	 /*
     * Metodo che restituisce tutte le statistiche del campo richiesto dall'utente chiamando i metodi sopra implementati
     *
     * @param campo nome del campo su cui vogliamo calcolare le statistiche(da distinguere un campo numerico e un campo di stringhe)
     * @param lista degli elementi presenti nel campo
     * @return una mappa che ha come chiave i nomi delle statistiche disponibili per il campo richiesto e come valore quello calcolato tramite i metodi della classe
     */
	
	public Map<String, Object> getStats(String campo, List<Object> lista) {
		Map<String, Object> mappa = new HashMap<>();
		mappa.put("field", campo);
		if(!lista.isEmpty()) {
			 // se il primo valore e' un numero crea una lista di numeri 
			if (lista.get(0) instanceof Number) 
			 { 
				List<Number> numLista = new ArrayList<>();
				for (Object elem : lista) 
				{
					numLista.add(((Number) elem));
				}
				mappa.put("count", count(numLista));
				mappa.put("sum", sum(numLista));
				mappa.put("avg", avg(numLista));
		        mappa.put("max", max(numLista));
		        mappa.put("min", min(numLista));
		        mappa.put("DevStd", devStd(numLista));
                return mappa;
			}
			// se il primo valore non e' un numero calcola le statistiche per le stringhe
			else {
				mappa.put("ElementiUnici", ElementiUnici(lista));
                mappa.put("count", count(lista));
			}
		}
		return mappa;
	}
	
}
