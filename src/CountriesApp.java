import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class CountriesApp {

	
	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome!! \nTime to learn about different Countries!! \n");
		
		while (true) {
			System.out.print("\nPlease enter a selection... \nSee countries, add a country, or quit. \n[see,add,quit]: ");
			String choice = scnr.nextLine();
			if (choice.equals("quit")) {
				break;
			} else if (choice.equals("see")) {
				     readFile();
			} else if (choice.equals("add")) {
				Country user = getCountryFromUser(scnr);
				System.out.println("Adding " + user);
				appendLineToFile(user);
			} else {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("Goodbye.");
		scnr.close();
	}
	

	private static Country getCountryFromUser(Scanner scnr) {
	    String name = Validator.getString(scnr, "Enter a Country you would like to add.\n ");
	    int population = Validator.getInt(scnr, "Enter the countries population:\n ");
	    return new Country (name, population);
	}

	
	 //Read all the objects from a file and store them in a List.
	 public static List<Country> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			
			for(String word: lines) {
				//System.out.println(word);
			
				String[] parts = word.split("~~~");
				System.out.println(Arrays.deepToString(parts));// separate each part based on index
				
				String name= parts[0];
				int population= Integer.parseInt(parts[1]);
				
				countries.add(Country(name,population));//  add to list new list
			} return countries;
			
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			
			return new ArrayList <>();
		}
	}

	
	
	


	private static Country Country(String name, int population) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void appendLineToFile(Country thing) {
		String line;
		line= thing.getName()+ "~~~" + thing.getPopulation();
		
		
		// Files.write requires a list of lines. Create a list of one line.
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}

}