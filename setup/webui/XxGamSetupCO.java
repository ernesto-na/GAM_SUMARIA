/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.setup.webui;

import java.io.Serializable;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class XxGamSetupCO extends OAControllerImpl
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
    OAApplicationModule am = pageContext.getApplicationModule(webBean);
    am.invokeMethod("consulta");
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
    
      String strEventParam = pageContext.getParameter(this.EVENT_PARAM);  
      OAApplicationModule am = pageContext.getApplicationModule(webBean);
      
      if (pageContext.getParameter("CreateBtn") != null){
                System.out.println("Entra en Crear");
                am.invokeMethod("createRecord");
                 
                
                     
            }
    
      if (pageContext.getParameter("SaveBtn") != null){
                System.out.println("Entra en Guardar");
                am.invokeMethod("Save");
                                       
            }
    
      if("deleteEvent".equals(strEventParam)){
            
                String  strIdSetup = pageContext.getParameter("pIdSetup"); 
                System.out.println(strIdSetup);
                
                Serializable[] param = {strIdSetup};
                
                am.invokeMethod("deleteRecord", param);
                am.invokeMethod("consulta"); 

            
            }
            
      if("updateEvent".equals(strEventParam)){
            
                String  strIdSetup = pageContext.getParameter("pIdSetup"); 
                System.out.println(strIdSetup);
                
                Serializable[] param = {strIdSetup};
                
                am.invokeMethod("updateRecord", param);
                 

            
            }
    
  }

}
