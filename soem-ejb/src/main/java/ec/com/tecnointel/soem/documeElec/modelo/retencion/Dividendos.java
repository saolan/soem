package ec.com.tecnointel.soem.documeElec.modelo.retencion;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dividendos", propOrder = {
    "fechaPagoDiv",
    "imRentaSoc",
    "ejerFisUtDiv"
})
public class Dividendos {

    @XmlElement(required = true)
    protected String fechaPagoDiv;
    @XmlElement(required = true)
    protected BigDecimal imRentaSoc;
    @XmlElement(required = true)
    protected String ejerFisUtDiv;

    public String getFechaPagoDiv() {
        return fechaPagoDiv;
    }

    public void setFechaPagoDiv(String value) {
        this.fechaPagoDiv = value;
    }

    public BigDecimal getImRentaSoc() {
        return imRentaSoc;
    }

    public void setImRentaSoc(BigDecimal value) {
        this.imRentaSoc = value;
    }

    public String getEjerFisUtDiv() {
        return ejerFisUtDiv;
    }

    public void setEjerFisUtDiv(String value) {
        this.ejerFisUtDiv = value;
    }
}
