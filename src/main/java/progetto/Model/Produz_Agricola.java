package progetto.Model;

import java.io.Serializable;
import java.util.Arrays;

/*
 * Classe che modella il dataset in tvs
 */


public class Produz_Agricola implements Serializable {
	private String unit;
	private String crops;
	private String agprdmet;
	private String geo;
	private double[] time = new double [7] ;
	
	/*
	 * Costruttore della classe
	 * 
	 * @param unit
	 * @param crops
	 * @param agprdmet
	 * @param geo
	 * @param time
	 */
	
	public Produz_Agricola(String unit, String crops, String agprdmet, String geo, double[] time  ) {
		this.unit = unit;
		this.crops = crops;
		this.agprdmet= agprdmet;
		this.geo = geo;
		this.time = time;
	
	}
	
	//Metodi Getter e Setter

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCrops() {
		return crops;
	}

	public void setCrops(String crops) {
		this.crops = crops;
	}

	public String getAgprdmet() {
		return agprdmet;
	}

	public void setAgprdmet(String agprdmet) {
		this.agprdmet = agprdmet;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public double[] getTime() {
		return time;
	}

	public void setTime(double[] time) {
		this.time = time;
	}
	
	/**
     * metodo che consente la stampa
     *
     * @return una stringa in cui vengono indicati i vari campi e il loro valore
     */
    @Override
    public String toString() {
        return "Produz_Agricola{" +
                "unit= " + unit + ' ' +
                ", crops= " + crops + ' ' +
                ", agprdmet= " + agprdmet + ' ' + 
                ", geo= " + geo + " " +
                ", time= "  + Arrays.toString(time) +
                '}';
    }

	
}
