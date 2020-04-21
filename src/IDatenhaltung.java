/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/**
 *
 * @author tarek.harms
 */
public interface IDatenhaltung {
    public void speichern(String linkeSpalte, String rechteSpalte) throws IOException;
    public Object[][] dateiLesen() throws IOException;
}
