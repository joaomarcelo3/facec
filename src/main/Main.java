package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // set the general scanner
		Arquivo arquivo = new Arquivo();
		
		// main try-catch
		try {
		
			// get the file path from user
			System.out.print("file path: ");
			String pathFile = scanner.nextLine();
			scanner.close();

			// set the file reader
			// Scanner reader = new Scanner(new FileReader(pathName));		
			String pathReport = arquivo.caminhoArquivo(pathFile);
			
			arquivo.leitorArquivo();
			
			// set the file info
			arquivo.setArquivo();
	
			// print the file info			
			arquivo.toString();

			// create the report file
			File report = new File(pathReport);
			if (report.createNewFile()) {
				System.out.println("\nreport file created");
			} else {
				System.out.println("\nreport file will be overwrite");
			}

			// write the report file
			FileWriter writer = new FileWriter(pathReport);
			writer.write(arquivo.toString());
			

			// print success message
			System.out.println("report generated");

			// close objects
			writer.close();

		}catch (FileNotFoundException e) {

			// print error message
			System.err.println("error in open content file: " + e.getMessage());

		} catch (IOException e) {

			// print error message
			System.err.println("error in create or write to report file: " + e.getMessage());
		}
			

	}

}


		




