package xxgam.oracle.apps.fa.sumaria.inquiry.util;


import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.util.List;
import java.io.*;
import java.util.LinkedList;
import java.net.URL;

public class ValidaArchivosXml {

public String strErrmsg = null; 
public String strErrcod = null; 
    
    public ValidaArchivosXml() {
    }
    
    public boolean validaXML(String pStrXML){
            boolean flag=true;
            try {
             Source xmlFile = new StreamSource(new StringReader(pStrXML));
             URL schemaFile = new URL("https://www.w3.org/2001/XMLSchema.xsd");
             SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
             Schema schema = schemaFactory.newSchema(schemaFile);
             Validator validator = schema.newValidator();
             final List exceptions = new LinkedList();
             validator.setErrorHandler(new ErrorHandler()
              {
              @Override
              public void warning(SAXParseException exception) throws SAXException
              {
               exceptions.add(exception);
              }
              @Override
              public void fatalError(SAXParseException exception) throws SAXException
              {
               exceptions.add(exception);
              }
              @Override
              public void error(SAXParseException exception) throws SAXException
              {
               exceptions.add(exception);
              }
              });

             validator.validate(xmlFile);

              } catch (SAXException ex) {
                  strErrmsg = ex.getMessage(); 
                  strErrcod = "1"; 
                  flag = false;
                  return flag;
              
              } catch (IOException e) {
              strErrmsg = e.getMessage(); 
              strErrcod = "2"; 
                 
              flag =false;
              return flag;
             }
            return flag;
        }
    
}
