package xxgam.oracle.apps.fa.sumaria.inquiry.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;

import oracle.apps.fnd.framework.server.OADBTransaction;

import oracle.jbo.RowSetIterator;

import xxgam.oracle.apps.fa.sumaria.inquiry.summary.util.Rubro;
import xxgam.oracle.apps.fa.sumaria.setup.server.XxGamSetupVORowImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class InquiryAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public InquiryAMImpl() {
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("xxgam.oracle.apps.fa.sumaria.inquiry.server", /* package name */
      "InquiryAMLocal" /* Configuration Name */);
    }
    
    /**
     * Metodo que actualiza la tabla de la operacion sumaria
     */
    
    public void updateRecord(String IdSetup,String myAux) {
        
            System.out.println("Actualizando Registro..."+IdSetup);
            //System.out.println(myAux);
             
             /* Java Programming */
             /* Obtener el Controlador (Driver) para conectarse a la base de datos */
             
             OADBTransaction oaDBTransaction =  this.getOADBTransaction();
             Connection connection = oaDBTransaction.getJdbcConnection();
             
             String strPrepStmt = " UPDATE XXGAM_SAF_SUMARIA_TBL SET XML_STRING=?, LAST_UPDATE_DATE=SYSDATE WHERE SAF_SUMARIA_ID=? ";
             
             PreparedStatement prepStmt;

             try {
               prepStmt = connection.prepareStatement(strPrepStmt);
               prepStmt.setString(1, myAux);
               prepStmt.setString(2, IdSetup);
               prepStmt.execute();
               System.out.println(strPrepStmt);
               oaDBTransaction.commit();
               if(prepStmt!=null){
                   prepStmt.close();
               }
               throw new OAException("Se actualizo exitosamente ",OAException.INFORMATION);
             } catch (SQLException e) {
                throw new OAException("No se actualizo el registro:",OAException.ERROR);
             }
        }       
    
     
        
    /**
     * Inserta en la tabla XXGAM_SAF_FLUJO_EFECTIVO
     */
     public void exec_insert(String uOp,String id_r,String rubro,String periodo_inicial,String periodo_final,String COST_SALDO_INICIAL,String DPRN_INITIAL_BALANCE,String COST_ADDITIONS,String COST_BAJAS,String COST_TRANSFERS_SALE,String DPN_DEPRECIACION,String DPN_BAJAS,String DPN_VAR_TIP_CAMBIO,String COST_VAR_TIP_CAMBIO,String COST_SALDO_FINAL,String DPN_SALDO_FINAL ) {
               /* Java Programming */
               /* Obtener el Controlador (Driver) para conectarse a la base de datos */
             System.out.print("u_op: "+uOp+" \nid_r: "+id_r+" \nrubro: "+rubro+" \nperiodo_inicial: "+periodo_inicial+" \nperiodo_final: "+periodo_final+" \nR1_COST_INITIAL_BALANCE: "+COST_SALDO_INICIAL+" \nDPRN_INITIAL_BALANCE "+DPRN_INITIAL_BALANCE+ " \nCOST_ADDITIONS "+COST_ADDITIONS+" \nCOST_BAJAS "+COST_BAJAS+ " \nCOST_TRANSFERS_SALE "+ COST_TRANSFERS_SALE+" \nDPN_DEPRECIACION "+DPN_DEPRECIACION
             +"  \nDPN_BAJAS"+DPN_BAJAS+" \nDPN_VAR_TIP_CAMBIO "+DPN_VAR_TIP_CAMBIO+" \nCOST_VAR_TIP_CAMBIO "+COST_VAR_TIP_CAMBIO+" \nCOST_SALDO_FINAL "+COST_SALDO_FINAL+" \nDPN_SALDO_FINAL "+DPN_SALDO_FINAL );  
               OADBTransaction oaDBTransaction =  this.getOADBTransaction();
               Connection connection = oaDBTransaction.getJdbcConnection();
               
             String rubroInitBal = " INSERT INTO xxgam_saf_flujo_efectivo(ID," +
                                                                        "EMPRESA," +
                                                                        "ID_RUBRO," +
                                                                        "RUBRO," +
                                                                        "PERIODO_INICIAL," +
                                                                        "PERIODO_FINAL," +
                                                                        "TIPO_SALDO," +
                                                                        "MONTO," +
                                                                        "CREATED_BY," +
                                                                        "CREATION_DATE," +
                                                                        "LAST_UPDATED_BY," +
                                                                        "LAST_UPDATE_DATE," +
                                                                        "LAST_UPDATE_LOGIN," +
                                                                        "REQUEST_ID," +
                                                                        "PROGRAM_APPLICATION_ID," +
                                                                        "PROGRAM_ID," +
                                                                        "PROGRAM_UPDATE_DATE)" +
                                                                        "VALUES (XXGAM_SAF_FLUJO_EFECTIVO_S.NEXTVAL," 
                                                                        +"'"+uOp+"',"+
                                                                        "'"+id_r+"',"+
                                                                        "'"+rubro+"',"+
                                                                        "'"+periodo_inicial+"',"+
                                                                        "'"+periodo_final+"',"+
                                                                        "'COST_SALDO_INICIAL',"+
                                                                        COST_SALDO_INICIAL+","+
                                                                        "nvl(TO_NUMBER (FND_PROFILE.VALUE('USER_ID')),-1)," +  /* CREATED_BY */ 
                                                                        "sysdate," +                                         /* CREATION_DATE */ 
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('USER_ID')),-1)," +  /* LAST_UPDATED_BY */
                                                                        "sysdate," +                                       /* LAST_UPDATE_DATE */ 
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('LOGIN_ID')),-1)," + /* LAST_UPDATE_LOGIN */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_REQUEST_ID')),-1)," +  /* REQUEST_ID */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_PROGRAM_APPLICATION_ID')),-1),"+  /* PROGRAM_APPLICATION_ID */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_PROGRAM_ID')),-1)," +   /* PROGRAM_ID */  
                                                                        "sysdate)";
             String rubroDPRN_INITIAL_BALANCE = " INSERT INTO xxgam_saf_flujo_efectivo(ID," +
                                                                        "EMPRESA," +
                                                                        "ID_RUBRO," +
                                                                        "RUBRO," +
                                                                        "PERIODO_INICIAL," +
                                                                        "PERIODO_FINAL," +
                                                                        "TIPO_SALDO," +
                                                                        "MONTO," +
                                                                        "CREATED_BY," +
                                                                        "CREATION_DATE," +
                                                                        "LAST_UPDATED_BY," +
                                                                        "LAST_UPDATE_DATE," +
                                                                        "LAST_UPDATE_LOGIN," +
                                                                        "REQUEST_ID," +
                                                                        "PROGRAM_APPLICATION_ID," +
                                                                        "PROGRAM_ID," +
                                                                        "PROGRAM_UPDATE_DATE)" +
                                                                        "VALUES (XXGAM_SAF_FLUJO_EFECTIVO_S.NEXTVAL," 
                                                                        +"'"+uOp+"',"+
                                                                        "'"+id_r+"',"+
                                                                        "'"+rubro+"',"+
                                                                        "'"+periodo_inicial+"',"+
                                                                        "'"+periodo_final+"',"+
                                                                        "'COST_SALDO_INICIAL',"+
                                                                        DPRN_INITIAL_BALANCE+","+
                                                                        "nvl(TO_NUMBER (FND_PROFILE.VALUE('USER_ID')),-1)," +  /* CREATED_BY */ 
                                                                        "sysdate," +                                         /* CREATION_DATE */ 
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('USER_ID')),-1)," +  /* LAST_UPDATED_BY */
                                                                        "sysdate," +                                       /* LAST_UPDATE_DATE */ 
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('LOGIN_ID')),-1)," + /* LAST_UPDATE_LOGIN */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_REQUEST_ID')),-1)," +  /* REQUEST_ID */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_PROGRAM_APPLICATION_ID')),-1),"+  /* PROGRAM_APPLICATION_ID */
                                                                        "nvl(TO_NUMBER(FND_PROFILE.VALUE('CONC_PROGRAM_ID')),-1)," +   /* PROGRAM_ID */  
                                                                        "sysdate)";
                                                                        
             insert_saf_flujo_efec(rubroInitBal); 
             insert_saf_flujo_efec(rubroDPRN_INITIAL_BALANCE);
           
         }

                   public void insert_saf_flujo_efec(String strPrepStmt ) {
                             /* Java Programming */
                             /* Obtener el Controlador (Driver) para conectarse a la base de datos */
                           System.out.println("__"+strPrepStmt);
                             OADBTransaction oaDBTransaction =  this.getOADBTransaction();
                             Connection connection = oaDBTransaction.getJdbcConnection();
                           PreparedStatement prepStmt;
                          try {
                               prepStmt = connection.prepareStatement(strPrepStmt);
                               //prepStmt.execute();
                               //System.out.println(rubroInitBal);
                               //oaDBTransaction.commit();
                               if(prepStmt!=null){
                                   prepStmt.close();
                               }
                              // throw new OAException("Se inserta exitosamente "+column1+" "+column2+" "+column3,OAException.CONFIRMATION);
                           } catch (SQLException e) {
                               System.out.println("Falla al insertar: "+ e.getMessage());
                                //throw new OAException("No se registra cambio para:"+column1+" "+column2+" "+column3,OAException.ERROR);
                           }
                       }
  
         
         
    /**Container's getter for XxGamSafOmTblVO1
     */
    public XxGamSafOmTblVOImpl getXxGamSafOmTblVO1() {
        return (XxGamSafOmTblVOImpl)findViewObject("XxGamSafOmTblVO1");
    }

  public XxGamSafOmTblVORowImpl findXxGamSafCurrrentRow(String strCurrentRow)
  {
    XxGamSafOmTblVOImpl SafOmTblVOImpl = getXxGamSafOmTblVO1(); 
    XxGamSafOmTblVORowImpl SafOmTblVORowImpl = null; 
    XxGamSafOmTblVORowImpl retval = null;
    
    oracle.jbo.domain.Number numCurrentRow = null;

    try
    {
      numCurrentRow = new oracle.jbo.domain.Number(strCurrentRow);
    } catch (SQLException e)
    {
     }
    RowSetIterator rowSetIterator = SafOmTblVOImpl.createRowSetIterator(null); 
    while(rowSetIterator.hasNext()){
      SafOmTblVORowImpl = (XxGamSafOmTblVORowImpl)rowSetIterator.next(); 
      if(numCurrentRow.equals(SafOmTblVORowImpl.getSafOmId())){
        retval = SafOmTblVORowImpl; 
        break; 
      }
    }
    
    return retval; 
    
  }
  
    public XxGamSafYtdeTblVORowImpl findXxGamSafYtdeCurrrentRow(String strCurrentRow)
    {
      XxGamSafYtdeTblVOImpl SafYtdeTblVOImpl = getXxGamSafYtdeTblVO1(); 
      XxGamSafYtdeTblVORowImpl SafYtdeTblVORowImpl = null; 
      XxGamSafYtdeTblVORowImpl retval = null;
      
      oracle.jbo.domain.Number numCurrentRow = null;

      try
      {
        numCurrentRow = new oracle.jbo.domain.Number(strCurrentRow);
      } catch (SQLException e)
      {
       }
      RowSetIterator rowSetIterator = SafYtdeTblVOImpl.createRowSetIterator(null); 
      while(rowSetIterator.hasNext()){
        SafYtdeTblVORowImpl = (XxGamSafYtdeTblVORowImpl)rowSetIterator.next(); 
        if(numCurrentRow.equals(SafYtdeTblVORowImpl.getSafYtdeId())){
          retval = SafYtdeTblVORowImpl; 
          break; 
        }
      }
      
      return retval; 
      
    }

    public XxGamSafSumariaTblVORowImpl findXxGamSafSumariaCurrrentRow(String strCurrentRow)
    {
      XxGamSafSumariaTblVOImpl SafSumariaTblVOImpl = getXxGamSafSumariaTblVO1(); 
      XxGamSafSumariaTblVORowImpl SafSumariaTblVORowImpl = null; 
      XxGamSafSumariaTblVORowImpl retval = null;
      
      oracle.jbo.domain.Number numCurrentRow = null;

      try
      {
        numCurrentRow = new oracle.jbo.domain.Number(strCurrentRow);
      } catch (SQLException e)
      {
       }
      RowSetIterator rowSetIterator = SafSumariaTblVOImpl.createRowSetIterator(null); 
      while(rowSetIterator.hasNext()){
        SafSumariaTblVORowImpl = (XxGamSafSumariaTblVORowImpl)rowSetIterator.next(); 
        if(numCurrentRow.equals(SafSumariaTblVORowImpl.getSafSumariaId())){
          retval = SafSumariaTblVORowImpl; 
          break; 
        }
      }
      
      return retval; 
      
    }



  /**Container's getter for XxGamSafYtdeTblVO1
   */
  public XxGamSafYtdeTblVOImpl getXxGamSafYtdeTblVO1()
  {
    return (XxGamSafYtdeTblVOImpl)findViewObject("XxGamSafYtdeTblVO1");
  }

    /**Container's getter for XxGamSafSumariaTblVO1
     */
    public XxGamSafSumariaTblVOImpl getXxGamSafSumariaTblVO1() {
        return (XxGamSafSumariaTblVOImpl)findViewObject("XxGamSafSumariaTblVO1");
    }

    /**
     * Metodo que recupera el registro sobre el cual se esta ejecutando el evento
     * de actualizar
     * @param strPsumariaId
     * @return
     */
    public XxGamSafSumariaTblVORowImpl filterSumariaVO(String strPsumariaId) {
        oracle.jbo.domain.Number strParamSumariaId=null;
        try {
            strParamSumariaId = new oracle.jbo.domain.Number(strPsumariaId);
        } catch (SQLException e) {
            // TODO
        }
        XxGamSafSumariaTblVORowImpl retVal = null;
        XxGamSafSumariaTblVOImpl sumariaVO = getXxGamSafSumariaTblVO1();
        RowSetIterator iterador = sumariaVO.createRowSetIterator(null); 
        while(iterador.hasNext()){
           retVal = (XxGamSafSumariaTblVORowImpl)iterador.next(); 
           oracle.jbo.domain.Number numSumariaId =retVal.getSafSumariaId();  
           if(strParamSumariaId.equals(numSumariaId)){
               break;
           }
           
        }
        return retVal;

    
    }
}
