/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.inquiry.summary.webui;

import java.sql.Blob;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;

import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransactionImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAPageLayoutBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageFileUploadBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;
import oracle.apps.xdo.oa.schema.server.TemplateHelper;
import oracle.cabo.ui.data.DataObject;

import oracle.jbo.domain.BlobDomain;

import oracle.jdbc.internal.OracleConnection;

import xxgam.oracle.apps.fa.sumaria.inquiry.server.InquiryAMImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafSumariaTblVOImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafSumariaTblVORowImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafYtdeTblVOImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafYtdeTblVORowImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.summary.util.XxGamReadExcel;


/**
 * Controller for ...
 */
public class XxGamSumariaCO extends OAControllerImpl
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
    
      InquiryAMImpl InquiryAM = (InquiryAMImpl)pageContext.getApplicationModule(webBean); 
      
      XxGamSafSumariaTblVOImpl SumariaTblVO = null; 
      
      SumariaTblVO = InquiryAM.getXxGamSafSumariaTblVO1();
      
      if(!pageContext.isFormSubmission()){
      
        System.out.println("Se inicializan y ejecutan los ViewObjects");
            
        if(null!=SumariaTblVO){
        
      SumariaTblVO.executeQuery();
        }
  }{
         System.out.println();
       }
       
     String auxProfile =  pageContext.getProfile("XXGAM_SAF_UPDATE");
     System.out.println("-->"+auxProfile);
     
     if ("N".equals(auxProfile)){
     //nadie sabe como funciona
         //si no tenemos permiso   msfUpload
      OAMessageFileUploadBean oAMessageFileUploadBean = (OAMessageFileUploadBean)webBean.findChildRecursive("msfUpload");
      OAMessageFileUploadBean.setRendered(oAMessageFileUploadBean,false);
      
     }
     
}

    public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
    {
      super.processFormRequest(pageContext, webBean);
        String auxParam="";
        Enumeration enums = pageContext.getParameterNames();
       /* while(enums.hasMoreElements()){
        String paramName = enums.nextElement().toString();
        System.out.println("Param name:-->"+paramName+"; Value:"+pageContext.getParameter(paramName));
        }*/
      
        InquiryAMImpl InquiryAM = (InquiryAMImpl)pageContext.getApplicationModule(webBean);
        String strEventParam =   pageContext.getParameter(this.EVENT_PARAM);
        String strSourceParam =   pageContext.getParameter(this.SOURCE_PARAM);
        String strEventSourceRowId =   pageContext.getParameter(this.EVENT_SOURCE_ROW_ID_PARAM);
        String strEventSourceRowReference =   pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);
        
        String strCurrentRow =  pageContext.getParameter("pCurrentId");
        
          System.out.println("strEventParam:"+strEventParam);
          System.out.println("strSourceParam:"+strSourceParam);
          System.out.println("strEventSourceRowId:"+strEventSourceRowId);
          System.out.println("strEventSourceRowReference:"+strEventSourceRowReference);
          System.out.println("strCurrentRow:"+strCurrentRow);
          
        //if("updateBtn".equals(pageContext.getParameter(this.EVENT_PARAM))){    
        //}
        if("ActualizarEvt".equals(strEventParam)){
           String strPsumariaId = pageContext.getParameter("pSumariaId");
            XxGamSafSumariaTblVORowImpl sumariaRow = InquiryAM.filterSumariaVO(strPsumariaId);
            System.out.println("Id: "+strPsumariaId);
            System.out.println("SafSumariaId:"+sumariaRow.getSafSumariaId());
            /*********************************************************/
             String auxIdMfU =   pageContext.getParameter("evtSrcRowIdx");
            System.out.println("||||||"+auxIdMfU);
             OAPageLayoutBean oaPageLayoutBean = pageContext.getPageLayoutBean();
             if(null!=oaPageLayoutBean){
              OATableBean oaTableBean = (OATableBean)oaPageLayoutBean.findChildRecursive("XxGamSafSumariaTblVO1"); 
              System.out.println("==>>: "+oaTableBean);
              String strTableName = (String)webBean.findIndexedChildRecursive("XxGamSafSumariaTblVO1").getAttributeValue(null,NAME_ATTR);
              System.out.println("strTableName:"+strTableName); //N3
                 auxParam=  strTableName+":MessageFileUpload:"+auxIdMfU;
                 System.out.println(auxParam);
              OAMessageFileUploadBean oaMessageFileUploadBean = (OAMessageFileUploadBean)oaTableBean.findChildRecursive("MessageFileUpload");
             }
            /*********************************************************/
            /*******************************************************************
            if(null==sumariaRow.getFileSumaria()){
             throw new OAException("EL contenido esta vacio.",OAException.ERROR); 
            }
            System.out.println("FileSumaria:"+sumariaRow.getFileSumaria());
            oracle.jbo.domain.BlobDomain lFileSumaria = sumariaRow.getFileSumaria();
            **************************************************************************/
            System.out.println("Se ejecuta el metodo upLoadFile");
             upLoadFile(auxParam,pageContext,webBean); 
             
            //upLoadFile("N3:MessageFileUpload:0",pageContext,webBean); 
        }
        
         
          
        if("ArchivoExcelEvt".equals(pageContext.getParameter(this.EVENT_PARAM))){
          XxGamSafSumariaTblVORowImpl SafSumariaTblVORow = null;
          SafSumariaTblVORow = InquiryAM.findXxGamSafSumariaCurrrentRow(strCurrentRow);      
          String strPeriodo = SafSumariaTblVORow.getPeriod(); 
          
          oracle.jbo.domain.ClobDomain clobXmlStr = SafSumariaTblVORow.getXmlString();
          String strClobXmlStr = clobXmlStr.toString(); 
          
          System.out.println("Periodo:"+strPeriodo); 
          //System.out.println("numCreatedBy:"+numCreatedBy);
          System.out.println("Unidad Operativa:"+SafSumariaTblVORow.getOperatingUnit());
          System.out.println("strClobXmlStr:"+strClobXmlStr);
          
          DataObject dataobject =  pageContext.getNamedDataObject("_SessionParameters");
          HttpServletResponse response = (HttpServletResponse)dataobject.selectValue(null, "HttpServletResponse");
    
          ServletOutputStream servletoutputstream = null;
          
          try {
          
              servletoutputstream = response.getOutputStream();
              response.setHeader("Content-Disposition", "attachment;filename=XxGamSafSumariaMaster"+System.currentTimeMillis()+".xls");
              response.setContentType("application/MSEXCEL");
              ByteArrayInputStream inputStream = new ByteArrayInputStream(strClobXmlStr.getBytes());
              ByteArrayOutputStream excelFile = new ByteArrayOutputStream();
              
              TemplateHelper.processTemplate(((OADBTransactionImpl)pageContext.getRootApplicationModule().getOADBTransaction()).getAppsContext(), 
                                                             "XBOL",//XxGQRecibosConstants.XXGQ_APP_SHORT_CUSTOM, 
                                                             "XXGAM_SAF_WS_MASTER", 
                                                            ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getLanguage(), 
                                                            ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getCountry(), 
                                                            inputStream,
                                                            TemplateHelper.OUTPUT_TYPE_EXCEL, 
                                                            null, 
                                                            excelFile
                                                            );
              byte[] b = excelFile.toByteArray();
              response.setContentLength(b.length);
              servletoutputstream.write(b, 0, b.length);
              servletoutputstream.flush();
              servletoutputstream.close();
              
          
              
          }
          catch(Exception e){
              response.setContentType("text/html");
              throw new OAException("Excepcion:"+e.getMessage(),OAException.ERROR);  
          }
    }

    }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   
   public void upLoadFile(OAPageContext pageContext,OAWebBean webBean)
   { /*String filePath = "D:\\Julian\\test";*/
     XxGamReadExcel leer = new XxGamReadExcel();  
       OracleConnection conn;
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
         
         System.out.println("Leer excel ");
       leer.readExcel(file);
         String xmlString = leer.prepareXML();
         leer.SetTotals();
         //System.out.println(xmlString);
         /*Actualizar tabla sumaria*/
          System.out.println("Actualizando tabla sumaria_________");
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          String strPsumariaId = pageContext.getParameter("pSumariaId");
         Serializable[] param = {strPsumariaId};
         am.invokeMethod("updateRecord", param);
     }
    }
    catch(NullPointerException npe){
        throw new OAException(npe.getMessage()+", "+npe.toString(), OAException.ERROR);
    }
    catch(Exception ex)
    {
     throw new OAException(ex.getMessage(), OAException.ERROR);
    }
   } 
  
  /**
     * Metodo sobrecargado que funciona para cargar mas de un archivo
     * @param pFileSumaria
     * @param pageContext
     * @param webBean
     */
   public void upLoadFile(BlobDomain pFileSumaria,  OAPageContext pageContext,OAWebBean webBean)
   {
     XxGamReadExcel leer = new XxGamReadExcel();  
    try
    {
      InputStream input = null;
      /* stream -> flujo    
       * InputStream  de objeto de bytes abrir canal al inputstream
       * OutputStream llenar objeto de bytes 
       * */ 
     /*  leer.validaExcel(uFileName);  */
      BlobDomain uploadedByteStream = pFileSumaria;
      input = uploadedByteStream.getInputStream();/*obtener informacion*/
      leer.readExcelInputStream(input); 
      String myAux = leer.prepareXML();
      //System.out.println(myAux);
         
            
     }
    catch(NullPointerException npe){
        throw new OAException(npe.getMessage()+", "+npe.toString(), OAException.ERROR);
    }
    catch(Exception ex)
    {
     throw new OAException(ex.getMessage(), OAException.ERROR);
    }
   
   } /** END  public void upLoadFile(BlobDomain pFileSumaria,  OAPageContext pageContext,OAWebBean webBean) **/
   
   
    /**
     * Procedure to handle form submissions for form elements in
     * a region.
     * @param pageContext the current OA page context
     * @param webBean the web bean corresponding to the region
     */
     public void upLoadFile(String pParameter,OAPageContext pageContext,OAWebBean webBean)
     { /*String filePath = "D:\\Julian\\test";*/
       XxGamReadExcel leer = new XxGamReadExcel();  
      /*System.out.println("Default File Path---->"+filePath);*/
      
      String MessageFileUpload = pageContext.getParameter(pParameter/*"MessageFileUpload"*/);
          System.out.println("::::--->:MessageFileUpload: " + MessageFileUpload); 
      String fileUrl = null;
      try
      {
       DataObject fileUploadData =  pageContext.getNamedDataObject(pParameter/*"MessageFileUpload"*/);  
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
           String test=leer.prepareR1();
            System.out.println("<><><>"+test);
           /*Actualizar tabla sumaria*/
            System.out.println("Actualizando tabla sumaria_________");
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            String strPsumariaId = pageContext.getParameter("pSumariaId");
           Serializable[] param = {strPsumariaId,myAux};
           Serializable[] param2 = {test};
           am.invokeMethod("updateRecord", param);
           System.out.println("Entrando en exec_insert...");
           am.invokeMethod("exec_insert",param2);
           System.out.println("Saliendo de.. exec_insert...");
           
               
       }
      }
      catch(NullPointerException npe){
          throw new OAException(npe.getMessage()+", "+npe.toString(), OAException.ERROR);
      }
      catch(Exception ex)
      {
       throw new OAException(ex.getMessage(), OAException.ERROR);
      }
     }
   
  
 

}
