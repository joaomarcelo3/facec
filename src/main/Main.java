package main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Arquivo arquivo = new Arquivo();
		
		// main try-catch
		try {
		
			// get the file path from user
			System.out.print("file path: ");
			String pathFile = scanner.nextLine();
			
			// set the file reader	
			String leitor = arquivo.caminhoArquivo(pathFile);
			
			arquivo.leitorArquivo();
			
			// set the file info
			arquivo.setArquivo();
	
			// print the file info			
			System.out.println(arquivo.toString());

			// create the report file
			String pathReport = leitor + "\\report.txt";
			Report report = new Report();
			report.caminhoReport(pathReport);

			// write the report file
			FileWriter writer = new FileWriter(pathReport);
			writer.write(arquivo.toString());
		
			// close objects
			scanner.close();
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


		




