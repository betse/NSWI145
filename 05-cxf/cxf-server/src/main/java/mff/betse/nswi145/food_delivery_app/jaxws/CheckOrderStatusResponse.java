
package mff.betse.nswi145.food_delivery_app.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.11
 * Sun Mar 23 01:38:21 CET 2025
 * Generated source version: 3.5.11
 */

@XmlRootElement(name = "checkOrderStatusResponse", namespace = "http://food_delivery_app.nswi145.betse.mff/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkOrderStatusResponse", namespace = "http://food_delivery_app.nswi145.betse.mff/")

public class CheckOrderStatusResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}

