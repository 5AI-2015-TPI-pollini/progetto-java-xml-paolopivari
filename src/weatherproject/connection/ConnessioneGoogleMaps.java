/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherproject.connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Paolo
 */
public class ConnessioneGoogleMaps {
    private String str;
    private Document document;
    private DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    public ConnessioneGoogleMaps(String s) throws MalformedURLException, IOException, 
            SAXException, ParserConfigurationException
    {
                    this.str=str;
                    String luogo;
                    //Tolgo gli spazi
                    luogo = s.replace(" ","");
                    System.out.println(luogo);
                    URL url = new URL("http://www.google.com/maps/api/geocode/xml?address=" + luogo);
                    URLConnection con = url.openConnection();
                    //Parse del documento preso dal sito
                    document = docBuilderFactory.newDocumentBuilder().parse(con.getInputStream());       
                }
    
    public Document prendiDoc()
    {
        return document;
    }
}
