package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


public class Arquivo {

    private File arquivo;
    private String nomeDoArquivo;
    private String caminhoDoArquivo;
    private boolean ehLegivel;
    private boolean ehEditavel;
    private String tamanhoDoArquivo;

    public Arquivo(String nomeArquivo){
        this.arquivo = new File(nomeArquivo).getAbsoluteFile();
    }
  
    public String getArquivo(){
        return this.arquivo.getParent();
    }

    public void lerArquivo() throws IOException {
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        
        String linha;
        System.out.println("Informações do Arquivo:");
        while((linha = br.readLine()) != null){
            System.out.println(linha);
        }
        br.close();
    }

    public void carregarInformacoesDoArquivo(){

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
        return String.format(
            "---------------Relatório do Arquivo---------------\n" +
            "Nome do arquivo: %s\n" +
            "Caminho do arquivo: %s\n" +
            "Pode ser lido: %s\n" +
            "Pode ser editado: %s\n" +
            "Tamanho do arquivo: %s\n" + 
            "--------------------------------------------------",nomeDoArquivo, caminhoDoArquivo, ehLegivel, ehEditavel, tamanhoDoArquivo
        );
    } 
}