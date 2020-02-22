package progetto.Service;

import progetto.Utilities.*;
import progetto.Metadata.*;
import progetto.Model.Produz_Agricola;
import progetto.Service.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/*
 * 
 * Classe che gestisce le operazioni di download e carica del dataset
 *
 */

@Component

public class Service {

	private String link ="https://data.europa.eu/euodp/data/api/3/action/package_show?id=cdqRaKp9e1GBbxMMovJEA" ;// Url del Dataset
	private Download_and_Parsing serviceD_and_P;
	private Metadata serviceMeta;
	private Statistics Stats;
	private ArrayList<Produz_Agricola> Dataset;

	/*
	 * Costruttore della classe che esegue il download e il parsing e vengono estratti i dati modellati
	 */

	public Service() {
		this.serviceD_and_P = new Download_and_Parsing();
		this.serviceMeta = new Metadata();
		this.Stats = new Statistics();

		String url="";

		url= serviceD_and_P.download(link);
		Dataset= serviceD_and_P.parsing(url);
	}

	/*
	 * Metodo che restituisce il dataset
     * 
	 * @return lista dei dati del tvs
	 */

	public ArrayList<Produz_Agricola> getDataset(){
		return Dataset;
	}

	/*
	 * Metodo che restituisce la lista dei metadati
	 * 
	 * @return lista dei metadati
	 */

	public ArrayList<Map> getMetadata(){
		return serviceMeta.getMetadata();
	}

	/*
	 * Metodo che restituisce le statistiche di un campo
	 * 
	 * @return lista dei dati del tvs
	 */
	
	public Map getStatistics(String campo) {
		// TODO Auto-generated method stub
		return Stats.getStats(campo, (List) Dataset);
	}
	
	/*
	 * Metodo che elimina un dato elemento
	 * 
	 */
	
	public ResponseEntity<String> deleteRecord(int id) {
		// TODO Auto-generated method stub
		Dataset.remove(id);
		return null;
	}

}

