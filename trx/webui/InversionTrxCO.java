/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxgam.oracle.apps.fa.sumaria.trx.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.fnd.framework.webui.beans.form.OASubmitButtonBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.nav.OAButtonBean;

import oracle.jbo.ViewCriteria;

import oracle.jbo.ViewCriteriaRow;

import xxgam.oracle.apps.fa.sumaria.trx.server.InversionTrxAMImpl;
import xxgam.oracle.apps.fa.sumaria.trx.server.InversionTrxVOImpl;
import xxgam.oracle.apps.fa.sumaria.trx.server.InversionTrxVORowImpl;
import xxgam.oracle.apps.fa.sumaria.trx.server.TransfManVOImpl;
import xxgam.oracle.apps.fa.sumaria.trx.server.TransfManVORowImpl;

/**
 * Controller for ...
 */
public class InversionTrxCO extends OAControllerImpl
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
    InversionTrxAMImpl inversionTrxAMImpl = (InversionTrxAMImpl)pageContext.getApplicationModule(webBean);
      environmentCurrencyFormats(pageContext,webBean);
      //String strEvent= pageContext.getParameter(EVENT_PARAM) ;
    
    if(!pageContext.isFormSubmission()){
         System.out.println("Debug1");
         //inversionTrxAMImpl.fillTable(); 
          
          
}
     else{
        System.out.println("Debug2");
    }/** END if(!pageContext.isFormSubmission()){ **/
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
    //declaramos un objeto tipo OAButtonBean
     
    OASubmitButtonBean deleteButton;  
 InversionTrxAMImpl inversionTrxAMImpl = (InversionTrxAMImpl)pageContext.getApplicationModule(webBean);

          String strUniOper     = pageContext.getParameter("UniOper");
          String strPeriodo     = pageContext.getParameter("Periodo");
          String strDivisa      = pageContext.getParameter("Divisa");
          String strRubroOrg    = pageContext.getParameter("IdRubro");
          String strRubroDes    = pageContext.getParameter("IdRubro2");
          
          /*          
          strUniOper1 = strUniOper;
          strPeriodo1 = strPeriodo;
          strDivisa1 = strDivisa;
          strRubroOrg1 = strRubroOrg;
          strRubroDes1 = strRubroDes;
            */  
          
          
      System.out.println("strUniOper:   "+strUniOper);
      System.out.println("strPeriodo:   "+strPeriodo);
      System.out.println("strDivisa:    "+strDivisa);
      System.out.println("IdRubro:      "+strRubroOrg);
      System.out.println("IdRubro2:     "+strRubroDes);
      
      
      
      
      /////BOTON BUSCAR
      if(pageContext.getParameter("BuscarBtn")!= null){
      System.out.println("Boton presionado");
      inversionTrxAMImpl.fillTable2(strUniOper, strPeriodo, strDivisa,strRubroOrg, strRubroDes); 
      
          }

      else
          System.out.println("no entro");
        
      ////BOTON APLICAR  
      if(pageContext.getParameter("AplicarBtn") != null){
        
      oracle.jbo.domain.Number numRegistros = inversionTrxAMImpl.getInfoSig(strUniOper, strPeriodo, strDivisa,strRubroOrg, strRubroDes);
         
          if (numRegistros.compareTo(0) > 0){
            System.out.println("Hay registros en el siguiente periodo-aplicar");
              //OAException message = new OAException("No se puede borrar informacion.\nRevisar informacion para meses posteriores.",OAException.ERROR);
              OAException message = new OAException("No se puede actualizar la información. Existe información para meses posteriores.",OAException.ERROR);
              pageContext.putDialogMessage(message);
          }
          else{
      
          
        inversionTrxAMImpl.suma();
          
        inversionTrxAMImpl.getTransaction().commit();          
          }//fin de if-else
      }//fin de if(pageContext.getParameter("AplicarBtn") != null) 
      
      ////BOTON CANCELAR
      if(pageContext.getParameter("CancelBtn") != null){
          
          inversionTrxAMImpl.getTransaction().rollback();
          inversionTrxAMImpl.fillTable2(strUniOper, strPeriodo, strDivisa,strRubroOrg, strRubroDes); 
          }//fin de if(pageContext.getParameter("CancelBtn") != null)

           ////BOTON GENERAR
       if(pageContext.getParameter("GenerarBtn") != null){
           
           inversionTrxAMImpl.generarOM(strUniOper,strPeriodo,strDivisa,strRubroOrg,strRubroDes);
           
       }//fin de if(pageContext.getParameter("GenerarBtn") 
       
      ////BOTON ELIMINAR
      if(pageContext.getParameter("EliminarBtn") != null){
      
         System.out.println("Entra Eliminar");
      
          /*strUniOper1 = strUniOper;
          strPeriodo1 = strPeriodo;
          strDivisa1 = strDivisa;
          strRubroOrg1 = strRubroOrg;
          strRubroDes1 = strRubroDes;*
          
          System.out.println("strUniOper1:   "+strUniOper1);
          System.out.println("strPeriodo1:   "+strPeriodo1);
          System.out.println("strDivisa1:    "+strDivisa1);
          System.out.println("strRubroOrg1:      "+strRubroOrg1);
          System.out.println("strRubroDes1:     "+strRubroDes1);
          */
          inversionTrxAMImpl.setInfoCopia(strUniOper, strPeriodo, strDivisa,strRubroOrg, strRubroDes);
          oracle.jbo.domain.Number numRegistros = inversionTrxAMImpl.getInfoSig(strUniOper, strPeriodo, strDivisa,strRubroOrg, strRubroDes);
             
              if (numRegistros.compareTo(0) > 0){
                System.out.println("Hay registros en el siguiente periodo");
                  //OAException message = new OAException("No se puede borrar informacion.\nRevisar informacion para meses posteriores.",OAException.ERROR);
                  OAException message = new OAException("No se puede borrar información. Existe información para meses posteriores.",OAException.ERROR);
                  pageContext.putDialogMessage(message);
              }
              else{
                System.out.println("No hay registros");
                     OAException message = new OAException("¿Esta seguro de eliminar los registros?");
                     OADialogPage dialogPage = new OADialogPage(OAException.WARNING, message, null, "","");
                     //String yes = pageContext.getMessage("AK", "FWK_TBX_T_YES", null);
                     //String no = pageContext.getMessage("AK", "FWK_TBX_T_NO", null);
                     dialogPage.setOkButtonItemName("YesButton");
                     dialogPage.setNoButtonItemName("NoButton");
                     dialogPage.setOkButtonToPost(true);
                     dialogPage.setNoButtonToPost(true);
                     dialogPage.setRetainAMValue(true);
                     dialogPage.setPostToCallingPage(true);
                     
                     //dialogPage.setOkButtonLabel(yes); 
                     //dialogPage.setNoButtonLabel(no);
                     pageContext.redirectToDialogPage(dialogPage);
                     
                      //inversionTrxAMImpl.eliminar(strUniOper1,strPeriodo1,strRubroOrg1,strRubroDes1,strDivisa1);             

                                         
                     
                //asignamos deleteButton al boton usando cast EliminarBtn
                 //deleteButton = (OASubmitButtonBean)webBean.findChildRecursive("EliminarBtn");
                 //prende el boton usando la referencia
                 //deleteButton.setDisabled(false);
                 
                 }
      } ///fin de if(pageContext.getParameter("EliminarBtn")
      
       if (pageContext.getParameter("YesButton") != null) 
              {
                  inversionTrxAMImpl.eliminar2();
                  //inversionTrxAMImpl.eliminar(strUniOper1,strPeriodo1,strRubroOrg1,strRubroDes1,strDivisa1);             
              }
       if (pageContext.getParameter("NoButton") != null)
         {
       // Write Action code for No Button
         }

          
          
      }///fin de public void processFormRequest(
        
       private void environmentCurrencyFormats(OAPageContext pageContext, 
                                                 OAWebBean webBean)
         {
             //referencia de tipo textInputFormat
             OAMessageTextInputBean textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("SaldoInicialMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("AdicionMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
                 
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("DisminucionMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("TransaccionesMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("Bajas_VentaMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("Bajas_scrapMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("Dprn_VentaMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("Dprn_scrapMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             textInputFormat = null;
             textInputFormat = (OAMessageTextInputBean)webBean.findChildRecursive("Dprn_ejerMan");
             if(null != textInputFormat){
                 textInputFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             //referencia de tipo messageStyledText
              OAMessageStyledTextBean styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("SumaMan");
              if(null != styledTextFormat){
                  styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
              }
              
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Saldo_finalMan");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("SaldoInicial");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Adiciones");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Disminuciones");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Transacciones");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Bajas_Venta");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Bajas_scrap");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Dprn_Venta");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Dprn_scrap");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
             styledTextFormat = null;
             styledTextFormat = (OAMessageStyledTextBean)webBean.findChildRecursive("Dprn_ejer");
             if(null != styledTextFormat){
                 styledTextFormat.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
             }
             
         }//FIN DE private void environmentCurrencyFormats
}//fin de public class InversionTrxCO
        
        




