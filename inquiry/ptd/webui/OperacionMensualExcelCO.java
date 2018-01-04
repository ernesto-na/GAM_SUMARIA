/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.inquiry.ptd.webui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.sql.SQLException;

import java.sql.Types;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OADBTransactionImpl;
import oracle.apps.fnd.framework.server.OAViewObjectImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.xdo.oa.schema.server.TemplateHelper;

import oracle.cabo.ui.data.DataObject;

import oracle.jdbc.OracleCallableStatement;

import xxgam.oracle.apps.fa.sumaria.inquiry.server.InquiryAMImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafOmTblVOImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafOmTblVORowImpl;

/**
 * Controller for ...
 */
public class OperacionMensualExcelCO extends OAControllerImpl
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
      /** Forma de crear un objeto tipo VO manual**/
          XxGamSafOmTblVOImpl SafOmTblVO = null;
            /* Forma de crear un objeto tipo AM manual */
          InquiryAMImpl InquiryAM = (InquiryAMImpl)pageContext.getApplicationModule(webBean); 
          /**AM Generico**/
          OAApplicationModuleImpl am = (OAApplicationModuleImpl)pageContext.getApplicationModule(webBean); 
          
          OAViewObjectImpl vo = null; 
          /**VO Generico **/
          vo = (OAViewObjectImpl)am.findViewObject("XxGamSafOmTblVO1"); 
          SafOmTblVO = InquiryAM.getXxGamSafOmTblVO1(); 
          
          if(!pageContext.isFormSubmission()){
            System.out.println("Se inicializan y ejecutan los ViewObjects");
            if(null!=SafOmTblVO){
                SafOmTblVO.executeQuery();
            } 
          }{
            System.out.println();
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
    
    XxGamSafOmTblVOImpl SafOmTblVO = null;
    InquiryAMImpl InquiryAM = (InquiryAMImpl)pageContext.getApplicationModule(webBean); 
    
    String unidadOperativaStr = pageContext.getParameter("unidadoperativalov");
    String periodoStr = pageContext.getParameter("periodolov");
    String divisaStr = pageContext.getParameter("divisalov");
    
    if (pageContext.getParameter("DespliegaBtn") != null)
    {String strGetValXML = null; 
    /***************************************************
     * Comienza Metodo que Obtiene el la estructura XML 
     **************************************************/
     System.out.println("unidadOperativaStr"+unidadOperativaStr);
     System.out.println("periodoStr"+periodoStr);
     System.out.println("divisaStr"+divisaStr);
     
     String strErrmsg = null; 
     String strErrcod = null; 
      
     String strCallableStmt = " BEGIN " + 
                              "  APPS.XXGAM_SAF_OM_MASTER_PKG.OBTIENE_XML ( PSO_ERRMSG          =>:1 " + 
                              "                                           , PSO_ERRCODE         =>:2 " + 
                              "                                           , PSI_OPERATING_UNIT  =>:3 " + 
                              "                                           , PSI_PERIODO         =>:4 " + 
                              "                                           , PSI_DIVISA          =>:5 " + 
                              "                                           , PCO_XML             =>:6" + 
                              "                                           ); " + 
                              "  COMMIT; " + 
                              " END;";
     
      OADBTransaction oadbtransaction = (OADBTransaction)InquiryAM.getTransaction();
      OracleCallableStatement oraclecallablestatement =  (OracleCallableStatement)oadbtransaction.createCallableStatement(strCallableStmt, 1);
      
      try{
      
         oraclecallablestatement.registerOutParameter(1,Types.VARCHAR);
         oraclecallablestatement.registerOutParameter(2,Types.VARCHAR);
         oraclecallablestatement.setString(3,unidadOperativaStr);
         oraclecallablestatement.setString(4,periodoStr);
         oraclecallablestatement.setString(5,divisaStr);
         oraclecallablestatement.registerOutParameter(6,Types.CLOB);
         
         oraclecallablestatement.execute();
                
         strErrmsg = oraclecallablestatement.getString(1);
         strErrcod = oraclecallablestatement.getString(2);
         
         System.out.println("strErrmsg:"+strErrmsg);
         System.out.println("strErrcod:"+strErrcod);
         
         if(null!=strErrmsg){
          throw new OAException("OAF Exception:"+strErrmsg,OAException.ERROR); 
         }
          
         java.sql.Clob clob =  oraclecallablestatement.getClob(6); 
         
         
         java.io.Reader reader =clob.getCharacterStream();
         java.io.BufferedReader bufferReader = new java.io.BufferedReader(reader);
         
         String retvalxml = "";
         String line = null; 
         while((line = bufferReader.readLine())!=null){
           retvalxml = retvalxml+line;
         }
         
         strGetValXML = retvalxml; 
          
         bufferReader.close();
         reader.close();
         
      }catch(IOException ioe){
          throw new OAException("Excepcion IO: "+ioe.getMessage(),OAException.ERROR);
      }
      catch(SQLException sqle){
        throw new OAException("Excepcion SQL: "+sqle.getMessage(),OAException.ERROR); 
      }
    
     /***************************************************
      * Finaliza Metodo que Obtiene el la estructura XML 
      **************************************************/ 
      
      System.out.println("strGetValXML:"+strGetValXML);
    
      /**************************************************
        Comienza Validacion de estructura XML 
      ****************************************************/
      
      
       /**************************************************
         Finaliza Validacion de estructura XML 
       ****************************************************/
      
    
    
      DataObject dataobject =  pageContext.getNamedDataObject("_SessionParameters");
      HttpServletResponse response =  (HttpServletResponse)dataobject.selectValue(null, "HttpServletResponse");

      ServletOutputStream servletoutputstream = null;
          try {
              servletoutputstream = response.getOutputStream();
              response.setHeader("Content-Disposition", "attachment;filename=XxGamSafOmMaster"+System.currentTimeMillis()+".xls");
              response.setContentType("application/MSEXCEL");
             
              /** ByteArrayInputStream inputStream = new ByteArrayInputStream("<XXGAM_SAF_OM_MASTER></XXGAM_SAF_OM_MASTER>".getBytes()); **/
              
               ByteArrayInputStream inputStream = new ByteArrayInputStream(strGetValXML.getBytes()); 
              
              ByteArrayOutputStream excelFile = new ByteArrayOutputStream();

              TemplateHelper.processTemplate(((OADBTransactionImpl)pageContext.getRootApplicationModule().getOADBTransaction()).getAppsContext(), 
                                              "XBOL",//XxGQRecibosConstants.XXGQ_APP_SHORT_CUSTOM, 
                                              "XXGAM_SAF_OM_MASTER", 
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
              
          } catch (Exception e) {
               response.setContentType("text/html");
               throw new OAException("Excepcion:"+e.getMessage(),OAException.ERROR); 
          }
   
  } /** END  if (pageContext.getParameter("DespliegaBtn") != null) **/
  
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

   
   if("ArchivoExcelEvt".equals(pageContext.getParameter(this.EVENT_PARAM))){
   
   
       XxGamSafOmTblVORowImpl SafOmTblVORow = null; 
       SafOmTblVORow  =   InquiryAM.findXxGamSafCurrrentRow(strCurrentRow); 
       
       String strPeriodo = SafOmTblVORow.getPeriod(); 
       
       java.lang.Number numLang = null;
       oracle.jbo.domain.Number numOracle = null; 
       oracle.jbo.domain.Number numCreatedBy = SafOmTblVORow.getCreatedBy(); 
       
       oracle.jbo.domain.ClobDomain clobXmlStr = SafOmTblVORow.getXmlString(); 
       
       String strClobXmlStr = clobXmlStr.toString(); 
       
       
       System.out.println("Periodo:"+strPeriodo); 
       System.out.println("numCreatedBy:"+numCreatedBy);
       System.out.println("Unidad Operativa:"+SafOmTblVORow.getOperatingUnit());
       System.out.println("strClobXmlStr:"+strClobXmlStr);
       
       /************************************************************************
       ValidaArchivosXml validaArchivosXml = new ValidaArchivosXml(); 
       boolean booValidaXml = validaArchivosXml.validaXML(strClobXmlStr);
       
       if(!booValidaXml){
         throw new OAException("Fallo Errmsg:"+validaArchivosXml.strErrmsg+", Errcode:"+validaArchivosXml.strErrcod,OAException.ERROR); 
       }
       *************************************************************************/
       
       
       DataObject dataobject =  pageContext.getNamedDataObject("_SessionParameters");
       HttpServletResponse response =  (HttpServletResponse)dataobject.selectValue(null, "HttpServletResponse");

       ServletOutputStream servletoutputstream = null;
           try {
               servletoutputstream = response.getOutputStream();
               response.setHeader("Content-Disposition", "attachment;filename=XxGamSafOmMaster"+System.currentTimeMillis()+".xls");
               response.setContentType("application/MSEXCEL");
              
               /** ByteArrayInputStream inputStream = new ByteArrayInputStream("<XXGAM_SAF_OM_MASTER></XXGAM_SAF_OM_MASTER>".getBytes()); **/
               
                ByteArrayInputStream inputStream = new ByteArrayInputStream(strClobXmlStr.getBytes()); 
               
               ByteArrayOutputStream excelFile = new ByteArrayOutputStream();

               TemplateHelper.processTemplate(((OADBTransactionImpl)pageContext.getRootApplicationModule().getOADBTransaction()).getAppsContext(), 
                                               "XBOL",//XxGQRecibosConstants.XXGQ_APP_SHORT_CUSTOM, 
                                               "XXGAM_SAF_OM_MASTER", 
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
               
           } catch (Exception e) {
                response.setContentType("text/html");
                throw new OAException("Excepcion:"+e.getMessage(),OAException.ERROR); 
           }
       
       
   
   } /** END    if("ArchivoExcelEvt".equals(pageContext.getParameter(this.EVENT_PARAM))){ **/
   
     
 

    
  /**
 
    
  SafOmTblVORow = (XxGamSafOmTblVORowImpl)InquiryAM.findRowByRef(strEventSourceRowReference); 
    
 System.out.println("Periodo:"+SafOmTblVORow.getPeriod());
 System.out.println("Unidad Operativa:"+SafOmTblVORow.getOperatingUnit());
 **/
          
  } /** END  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) **/

}
