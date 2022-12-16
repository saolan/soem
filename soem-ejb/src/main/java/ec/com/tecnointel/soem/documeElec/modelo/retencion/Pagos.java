package ec.com.tecnointel.soem.documeElec.modelo.retencion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagos", propOrder = {
    "pago"
})
public class Pagos {

    @XmlElement(required = true)
    protected List<Pago> pago;

    public List<Pago> getPago() {
        if (pago == null) {
            pago = new ArrayList<Pago>();
        }
        return this.pago;
    }

}
