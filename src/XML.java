/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author tarek.harms
 */
public class XML implements IDatenhaltung
{
    public static final String PFAD = System.getProperty("user.home") + "\\documents\\homeschooling420\\daten.xml";
    
    @Override 
    public void speichern(String links, String rechts) throws IOException
    {	
    	String[][] daten = (String[][])dateiLesen();
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	try
    	{
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	
        	Document doc = db.newDocument();
        	
        	Element table = doc.createElement("table");
        	
        	doc.appendChild(table);    	
        	
        	int leng = daten.length;
        	
        	for(int zeile = 0; zeile < leng; zeile++)
        	{
        		Element row = doc.createElement("row");
        		Element textEins = doc.createElement("textEins");
        		textEins.appendChild(doc.createTextNode(daten[zeile][0]));
        		Element textZwei = doc.createElement("textZwei");
        		textZwei.appendChild(doc.createTextNode(daten[zeile][1]));
        		
        		row.appendChild(textEins);
        		row.appendChild(textZwei);
        		table.appendChild(row);
        	}
        	
    		Element row = doc.createElement("row");
    		Element textEins = doc.createElement("textEins");
    		textEins.appendChild(doc.createTextNode(links));
    		Element textZwei = doc.createElement("textZwei");
    		textZwei.appendChild(doc.createTextNode(rechts));
    		
    		row.appendChild(textEins);
    		row.appendChild(textZwei);
    		table.appendChild(row);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            DOMSource source = new DOMSource(doc);          
            StreamResult result = new StreamResult(new File(PFAD));  

            transformer.transform(source, result);
    	}
    	catch (Exception ex)
    	{
    		System.out.println(ex);
    	}
    }

    @Override
    public String[][] dateiLesen() throws IOException
    {
    	File datei = new File(PFAD);
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    	
    	try 
    	{
        	DocumentBuilder db = dbf.newDocumentBuilder();
        	
        	Document doc = db.parse(datei);
        	doc.getDocumentElement().normalize();
        	
        	NodeList liste = doc.getElementsByTagName("row");
        	
        	String[][] daten = new String[liste.getLength()][2];
        	
        	for (int zeile = 0; zeile < liste.getLength(); zeile++)
        	{
        		Element element = (Element)liste.item(zeile);
        		
        		daten[zeile][0] = element.getElementsByTagName("textEins").item(0).getTextContent();
        		daten[zeile][1] = element.getElementsByTagName("textZwei").item(0).getTextContent();
        	}
        	
        	return daten;
    	}
    	catch (Exception e)
    	{
    		System.out.println(e);
    	}
    	
    	return new String[0][2];
    }
}






















