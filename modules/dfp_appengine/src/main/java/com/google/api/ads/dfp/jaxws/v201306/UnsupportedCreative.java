
package com.google.api.ads.dfp.jaxws.v201306;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             A {@code Creative} that isn't supported by this version of the API.
 *             This object is readonly and when encountered should be reported
 *             on the DFP API forum.
 *           
 * 
 * <p>Java class for UnsupportedCreative complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnsupportedCreative">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.google.com/apis/ads/publisher/v201306}Creative">
 *       &lt;sequence>
 *         &lt;element name="unsupportedCreativeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnsupportedCreative", propOrder = {
    "unsupportedCreativeType"
})
public class UnsupportedCreative
    extends Creative
{

    protected String unsupportedCreativeType;

    /**
     * Gets the value of the unsupportedCreativeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnsupportedCreativeType() {
        return unsupportedCreativeType;
    }

    /**
     * Sets the value of the unsupportedCreativeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnsupportedCreativeType(String value) {
        this.unsupportedCreativeType = value;
    }

}
