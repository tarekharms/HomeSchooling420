/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author tarek.harms
 */
public class XML implements IDatenhaltung
{
    private static final String PFAD = "./daten.xml";
    
    @Override 
    public void speichern(String links, String rechts)
    {
    }

    @Override
    public Object[][] dateiLesen() 
    {
        ArrayList<String[]> datenListe = new ArrayList<String[]>();
        String[][] daten;
        
        daten = new String[datenListe.size()][2];
        int zeile = 0;
        
        for(String[] row : datenListe)
        {
        	daten[zeile][0] = row[0];
        	daten[zeile][1] = row[1];
        	zeile++;
        }
        
        return daten;
    }
}
