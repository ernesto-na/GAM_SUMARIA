package xxgam.oracle.apps.fa.sumaria.setup.lov.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxGamCuentaVORowImpl extends OAViewRowImpl {
    public static final int CUENTA = 0;
    public static final int DESCRIPCION = 1;

    /**This is the default constructor (do not remove)
     */
    public XxGamCuentaVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute Cuenta
     */
    public String getCuenta() {
        return (String) getAttributeInternal(CUENTA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Cuenta
     */
    public void setCuenta(String value) {
        setAttributeInternal(CUENTA, value);
    }

    /**Gets the attribute value for the calculated attribute Descripcion
     */
    public String getDescripcion() {
        return (String) getAttributeInternal(DESCRIPCION);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Descripcion
     */
    public void setDescripcion(String value) {
        setAttributeInternal(DESCRIPCION, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CUENTA:
            return getCuenta();
        case DESCRIPCION:
            return getDescripcion();
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
