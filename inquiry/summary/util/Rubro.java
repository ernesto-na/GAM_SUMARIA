package xxgam.oracle.apps.fa.sumaria.inquiry.summary.util;

public class Rubro {
      String unOper;
      String id_rubro;
      String rubro;
       String p_inicial;
       String p_final;
      String COST_SALDO_INICIAL;
      String DPRN_INITIAL_BALANCE;
      String COST_ADDITIONS;
      String COST_BAJAS;
      String COST_TRANSFERS_SALE;
      String DPN_DEPRECIACION;
      String DPN_BAJAS;
      String DPN_VAR_TIP_CAMBIO;
      String COST_VAR_TIP_CAMBIO;
      String COST_SALDO_FINAL;
      String DPN_SALDO_FINAL;
    public Rubro(String unOper, String id_rubro, String rubro, String p_inicial, String p_final, String COST_SALDO_INICIAL, String DPRN_INITIAL_BALANCE, String COST_ADDITIONS, String COST_BAJAS, String COST_TRANSFERS_SALE, String DPN_DEPRECIACION, String DPN_BAJAS, String DPN_VAR_TIP_CAMBIO, String COST_VAR_TIP_CAMBIO, String COST_SALDO_FINAL, String DPN_SALDO_FINAL) {
            this.unOper = unOper;
            this.id_rubro = id_rubro;
            this.rubro = rubro;
            this.p_inicial = p_inicial;
            this.p_final = p_final;
            this.COST_SALDO_INICIAL = COST_SALDO_INICIAL;
            this.DPRN_INITIAL_BALANCE = DPRN_INITIAL_BALANCE;
            this.COST_ADDITIONS = COST_ADDITIONS;
            this.COST_BAJAS = COST_BAJAS;
            this.COST_TRANSFERS_SALE = COST_TRANSFERS_SALE;
            this.DPN_DEPRECIACION = DPN_DEPRECIACION;
            this.DPN_BAJAS = DPN_BAJAS;
            this.DPN_VAR_TIP_CAMBIO = DPN_VAR_TIP_CAMBIO;
            this.COST_VAR_TIP_CAMBIO = COST_VAR_TIP_CAMBIO;
            this.COST_SALDO_FINAL = COST_SALDO_FINAL;
            this.DPN_SALDO_FINAL = DPN_SALDO_FINAL;
        }
    
    public String getP_inicial() {
            return p_inicial;
        }

        public String getP_final() {
            return p_final;
        }

        public void setP_inicial(String p_inicial) {
            this.p_inicial = p_inicial;
        }

        public void setP_final(String p_final) {
            this.p_final = p_final;
        }
    public String getUnOper() {
            return unOper;
        }

        public void setUnOper(String unOper) {
            this.unOper = unOper;
        }
    public String getId_rubro() {
           return id_rubro;
       }

       public String getRubro() {
           return rubro;
       }

       public void setId_rubro(String id_rubro) {
           this.id_rubro = id_rubro;
       }

       public void setRubro(String rubro) {
           this.rubro = rubro;
       }

      public void setCOST_SALDO_INICIAL(String COST_SALDO_INICIAL) {
          this.COST_SALDO_INICIAL = COST_SALDO_INICIAL;
      }

      public void setDPRN_INITIAL_BALANCE(String DPRN_INITIAL_BALANCE) {
          this.DPRN_INITIAL_BALANCE = DPRN_INITIAL_BALANCE;
      }

      public void setCOST_ADDITIONS(String COST_ADDITIONS) {
          this.COST_ADDITIONS = COST_ADDITIONS;
      }

      public void setCOST_BAJAS(String COST_BAJAS) {
          this.COST_BAJAS = COST_BAJAS;
      }

      public void setCOST_TRANSFERS_SALE(String COST_TRANSFERS_SALE) {
          this.COST_TRANSFERS_SALE = COST_TRANSFERS_SALE;
      }

      public void setDPN_DEPRECIACION(String DPN_DEPRECIACION) {
          this.DPN_DEPRECIACION = DPN_DEPRECIACION;
      }

      public void setDPN_BAJAS(String DPN_BAJAS) {
          this.DPN_BAJAS = DPN_BAJAS;
      }

      public void setDPN_VAR_TIP_CAMBIO(String DPN_VAR_TIP_CAMBIO) {
          this.DPN_VAR_TIP_CAMBIO = DPN_VAR_TIP_CAMBIO;
      }

      public void setCOST_VAR_TIP_CAMBIO(String COST_VAR_TIP_CAMBIO) {
          this.COST_VAR_TIP_CAMBIO = COST_VAR_TIP_CAMBIO;
      }

      public void setCOST_SALDO_FINAL(String COST_SALDO_FINAL) {
          this.COST_SALDO_FINAL = COST_SALDO_FINAL;
      }

      public void setDPN_SALDO_FINAL(String DPN_SALDO_FINAL) {
          this.DPN_SALDO_FINAL = DPN_SALDO_FINAL;
      }

      public String getCOST_SALDO_INICIAL() {
          return COST_SALDO_INICIAL;
      }

      public String getDPRN_INITIAL_BALANCE() {
          return DPRN_INITIAL_BALANCE;
      }

      public String getCOST_ADDITIONS() {
          return COST_ADDITIONS;
      }

      public String getCOST_BAJAS() {
          return COST_BAJAS;
      }

      public String getCOST_TRANSFERS_SALE() {
          return COST_TRANSFERS_SALE;
      }

      public String getDPN_DEPRECIACION() {
          return DPN_DEPRECIACION;
      }

      public String getDPN_BAJAS() {
          return DPN_BAJAS;
      }

      public String getDPN_VAR_TIP_CAMBIO() {
          return DPN_VAR_TIP_CAMBIO;
      }

      public String getCOST_VAR_TIP_CAMBIO() {
          return COST_VAR_TIP_CAMBIO;
      }

      public String getCOST_SALDO_FINAL() {
          return COST_SALDO_FINAL;
      }

      public String getDPN_SALDO_FINAL() {
          return DPN_SALDO_FINAL;
      }
      
}
