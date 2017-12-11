package xxgam.oracle.apps.fa.sumaria.upload.util;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author GHCM-T430-01
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class XxGamReadExcelDB {
    static   String auxUnidadOp="test";
        static   String auxPromptA="testprompA";
        static   String auxPromptB="testprompB";
        static   String auxPromptC="testprompC";
        static   String R1_PROMPT_COL_MX ="R1_PROMPT_COL_MX";
        static String R1_PROMPT_COL_US ="Eq.Vlo.en Arrendamiento Financiero";
       static  String auxTemplate="";
        static String R2_PROMPT_COL_MX ="R2_PROMPT_COL_MX";
        static String R2_PROMPT_COL_US ="R2_PROMPT_COL_US";
        static String R3_PROMPT_COL_MX ="R3_PROMPT_COL_MX";
        static String R3_PROMPT_COL_US ="R3_PROMPT_COL_US";
        static String R4_PROMPT_COL_MX ="R4_PROMPT_COL_MX";
        static String R4_PROMPT_COL_US ="R4_PROMPT_COL_US";
        static String R5_PROMPT_COL_MX ="R5_PROMPT_COL_MX";
        static String R5_PROMPT_COL_US ="R5_PROMPT_COL_US";
        static String R6_PROMPT_COL_MX ="R6_PROMPT_COL_MX";
        static String R6_PROMPT_COL_US ="R6_PROMPT_COL_US";
        static String R7_PROMPT_COL_MX ="R7_PROMPT_COL_MX";
        static String R7_PROMPT_COL_US ="R7_PROMPT_COL_US";
        static String R8_PROMPT_COL_MX ="R8_PROMPT_COL_MX";
        static String R8_PROMPT_COL_US ="R8_PROMPT_COL_US";
        static String R9_PROMPT_COL_MX ="R9_PROMPT_COL_MX";
        static String R9_PROMPT_COL_US ="R9_PROMPT_COL_US";
        static String R10_PROMPT_COL_MX="R10_PROMPT_COL_MX";
        static String R10_PROMPT_COL_US="R10_PROMPT_COL_US";
        static String R11_PROMPT_COL_MX="R11_PROMPT_COL_MX";
        static String R11_PROMPT_COL_US="R11_PROMPT_COL_US";
        static String R12_PROMPT_COL_MX="R12_PROMPT_COL_MX";
        static String R12_PROMPT_COL_US="R12_PROMPT_COL_US";
        static String R13_PROMPT_COL_MX="R13_PROMPT_COL_MX";
        static String R13_PROMPT_COL_US="R13_PROMPT_COL_US";
        static String R14_PROMPT_COL_MX="R14_PROMPT_COL_MX";
        static String R14_PROMPT_COL_US="R14_PROMPT_COL_US";
        static String RI1_PROMPT_COL_MX="RI1_PROMPT_COL_MX";
        static String RI1_PROMPT_COL_US="RI1_PROMPT_COL_US";
        static String PROMPT_D="test";
        static String PROMPT_INI_BAL="test";
        
        //*Rubros*//
    static String R1_COST_INITIAL_BALANCE="0";
    static String R1_DPRN_INITIAL_BALANCE="0";
    static String R1_COST_ADDITIONS      ="0";
    static String R1_COST_DISPOSALS      ="0";
    static String R1_COST_TRX_SALE       ="0";
    static String R1_DPN_FOR_YEAR        ="0";
    static String R1_DPN_DISPOSALS       ="0";
                                  
    static String R2_COST_INITIAL_BALANCE="0";
    static String R2_DPRN_INITIAL_BALANCE="0";
    static String R2_COST_ADDITIONS      ="0";
    static String R2_COST_DISPOSALS      ="0";
    static String R2_COST_TRX_SALE       ="0";
    static String R2_DPN_FOR_YEAR        ="0";
    static String R2_DPN_DISPOSALS       ="0";
                                
    static String R3_COST_INITIAL_BALANCE="0";
    static String R3_DPRN_INITIAL_BALANCE="0";
    static String R3_COST_ADDITIONS      ="0";
    static String R3_COST_DISPOSALS      ="0";
    static String R3_COST_TRX_SALE       ="0";
    static String R3_DPN_FOR_YEAR        ="0";
    static String R3_DPN_DISPOSALS       ="0";
                                
    static String R4_COST_INITIAL_BALANCE="0";
    static String R4_DPRN_INITIAL_BALANCE="0";
    static String R4_COST_ADDITIONS      ="0";
    static String R4_COST_DISPOSALS      ="0";
    static String R4_COST_TRX_SALE       ="0";
    static String R4_DPN_FOR_YEAR        ="0";
    static String R4_DPN_DISPOSALS       ="0";
                                
    static String R5_COST_INITIAL_BALANCE="0";
    static String R5_DPRN_INITIAL_BALANCE="0";
    static String R5_COST_ADDITIONS      ="0";
    static String R5_COST_DISPOSALS      ="0";
    static String R5_COST_TRX_SALE       ="0";
    static String R5_DPN_FOR_YEAR        ="0";
    static String R5_DPN_DISPOSALS       ="0";
                            
    static String R6_COST_INITIAL_BALANCE="0";
    static String R6_DPRN_INITIAL_BALANCE="0";
    static String R6_COST_ADDITIONS      ="0";
    static String R6_COST_DISPOSALS      ="0";
    static String R6_COST_TRX_SALE       ="0";
    static String R6_DPN_FOR_YEAR        ="0";
    static String R6_DPN_DISPOSALS       ="0";
                                  
    static String R7_COST_INITIAL_BALANCE="0";
    static String R7_DPRN_INITIAL_BALANCE="0";
    static String R7_COST_ADDITIONS      ="0";
    static String R7_COST_DISPOSALS      ="0";
    static String R7_COST_TRX_SALE       ="0";
    static String R7_DPN_FOR_YEAR        ="0";
    static String R7_DPN_DISPOSALS       ="0";
                               
    static String R8_COST_INITIAL_BALANCE="0";
    static String R8_DPRN_INITIAL_BALANCE="0";
    static String R8_COST_ADDITIONS      ="0";
    static String R8_COST_DISPOSALS      ="0";
    static String R8_COST_TRX_SALE       ="0";
    static String R8_DPN_FOR_YEAR        ="0";
    static String R8_DPN_DISPOSALS       ="0";
                                
    static String R9_COST_INITIAL_BALANCE="0";
    static String R9_DPRN_INITIAL_BALANCE="0";
    static String R9_COST_ADDITIONS="0";
    static String R9_COST_DISPOSALS="0";
    static String R9_COST_TRX_SALE ="0";
    static String R9_DPN_FOR_YEAR  ="0";
    static String R9_DPN_DISPOSALS ="0";

    static String R10_COST_INITIAL_BALANCE="";
    static String R10_DPRN_INITIAL_BALANCE="";
    static String R10_COST_ADDITIONS      ="";
    static String R10_COST_DISPOSALS      ="";
    static String R10_COST_TRX_SALE       ="";
    static String R10_DPN_FOR_YEAR        ="";
    static String R10_DPN_DISPOSALS       ="";
                            
    static String R11_COST_INITIAL_BALANCE="";
    static String R11_DPRN_INITIAL_BALANCE="";
    static String R11_COST_ADDITIONS      ="";
    static String R11_COST_DISPOSALS      ="";
    static String R11_COST_TRX_SALE       ="";
    static String R11_DPN_FOR_YEAR        ="";
    static String R11_DPN_DISPOSALS       ="";
                                
    static String R12_COST_INITIAL_BALANCE="";
    static String R12_DPRN_INITIAL_BALANCE="";
    static String R12_COST_ADDITIONS      ="";
    static String R12_COST_DISPOSALS      ="";
    static String R12_COST_TRX_SALE       ="";
    static String R12_DPN_FOR_YEAR        ="";
    static String R12_DPN_DISPOSALS       ="";
                                 
    static String R13_COST_INITIAL_BALANCE="";
    static String R13_DPRN_INITIAL_BALANCE="";
    static String R13_COST_ADDITIONS      ="";
    static String R13_COST_DISPOSALS      ="";
    static String R13_COST_TRX_SALE       ="";
    static String R13_DPN_FOR_YEAR        ="";
    static String R13_DPN_DISPOSALS="";
                                
    static String R14_COST_INITIAL_BALANCE="";
    static String R14_DPRN_INITIAL_BALANCE="";
    static String R14_COST_ADDITIONS      ="";
    static String R14_COST_DISPOSALS      ="";
    static String R14_COST_TRX_SALE       ="";
    static String R14_DPN_FOR_YEAR        ="";
    static String R14_DPN_DISPOSALS       ="";
                                 
    static String RI1_COST_INITIAL_BALANCE="";
    static String RI1_DPRN_INITIAL_BALANCE="";
    static String RI1_COST_ADDITIONS      ="";
    static String RI1_COST_DISPOSALS      ="";
    static String RI1_COST_TRX_SALE       ="";
    static String RI1_DPN_FOR_YEAR        ="";
    static String RI1_DPN_DISPOSALS       ="";

    private String inputFile;
    public void setInputFile(String inputFile) {
           this.inputFile = inputFile;
       }
    public static String nvl(String value, String alternateValue) {
       if (value == null)
           return alternateValue;

       return value;
    }
    //preapara el xml
    /*public static String prepareXML() {
            auxTemplate="<XXGAM_SAF_WS_MASTER_PKG>\n" +
               "<OPERATING_UNIT>"+ auxUnidadOp +"</OPERATING_UNIT>\n" +
               "<PROMPT_A>"+auxPromptA+"</PROMPT_A>\n" +
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
               "<PROMPT_D>"+PROMPT_D+"</PROMPT_D>\n" +
               "<PROMPT_INI_BAL>"+PROMPT_INI_BAL+"</PROMPT_INI_BAL>\n" +
               "<RUBRO1>\n" +
               "<COST_INITIAL_BALANCE>"+R1_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R1_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R1_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R1_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R1_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R1_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R1_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO1>\n" +
               "<RUBRO2>\n" +
               "<COST_INITIAL_BALANCE>"+R2_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R2_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R2_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R2_COST_DISPOSALS+"/COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R2_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R2_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R2_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO2>\n" +
               "<RUBRO3>\n" +
               "<COST_INITIAL_BALANCE>"+R3_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R3_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R3_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R3_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R3_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R3_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R3_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO3>\n" +
               "<RUBRO4>\n" +
               "<COST_INITIAL_BALANCE>"+R4_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R4_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R4_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R4_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R4_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R4_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R4_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO4>\n" +
               "<RUBRO5>\n" +
               "<COST_INITIAL_BALANCE>"+R5_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R5_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R5_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R5_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R5_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R5_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R5_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO5>\n" +
               "<RUBRO6>\n" +
               "<COST_INITIAL_BALANCE>"+R6_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R6_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R6_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R6_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R6_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R6_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R6_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "<MF_RESULTADOS>-4,950,799.972400</MF_RESULTADOS>\n" +
               "<MF_BALANCE>8,468,617.958254</MF_BALANCE>\n" +
               "</RUBRO6>\n" +
               "<RUBRO7>\n" +
               "<COST_INITIAL_BALANCE>"+R7_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R7_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R7_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R7_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R7_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R7_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R7_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO7>\n" +
               "<RUBRO8>\n" +
               "<COST_INITIAL_BALANCE>"+R8_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R8_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R8_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R8_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R8_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R8_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R8_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO8>\n" +
               "<RUBRO9>\n" +
               "<COST_INITIAL_BALANCE>"+R9_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R9_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R9_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R9_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R9_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R9_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R9_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "<MF_RESULTADOS>-527,436.787600</MF_RESULTADOS>\n" +
               "<MF_BALANCE>669,371.252746</MF_BALANCE>\n" +
               "</RUBRO9>\n" +
               "<RUBRO10>\n" +
               "<COST_INITIAL_BALANCE>"+R10_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R10_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R10_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R10_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R10_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R10_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R10_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO10>\n" +
               "<RUBRO11>\n" +
               "<COST_INITIAL_BALANCE>"+R11_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE"+R11_COST_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R11_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R11_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R11_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R11_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R11_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO11>\n" +
               "<RUBRO12>\n" +
               "<COST_INITIAL_BALANCE>"+R12_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R12_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R12_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R12_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R12_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R12_COST_TRX_SALE+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R12_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO12>\n" +
               "<RUBRO13>\n" +
               "<COST_INITIAL_BALANCE>"+R13_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R13_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R13_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R13_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R13_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R13_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R13_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO13>\n" +
               "<RUBRO14>\n" +
               "<COST_INITIAL_BALANCE>"+R14_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+R14_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+R14_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>"+R14_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+R14_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+R14_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+R14_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBRO14>\n" +
               "<RUBROI1>\n" +
               "<COST_INITIAL_BALANCE>"+RI1_COST_INITIAL_BALANCE+"</COST_INITIAL_BALANCE>\n" +
               "<DPRN_INITIAL_BALANCE>"+RI1_DPRN_INITIAL_BALANCE+"</DPRN_INITIAL_BALANCE>\n" +
               "<COST_ADDITIONS>"+RI1_COST_ADDITIONS+"</COST_ADDITIONS>\n" +
               "<COST_DISPOSALS>."+RI1_COST_DISPOSALS+"</COST_DISPOSALS>\n" +
               "<COST_TRX_SALE>"+RI1_COST_TRX_SALE+"</COST_TRX_SALE>\n" +
               "<DPN_FOR_YEAR>"+RI1_DPN_FOR_YEAR+"</DPN_FOR_YEAR>\n" +
               "<DPN_DISPOSALS>"+RI1_DPN_DISPOSALS+"</DPN_DISPOSALS>\n" +
               "</RUBROI1>\n" +
               "</XXGAM_SAF_WS_MASTER_PKG>\n";
            return auxTemplate;
       }*/
    //Setea el xml con la info del excel
    public void read() throws IOException  {
           File inputWorkbook = new File(inputFile);
           Workbook w;
           try {
               w = Workbook.getWorkbook(inputWorkbook);
               // Get the first sheet
               Sheet sheet = w.getSheet(0);
               
                    //trae los valores de una columna
                    String aux;
                     for (int j = 0; j < sheet.getColumns(); j++) {
                    for(int i=0; i< sheet.getRows();i++)
                       {
                           Cell cell = sheet.getCell(j, i);
                           System.out.print(cell.getContents());
                           if("Effect of movements in exchange rates".equals(cell.getContents())) {
                               System.out.print(cell.getContents());
                           }
                           
                           if("Additions".equals(cell.getContents().trim()))
                           {
                               Integer auxI=0,auxJ=0;
                               auxI=i;
                               auxJ=j;
                               Cell cellAux = sheet.getCell(auxJ+1, auxI);
                               System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                           }
                           if("Disposals".equals(cell.getContents().trim()))
                           {
                               Integer auxI=0,auxJ=0;
                               auxI=i;
                               auxJ=j;
                               Cell cellAux = sheet.getCell(auxJ+1, auxI);
                               System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                           }
                          if("Transfer to assets held for sale".equals(cell.getContents().toString().trim()))
                           {
                               Integer auxI=0,auxJ=0;
                               auxI=i;
                               auxJ=j;
                               Cell cellAux = sheet.getCell(auxJ+1, auxI);
                               System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                           }
                          if("Effect of movements in exchange rates".equals(cell.getContents().trim()))
                           {
                               Integer auxI=0,auxJ=0;
                               auxI=i;
                               auxJ=j;
                               Cell cellAux = sheet.getCell(auxJ+1, auxI);
                               System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                           }
                         
                          if("Ajustes".equals(cell.getContents().trim()))
                           {
                               Integer auxI=0,auxJ=0;
                               auxI=i;
                               auxJ=j;
                               Cell cellAux = sheet.getCell(auxJ+1, auxI);
                               System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                           } 
                           if("Balance May 31, 2017".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                           if("Balance December 31, 2016".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                           if("Depreciation for the year".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                           if("Disposals".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                           if("Effect of movements in exchange rates".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                         
                           if("Balance May 31, 2017".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                           if("At 31 December 2016".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            }
                           if("At 31 May 2017".equals(cell.getContents().trim()))
                            {
                                Integer auxI=0,auxJ=0;
                                auxI=i;
                                auxJ=j;
                                Cell cellAux = sheet.getCell(auxJ+1, auxI);
                                System.out.print("-->:"+cellAux.getContents().trim()+" "); 
                            } 
                       }
                    System.out.println("\n");
                         System.out.println("");
                     }                   
                    

           } catch (BiffException e) {
               e.printStackTrace();
           }
       }
    
}
