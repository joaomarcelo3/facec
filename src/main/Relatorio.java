package main;

import java.io.File;
import java.io.IOException;

public class Relatorio {

    public boolean criarPastaRelatorio(){
        File pasta = new File("relatórios");
        if (!pasta.exists()) {
            pasta.mkdir();
            System.out.println("Pasta do relatório criada!");
        } else{
            System.out.println("a Pasta já existe!");
        }
        return true;
    }
    
    public boolean gerarRelatorio(String caminhoDoRelatorio) throws IOException{

            File relatorio = new File(caminhoDoRelatorio);
            if (!relatorio.exists()) {
                if (relatorio.createNewFile()) 
                    System.out.println("\nArquivo de relatório criado");
                } else {
                    System.out.println("\nArquivo de relatório sobrescrito");
                }

			System.out.println("Relatório gerado!");
            return true;
    }
}
