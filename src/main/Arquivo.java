package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Arquivo {

    File arquivo;
    int contador;

    String nomeDoArquivo;
    String caminhoDoArquivo;
    boolean ehLegivel;
    boolean ehEditavel;
    String tamanhoDoArquivo;
  
    public String caminhoArquivo(String nomeArquivo){

        this.arquivo = new File(nomeArquivo).getAbsoluteFile();
        return arquivo.getParent();
        
    }

    public void leitorArquivo() throws FileNotFoundException{
        Scanner leitor = new Scanner(arquivo);

        System.out.println("Conteúdo do arquivo:");
        while (leitor.hasNextLine()) {
            System.out.printf("linha = %d %s\n", ++contador, leitor.nextLine());
        }

        leitor.close();
    }

    public void setArquivo(){

        DecimalFormat df = new DecimalFormat("#.##");
        double contentSize = arquivo.length() / Math.pow(1024, 2);

        this.nomeDoArquivo = arquivo.getName();
        this.caminhoDoArquivo =arquivo.getAbsolutePath();
        this.ehLegivel = arquivo.canRead();
        this.ehEditavel = arquivo.canWrite();
        this.tamanhoDoArquivo = df.format(contentSize) + " MiB";
    }

    @Override
    public String toString() {
        return "Informações do arquivo:\n" +
                "Nome do arquivo: " + nomeDoArquivo +"\n" +
                "Caminho do arquivo: " + caminhoDoArquivo +"\n" +
                "Pode ser lido: " + ehLegivel + "\n" +
                "Pode ser editado: " + ehEditavel + "\n" +
                "Tamanho do arquivo: " + tamanhoDoArquivo ;
    } 

    
    
}
