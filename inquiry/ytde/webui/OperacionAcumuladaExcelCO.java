/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.inquiry.ytde.webui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransactionImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.xdo.oa.schema.server.TemplateHelper;
import oracle.cabo.ui.data.DataObject;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.InquiryAMImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafYtdeTblVOImpl;
import xxgam.oracle.apps.fa.sumaria.inquiry.server.XxGamSafYtdeTblVORowImpl;

/**
 * Controller for ...
 */
public class OperacionAcumuladaExcelCO extends OAControllerImpl
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
    
    XxGamSafYtdeTblVOImpl YtdeTblVO = null; 
 
    YtdeTblVO = InquiryAM.getXxGamSafYtdeTblVO1();
    
    if(!pageContext.isFormSubmission()){
      System.out.println("Se inicializan y ejecutan los ViewObjects");
      if(null!=YtdeTblVO){
          YtdeTblVO.executeQuery();
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
        
     if("ArchivoExcelEvt".equals(pageContext.getParameter(this.EVENT_PARAM))){
     
         XxGamSafYtdeTblVORowImpl SafYtdeTblVORow = null;
         SafYtdeTblVORow = InquiryAM.findXxGamSafYtdeCurrrentRow(strCurrentRow);
         
         String strPeriodo = SafYtdeTblVORow.getPeriod(); 
         
         oracle.jbo.domain.ClobDomain clobXmlStr = SafYtdeTblVORow.getXmlString();     
         String strClobXmlStr = clobXmlStr.toString(); 
         
         System.out.println("Periodo:"+strPeriodo); 
         //System.out.println("numCreatedBy:"+numCreatedBy);
         System.out.println("Unidad Operativa:"+SafYtdeTblVORow.getOperatingUnit());
         System.out.println("strClobXmlStr:"+strClobXmlStr);
         
         DataObject dataobject =  pageContext.getNamedDataObject("_SessionParameters");
         HttpServletResponse response =  (HttpServletResponse)dataobject.selectValue(null, "HttpServletResponse");
         
         ServletOutputStream servletoutputstream = null;

            try {
                servletoutputstream = response.getOutputStream();
                response.setHeader("Content-Disposition", "attachment;filename=XxGamSafYtdeMaster"+System.currentTimeMillis()+".xls");
                response.setContentType("application/MSEXCEL");
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
        } //fin de if("ArchivoExcelEvt".equals(PageContext.getParameter(this.EVENT_PARAM)))

  }//fin de metodo

}//fin de clase principal
