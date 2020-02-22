package progetto.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import progetto.Service.Service;


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
	
	//Metodi per la comunicazione con il client che gestiscono le richieste GET
	
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
	public Map getStatistics(@RequestParam (value="campo" , defaultValue="") String campo){
		return service.getStatistics(campo);
	}
	
	/*
	 * Metodo che gestisce la richiesta DELETE alla rotta "/delete"
	 * 
	 * @param id identificatore di un determinato elemento
	 * @return elemento eliminato
	 */
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteRecord(@RequestParam (value="id" , defaultValue="") Integer id){
		if(id >= 0)
			return service.deleteRecord(id);
		else
			return new ResponseEntity<String>("invalid id", HttpStatus.BAD_REQUEST);
		
	}

}
