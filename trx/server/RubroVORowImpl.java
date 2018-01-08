package xxgam.oracle.apps.fa.sumaria.trx.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RubroVORowImpl extends OAViewRowImpl {


    public static final int IDRUBRO = 0;

    /**This is the default constructor (do not remove)
     */
    public RubroVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute IdRubro
     */
    public String getIdRubro() {
        return (String) getAttributeInternal(IDRUBRO);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute IdRubro
     */
    public void setIdRubro(String value) {
        setAttributeInternal(IDRUBRO, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case IDRUBRO:
            return getIdRubro();
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