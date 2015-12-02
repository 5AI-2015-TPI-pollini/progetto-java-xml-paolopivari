/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherproject.meteo;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Paolo
 */
public class HandlerLuogo {
    private static final XPathFactory xpathFactory = XPathFactory.newInstance();
    private Luogo[] luoghi;
    private String address = "/GeocodeResponse/result/formatted_address/text()";
    private String latitudine = "/GeocodeResponse/result/geometry/location/lat/text()";
    private String longitudine = "/GeocodeResponse/result/geometry/location/lng/text()";
    
    public HandlerLuogo(){}
    
    public Luogo[] ottieni(Document xml) {
        try {
            XPath xpath = xpathFactory.newXPath();
            
            // Complial le XPATH expression per valutarle piu tardi
            XPathExpression indirizzo = xpath.compile(address);
            XPathExpression lat = xpath.compile(latitudine);
            XPathExpression lon = xpath.compile(longitudine);
            
            // Valuta l'espressioni XPATH nel contesto specifico e ritorna il risultato del tipo designato
            NodeList luoghis = (NodeList) indirizzo.evaluate(xml, XPathConstants.NODESET);
            NodeList latitudine = (NodeList) lat.evaluate(xml, XPathConstants.NODESET);
            NodeList longitudine= (NodeList) lon.evaluate(xml, XPathConstants.NODESET);
            
            luoghi = new Luogo[luoghis.getLength()];
            for (int i = 0; i < luoghi.length; i++) 
                 luoghi[i] = new Luogo(luoghis.item(i).getNodeValue(), Double.parseDouble(latitudine.item(i).getNodeValue()), Double.parseDouble(longitudine.item(i).getNodeValue()));
            } catch (XPathExpressionException ex) {
            System.out.println("Non è possibile ottenere il luogo");
    }
        return luoghi;
    }
    
    public int ottieniLuoghi()
    {
        return luoghi.length;
    }
}
