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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.apps.fnd.common.AppsContext;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OADBTransactionImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.xdo.XDOException;
import oracle.apps.xdo.oa.schema.server.TemplateHelper;

import oracle.cabo.ui.data.DataObject;

import oracle.xml.parser.v2.XMLNode;

import xxgam.oracle.apps.fa.sumaria.inquiry.server.InquiryAMImpl;

/**
 * Controller for ...
 */
public class OperacionMensualCO extends OAControllerImpl
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
    System.out.println("GetLanguage:"+((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getLanguage());
    System.out.println("GetCountry:"+((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getCountry());
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
    DataObject dataobject =  pageContext.getNamedDataObject("_SessionParameters");
    HttpServletResponse response =  (HttpServletResponse)dataobject.selectValue(null, "HttpServletResponse");

    ServletOutputStream servletoutputstream = null;
        try {
            servletoutputstream = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=XxGamSafOmMaster.pdf");
            response.setContentType("application/pdf");
            ByteArrayInputStream inputStream = new ByteArrayInputStream("<XXGAM_SAF_OM_MASTER></XXGAM_SAF_OM_MASTER>".getBytes());
            
            ByteArrayOutputStream pdfFile = new ByteArrayOutputStream();

            TemplateHelper.processTemplate(((OADBTransactionImpl)pageContext.getRootApplicationModule().getOADBTransaction()).getAppsContext(), 
                                            "XBOL",//XxGQRecibosConstants.XXGQ_APP_SHORT_CUSTOM, 
                                            "XXGAM_SAF_OM_MASTER", 
                                           ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getLanguage(), 
                                           ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getCountry(), 
                                           inputStream,
                                           TemplateHelper.OUTPUT_TYPE_PDF, 
                                           null, 
                                           pdfFile
                                           );
              
            byte[] b = pdfFile.toByteArray();
            response.setContentLength(b.length);
            servletoutputstream.write(b, 0, b.length);
            servletoutputstream.flush();
            servletoutputstream.close();                                                 
            
        } catch (Exception e) {
             response.setContentType("text/html");
             throw new OAException("Excepcion:"+e.getMessage(),OAException.ERROR); 
        }
        
    } /** END public void processFormRequest(OAPageContext pageContext, OAWebBean webBean) **/
  

}
