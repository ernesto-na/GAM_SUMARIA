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
import xxgam.oracle.apps.fa.sumaria.inquiry.summary.util.Rubro;
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
           //String test[]=leer.prepareR1();
           Rubro testRubro = leer.prepareR1DprnInitBal();
           Rubro rubro2=leer.prepareR2();
           Rubro rubro3=leer.prepareR3();
           Rubro rubro4=leer.prepareR4();
           Rubro rubro5=leer.prepareR5();
           Rubro rubro6=leer.prepareR6();
           Rubro rubro7=leer.prepareR7();
           Rubro rubro8=leer.prepareR8();
           Rubro rubro9=leer.prepareR9();
           Rubro rubro10=leer.prepareR10();
           Rubro rubro11=leer.prepareR11();
           Rubro rubro12=leer.prepareR12();
           Rubro rubro13=leer.prepareR13();
           Rubro rubro14=leer.prepareR14();
           Rubro rubroI1=leer.prepareRI1();
            
            
           /*Actualizar tabla sumaria*/
            System.out.println("Actualizando tabla sumaria_________");
            try{
                OAApplicationModule am = pageContext.getApplicationModule(webBean);
                String strPsumariaId = pageContext.getParameter("pSumariaId");
                Serializable[] param = {strPsumariaId,myAux};
                System.out.println("Empieza a actualizar");
                am.invokeMethod("updateRecord", param);
                System.out.println("Termina de actualizar");
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
            try{
                OAApplicationModule am = pageContext.getApplicationModule(webBean);
                Serializable[] param2 = {testRubro.getUnOper(),testRubro.getId_rubro(),testRubro.getRubro(),testRubro.getP_inicial(),testRubro.getP_final(),testRubro.getCOST_SALDO_INICIAL(),testRubro.getDPRN_INITIAL_BALANCE(),testRubro.getCOST_ADDITIONS(),testRubro.getCOST_BAJAS(),testRubro.getCOST_TRANSFERS_SALE(),testRubro.getDPN_DEPRECIACION(),testRubro.getDPN_BAJAS(),testRubro.getDPN_VAR_TIP_CAMBIO(),testRubro.getCOST_VAR_TIP_CAMBIO(),testRubro.getCOST_SALDO_FINAL(),testRubro.getDPN_SALDO_FINAL()};
                System.out.println("Entrando en exec_insert...");
                am.invokeMethod("exec_insert",param2);
                System.out.println("Saliendo de.. exec_insert...");
            }catch(Exception e){
                System.out.println(e.getMessage()); 
            }
           try{
               OAApplicationModule am = pageContext.getApplicationModule(webBean);
               Serializable[] param2 = {rubro2.getUnOper(),rubro2.getId_rubro(),rubro2.getRubro(),rubro2.getP_inicial(),rubro2.getP_final(),rubro2.getCOST_SALDO_INICIAL(),rubro2.getDPRN_INITIAL_BALANCE(),rubro2.getCOST_ADDITIONS(),rubro2.getCOST_BAJAS(),rubro2.getCOST_TRANSFERS_SALE(),rubro2.getDPN_DEPRECIACION(),rubro2.getDPN_BAJAS(),rubro2.getDPN_VAR_TIP_CAMBIO(),rubro2.getCOST_VAR_TIP_CAMBIO(),rubro2.getCOST_SALDO_FINAL(),rubro2.getDPN_SALDO_FINAL()};
               System.out.println("Entrando en exec_insert...");
               am.invokeMethod("exec_insert",param2);
               System.out.println("Saliendo de.. exec_insert...");
           }catch(Exception e){
               System.out.println(e.getMessage()); 
           }
           try{
               OAApplicationModule am = pageContext.getApplicationModule(webBean);
               Serializable[] param2 = {rubro3.getUnOper(),rubro3.getId_rubro(),rubro3.getRubro(),rubro3.getP_inicial(),rubro3.getP_final(),rubro3.getCOST_SALDO_INICIAL(),rubro3.getDPRN_INITIAL_BALANCE(),rubro3.getCOST_ADDITIONS(),rubro3.getCOST_BAJAS(),rubro3.getCOST_TRANSFERS_SALE(),rubro3.getDPN_DEPRECIACION(),rubro3.getDPN_BAJAS(),rubro3.getDPN_VAR_TIP_CAMBIO(),rubro3.getCOST_VAR_TIP_CAMBIO(),rubro3.getCOST_SALDO_FINAL(),rubro3.getDPN_SALDO_FINAL()};
               System.out.println("Entrando en exec_insert...");
               am.invokeMethod("exec_insert",param2);
               System.out.println("Saliendo de.. exec_insert...");
           }catch(Exception e){
               System.out.println(e.getMessage()); 
           }
           try{
            OAApplicationModule am = pageContext.getApplicationModule(webBean);
            Serializable[] param2 = {rubro4.getUnOper(),rubro4.getId_rubro(),rubro4.getRubro(),rubro4.getP_inicial(),rubro4.getP_final(),rubro4.getCOST_SALDO_INICIAL(),rubro4.getDPRN_INITIAL_BALANCE(),rubro4.getCOST_ADDITIONS(),rubro4.getCOST_BAJAS(),rubro4.getCOST_TRANSFERS_SALE(),rubro4.getDPN_DEPRECIACION(),rubro4.getDPN_BAJAS(),rubro4.getDPN_VAR_TIP_CAMBIO(),rubro4.getCOST_VAR_TIP_CAMBIO(),rubro4.getCOST_SALDO_FINAL(),rubro4.getDPN_SALDO_FINAL()};
            System.out.println("Entrando en exec_insert...");
            am.invokeMethod("exec_insert",param2);
            System.out.println("Saliendo de.. exec_insert...");
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
           try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro5.getUnOper(),rubro5.getId_rubro(),rubro5.getRubro(),rubro5.getP_inicial(),rubro5.getP_final(),rubro5.getCOST_SALDO_INICIAL(),rubro5.getDPRN_INITIAL_BALANCE(),rubro5.getCOST_ADDITIONS(),rubro5.getCOST_BAJAS(),rubro5.getCOST_TRANSFERS_SALE(),rubro5.getDPN_DEPRECIACION(),rubro5.getDPN_BAJAS(),rubro5.getDPN_VAR_TIP_CAMBIO(),rubro5.getCOST_VAR_TIP_CAMBIO(),rubro5.getCOST_SALDO_FINAL(),rubro5.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
          }catch(Exception e){
              System.out.println(e.getMessage()); 
          }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro6.getUnOper(),rubro6.getId_rubro(),rubro6.getRubro(),rubro6.getP_inicial(),rubro6.getP_final(),rubro6.getCOST_SALDO_INICIAL(),rubro6.getDPRN_INITIAL_BALANCE(),rubro6.getCOST_ADDITIONS(),rubro6.getCOST_BAJAS(),rubro6.getCOST_TRANSFERS_SALE(),rubro6.getDPN_DEPRECIACION(),rubro6.getDPN_BAJAS(),rubro6.getDPN_VAR_TIP_CAMBIO(),rubro6.getCOST_VAR_TIP_CAMBIO(),rubro6.getCOST_SALDO_FINAL(),rubro6.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       } 
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro7.getUnOper(),rubro7.getId_rubro(),rubro7.getRubro(),rubro7.getP_inicial(),rubro7.getP_final(),rubro7.getCOST_SALDO_INICIAL(),rubro7.getDPRN_INITIAL_BALANCE(),rubro7.getCOST_ADDITIONS(),rubro7.getCOST_BAJAS(),rubro7.getCOST_TRANSFERS_SALE(),rubro7.getDPN_DEPRECIACION(),rubro7.getDPN_BAJAS(),rubro7.getDPN_VAR_TIP_CAMBIO(),rubro7.getCOST_VAR_TIP_CAMBIO(),rubro7.getCOST_SALDO_FINAL(),rubro7.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro8.getUnOper(),rubro8.getId_rubro(),rubro8.getRubro(),rubro8.getP_inicial(),rubro8.getP_final(),rubro8.getCOST_SALDO_INICIAL(),rubro8.getDPRN_INITIAL_BALANCE(),rubro8.getCOST_ADDITIONS(),rubro8.getCOST_BAJAS(),rubro8.getCOST_TRANSFERS_SALE(),rubro8.getDPN_DEPRECIACION(),rubro8.getDPN_BAJAS(),rubro8.getDPN_VAR_TIP_CAMBIO(),rubro8.getCOST_VAR_TIP_CAMBIO(),rubro8.getCOST_SALDO_FINAL(),rubro8.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro9.getUnOper(),rubro9.getId_rubro(),rubro9.getRubro(),rubro9.getP_inicial(),rubro9.getP_final(),rubro9.getCOST_SALDO_INICIAL(),rubro9.getDPRN_INITIAL_BALANCE(),rubro9.getCOST_ADDITIONS(),rubro9.getCOST_BAJAS(),rubro9.getCOST_TRANSFERS_SALE(),rubro9.getDPN_DEPRECIACION(),rubro9.getDPN_BAJAS(),rubro9.getDPN_VAR_TIP_CAMBIO(),rubro9.getCOST_VAR_TIP_CAMBIO(),rubro9.getCOST_SALDO_FINAL(),rubro9.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro10.getUnOper(),rubro10.getId_rubro(),rubro10.getRubro(),rubro10.getP_inicial(),rubro10.getP_final(),rubro10.getCOST_SALDO_INICIAL(),rubro10.getDPRN_INITIAL_BALANCE(),rubro10.getCOST_ADDITIONS(),rubro10.getCOST_BAJAS(),rubro10.getCOST_TRANSFERS_SALE(),rubro10.getDPN_DEPRECIACION(),rubro10.getDPN_BAJAS(),rubro10.getDPN_VAR_TIP_CAMBIO(),rubro10.getCOST_VAR_TIP_CAMBIO(),rubro10.getCOST_SALDO_FINAL(),rubro10.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro11.getUnOper(),rubro11.getId_rubro(),rubro11.getRubro(),rubro11.getP_inicial(),rubro11.getP_final(),rubro11.getCOST_SALDO_INICIAL(),rubro11.getDPRN_INITIAL_BALANCE(),rubro11.getCOST_ADDITIONS(),rubro11.getCOST_BAJAS(),rubro11.getCOST_TRANSFERS_SALE(),rubro11.getDPN_DEPRECIACION(),rubro11.getDPN_BAJAS(),rubro11.getDPN_VAR_TIP_CAMBIO(),rubro11.getCOST_VAR_TIP_CAMBIO(),rubro11.getCOST_SALDO_FINAL(),rubro11.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro12.getUnOper(),rubro12.getId_rubro(),rubro12.getRubro(),rubro12.getP_inicial(),rubro12.getP_final(),rubro12.getCOST_SALDO_INICIAL(),rubro12.getDPRN_INITIAL_BALANCE(),rubro12.getCOST_ADDITIONS(),rubro12.getCOST_BAJAS(),rubro12.getCOST_TRANSFERS_SALE(),rubro12.getDPN_DEPRECIACION(),rubro12.getDPN_BAJAS(),rubro12.getDPN_VAR_TIP_CAMBIO(),rubro12.getCOST_VAR_TIP_CAMBIO(),rubro12.getCOST_SALDO_FINAL(),rubro12.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro13.getUnOper(),rubro13.getId_rubro(),rubro13.getRubro(),rubro13.getP_inicial(),rubro13.getP_final(),rubro13.getCOST_SALDO_INICIAL(),rubro13.getDPRN_INITIAL_BALANCE(),rubro13.getCOST_ADDITIONS(),rubro13.getCOST_BAJAS(),rubro13.getCOST_TRANSFERS_SALE(),rubro13.getDPN_DEPRECIACION(),rubro13.getDPN_BAJAS(),rubro13.getDPN_VAR_TIP_CAMBIO(),rubro13.getCOST_VAR_TIP_CAMBIO(),rubro13.getCOST_SALDO_FINAL(),rubro13.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubro14.getUnOper(),rubro14.getId_rubro(),rubro14.getRubro(),rubro14.getP_inicial(),rubro14.getP_final(),rubro14.getCOST_SALDO_INICIAL(),rubro14.getDPRN_INITIAL_BALANCE(),rubro14.getCOST_ADDITIONS(),rubro14.getCOST_BAJAS(),rubro14.getCOST_TRANSFERS_SALE(),rubro14.getDPN_DEPRECIACION(),rubro14.getDPN_BAJAS(),rubro14.getDPN_VAR_TIP_CAMBIO(),rubro14.getCOST_VAR_TIP_CAMBIO(),rubro14.getCOST_SALDO_FINAL(),rubro14.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
       try{
          OAApplicationModule am = pageContext.getApplicationModule(webBean);
          Serializable[] param2 = {rubroI1.getUnOper(),rubroI1.getId_rubro(),rubroI1.getRubro(),rubroI1.getP_inicial(),rubroI1.getP_final(),rubroI1.getCOST_SALDO_INICIAL(),rubroI1.getDPRN_INITIAL_BALANCE(),rubroI1.getCOST_ADDITIONS(),rubroI1.getCOST_BAJAS(),rubroI1.getCOST_TRANSFERS_SALE(),rubroI1.getDPN_DEPRECIACION(),rubroI1.getDPN_BAJAS(),rubroI1.getDPN_VAR_TIP_CAMBIO(),rubroI1.getCOST_VAR_TIP_CAMBIO(),rubroI1.getCOST_SALDO_FINAL(),rubroI1.getDPN_SALDO_FINAL()};
          System.out.println("Entrando en exec_insert...");
          am.invokeMethod("exec_insert",param2);
          System.out.println("Saliendo de.. exec_insert...");
       }catch(Exception e){
          System.out.println(e.getMessage()); 
       }
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
