package progetto.Controller;

import progetto.Service.*;
import java.util.List;
import java.util.Map;

import com.digarcisi.progettoesame.controller.RequestParam;
import com.lindatato.Progetto.Controller.Autowired;
import com.lindatato.Progetto.Controller.GetMapping;

/*
 * Gestisce le richieste dell'utente
 */
@RestController

public class Controller {
	
	private Service service; // si crea una variabile della classe service
	@Autowired  //il controllore dipende da service, stiamo dunque iniettando una dipendenza
	
	/**
     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
     *
     * @param service 
     */
	
	public Controller(Service service) {
		this.service= service;
	}
	
	//Metodi per la comunicazione con il client che gestiscono le richieste GET e POST
	
	/*
	 * Metodo che gestisce la richiesta GET alla rotta "/dataset"
	 * 
	 * @return lista di oggetti del dataset
	 */
	
	@GetMapping("/dataset")
    public List getDataset() {
        return service.getDataset();
    }
	
	/*
	 * Metodo che gestisce la richiesta GET alla rotta "/metadata"
	 * 
	 * @return lista di metadati
	 */
	@GetMapping("/metadata")
    public List getMetadata() {
        return service.getMetadata();
    }
	
	/*
	 * Metodo che gestisce la richiesta GET alla rotta "/statistics"
	 * 
	 * @param campo nome del campo di cui vogliamo calcolare le statistiche
	 * @return lista di oggetti del dataset
	 */
	
	@GetMapping("/statistics")
	public List<Map> getStatistics(@RequestParam (value="nome campo" , Default="") String campo){
		return service.getStatistics(campo);
	}
	
	/*
	 * Metodo che gestisce la richiesta DELETE alla rotta "/delete"
	 * 
	 * @param campo nome del campo
	 * @param body contiene i criteri
	 * @return lista degli elementi eliminati
	 */
	
	@DeleteMapping("/delete")
	
	
	/*
	 * Metodo che gestisce la richiesta POST alla rotta "/dataset"
	 * 
	 * @param 
	 * @return lista di oggetti del dataset
	 */

}
