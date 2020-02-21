# PROGETTO
Progetto di Febbraio

## Introduzione

Questo progetto è stato realizzato da Federica Di Crescenzo per il corso di Programmazione ad Oggetti, tenuto presso l'Università Politecnica delle Marche nell'anno accademico 2018-2019.
 
L’applicazione, basata sul linguaggio di programmazione Java, sfrutta il framework Spring, il quale restituisce tramite richieste API REST GET o POST dati, metadati e statistiche (in formato JSON) di un dataset assegnato dal docente.

## Avvio 

All’avvio, l’applicazione apre una connessione con il web-server in locale sula porta 8080. Viene scaricato in automatico il dataset ed effettua il parsing del file TSV contenuto nell’[URL](https://ec.europa.eu/eurostat/estat-navtree-portlet-prod/BulkDownloadListing?file=data/org_cropar.tsv.gz&unzip=true) assegnatoci. 
Per testare il software è possibile utilizzare **Postman**, ambiente attraverso il quale è possibile richiedere dati, metadati, statistiche sui dati.

## Struttura del codice

Le classi sono inserite in cinque package principali basati sulla logica MVC (Model View Controller):

_Controller_ racchiude tutti i metodi necessari per far fronte alle richieste GET.

_Services_ è utile nell’implementazione di metodi che gestiscono l’accesso a dati, metadati, statistiche.

_Model_ contiene la classe principale su cui si basa l’intero programma.

_Metadata_ contiene la classe dei metadata.

_Utilities_ include la classe che permette di fare il download e il parsing del file TSV.

## Richieste

Si possono effettuare richieste di tipo GET e POST all'indirizzo [http://localhost:8080](http://localhost:8080/) tramite le seguenti istruzioni: **RICHIESTE GET**

-   **/dataset** per ottenere i dati in formato JSON.
```
localhost:8080/dataset
```

-   **/metadata** per ottenere i metadati in formato JSON.

```
localhost:8080/metadata
```
-  **/statistics?campo="campo"**(in cui "campo" può essere unit , crops, agprdmet, geo o, per ottenere statistiche di tipo numerico, un anno compreso tra il 2012 e il 2018 inclusi) per la restituzione delle statistiche su un determinato campo del dataset.
```
localhost:8080/statistics
```

-   **/delete** : attraverso questa richiesta è possibile eliminare un dato specifico attraverso un numero identificativo da noi assegnato.
```
localhost:8080/delete
```
