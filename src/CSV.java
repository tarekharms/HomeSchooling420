/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author tarek.harms
 */
public class CSV implements IDatenhaltung 
{
    private static final String PFAD = "C:\\Users\\tarek.harms\\eclipse-workspace\\HomeSchooling420\\bin\\daten.csv";
    
    @Override
    public void speichern(String linkeSpalte, String rechteSpalte) throws IOException
    {
        FileWriter csvWriter = new FileWriter(PFAD, true);
        csvWriter.append(linkeSpalte);
        csvWriter.append(",");
        csvWriter.append(rechteSpalte);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }

    @Override
    public Object[][] dateiLesen() throws IOException
    {
        ArrayList<String[]> datenListe = new ArrayList<>();
        
        BufferedReader csvReader = new BufferedReader(new FileReader(PFAD));
        String row;
        while((row = csvReader.readLine()) != null)
        {
        	datenListe.add(row.split(","));
        }
        csvReader.close();
        
        String[][] daten;
        
        daten = new String[datenListe.size()][2];
        int zeile = 0;
        
        for(String[] datenZeile : datenListe)
        {
        	daten[zeile][0] = datenZeile[0];
        	daten[zeile][1] = datenZeile[1];
        	zeile++;
        }
        
        
        return daten;
    }
    
}
