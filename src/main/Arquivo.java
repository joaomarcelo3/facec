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
    String ehLegivel;
    String ehEditavel;
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

        System.out.println("informações do arquivo");
        this.nomeDoArquivo = "name: " + arquivo.getName();
        this.caminhoDoArquivo = "path: " + arquivo.getAbsolutePath();
        this.ehLegivel = "readable: " + arquivo.canRead();
        this.ehEditavel = "writeable: " + arquivo.canWrite();
        this.tamanhoDoArquivo = "size: " + df.format(contentSize) + " MiB";
    }

    @Override
    public String toString() {
        return "Arquivo [ nomeDoArquivo=" + nomeDoArquivo
                + ", caminhoDoArquivo=" + caminhoDoArquivo + ", ehLegivel=" + ehLegivel + ", ehEditavel=" + ehEditavel
                + ", tamanhoDoArquivo=" + tamanhoDoArquivo + "]";
    } 

    
    
}
