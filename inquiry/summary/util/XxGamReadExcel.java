package xxgam.oracle.apps.fa.sumaria.inquiry.summary.util;

import java.text.DecimalFormat;

import java.util.Locale;

import jxl.*; 
import java.io.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;

import oracle.apps.fnd.framework.server.OADBTransaction;

import oracle.jbo.RowSetIterator;




import oracle.apps.fnd.framework.OAApplicationModule;


public  class XxGamReadExcel {
    static   String auxUnidadOp="02 - Aerovias de Mexico S.A de C.V";
        static   String auxPromptA="--";
        static   String auxPromptB="--";
        static   String auxPromptC="--";
        
        static String periodo_inicial="--";
        static String periodo_final="--";
        
       static   String auxPromptD="--";
       static String yearAux="--";
    static String anioAux="";
    static String operating_unit ="";
        
        
        
        
    static   String R1_PROMPT_COL_MX ="Eq.Vlo.en Arrendamiento Financiero";
            static String R1_PROMPT_COL_US ="Flight equipment under financial leases";
            static  String auxTemplate="";
            static String R2_PROMPT_COL_MX ="Mantenimiento Mayor";
            static String R2_PROMPT_COL_US ="Major Maintenance";
            static String R3_PROMPT_COL_MX ="Rotables repuestos y accesorios";
            static String R3_PROMPT_COL_US ="Rotable spare parts and accessories";
            static String R4_PROMPT_COL_MX ="Mejoras de equipo de vuelo";
            static String R4_PROMPT_COL_US ="Improvements of flight equipment";
            static String R5_PROMPT_COL_MX ="Maquinaria y Equipo";
            static String R5_PROMPT_COL_US ="Machinery and equipment";
            static String R6_PROMPT_COL_MX ="Mejoras en propiedades arrendadas";
            static String R6_PROMPT_COL_US ="Leasehold improvements";
            static String R7_PROMPT_COL_MX ="Mobiliario y equipo de computo";
            static String R7_PROMPT_COL_US ="Furniture and computer equipment";
            static String R8_PROMPT_COL_MX ="Equipo de vuelo Capitalizable";
            static String R8_PROMPT_COL_US ="Flight equipment Cap.";
            static String R9_PROMPT_COL_MX ="Construccion";
            static String R9_PROMPT_COL_US ="Construction";
            static String R10_PROMPT_COL_MX="Equipo de tierra";
            static String R10_PROMPT_COL_US="Ground equipment";
            static String R11_PROMPT_COL_MX="Equipo de transporte";
            static String R11_PROMPT_COL_US="Transportation equipment";
            static String R12_PROMPT_COL_MX="Otros Equipos";
            static String R12_PROMPT_COL_US="Other equipment";
            static String R13_PROMPT_COL_MX="Trabajos en proceso";
            static String R13_PROMPT_COL_US="Work in progress";
            static String R14_PROMPT_COL_MX="Terrenos";
            static String R14_PROMPT_COL_US="Land";
            static String RI1_PROMPT_COL_MX="Software";
            static String RI1_PROMPT_COL_US="Software";
            static String PROMPT_D="";
            static String PROMPT_INI_BAL="";
        
        //*Rubros*//
    static String R1_COST_INITIAL_BALANCE="0";
    static String R1_DPRN_INITIAL_BALANCE="0";
    static String R1_COST_ADDITIONS      ="0";
    static String R1_COST_DISPOSALS      ="0";
    static String R1_COST_TRX_SALE       ="0";
    static String R1_DPN_FOR_YEAR        ="0";
    static String R1_DPN_DISPOSALS       ="0";
    /*added*/
        static String R1_MF_RES ="0";
        static String R1_MF_BALANCE ="0";
        static String R1_COST_BALANCE ="0";
        static String R1_DPN_INI_BAL = "0";  /*added*/
        static String R1_TOTAL_I_BLN ="0";
        static String R1_TOTAL_F_BLN ="0";
        static String R1_AJUSTE="0";
                                  
    static String R2_COST_INITIAL_BALANCE="0";
    static String R2_DPRN_INITIAL_BALANCE="0";
    static String R2_COST_ADDITIONS      ="0";
    static String R2_COST_DISPOSALS      ="0";
    static String R2_COST_TRX_SALE       ="0";
    static String R2_DPN_FOR_YEAR        ="0";
    static String R2_DPN_DISPOSALS       ="0";
    /*Added*/
         static String R2_MF_RES ="0";
         static String R2_MF_BALANCE ="0";
         static String R2_COST_BALANCE ="0";
    static String R2_DPN_INI_BAL = "0";  /*added*/
         static String R2_TOTAL_I_BLN ="0";
         static String R2_TOTAL_F_BLN ="0";
         static String R2_AJUSTE="0";
                                
    static String R3_COST_INITIAL_BALANCE="0";
    static String R3_DPRN_INITIAL_BALANCE="0";
    static String R3_COST_ADDITIONS      ="0";
    static String R3_COST_DISPOSALS      ="0";
    static String R3_COST_TRX_SALE       ="0";
    static String R3_DPN_FOR_YEAR        ="0";
    static String R3_DPN_DISPOSALS       ="0";
    /*Added*/
         static String R3_MF_RES ="0";
         static String R3_MF_BALANCE ="0";
         static String R3_COST_BALANCE ="0";
    static String R3_DPN_INI_BAL = "0";  /*added*/
         static String R3_TOTAL_I_BLN ="0";
         static String R3_TOTAL_F_BLN ="0";
         static String R3_AJUSTE="0";
                                
    static String R4_COST_INITIAL_BALANCE="0";
    static String R4_DPRN_INITIAL_BALANCE="0";
    static String R4_COST_ADDITIONS      ="0";
    static String R4_COST_DISPOSALS      ="0";
    static String R4_COST_TRX_SALE       ="0";
    static String R4_DPN_FOR_YEAR        ="0";
    static String R4_DPN_DISPOSALS       ="0";
    /*Added*/
        static String R4_MF_RES ="0";
        static String R4_MF_BALANCE ="0";
        static String R4_COST_BALANCE ="0";
    static String R4_DPN_INI_BAL = "0";  /*added*/
        static String R4_TOTAL_I_BLN ="0";
        static String R4_TOTAL_F_BLN ="0";
        static String R4_AJUSTE="0";
                                
    static String R5_COST_INITIAL_BALANCE="0";
    static String R5_DPRN_INITIAL_BALANCE="0";
    static String R5_COST_ADDITIONS      ="0";
    static String R5_COST_DISPOSALS      ="0";
    static String R5_COST_TRX_SALE       ="0";
    static String R5_DPN_FOR_YEAR        ="0";
    static String R5_DPN_DISPOSALS       ="0";
    /*Added*/
        static String R5_MF_RES ="0";
        static String R5_MF_BALANCE ="0";
        static String R5_COST_BALANCE ="0";
    static String R5_DPN_INI_BAL = "0";  /*added*/
        static String R5_TOTAL_I_BLN ="0";
        static String R5_TOTAL_F_BLN ="0";
        static String R5_AJUSTE="0";
    
                            
    static String R6_COST_INITIAL_BALANCE="0";
    static String R6_DPRN_INITIAL_BALANCE="0";
    static String R6_COST_ADDITIONS      ="0";
    static String R6_COST_DISPOSALS      ="0";
    static String R6_COST_TRX_SALE       ="0";
    static String R6_DPN_FOR_YEAR        ="0";
    static String R6_DPN_DISPOSALS       ="0";
    /*Added*/
        static String R6_MF_RES ="0";
        static String R6_MF_BALANCE ="0";
        static String R6_COST_BALANCE ="0";
    static String R6_DPN_INI_BAL = "0";  /*added*/
        static String R6_TOTAL_I_BLN ="0";
        static String R6_TOTAL_F_BLN ="0";
        static String R6_AJUSTE="0";
                                  
    static String R7_COST_INITIAL_BALANCE="0";
    static String R7_DPRN_INITIAL_BALANCE="0";
    static String R7_COST_ADDITIONS      ="0";
    static String R7_COST_DISPOSALS      ="0";
    static String R7_COST_TRX_SALE       ="0";
    static String R7_DPN_FOR_YEAR        ="0";
    static String R7_DPN_DISPOSALS       ="0";
    /*Added*/
         static String R7_MF_RES ="0";
         static String R7_MF_BALANCE ="0";
         static String R7_COST_BALANCE ="0";
    static String R7_DPN_INI_BAL = "0";  /*added*/
         static String R7_TOTAL_I_BLN ="0";
         static String R7_TOTAL_F_BLN ="0";
         static String R7_AJUSTE="0";
    
                               
    static String R8_COST_INITIAL_BALANCE="0";
    static String R8_DPRN_INITIAL_BALANCE="0";
    static String R8_COST_ADDITIONS      ="0";
    static String R8_COST_DISPOSALS      ="0";
    static String R8_COST_TRX_SALE       ="0";
    static String R8_DPN_FOR_YEAR        ="0";
    static String R8_DPN_DISPOSALS       ="0";
    /*Added*/
         static String R8_MF_RES ="0";
         static String R8_MF_BALANCE ="0";
         static String R8_COST_BALANCE ="0";
    static String R8_DPN_INI_BAL = "0";  /*added*/
         static String R8_TOTAL_I_BLN ="0";
         static String R8_TOTAL_F_BLN ="0";
         static String R8_AJUSTE="0";
                                
    static String R9_COST_INITIAL_BALANCE="0";
    static String R9_DPRN_INITIAL_BALANCE="0";
    static String R9_COST_ADDITIONS="0";
    static String R9_COST_DISPOSALS="0";
    static String R9_COST_TRX_SALE ="0";
    static String R9_DPN_FOR_YEAR  ="0";
    static String R9_DPN_DISPOSALS ="0";
    /*Added*/
         static String R9_MF_RES ="0";
         static String R9_MF_BALANCE ="0";
         static String R9_COST_BALANCE ="0";
    static String R9_DPN_INI_BAL = "0";  /*added*/
         static String R9_TOTAL_I_BLN ="0";
         static String R9_TOTAL_F_BLN ="0";
         static String R9_AJUSTE="0";

    static String R10_COST_INITIAL_BALANCE="";
    static String R10_DPRN_INITIAL_BALANCE="";
    static String R10_COST_ADDITIONS      ="";
    static String R10_COST_DISPOSALS      ="";
    static String R10_COST_TRX_SALE       ="";
    static String R10_DPN_FOR_YEAR        ="";
    static String R10_DPN_DISPOSALS       ="";
    /*Added*/
         static String R10_MF_RES ="0";
         static String R10_MF_BALANCE ="0";
         static String R10_COST_BALANCE ="0";
    static String R10_DPN_INI_BAL = "0";  /*added*/
         static String R10_TOTAL_I_BLN ="0";
         static String R10_TOTAL_F_BLN ="0";
         static String R10_AJUSTE="0";
                            
    static String R11_COST_INITIAL_BALANCE="";
    static String R11_DPRN_INITIAL_BALANCE="";
    static String R11_COST_ADDITIONS      ="";
    static String R11_COST_DISPOSALS      ="";
    static String R11_COST_TRX_SALE       ="";
    static String R11_DPN_FOR_YEAR        ="";
    static String R11_DPN_DISPOSALS       ="";
    /*Added*/
         static String R11_MF_RES ="0";
         static String R11_MF_BALANCE ="0";
         static String R11_COST_BALANCE ="0";
    static String R11_DPN_INI_BAL = "0";  /*added*/
         static String R11_TOTAL_I_BLN ="0";
         static String R11_TOTAL_F_BLN ="0";
         static String R11_AJUSTE="0";
                                
    static String R12_COST_INITIAL_BALANCE="";
    static String R12_DPRN_INITIAL_BALANCE="";
    static String R12_COST_ADDITIONS      ="";
    static String R12_COST_DISPOSALS      ="";
    static String R12_COST_TRX_SALE       ="";
    static String R12_DPN_FOR_YEAR        ="";
    static String R12_DPN_DISPOSALS       ="";
    /*Added*/
         static String R12_MF_RES ="0";
         static String R12_MF_BALANCE ="0";
         static String R12_COST_BALANCE ="0";
    static String R12_DPN_INI_BAL = "0";  /*added*/
         static String R12_TOTAL_I_BLN ="0";
         static String R12_TOTAL_F_BLN ="0";
         static String R12_AJUSTE="0";
                                 
    static String R13_COST_INITIAL_BALANCE="";
    static String R13_DPRN_INITIAL_BALANCE="";
    static String R13_COST_ADDITIONS      ="";
    static String R13_COST_DISPOSALS      ="";
    static String R13_COST_TRX_SALE       ="";
    static String R13_DPN_FOR_YEAR        ="";
    static String R13_DPN_DISPOSALS="";
    /*Added*/
        static String R13_MF_RES ="0";
        static String R13_MF_BALANCE ="0";
        static String R13_COST_BALANCE ="0";
    static String R13_DPN_INI_BAL = "0";  /*added*/
        static String R13_TOTAL_I_BLN ="0";
        static String R13_TOTAL_F_BLN ="0";
        static String R13_AJUSTE="0";
    
                                
    static String R14_COST_INITIAL_BALANCE="";
    static String R14_DPRN_INITIAL_BALANCE="";
    static String R14_COST_ADDITIONS      ="";
    static String R14_COST_DISPOSALS      ="";
    static String R14_COST_TRX_SALE       ="";
    static String R14_DPN_FOR_YEAR        ="";
    static String R14_DPN_DISPOSALS       ="";
    /*ADDED*/
         static String R14_MF_RES ="0";
         static String R14_MF_BALANCE ="0";
         static String R14_COST_BALANCE ="0";
    static String R14_DPN_INI_BAL = "0";  /*added*/
         static String R14_TOTAL_I_BLN ="0";
         static String R14_TOTAL_F_BLN ="0";
         static String R14_AJUSTE="0";
                                 
    static String RI1_COST_INITIAL_BALANCE="";
    static String RI1_DPRN_INITIAL_BALANCE="";
    static String RI1_COST_ADDITIONS      ="";
    static String RI1_COST_DISPOSALS      ="";
    static String RI1_COST_TRX_SALE       ="";
    static String RI1_DPN_FOR_YEAR        ="";
    static String RI1_DPN_DISPOSALS       ="";
    static String RI1_MF_BALANCE ="0";
    /*added*/
        static String RI1_MF_RES ="0";
         static String RI1_COST_BALANCE ="0";
         static String RI1_DPN_INI_BAL = "0";  /*added*/
         static String RI1_TOTAL_I_BLN ="0";
         static String RI1_TOTAL_F_BLN ="0";
         static String RI1_AJUSTE="0";
         
         /*added*/
          static String RT_COST_INITIAL_BALANCE="0";
           static String RT_DPRN_INITIAL_BALANCE="0";
           static String RT_COST_ADDITIONS      ="0";
           static String RT_COST_DISPOSALS      ="0";
           static String RT_COST_TRX_SALE       ="0";
           static String RT_DPN_FOR_YEAR        ="0";
           static String RT_DPN_DISPOSALS       ="0";
           static String RT_MF_BALANCE ="0";
           /*added*/
               static String RT_MF_RES ="0";
                static String RT_COST_BALANCE ="0";
                static String RT_DPN_INI_BAL = "0";  /*added*/
                static String RT_TOTAL_I_BLN ="0";
                static String RT_TOTAL_F_BLN ="0";
                static String RT_AJUSTE="0";


    public XxGamReadExcel() {
    }
    /**
     * le quita las comas a los numeros
     * @param text
     * @return
     */
    public static String FormateNumeros(String text)
        {
             text = text.replace(",", "");
               return text;
        }
    public static Double FormatForDouble(String ntext)
       {
        Locale.setDefault(Locale.US);
        ntext = ntext.replace(",", "");
        double value = Double.parseDouble(ntext);
        System.out.println(value);
        return value;
       }
               
       //recibo la cantidad en double y la imprimo con formato en String 
      public static String conversion(double valor)
       {
         Locale.setDefault(Locale.US);
         DecimalFormat num = new DecimalFormat("###.00");
         return num.format(valor);
       }      
        
    public static String prepareXML() {
           auxTemplate="<XXGAM_SAF_WS_MASTER_PKG>\n" +
                          "<OPERATING_UNIT>"+ auxUnidadOp +"</OPERATING_UNIT>\n" +
                          "<PROMPT_A>"+auxPromptA+"</PROMPT_A>\n" +
                          "<PAST_YEAR>"+yearAux+"</PAST_YEAR>"  +
                          "<PROMPT_B>"+auxPromptB+"</PROMPT_B>\n" +
                          "<PROMPT_C>"+auxPromptC+"</PROMPT_C>\n" +
                          "<R1_PROMPT_COL_MX>"+R1_PROMPT_COL_MX+"</R1_PROMPT_COL_MX>\n" +
                          "<R1_PROMPT_COL_US>"+R1_PROMPT_COL_US+"</R1_PROMPT_COL_US>\n" +
                          "<R2_PROMPT_COL_MX>"+R2_PROMPT_COL_MX+"</R2_PROMPT_COL_MX>\n" +
                          "<R2_PROMPT_COL_US>"+R2_PROMPT_COL_US+"</R2_PROMPT_COL_US>\n" +
                          "<R3_PROMPT_COL_MX>"+R3_PROMPT_COL_MX+"</R3_PROMPT_COL_MX>\n" +
                          "<R3_PROMPT_COL_US>"+R3_PROMPT_COL_US+"</R3_PROMPT_COL_US>\n" +
                          "<R4_PROMPT_COL_MX>"+R4_PROMPT_COL_MX+"</R4_PROMPT_COL_MX>\n" +
                          "<R4_PROMPT_COL_US>"+R4_PROMPT_COL_US+"</R4_PROMPT_COL_US>\n" +
                          "<R5_PROMPT_COL_MX>"+R5_PROMPT_COL_MX+"</R5_PROMPT_COL_MX>\n" +
                          "<R5_PROMPT_COL_US>"+R5_PROMPT_COL_US+"</R5_PROMPT_COL_US>\n" +
                          "<R6_PROMPT_COL_MX>"+R6_PROMPT_COL_MX+"</R6_PROMPT_COL_MX>\n" +
                          "<R6_PROMPT_COL_US>"+R6_PROMPT_COL_US+"</R6_PROMPT_COL_US>\n" +
                          "<R7_PROMPT_COL_MX>"+R7_PROMPT_COL_MX+"</R7_PROMPT_COL_MX>\n" +
                          "<R7_PROMPT_COL_US>"+R7_PROMPT_COL_US+"</R7_PROMPT_COL_US>\n" +
                          "<R8_PROMPT_COL_MX>"+R8_PROMPT_COL_MX+"</R8_PROMPT_COL_MX>\n" +
                          "<R8_PROMPT_COL_US>"+R8_PROMPT_COL_US+"</R8_PROMPT_COL_US>\n" +
                          "<R9_PROMPT_COL_MX>"+R9_PROMPT_COL_MX+"</R9_PROMPT_COL_MX>\n" +
                          "<R9_PROMPT_COL_US>"+R9_PROMPT_COL_US+"</R9_PROMPT_COL_US>\n" +
                          "<R10_PROMPT_COL_MX>"+R10_PROMPT_COL_MX+"</R10_PROMPT_COL_MX>\n" +
                          "<R10_PROMPT_COL_US>"+R10_PROMPT_COL_US+"</R10_PROMPT_COL_US>\n" +
                          "<R11_PROMPT_COL_MX>"+R11_PROMPT_COL_MX+"</R11_PROMPT_COL_MX>\n" +
                          "<R11_PROMPT_COL_US>"+R11_PROMPT_COL_US+"</R11_PROMPT_COL_US>\n" +
                          "<R12_PROMPT_COL_MX>"+R12_PROMPT_COL_MX+"</R12_PROMPT_COL_MX>\n" +
                          "<R12_PROMPT_COL_US>"+R12_PROMPT_COL_US+"</R12_PROMPT_COL_US>\n" +
                          "<R13_PROMPT_COL_MX>"+R13_PROMPT_COL_MX+"</R13_PROMPT_COL_MX>\n" +
                          "<R13_PROMPT_COL_US>"+R13_PROMPT_COL_US+"</R13_PROMPT_COL_US>\n" +
                          "<R14_PROMPT_COL_MX>"+R14_PROMPT_COL_MX+"</R14_PROMPT_COL_MX>\n" +
                          "<R14_PROMPT_COL_US>"+R14_PROMPT_COL_US+"</R14_PROMPT_COL_US>\n" +
                          "<RI1_PROMPT_COL_MX>"+RI1_PROMPT_COL_MX+"</RI1_PROMPT_COL_MX>\n" +
                          "<RI1_PROMPT_COL_US>"+RI1_PROMPT_COL_US+"</RI1_PROMPT_COL_US>\n" +
                          "<PROMPT_D>"+auxPromptD+"</PROMPT_D>\n" +
                          "<PROMPT_INI_BAL>"+PROMPT_INI_BAL+"</PROMPT_INI_BAL>\n" +
                          "<RUBRO1>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R1_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R1_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R1_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R1_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R1_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R1_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R1_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R1_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R1_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R1_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R1_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R1_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R1_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R1_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO1>\n" +
                          "<RUBRO2>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R2_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R2_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R2_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R2_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R2_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R2_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R2_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R2_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R2_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R2_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R2_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R2_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R2_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R2_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO2>\n" +
                          "<RUBRO3>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R3_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R3_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R3_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R3_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R3_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R3_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R3_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R3_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R3_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R3_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R3_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R3_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R3_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R3_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO3>\n" +
                          "<RUBRO4>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R4_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R4_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R4_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R4_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R4_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R4_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R4_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R4_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R4_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R4_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R4_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R4_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R4_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R4_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO4>\n" +
                          "<RUBRO5>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R5_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R5_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R5_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R5_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R5_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R5_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R5_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R5_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R5_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R5_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R5_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R5_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R5_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R5_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO5>\n" +
                          "<RUBRO6>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R6_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R6_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R6_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R6_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R6_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R6_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R6_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R6_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R6_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R6_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R6_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R6_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R6_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R6_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO6>\n" +
                          "<RUBRO7>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R7_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R7_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R7_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R7_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R7_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R7_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R7_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R7_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R7_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R7_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R7_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R7_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R7_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R7_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO7>\n" +
                          "<RUBRO8>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R8_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R8_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R8_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R8_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R8_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R8_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R8_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R8_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R8_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R8_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R8_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R8_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R8_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R8_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO8>\n" +
                          "<RUBRO9>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R9_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R9_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R9_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R9_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R9_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R9_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R9_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R9_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R9_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R9_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R9_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R9_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R9_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R9_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO9>\n" +
                          "<RUBRO10>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R10_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R10_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R10_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R10_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R10_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R10_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R10_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R10_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R10_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R10_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R10_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R10_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R10_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R10_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO10>\n" +
                          "<RUBRO11>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R11_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R11_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R11_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R11_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R11_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R11_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R11_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R11_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R11_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R11_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R11_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R11_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R11_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R11_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO11>\n" +
                          "<RUBRO12>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R12_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R12_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R12_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R12_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R12_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R12_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R12_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                         "<MF_RESULTADOS>"+FormateNumeros(R12_MF_RES)+"</MF_RESULTADOS>\n"+
                         "<MF_BALANCE>"+FormateNumeros(R12_MF_BALANCE)+"</MF_BALANCE>\n"+
                         "<COST_BALANCE>"+FormateNumeros(R12_COST_BALANCE)+"</COST_BALANCE>\n"+
                         "<DPN_BALANCE>"+FormateNumeros(R12_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                         "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R12_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                         "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R12_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                         "<AJUSTE>"+FormateNumeros(R12_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO12>\n" +
                          "<RUBRO13>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R13_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R13_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R13_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R13_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R13_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R13_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R13_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R13_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R13_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R13_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R13_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R13_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R13_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R13_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO13>\n" +
                          "<RUBRO14>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(R14_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(R14_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(R14_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(R14_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(R14_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(R14_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(R14_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(R14_MF_RES)+"</MF_RESULTADOS>\n"+
                          "<MF_BALANCE>"+FormateNumeros(R14_MF_BALANCE)+"</MF_BALANCE>\n"+
                          "<COST_BALANCE>"+FormateNumeros(R14_COST_BALANCE)+"</COST_BALANCE>\n"+
                          "<DPN_BALANCE>"+FormateNumeros(R14_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                          "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(R14_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                          "<TOTAL_FINAL_BALANCE>"+FormateNumeros(R14_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                          "<AJUSTE>"+FormateNumeros(R14_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBRO14>\n" +
                        "<RUBROT>\n" +
                         "<COST_INITIAL_BALANCE>"+FormateNumeros(RT_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                         "<DPRN_INITIAL_BALANCE>"+FormateNumeros(RT_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                         "<COST_ADDITIONS>"+FormateNumeros(RT_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                         "<COST_DISPOSALS>"+FormateNumeros(RT_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                         "<COST_TRX_SALE>"+FormateNumeros(RT_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                         "<DPN_FOR_YEAR>"+FormateNumeros(RT_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                         "<DPN_DISPOSALS>"+FormateNumeros(RT_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                         "<MF_RESULTADOS>"+FormateNumeros(RT_MF_RES)+"</MF_RESULTADOS>\n"+
                        "<MF_BALANCE>"+FormateNumeros(RT_MF_BALANCE)+"</MF_BALANCE>\n"+
                        "<COST_BALANCE>"+FormateNumeros(RT_COST_BALANCE)+"</COST_BALANCE>\n"+
                        "<DPN_BALANCE>"+FormateNumeros(RT_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                        "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(RT_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                        "<TOTAL_FINAL_BALANCE>"+FormateNumeros(RT_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                        "<AJUSTE>"+FormateNumeros(RT_AJUSTE)+"</AJUSTE>\n"+
                         "</RUBROT>\n" +
                          "<RUBROI1>\n" +
                          "<COST_INITIAL_BALANCE>"+FormateNumeros(RI1_COST_INITIAL_BALANCE)+"</COST_INITIAL_BALANCE>\n" +
                          "<DPRN_INITIAL_BALANCE>"+FormateNumeros(RI1_DPRN_INITIAL_BALANCE)+"</DPRN_INITIAL_BALANCE>\n" +
                          "<COST_ADDITIONS>"+FormateNumeros(RI1_COST_ADDITIONS)+"</COST_ADDITIONS>\n" +
                          "<COST_DISPOSALS>"+FormateNumeros(RI1_COST_DISPOSALS)+"</COST_DISPOSALS>\n" +
                          "<COST_TRX_SALE>"+FormateNumeros(RI1_COST_TRX_SALE)+"</COST_TRX_SALE>\n" +
                          "<DPN_FOR_YEAR>"+FormateNumeros(RI1_DPN_FOR_YEAR)+"</DPN_FOR_YEAR>\n" +
                          "<DPN_DISPOSALS>"+FormateNumeros(RI1_DPN_DISPOSALS)+"</DPN_DISPOSALS>\n" +
                          "<MF_RESULTADOS>"+FormateNumeros(RI1_MF_RES)+"</MF_RESULTADOS>\n"+
                         "<MF_BALANCE>"+FormateNumeros(RI1_MF_BALANCE)+"</MF_BALANCE>\n"+
                         "<COST_BALANCE>"+FormateNumeros(RI1_COST_BALANCE)+"</COST_BALANCE>\n"+
                         "<DPN_BALANCE>"+FormateNumeros(RI1_DPN_INI_BAL)+"</DPN_BALANCE>\n"+
                         "<TOTAL_INITIAL_BALANCE>"+FormateNumeros(RI1_TOTAL_I_BLN)+"</TOTAL_INITIAL_BALANCE>\n"+
                         "<TOTAL_FINAL_BALANCE>"+FormateNumeros(RI1_TOTAL_F_BLN)+"</TOTAL_FINAL_BALANCE>\n"+
                         "<AJUSTE>"+FormateNumeros(RI1_AJUSTE)+"</AJUSTE>\n"+
                          "</RUBROI1>\n" +
                          "</XXGAM_SAF_WS_MASTER_PKG>\n";
           
            return auxTemplate;
       }
    public static void SetTotals(){
        RT_COST_INITIAL_BALANCE=conversion(FormatForDouble(R1_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R2_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R3_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R4_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R5_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R6_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R7_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R8_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R9_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R10_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R11_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R12_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R13_COST_INITIAL_BALANCE)
                                        +FormatForDouble(R14_COST_INITIAL_BALANCE));
      
        
         RT_DPRN_INITIAL_BALANCE     =  conversion(FormatForDouble(R1_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R2_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R3_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R4_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R5_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R6_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R7_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R8_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R9_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R10_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R11_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R12_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R13_DPRN_INITIAL_BALANCE)
                                        +FormatForDouble(R14_DPRN_INITIAL_BALANCE));
                                        
        RT_COST_ADDITIONS =           conversion(FormatForDouble(R1_COST_ADDITIONS)
                                        +FormatForDouble(R2_COST_ADDITIONS)
                                        +FormatForDouble(R3_COST_ADDITIONS)
                                        +FormatForDouble(R4_COST_ADDITIONS)
                                        +FormatForDouble(R5_COST_ADDITIONS)
                                        +FormatForDouble(R6_COST_ADDITIONS)
                                        +FormatForDouble(R7_COST_ADDITIONS)
                                        +FormatForDouble(R8_COST_ADDITIONS)
                                        +FormatForDouble(R9_COST_ADDITIONS)
                                        +FormatForDouble(R10_COST_ADDITIONS)
                                        +FormatForDouble(R11_COST_ADDITIONS)
                                        +FormatForDouble(R12_COST_ADDITIONS)
                                        +FormatForDouble(R13_COST_ADDITIONS)
                                        +FormatForDouble(R14_COST_ADDITIONS));    
                                        
        RT_COST_DISPOSALS      =   conversion(FormatForDouble(R1_COST_DISPOSALS)
                                        +FormatForDouble(R2_COST_DISPOSALS)
                                        +FormatForDouble(R3_COST_DISPOSALS)
                                        +FormatForDouble(R4_COST_DISPOSALS)
                                        +FormatForDouble(R5_COST_DISPOSALS)
                                        +FormatForDouble(R6_COST_DISPOSALS)
                                        +FormatForDouble(R7_COST_DISPOSALS)
                                        +FormatForDouble(R8_COST_DISPOSALS)
                                        +FormatForDouble(R9_COST_DISPOSALS)
                                        +FormatForDouble(R10_COST_DISPOSALS)
                                        +FormatForDouble(R11_COST_DISPOSALS)
                                        +FormatForDouble(R12_COST_DISPOSALS)
                                        +FormatForDouble(R13_COST_DISPOSALS)
                                        +FormatForDouble(R14_COST_DISPOSALS));
         
         RT_COST_TRX_SALE   =  conversion(FormatForDouble(R1_COST_TRX_SALE)
                                        +FormatForDouble(R2_COST_TRX_SALE)
                                        +FormatForDouble(R3_COST_TRX_SALE)
                                        +FormatForDouble(R4_COST_TRX_SALE)
                                        +FormatForDouble(R5_COST_TRX_SALE)
                                        +FormatForDouble(R6_COST_TRX_SALE)
                                        +FormatForDouble(R7_COST_TRX_SALE)
                                        +FormatForDouble(R8_COST_TRX_SALE)
                                        +FormatForDouble(R9_COST_TRX_SALE)
                                        +FormatForDouble(R10_COST_TRX_SALE)
                                        +FormatForDouble(R11_COST_TRX_SALE)
                                        +FormatForDouble(R12_COST_TRX_SALE)
                                        +FormatForDouble(R13_COST_TRX_SALE)
                                        +FormatForDouble(R14_COST_TRX_SALE)); 
         
         
         
         
         RT_DPN_FOR_YEAR        = conversion(FormatForDouble(R1_DPN_FOR_YEAR)
                                        +FormatForDouble(R2_DPN_FOR_YEAR)
                                        +FormatForDouble(R3_DPN_FOR_YEAR)
                                        +FormatForDouble(R4_DPN_FOR_YEAR)
                                        +FormatForDouble(R5_DPN_FOR_YEAR)
                                        +FormatForDouble(R6_DPN_FOR_YEAR)
                                        +FormatForDouble(R7_DPN_FOR_YEAR)
                                        +FormatForDouble(R8_DPN_FOR_YEAR)
                                        +FormatForDouble(R9_DPN_FOR_YEAR)
                                        +FormatForDouble(R10_DPN_FOR_YEAR)
                                        +FormatForDouble(R11_DPN_FOR_YEAR)
                                        +FormatForDouble(R12_DPN_FOR_YEAR)
                                        +FormatForDouble(R13_DPN_FOR_YEAR)
                                        +FormatForDouble(R14_DPN_FOR_YEAR));
                                        
         RT_DPN_DISPOSALS  =     conversion(FormatForDouble(R1_DPN_DISPOSALS)
                                        +FormatForDouble(R2_DPN_DISPOSALS)
                                        +FormatForDouble(R3_DPN_DISPOSALS)
                                        +FormatForDouble(R4_DPN_DISPOSALS)
                                        +FormatForDouble(R5_DPN_DISPOSALS)
                                        +FormatForDouble(R6_DPN_DISPOSALS)
                                        +FormatForDouble(R7_DPN_DISPOSALS)
                                        +FormatForDouble(R8_DPN_DISPOSALS)
                                        +FormatForDouble(R9_DPN_DISPOSALS)
                                        +FormatForDouble(R10_DPN_DISPOSALS)
                                        +FormatForDouble(R11_DPN_DISPOSALS)
                                        +FormatForDouble(R12_DPN_DISPOSALS)
                                        +FormatForDouble(R13_DPN_DISPOSALS)
                                        +FormatForDouble(R14_DPN_DISPOSALS)); 
                                        
         RT_MF_BALANCE = conversion(FormatForDouble(R1_MF_BALANCE)
                                        +FormatForDouble(R2_MF_BALANCE)
                                        +FormatForDouble(R3_MF_BALANCE)
                                        +FormatForDouble(R4_MF_BALANCE)
                                        +FormatForDouble(R5_MF_BALANCE)
                                        +FormatForDouble(R6_MF_BALANCE)
                                        +FormatForDouble(R7_MF_BALANCE)
                                        +FormatForDouble(R8_MF_BALANCE)
                                        +FormatForDouble(R9_MF_BALANCE)
                                        +FormatForDouble(R10_MF_BALANCE)
                                        +FormatForDouble(R11_MF_BALANCE)
                                        +FormatForDouble(R12_MF_BALANCE)
                                        +FormatForDouble(R13_MF_BALANCE)
                                        +FormatForDouble(R14_MF_BALANCE)); 
    
        RT_MF_RES =  conversion(FormatForDouble(R1_MF_RES)
                                        +FormatForDouble(R2_MF_RES)
                                        +FormatForDouble(R3_MF_RES)
                                        +FormatForDouble(R4_MF_RES)
                                        +FormatForDouble(R5_MF_RES)
                                        +FormatForDouble(R6_MF_RES)
                                        +FormatForDouble(R7_MF_RES)
                                        +FormatForDouble(R8_MF_RES)
                                        +FormatForDouble(R9_MF_RES)
                                        +FormatForDouble(R10_MF_RES)
                                        +FormatForDouble(R11_MF_RES)
                                        +FormatForDouble(R12_MF_RES)
                                        +FormatForDouble(R13_MF_RES)
                                        +FormatForDouble(R14_MF_RES)); 
         
         RT_COST_BALANCE =  conversion(FormatForDouble(R1_COST_BALANCE)
                                        +FormatForDouble(R2_COST_BALANCE)
                                        +FormatForDouble(R3_COST_BALANCE)
                                        +FormatForDouble(R4_COST_BALANCE)
                                        +FormatForDouble(R5_COST_BALANCE)
                                        +FormatForDouble(R6_COST_BALANCE)
                                        +FormatForDouble(R7_COST_BALANCE)
                                        +FormatForDouble(R8_COST_BALANCE)
                                        +FormatForDouble(R9_COST_BALANCE)
                                        +FormatForDouble(R10_COST_BALANCE)
                                        +FormatForDouble(R11_COST_BALANCE)
                                        +FormatForDouble(R12_COST_BALANCE)
                                        +FormatForDouble(R13_COST_BALANCE)
                                        +FormatForDouble(R14_COST_BALANCE)); 
         RT_DPN_INI_BAL = conversion(FormatForDouble(R1_DPN_INI_BAL)
                                        +FormatForDouble(R2_DPN_INI_BAL)
                                        +FormatForDouble(R3_DPN_INI_BAL)
                                        +FormatForDouble(R4_DPN_INI_BAL)
                                        +FormatForDouble(R5_DPN_INI_BAL)
                                        +FormatForDouble(R6_DPN_INI_BAL)
                                        +FormatForDouble(R7_DPN_INI_BAL)
                                        +FormatForDouble(R8_DPN_INI_BAL)
                                        +FormatForDouble(R9_DPN_INI_BAL)
                                        +FormatForDouble(R10_DPN_INI_BAL)
                                        +FormatForDouble(R11_DPN_INI_BAL)
                                        +FormatForDouble(R12_DPN_INI_BAL)
                                        +FormatForDouble(R13_DPN_INI_BAL)
                                        +FormatForDouble(R14_DPN_INI_BAL)); 
         RT_TOTAL_I_BLN =  conversion(FormatForDouble(R1_TOTAL_I_BLN)
                                        +FormatForDouble(R2_TOTAL_I_BLN)
                                        +FormatForDouble(R3_TOTAL_I_BLN)
                                        +FormatForDouble(R4_TOTAL_I_BLN)
                                        +FormatForDouble(R5_TOTAL_I_BLN)
                                        +FormatForDouble(R6_TOTAL_I_BLN)
                                        +FormatForDouble(R7_TOTAL_I_BLN)
                                        +FormatForDouble(R8_TOTAL_I_BLN)
                                        +FormatForDouble(R9_TOTAL_I_BLN)
                                        +FormatForDouble(R10_TOTAL_I_BLN)
                                        +FormatForDouble(R11_TOTAL_I_BLN)
                                        +FormatForDouble(R12_TOTAL_I_BLN)
                                        +FormatForDouble(R13_TOTAL_I_BLN)
                                        +FormatForDouble(R14_TOTAL_I_BLN)); 
         RT_TOTAL_F_BLN =   conversion(FormatForDouble(R1_TOTAL_F_BLN)
                                        +FormatForDouble(R2_TOTAL_F_BLN)
                                        +FormatForDouble(R3_TOTAL_F_BLN)
                                        +FormatForDouble(R4_TOTAL_F_BLN)
                                        +FormatForDouble(R5_TOTAL_F_BLN)
                                        +FormatForDouble(R6_TOTAL_F_BLN)
                                        +FormatForDouble(R7_TOTAL_F_BLN)
                                        +FormatForDouble(R8_TOTAL_F_BLN)
                                        +FormatForDouble(R9_TOTAL_F_BLN)
                                        +FormatForDouble(R10_TOTAL_F_BLN)
                                        +FormatForDouble(R11_TOTAL_F_BLN)
                                        +FormatForDouble(R12_TOTAL_F_BLN)
                                        +FormatForDouble(R13_TOTAL_F_BLN)
                                        +FormatForDouble(R14_TOTAL_F_BLN)); 
         RT_AJUSTE  =  conversion(FormatForDouble(R1_AJUSTE)
                                        +FormatForDouble(R2_AJUSTE)
                                        +FormatForDouble(R3_AJUSTE)
                                        +FormatForDouble(R4_AJUSTE)
                                        +FormatForDouble(R5_AJUSTE)
                                        +FormatForDouble(R6_AJUSTE)
                                        +FormatForDouble(R7_AJUSTE)
                                        +FormatForDouble(R8_AJUSTE)
                                        +FormatForDouble(R9_AJUSTE)
                                        +FormatForDouble(R10_AJUSTE)
                                        +FormatForDouble(R11_AJUSTE)
                                        +FormatForDouble(R12_AJUSTE)
                                        +FormatForDouble(R13_AJUSTE)
                                        +FormatForDouble(R14_AJUSTE));                             
                                        
                                        
        
    }
    
    public void leerArchivoExcel(String archivoDestino) { 
    

    try { 
        
    Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino)); 

    System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets()); 
    for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) /* Recorre cada hoja */                                                                                                                                  
    { 
        Sheet hoja = archivoExcel.getSheet(sheetNo); 
            int numColumnas = hoja.getColumns(); 
            int numFilas = hoja.getRows(); 
            String data; 
            System.out.println("Nombre de la Hoja\t"+ archivoExcel.getSheet(sheetNo).getName()); 
    for (int fila = 0; fila < numFilas; fila++) { /* Recorre cada fila de la hoja*/ 
    for (int columna = 0; columna < numColumnas; columna++) { /* Recorre cada columna de la fila */
    data = hoja.getCell(columna, fila).getContents(); 
    System.out.print(data + " "); 
    } 
    System.out.println("\n"); 
    } 
    }
    } catch (Exception ioe) { 
    System.out.println("mi excepcion"+ioe.getMessage());} 

    } 
    
    
    /**
     * Metodo que lee el archivo excel 
     * @param pInputStream
     */
    public void readExcelInputStream(java.io.InputStream pInputStream) { 
    try { 
        
    Workbook archivoExcel = Workbook.getWorkbook(pInputStream); 

    System.out.println("Numero de Hojas\t" + archivoExcel.getNumberOfSheets()); 
    //for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) /* Recorre cada hoja */                                                                                                                                  
    //{ 
     //   Sheet hoja = archivoExcel.getSheet(sheetNo); 
       //     int numColumnas = hoja.getColumns(); 
         //   int numFilas = hoja.getRows(); 
           // String data; 
            //System.out.println("Nombre de la Hoja\t"+ archivoExcel.getSheet(sheetNo).getName()); 
    //for (int fila = 0; fila < numFilas; fila++) { /* Recorre cada fila de la hoja*/ 
    //for (int columna = 0; columna < numColumnas; columna++) { /* Recorre cada columna de la fila */
    //data = hoja.getCell(columna, fila).getContents(); 
    //System.out.print(data + " "); 
    //} 
    //System.out.println("\n"); 
    //} 
    //}
    
    
        for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) /* Recorre cada hoja */                                                                                                                                  
        { 
            Sheet hoja = archivoExcel.getSheet(sheetNo); 
                int numColumnas = hoja.getColumns(); 
                int numFilas = hoja.getRows(); 
                String data; 
                System.out.println("Nombre de la Hoja\t"+ archivoExcel.getSheet(sheetNo).getName()); 
        for (int columna = 0; columna < numColumnas; columna++) 
        { 
                for(int fila = 0; fila < numFilas; fila++)  
                { 
                    data = hoja.getCell(columna, fila).getContents(); 
                   // System.out.print(data + " "); 
                    if("Balance December 31, 2016".equals(hoja.getCell(columna, fila).getContents().trim())&& (fila==6))
                        {
                            Integer auxI=0,auxJ=0;
                            auxI=fila;
                            auxJ=columna;
                            auxJ=++auxJ;
                            
                            Cell cellAux = hoja.getCell(auxJ, auxI);
                            R1_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R2_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R3_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R4_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R5_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R6_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R7_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R8_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R9_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R10_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R11_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R12_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R13_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R14_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            RI1_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            System.out.print(" j:"+auxJ +" i: "+ auxI);
                            System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            
                        }
                    
                    if("Additions".equals(hoja.getCell(columna, fila).getContents().trim())&& (fila==8))
                                            {
                                                Integer auxI=0,auxJ=0;
                                                auxI=fila;
                                                auxJ=columna;
                                                auxJ=++auxJ;
                                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                                R1_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R2_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R3_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R4_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R5_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R6_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R7_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R8_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R9_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R10_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R11_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R12_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R13_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R14_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                RI1_COST_ADDITIONS=cellAux.getContents().trim();
                                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                                                
                                            }
                    if("Disposals".equals(hoja.getCell(columna, fila).getContents().trim()) && (fila==9))
                                            {
                                                Integer auxI=0,auxJ=0;
                                                auxI=fila;
                                                auxJ=columna;
                                                auxJ=++auxJ;
                                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                                R1_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R2_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R3_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R4_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R5_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R6_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R7_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R8_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R9_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R10_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R11_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R12_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R13_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R14_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                RI1_COST_DISPOSALS=cellAux.getContents().trim();
                                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                                            }
                    if("Transfer to assets held for sale".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_COST_TRX_SALE=cellAux.getContents().trim();
                                
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("Effect of movements in exchange rates".equals(hoja.getCell(columna, fila).getContents().trim())&& fila==11)
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("Ajustes".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }               
                    if("Balance May 31, 2017".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                    if("Balance December 31, 2016".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
        if("Depreciation for the year".equals(hoja.getCell(columna, fila).getContents().trim()))
                {
                    Integer auxI=0,auxJ=0;
                    auxI=fila;
                    auxJ=columna;
                    auxJ=++auxJ;
                    Cell cellAux = hoja.getCell(auxJ, auxI);
                    R1_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R2_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R3_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R4_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R5_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R6_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R7_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R8_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R9_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R10_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R11_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R12_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R13_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R14_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    RI1_DPN_FOR_YEAR=cellAux.getContents().trim();
                    System.out.print(" j:"+auxJ +" i: "+ auxI);
                    System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                }         
                    if("Disposals".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_DPN_DISPOSALS=cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("Effect of movements in exchange rates".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("At 31 December 2016".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("At 31 May 2017".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                } 
        //System.out.println("\n"); 
        } 
        }
    
    //String myAux = prepareXML();
      //  System.out.println(myAux);
    
    
    
    
    
    } catch (Exception ioe) { 
    System.out.println("Excepción: "+ioe.getMessage());
    
    } 
   
  }
    /** END  public void readExcelInputStream(java.io.InputStream pInputStream) { **/
    
    /**
     * Obtiene los periodos para saf_flujo_efectivo
     */
     public String getPeriodoFinal (String p_final) {
                  p_final =p_final.toUpperCase();
                  
                  int enero = p_final.indexOf("ENE");
                  int january = p_final.indexOf("JAN");
                          if(enero != -1 ||january!=-1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="ENE-"+anioAux;
                              return p_final;
                          }
                        
                  int febrero = p_final.indexOf("FEB");
                          if(febrero != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="FEB-"+anioAux;
                              return p_final;
                          }
                  int marzo = p_final.indexOf("MAR");
                          if(marzo != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="MAR-"+anioAux;
                              return p_final;
                          }
                  int abril = p_final.indexOf("ABR");
                  int april = p_final.indexOf("APR");
                          if(abril != -1||april != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="ABR-"+anioAux;
                              return p_final;
                          }
                  int mayo = p_final.indexOf("MAY");
                          if(mayo != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="MAY-"+anioAux;
                              return p_final;
                          }
                  int junio = p_final.indexOf("JUN");
                          if(junio != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="JUN-"+anioAux;
                              return p_final;
                          }
                  int julio = p_final.indexOf("JUL");
                          if(julio != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="JUL-"+anioAux;
                              return p_final;
                          }
                  int agosto = p_final.indexOf("AGO");
                  int august = p_final.indexOf("AUG");
                          if(agosto != -1 || august!=-1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="AGO-"+anioAux;
                              return p_final;
                          }
                  int septiembre = p_final.indexOf("SEP");
                          if(septiembre != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="SEP-"+anioAux;
                              return p_final;
                          }
                  int octubre = p_final.indexOf("OCT");
                          if(octubre != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="OCT-"+anioAux;
                              return p_final;
                          }
                  int noviembre = p_final.indexOf("NOV");
                          if(noviembre != -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="NOV-"+anioAux;
                              return p_final;
                          }
                  int diciembre = p_final.indexOf("DIC");
                  int december = p_final.indexOf("DEC");
                          if(diciembre != -1||december!= -1) 
                          {
                              anioAux=p_final.substring(p_final.length()-2,p_final.length());
                              p_final="DIC-"+anioAux;
                              return p_final;
                          }
                  return p_final;
              }
    
    
    
    /**
     * MAIN
     * @param archivoDestino
     */
    public void readExcel(File archivoDestino) { 

    try { 
        
    Workbook archivoExcel = Workbook.getWorkbook(archivoDestino); 

    System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets()); 
    /*Identificar periodo final y periodo inicial*/
     Sheet hoja1 = archivoExcel.getSheet(0); 
              Cell cellAux1 = hoja1.getCell(0, 2);
              System.out.println("|----->"+cellAux1.getContents().trim()+"<----|");
              periodo_final = cellAux1.getContents().trim();
              
            
             periodo_final=getPeriodoFinal(periodo_final);
            periodo_inicial = "ENE-"+anioAux;
             System.out.println("periodo_inicial: "+periodo_inicial+" periodo_final: "+periodo_final);
    
    
        for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) /* Recorre cada hoja */                                                                                                                                  
        { 
            Sheet hoja = archivoExcel.getSheet(sheetNo); 
                int numColumnas = hoja.getColumns(); 
                int numFilas = hoja.getRows(); 
                String data; 
                System.out.println("Nombre de la Hojas\t"+ archivoExcel.getSheet(sheetNo).getName()); 
                
                        Cell cellAuxUP = hoja.getCell(0,0);    
                        auxUnidadOp=cellAuxUP.getContents().trim();
                        operating_unit=auxUnidadOp.substring(0,2);
                        cellAuxUP = hoja.getCell(0,1);
                        auxPromptA=cellAuxUP.getContents().trim();
                        cellAuxUP = hoja.getCell(0,2);
                        auxPromptB=cellAuxUP.getContents().trim();
                        cellAuxUP = hoja.getCell(0,3);
                        auxPromptC=cellAuxUP.getContents().trim();
                        cellAuxUP = hoja.getCell(0,5);
                        auxPromptD=cellAuxUP.getContents().trim();
                        cellAuxUP = hoja.getCell(0,6);
                        PROMPT_INI_BAL=cellAuxUP.getContents().trim();
                        yearAux = PROMPT_INI_BAL.substring(PROMPT_INI_BAL.length()-2,PROMPT_INI_BAL.length());
                
        for (int columna = 0; columna < numColumnas; columna++) 
        { 
                for(int fila = 0; fila < numFilas; fila++)  
                { 
                    data = hoja.getCell(columna, fila).getContents(); 
                   // System.out.print(data + " "); 
                    if(columna==0&&fila==6)
                        {
                            Integer auxI=0,auxJ=0;
                            auxI=fila;
                            auxJ=columna;
                            auxJ=++auxJ;
                            
                            Cell cellAux = hoja.getCell(auxJ, auxI);
                            R1_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R2_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R3_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R4_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R5_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R6_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R7_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R8_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R9_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R10_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R11_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R12_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R13_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R14_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            RI1_COST_INITIAL_BALANCE=cellAux.getContents().trim();
                            System.out.print(" j:"+auxJ +" i: "+ auxI);
                            System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            
                        }
                    if(columna==0&& fila==8)/*Additions*/
                    {
                        Integer auxI=0,auxJ=0;
                        auxI=fila;
                        auxJ=columna;
                        auxJ=++auxJ;
                        Cell cellAux = hoja.getCell(auxJ, auxI);
                        R1_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R2_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R3_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R4_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R5_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R6_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R7_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R8_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R9_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R10_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R11_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R12_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R13_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        R14_COST_ADDITIONS=cellAux.getContents().trim();
                        auxJ=++auxJ;
                        auxJ=++auxJ;
                        cellAux = hoja.getCell(auxJ, auxI);
                        RI1_COST_ADDITIONS=cellAux.getContents().trim();
                        System.out.print(" j:"+auxJ +" i: "+ auxI);
                        System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                        
                    }
                    /*if("Additions".equals(hoja.getCell(columna, fila).getContents().trim())&& (fila==8))
                                            {
                                                Integer auxI=0,auxJ=0;
                                                auxI=fila;
                                                auxJ=columna;
                                                auxJ=++auxJ;
                                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                                R1_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R2_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R3_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R4_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R5_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R6_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R7_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R8_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R9_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R10_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R11_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R12_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R13_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R14_COST_ADDITIONS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                RI1_COST_ADDITIONS=cellAux.getContents().trim();
                                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                                                
                                            }*/
                   /* if("Disposals".equals(hoja.getCell(columna, fila).getContents().trim()) && (fila==9))
                                            {
                                                Integer auxI=0,auxJ=0;
                                                auxI=fila;
                                                auxJ=columna;
                                                auxJ=++auxJ;
                                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                                R1_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R2_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R3_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R4_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R5_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R6_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R7_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R8_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R9_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R10_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R11_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R12_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R13_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                R14_COST_DISPOSALS=cellAux.getContents().trim();
                                                auxJ=++auxJ;
                                                auxJ=++auxJ;
                                                cellAux = hoja.getCell(auxJ, auxI);
                                                RI1_COST_DISPOSALS=cellAux.getContents().trim();
                                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                                            }*/
                    if(columna==0 && fila==9)/*Dispossals*/
                        {
                            Integer auxI=0,auxJ=0;
                            auxI=fila;
                            auxJ=columna;
                            auxJ=++auxJ;
                            Cell cellAux = hoja.getCell(auxJ, auxI);
                            R1_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R2_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R3_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R4_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R5_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R6_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R7_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R8_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R9_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R10_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R11_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R12_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R13_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            R14_COST_DISPOSALS=cellAux.getContents().trim();
                            auxJ=++auxJ;
                            auxJ=++auxJ;
                            cellAux = hoja.getCell(auxJ, auxI);
                            RI1_COST_DISPOSALS=cellAux.getContents().trim();
                            System.out.print(" j:"+auxJ +" i: "+ auxI);
                            System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                        }
                        
                        
                    if(columna==0&&fila==10)
                            {   /*COST_TRX_SALE*/
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                 R1_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_COST_TRX_SALE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_COST_TRX_SALE=cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                        
                        
                        
                    if(columna==0 && fila==11)   /*Effect of movements in exchange rates*/
                                              {
                                                  Integer auxI=0,auxJ=0;
                                                  auxI=fila;
                                                  auxJ=columna;
                                                  // TODO agregar vars cuando se hallan mapeado
                                                  auxJ=++auxJ;
                                                  Cell cellAux = hoja.getCell(auxJ, auxI);
                                                   R1_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R2_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R3_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R4_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R5_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R6_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R7_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R8_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R9_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R10_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R11_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R12_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R13_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  R14_MF_BALANCE=cellAux.getContents().trim();
                                                  auxJ=++auxJ;
                                                  cellAux = hoja.getCell(auxJ, auxI);
                                                  RI1_MF_BALANCE=cellAux.getContents().trim();
                                                   
                                                  System.out.print(" j:"+auxJ +" i: "+ auxI);
                                                  System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                                              }   
                        
                        
                                            
                    /*Deprecated*/
                   /* if("Effect of movements in exchange rates".equals(hoja.getCell(columna, fila).getContents().trim())&& fila==11)
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }/*/
                    if(columna==0&&fila==12)/*Ajustes*/
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_AJUSTE=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_AJUSTE=cellAux.getContents().trim();
                                
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }    
                            
                            
                    if(columna==0 && fila ==14)/*Balance*/
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_COST_BALANCE= cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_COST_BALANCE= cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                   /* if("Balance December 31, 2016".equals(hoja.getCell(columna, fila).getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                Cell cellAux = hoja.getCell(auxJ+1, auxI);
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }*/
                            
          if (columna ==0 &&fila==19)/*Balance inicial dprn*/
              {
                  Integer auxI=0,auxJ=0;
                  auxI=fila;
                  auxJ=columna;
                  auxJ=++auxJ;
                  Cell cellAux = hoja.getCell(auxJ, auxI);
                  R1_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R2_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R3_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R4_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R5_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R6_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R7_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R8_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R9_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R10_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R11_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R12_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R13_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  R14_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  auxJ=++auxJ;
                  auxJ=++auxJ;
                  cellAux = hoja.getCell(auxJ, auxI);
                  RI1_DPRN_INITIAL_BALANCE=cellAux.getContents().trim();
                  
              }
                            
        if("Depreciation for the year".equals(hoja.getCell(columna, fila).getContents().trim()))
                {
                    Integer auxI=0,auxJ=0;
                    auxI=fila;
                    auxJ=columna;
                    auxJ=++auxJ;
                    Cell cellAux = hoja.getCell(auxJ, auxI);
                    R1_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R2_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R3_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R4_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R5_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R6_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R7_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R8_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R9_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R10_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R11_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R12_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R13_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    R14_DPN_FOR_YEAR=cellAux.getContents().trim();
                    auxJ=++auxJ;
                    auxJ=++auxJ;
                    cellAux = hoja.getCell(auxJ, auxI);
                    RI1_DPN_FOR_YEAR=cellAux.getContents().trim();
                    System.out.print(" j:"+auxJ +" i: "+ auxI);
                    System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                }         
                    if("Disposals".equals(hoja.getCell(columna, fila).getContents().trim())&& fila ==22)
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_DPN_DISPOSALS=cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_DPN_DISPOSALS=cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if("Effect of movements in exchange rates".equals(hoja.getCell(columna, fila).getContents().trim())&& fila==23)
                            {
                            // TODO p01
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_MF_RES = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_MF_RES = cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if(columna==0&&fila==25)/*Balance at dprn init bal*/
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_DPN_INI_BAL = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_DPN_INI_BAL = cellAux.getContents().trim();
                                
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if(columna==0&&fila ==29 )
                            {
                                // TODO p02
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_TOTAL_I_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_TOTAL_I_BLN = cellAux.getContents().trim();
                                System.out.print(" j:"+auxJ +" i: "+ auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                    if(columna==0&&fila ==30 )
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=fila;
                                auxJ=columna;
                                auxJ=++auxJ;
                                Cell cellAux = hoja.getCell(auxJ, auxI);
                                R1_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R2_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R3_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R4_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R5_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R6_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R7_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R8_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R9_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R10_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R11_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R12_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R13_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                R14_TOTAL_F_BLN = cellAux.getContents().trim();
                                auxJ=++auxJ;
                                auxJ=++auxJ;
                                cellAux = hoja.getCell(auxJ, auxI);
                                RI1_TOTAL_F_BLN = cellAux.getContents().trim();
                            
                            }
                            
                } 
        //System.out.println("\n"); 
        } 
        }
    
    //String myAux = prepareXML();
      //  System.out.println(myAux);
    
       SetTotals();
        System.out.println("Entrando en prepareR1....");
        //prepareR1();
    
    
    } catch (Exception ioe) { 
    System.out.println("Excepción: "+ioe.getMessage());} 

    } 
    
    public static String[] prepareR1(){
    String id_r="1",rubro="Eq.Vlo.en Arrendamiento Financiero",tipo_saldo="COST_SALDO_INICIAL";
        String arreglo[] = {operating_unit,id_r,rubro,tipo_saldo,periodo_inicial,periodo_final,FormateNumeros(R1_COST_INITIAL_BALANCE)};
        /*System.out.println("Dentro de prepareR1..."+arreglo[0]+" "+arreglo[1]+" "+arreglo[2]);*/
        String vartest=RT_COST_INITIAL_BALANCE ;
     return  arreglo;  
    }


    public void leerPorHojaCelda(String archivoDestino,int numHoja,int fila, String columna) { 

        try { 
        int columnaAux = abc(columna);
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino)); 

        for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) /* Recorre cada hoja */                                                                                                                                  
        { 

        Sheet hoja = archivoExcel.getSheet(sheetNo);
            
        int numColumnas = hoja.getColumns(); 
        int numFilas = hoja.getRows(); 
         
                String data; 
                if (sheetNo+1==numHoja){
                System.out.println("Nombre de la Hoja\t"+ archivoExcel.getSheet(sheetNo).getName()); 
                for (int fililla = 1; fililla <= numFilas; fililla++) { /* Recorre cada fila de la hoja*/ 
                      
                for (int columnilla = 1; columnilla <= numColumnas; columnilla++) { /* Recorre cada columna de la fila */
                 if (fililla == fila && columnilla == columnaAux)    
                {
                data = hoja.getCell(columnilla-1, fililla-1).getContents(); 
               // data = hoja.getCell(columnilla, fililla).getContents(); 
                System.out.print(data + " "); 
                }
        } /** end for (int columnilla = 0; columnilla < numColumnas; columnilla++) **/
       
        } /** end for (int fililla = 0; fililla < numFilas; fililla++) {  **/
        }
        
        }
        } catch (Exception ioe) { 
        System.out.println("Excepcion:"+ioe.getMessage());} 

        } 

    static int abc(String val ) {
     String [] cadena = {"A","B","C", "D","E","F","G","H","I ","J","K","L ","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA", "AB","AC","AD","AE","AF","AG","AH","AI ","AJ","AK","AL ","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ"};
     int posicion=0;
     
     for (int lugar = 0; lugar<cadena.length;lugar++){
            if (cadena[lugar]== val){
            posicion = lugar +1;}      
     }
      
     return posicion;
             }


        
    
}
