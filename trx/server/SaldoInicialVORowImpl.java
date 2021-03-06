package xxgam.oracle.apps.fa.sumaria.trx.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SaldoInicialVORowImpl extends OAViewRowImpl {
    public static final int LEDGER = 0;
    public static final int ACCOUNT = 1;
    public static final int PERIOD = 2;
    public static final int CURRENCY = 3;
    public static final int PTD = 4;
    public static final int PTDCONVERTED = 5;
    public static final int YTD = 6;
    public static final int YTDCONVERTED = 7;
    public static final int CODECUENTA = 8;
    public static final int SEGMENT1 = 9;
    public static final int SEGMENT5 = 10;
    public static final int SEGMENT6 = 11;
    public static final int PERIODNAME = 12;
    public static final int NAME = 13;

    /**This is the default constructor (do not remove)
     */
    public SaldoInicialVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute Ledger
     */
    public String getLedger() {
        return (String) getAttributeInternal(LEDGER);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Ledger
     */
    public void setLedger(String value) {
        setAttributeInternal(LEDGER, value);
    }

    /**Gets the attribute value for the calculated attribute Account
     */
    public String getAccount() {
        return (String) getAttributeInternal(ACCOUNT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Account
     */
    public void setAccount(String value) {
        setAttributeInternal(ACCOUNT, value);
    }

    /**Gets the attribute value for the calculated attribute Period
     */
    public String getPeriod() {
        return (String) getAttributeInternal(PERIOD);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Period
     */
    public void setPeriod(String value) {
        setAttributeInternal(PERIOD, value);
    }

    /**Gets the attribute value for the calculated attribute Currency
     */
    public String getCurrency() {
        return (String) getAttributeInternal(CURRENCY);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Currency
     */
    public void setCurrency(String value) {
        setAttributeInternal(CURRENCY, value);
    }

    /**Gets the attribute value for the calculated attribute Ptd
     */
    public Number getPtd() {
        return (Number) getAttributeInternal(PTD);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Ptd
     */
    public void setPtd(Number value) {
        setAttributeInternal(PTD, value);
    }

    /**Gets the attribute value for the calculated attribute PtdConverted
     */
    public String getPtdConverted() {
        return (String) getAttributeInternal(PTDCONVERTED);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PtdConverted
     */
    public void setPtdConverted(String value) {
        setAttributeInternal(PTDCONVERTED, value);
    }

    /**Gets the attribute value for the calculated attribute Ytd
     */
    public Number getYtd() {
        return (Number) getAttributeInternal(YTD);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Ytd
     */
    public void setYtd(Number value) {
        setAttributeInternal(YTD, value);
    }

    /**Gets the attribute value for the calculated attribute YtdConverted
     */
    public String getYtdConverted() {
        return (String) getAttributeInternal(YTDCONVERTED);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute YtdConverted
     */
    public void setYtdConverted(String value) {
        setAttributeInternal(YTDCONVERTED, value);
    }

    /**Gets the attribute value for the calculated attribute CodeCuenta
     */
    public Number getCodeCuenta() {
        return (Number) getAttributeInternal(CODECUENTA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CodeCuenta
     */
    public void setCodeCuenta(Number value) {
        setAttributeInternal(CODECUENTA, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case LEDGER:
            return getLedger();
        case ACCOUNT:
            return getAccount();
        case PERIOD:
            return getPeriod();
        case CURRENCY:
            return getCurrency();
        case PTD:
            return getPtd();
        case PTDCONVERTED:
            return getPtdConverted();
        case YTD:
            return getYtd();
        case YTDCONVERTED:
            return getYtdConverted();
        case CODECUENTA:
            return getCodeCuenta();
        case SEGMENT1:
            return getSegment1();
        case SEGMENT5:
            return getSegment5();
        case SEGMENT6:
            return getSegment6();
        case PERIODNAME:
            return getPeriodName();
        case NAME:
            return getName();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case SEGMENT1:
            setSegment1((String)value);
            return;
        case SEGMENT5:
            setSegment5((String)value);
            return;
        case SEGMENT6:
            setSegment6((String)value);
            return;
        case PERIODNAME:
            setPeriodName((String)value);
            return;
        case NAME:
            setName((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute Segment1
     */
    public String getSegment1() {
        return (String) getAttributeInternal(SEGMENT1);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Segment1
     */
    public void setSegment1(String value) {
        setAttributeInternal(SEGMENT1, value);
    }

    /**Gets the attribute value for the calculated attribute Segment5
     */
    public String getSegment5() {
        return (String) getAttributeInternal(SEGMENT5);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Segment5
     */
    public void setSegment5(String value) {
        setAttributeInternal(SEGMENT5, value);
    }

    /**Gets the attribute value for the calculated attribute Segment6
     */
    public String getSegment6() {
        return (String) getAttributeInternal(SEGMENT6);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Segment6
     */
    public void setSegment6(String value) {
        setAttributeInternal(SEGMENT6, value);
    }

    /**Gets the attribute value for the calculated attribute PeriodName
     */
    public String getPeriodName() {
        return (String) getAttributeInternal(PERIODNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PeriodName
     */
    public void setPeriodName(String value) {
        setAttributeInternal(PERIODNAME, value);
    }

    /**Gets the attribute value for the calculated attribute Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }
}
