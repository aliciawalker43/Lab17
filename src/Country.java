import java.util.Scanner;
public class Country {

	
	private String name;
	private int population;
	private Scanner scnr;
	
	//Constructors
	public Country(String name) {
		this.name = name;
	}	
	public Country(int population) {
			this.population= population;
		}
	public Country(Scanner scnr) {
		this.scnr= scnr;
	}
	
	
	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}
	//Getters& Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	//to string
	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}
	
	}
	

