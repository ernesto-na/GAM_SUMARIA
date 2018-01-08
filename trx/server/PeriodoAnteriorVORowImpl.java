package xxgam.oracle.apps.fa.sumaria.trx.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PeriodoAnteriorVORowImpl extends OAViewRowImpl {
    public static final int PERIODANT = 0;
    public static final int PERIODNAME = 1;

    /**This is the default constructor (do not remove)
     */
    public PeriodoAnteriorVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute PeriodAnt
     */
    public String getPeriodAnt() {
        return (String) getAttributeInternal(PERIODANT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute PeriodAnt
     */
    public void setPeriodAnt(String value) {
        setAttributeInternal(PERIODANT, value);
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

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case PERIODANT:
            return getPeriodAnt();
        case PERIODNAME:
            return getPeriodName();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }
}