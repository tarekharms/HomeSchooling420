/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author tarek.harms
 */
public class HomeSchooling420 {
    public static void main(String[] args) throws IOException
    {
		createDirIfNotExists(new File(System.getProperty("user.home") + "\\documents\\homeschooling420"));
		createDirIfNotExists(new File(System.getProperty("user.home") + "\\documents"));
		
    	File saveFile = new File(CSV.PFAD);
    	if(!saveFile.exists())
    	{
        	saveFile.createNewFile();
    	}
    	
    	saveFile = new File(XML.PFAD);
    	if(!saveFile.exists())
    	{
        	saveFile.createNewFile();
    	}
    	
        Ansicht ansicht = new Ansicht(new CSV());
        
        ansicht.open();
    }

    private static boolean createDirIfNotExists(File dir) throws IOException {
      System.out.println("createDirIfNotExists(" + dir + ")");
      if (!dir.exists()) {
        dir.mkdir();
        return true;
      } else {
        return false;
      }
    }
}
