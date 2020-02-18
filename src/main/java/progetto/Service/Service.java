package progetto.Service;

import progetto.Download_and_Parsing.Parsing;
import progetto.Download_and_Parsing.Download;
import progetto.Metadata.*;
import progetto.Model.Produz_Agricola;
import progetto.Service.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * Classe che gestisce le operazioni di download e carica del dataset
 *
 */

public class Service {
	
	private String url="https://data.europa.eu/euodp/data/api/3/action/package_show?id=cdqRaKp9e1GBbxMMovJEA" // Url del Dataset
	private Download serviceDownload;
	private Parsing serviceParsing;;
	private Metadata serviceMeta;
	private List<Produz_Agricola> Dataset;
	private Statistics Stats;
	
	/*
	 * Costruttore della classe che esegue il download e il parsing e vengono estratti i dati modellati
	 */
	
	public Service () {
		this.serviceDownload = new Download();
		this.serviceParsing = new Parsing();
		this.serviceMeta = new Metadata();
		this.Stats = new Statistics();
		
        String link="";
		
		link = serviceDownload (url);
		Dataset = serviceParsing (link);
	}
	
	

}
