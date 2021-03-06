package xxgam.oracle.apps.fa.sumaria.trx.server;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CuentasRubrosVORowImpl extends OAViewRowImpl {
    public static final int CUENTA = 0;
    public static final int DESCRIPCIONCUENTA = 1;
    public static final int SUBCUENTA = 2;
    public static final int DESCRIPCIONSUBCUENTA = 3;
    public static final int OPERATINGUNIT = 4;
    public static final int IDRUBRO = 5;

    /**This is the default constructor (do not remove)
     */
    public CuentasRubrosVORowImpl() {
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

    /**Gets the attribute value for the calculated attribute DescripcionCuenta
     */
    public String getDescripcionCuenta() {
        return (String) getAttributeInternal(DESCRIPCIONCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute DescripcionCuenta
     */
    public void setDescripcionCuenta(String value) {
        setAttributeInternal(DESCRIPCIONCUENTA, value);
    }

    /**Gets the attribute value for the calculated attribute Subcuenta
     */
    public String getSubcuenta() {
        return (String) getAttributeInternal(SUBCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute Subcuenta
     */
    public void setSubcuenta(String value) {
        setAttributeInternal(SUBCUENTA, value);
    }

    /**Gets the attribute value for the calculated attribute DescripcionSubcuenta
     */
    public String getDescripcionSubcuenta() {
        return (String) getAttributeInternal(DESCRIPCIONSUBCUENTA);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute DescripcionSubcuenta
     */
    public void setDescripcionSubcuenta(String value) {
        setAttributeInternal(DESCRIPCIONSUBCUENTA, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case CUENTA:
            return getCuenta();
        case DESCRIPCIONCUENTA:
            return getDescripcionCuenta();
        case SUBCUENTA:
            return getSubcuenta();
        case DESCRIPCIONSUBCUENTA:
            return getDescripcionSubcuenta();
        case OPERATINGUNIT:
            return getOperatingUnit();
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
        case OPERATINGUNIT:
            setOperatingUnit((String)value);
            return;
        case IDRUBRO:
            setIdRubro((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute OperatingUnit
     */
    public String getOperatingUnit() {
        return (String) getAttributeInternal(OPERATINGUNIT);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute OperatingUnit
     */
    public void setOperatingUnit(String value) {
        setAttributeInternal(OPERATINGUNIT, value);
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
}
