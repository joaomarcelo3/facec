package main;

import java.io.File;
import java.io.IOException;

public class Report {

    File report;
    
    public void caminhoReport(String pathReport) throws IOException{

        this.report = new File(pathReport);
            if (report.createNewFile()) {
                System.out.println("\nreport file created");
            } else {
                System.out.println("\nreport file will be overwrite");
            }

			System.out.println("report generated");
    }
}
