package ec.com.tecnointel.soem.documeElec.modelo.retencion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleImpuestos", propOrder = {
    "detalleImpuesto"
})
public class DetalleImpuestos {

    @XmlElement(required = true)
    protected List<DetalleImpuesto> detalleImpuesto;
    
    public List<DetalleImpuesto> getDetalleImpuesto() {
        if (detalleImpuesto == null) {
            detalleImpuesto = new ArrayList<DetalleImpuesto>();
        }
        return this.detalleImpuesto;
    }

}
