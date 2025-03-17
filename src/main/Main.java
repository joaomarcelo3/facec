package main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// main try-catch
		try {
		
			// get the file path from user
			System.out.print("Nome do arquivo: ");
			String nomeDoArquivo = scanner.nextLine();
			
			// set the file reader
			Arquivo arquivo = new Arquivo(nomeDoArquivo);
			arquivo.lerArquivo();
			
			// set the file info
			arquivo.carregarInformacoesDoArquivo();
	
			// print the file info
			System.out.println("");			
			System.out.println(arquivo);

			// create the report file
			String caminhoDorelatorio = arquivo.getArquivo() + "\\report.txt";
			Relatorio relatorio = new Relatorio();
			relatorio.caminhoReport(caminhoDorelatorio);

			// write the report file
			FileWriter writer = new FileWriter(caminhoDorelatorio);
			writer.write(arquivo.toString());
		
			// close objects
			writer.close();

		}catch (FileNotFoundException e) {

			// print error message
			System.err.println("erro no arquivo: " + e.getMessage());

		} catch (IOException e) {

			// print error message
			System.err.println("erro ao criar ou gravar o relatório do arquivo: " + e.getMessage());
		} finally{

			scanner.close();
		}
	}
}