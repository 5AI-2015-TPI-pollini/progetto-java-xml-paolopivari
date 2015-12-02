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

/**
 *
 * @author Paolo
 */
public class HandlerMeteo {
    private static final XPathFactory xpathFactory = XPathFactory.newInstance();
    private Meteo forecast;
    private static final String temperatura = "/current/temperature/@value";
    private static final String mintemp = "/current/temperature/@min";
    private static final String maxtemp = "/current/temperature/@max";
    private static final String sky = "/current/clouds/@name";
    
    
    public HandlerMeteo(){}
    
    public Meteo ottieni(Document xml) {
        try {
            XPath xpath = xpathFactory.newXPath();
            // Prepare the queries
            XPathExpression temp = xpath.compile(temperatura);
            XPathExpression mint = xpath.compile(mintemp);
            XPathExpression maxt = xpath.compile(maxtemp);
            XPathExpression skyx = xpath.compile(sky);
            // Execute the xpath query
            double tempora = (Double) temp.evaluate(xml, XPathConstants.NUMBER);
            double mintempora = (Double) mint.evaluate(xml, XPathConstants.NUMBER);
            double maxtempora = (Double) maxt.evaluate(xml, XPathConstants.NUMBER);
            String cloudora = (String) skyx.evaluate(xml, XPathConstants.STRING);
            forecast = new Meteo(tempora, mintempora, maxtempora, cloudora);
            
        } catch (XPathExpressionException ex) {
            System.out.println("extractFromDoc has reported an error");
        }
        return forecast;
    }
}
