//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.2 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.14 alle 08:38:26 AM CEST 
//


package it.rest.common;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.rest.common package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.rest.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link AccountBalance }
     * 
     */
    public AccountBalance createAccountBalance() {
        return new AccountBalance();
    }

    /**
     * Create an instance of {@link ResponseAccountBalance }
     * 
     */
    public ResponseAccountBalance createResponseAccountBalance() {
        return new ResponseAccountBalance();
    }

    /**
     * Create an instance of {@link Amount }
     * 
     */
    public Amount createAmount() {
        return new Amount();
    }

    /**
     * Create an instance of {@link Fees }
     * 
     */
    public Fees createFees() {
        return new Fees();
    }

    /**
     * Create an instance of {@link SctOrder }
     * 
     */
    public SctOrder createSctOrder() {
        return new SctOrder();
    }

    /**
     * Create an instance of {@link RequestSctOrder }
     * 
     */
    public RequestSctOrder createRequestSctOrder() {
        return new RequestSctOrder();
    }

    /**
     * Create an instance of {@link ResponseSctOrder }
     * 
     */
    public ResponseSctOrder createResponseSctOrder() {
        return new ResponseSctOrder();
    }

}
