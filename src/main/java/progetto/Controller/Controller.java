package progetto.Controller;

import java.util.List;
import java.util.Map;

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
    public List getAllDataset() {
        return service.getDataset();
    }
	
	/**
     * Metodo che gestisce la richiesta GET alla rotta "/metadata"
     *
     * @return i metadati
     */
	@GetMapping("/metadata")
    public List<Map> getMetadata() {
        return service.getMetadata();
    }
	

}
