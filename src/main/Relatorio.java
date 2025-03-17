package main;

import java.io.File;
import java.io.IOException;

public class Relatorio {

    File relatorio;
    
    public void caminhoReport(String caminhoDoRelatorio) throws IOException{

        this.relatorio = new File(caminhoDoRelatorio);
            if (relatorio.createNewFile()) {
                System.out.println("\nArquivo de relatório criado");
            } else {
                System.out.println("\nArquivo de relatório sobrescrito");
            }

			System.out.println("Relatório gerado!");
    }
}
