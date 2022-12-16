package ec.com.tecnointel.soem.documeElec.modelo.retencion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "impuestosDocSustento", propOrder = {
    "impuestoDocSustento"
})
public class ImpuestosDocSustento {

    @XmlElement(required = true)
    protected List<ImpuestoDocSustento> impuestoDocSustento;

    public List<ImpuestoDocSustento> getImpuestoDocSustento() {
        if (impuestoDocSustento == null) {
            impuestoDocSustento = new ArrayList<ImpuestoDocSustento>();
        }
        return this.impuestoDocSustento;
    }

}
