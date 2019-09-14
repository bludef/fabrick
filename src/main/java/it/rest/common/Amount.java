//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.14 alle 08:38:26 AM CEST 
//


package it.rest.common;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Amount complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Amount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="receiverAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="receiverCurrency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Amount", propOrder = {
    "receiverAmount",
    "receiverCurrency",
    "exchangeRate"
})
public class Amount
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String receiverAmount;
    @XmlElement(required = true)
    protected String receiverCurrency;
    @XmlElement(required = true)
    protected String exchangeRate;

    /**
     * Recupera il valore della proprietà receiverAmount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverAmount() {
        return receiverAmount;
    }

    /**
     * Imposta il valore della proprietà receiverAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverAmount(String value) {
        this.receiverAmount = value;
    }

    /**
     * Recupera il valore della proprietà receiverCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverCurrency() {
        return receiverCurrency;
    }

    /**
     * Imposta il valore della proprietà receiverCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverCurrency(String value) {
        this.receiverCurrency = value;
    }

    /**
     * Recupera il valore della proprietà exchangeRate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Imposta il valore della proprietà exchangeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExchangeRate(String value) {
        this.exchangeRate = value;
    }

}
