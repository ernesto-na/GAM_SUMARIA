/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.upload.webui;



import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.cabo.ui.data.DataObject;
import java.io.FileOutputStream;
import java.io.InputStream;
import oracle.jbo.domain.BlobDomain;
import java.io.File;
import oracle.apps.fnd.framework.OAException;

import oracle.apps.fnd.framework.webui.beans.OAWebBeanFileUpload;

import xxgam.oracle.apps.fa.sumaria.inquiry.summary.util.XxGamReadExcel;


/**
 * Controller for ...
 */
public class XxGamUploadExcelCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    String strOperativeSystem=  System.getProperty("os.name");
      String fileSeparator=  System.getProperty("file.separator");
    System.out.println("strOperativeSystem:"+strOperativeSystem);
    System.out.println("Separator"+ fileSeparator);
    if(!pageContext.isFormSubmission()){
       
    }else{
    
    }
    
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
    
      if(pageContext.getParameter("Submit")!=null)
       {
        upLoadFile(pageContext,webBean);           
       }
  }
  
    public void upLoadFile(OAPageContext pageContext,OAWebBean webBean)
    { /*String filePath = "D:\\Julian\\test";*/
      XxGamReadExcel leer = new XxGamReadExcel();  
     /*System.out.println("Default File Path---->"+filePath);*/
     String MessageFileUpload = pageContext.getParameter("MessageFileUpload");
     System.out.println("::::--->:MessageFileUpload: " + MessageFileUpload);               
     String fileUrl = null;
     try
     {
      DataObject fileUploadData =  pageContext.getNamedDataObject("MessageFileUpload");  
      String aux1 = fileUploadData.toString();
         System.out.println("00000:"+aux1);
    //FileUploading is my MessageFileUpload Bean Id
      if(fileUploadData!=null)
      {/*Entro al dataObject */
       String uFileName = (String)fileUploadData.selectValue(null, "UPLOAD_FILE_NAME");    
          System.out.println("***------>"+uFileName);
          String uFileName2 = (String)fileUploadData.selectValue(null, "UPLOAD_FILE_PATH");   
          System.out.println("***------>"+uFileName2);
       String contentType = (String) fileUploadData.selectValue(null, "UPLOAD_FILE_MIME_TYPE");  
       System.out.println("User File Name---->"+uFileName);
       FileOutputStream output = null;
       InputStream input = null;
       /* stream -> flujo    
        * InputStream  de objeto de bytes abrir canal al inputstream
        * OutputStream llenar objeto de bytes 
        * */ 
     /*  leer.validaExcel(uFileName);  */
       BlobDomain uploadedByteStream = (BlobDomain)fileUploadData.selectValue(null, uFileName);
     /*  System.out.println("uploadedByteStream---->"+uploadedByteStream);*/
       File file = new File(uFileName);  
       System.out.println("File output---->"+file);
       output = new FileOutputStream(file); /*alimentar de informacion*/
       System.out.println("output----->"+output);
       input = uploadedByteStream.getInputStream();/*obtener informacion*/
       System.out.println("input---->"+input);
       byte abyte0[] = new byte[0x19000];
       int i;
       while((i = input.read(abyte0)) > 0){
       output.write(abyte0, 0, i);
       }
          output.close();
          input.close();
          
        leer.readExcel(file);
          String myAux = leer.prepareXML();
          
              System.out.println(myAux);
      
      }
     }
     catch(Exception ex)
     {
     System.out.println("Message error: "+ex.getMessage());
      throw new OAException("-->"+ex.getMessage(), OAException.ERROR);
     }
    } 
}


