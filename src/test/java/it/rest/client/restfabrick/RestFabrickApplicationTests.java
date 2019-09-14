package it.rest.client.restfabrick;

import it.rest.common.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestFabrickApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(RestFabrickApplicationTests.class);


    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Retrieves the full list of cash accounts.
     * Please note that this endpoint is an alias for /api/gbs/customer/v2/myself/accounts.
     */
    @Test
    public void getAccountsBalanceTest()  {

        final String uri = "https://sandbox.platfr.io/api/gbs/customer/v2/myself/accounts";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Auth-Schema","S2S");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        logger.info("getAccountsBalance : "+response.getBody());


    }

    /**
     * Retrieves the balance of a cash account.
     * Operazione: Lettura saldo
     * 	API: https://www.platfr.io/#/docs/api#GET-BankingAccountBalance
     * 	url : https://sandbox.platfr.io/api/gbs/banking/v2/accounts/{accountId}/balance
     * 	Input: {accountId}:Long è un parametro dell’applicazione;
     * Output: Visualizzare il saldo
     */
    @Test
    public void getAccountBalanceByAccountIdTest()  {

        //======================
        String accountId = "XXXX";
        //======================


        final String url = "https://sandbox.platfr.io/api/gbs/banking/v2/accounts/"+accountId+"/balance";
        //=======================================================================
        //============================= HEADER ==================================
        //=======================================================================
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Auth-Schema","S2S");

        HttpEntity<AccountBalance> entity = new HttpEntity<>(requestHeaders);
        // Send request with GET method, and Headers.
        ResponseEntity<ResponseAccountBalance> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, ResponseAccountBalance.class);

        HttpStatus statusCode = response.getStatusCode();
        logger.info("Response Satus Code: " + statusCode);

        if (statusCode == HttpStatus.OK) {
            // Response Body Data
           if(Objects.requireNonNull(response.getBody()).getPayload() != null ) {

               for(AccountBalance accountBalance : response.getBody().getPayload() ) {
                   logger.info("AccountBalance : ");
                   logger.info("Date : " + accountBalance.getDate());
                   logger.info("balance : " + accountBalance.getBalance());
                   logger.info("availableBalance : " + accountBalance.getAvailableBalance());
               }
            }

        }

    } //  end getAccountBalanceByAccountId


    /**
     *     Payments/SCT - SEPA Credit Transfer
     *     /api/gbs/banking/v2.1/accounts/{accountId}/payments/sct/orders
     */

    @Test
    public void createsSctPaymentOrderTest()  {
        //======================
        String accountId = "XXXX";
        //======================
        final String uri = "https://sandbox.platfr.io/api/gbs/banking/v2.1/accounts/"+accountId+"/payments/sct/orders";
        //=======================================================================
        //============================= HEADER ==================================
        //=======================================================================
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Auth-Schema","S2S");

        //=======================================================================
        //================ setting up the request body ==========================
        //=======================================================================
        RequestSctOrder requestSctOrder = new RequestSctOrder();
//        requestSctOrder.setReceiverName("Dan Dan");
        requestSctOrder.setDescription("Payment invoice 75/2017");
        requestSctOrder.setAmount("900.00");
        requestSctOrder.setCurrency("EUR");
        requestSctOrder.setExecutionDate("13/09/2019");
        requestSctOrder.setFeeType("");


        HttpEntity<RequestSctOrder> entity = new HttpEntity<>(requestSctOrder,requestHeaders);


        // Send request with POST method, and Headers.
//        ResponseEntity<String> response = restTemplate.exchange(uri,
//                HttpMethod.POST, entity, String.class);
        ResponseEntity<ResponseSctOrder> response = restTemplate.exchange(uri,
                HttpMethod.POST, entity, ResponseSctOrder.class);

        HttpStatus statusCode = response.getStatusCode();
        logger.info("Response Satus Code: " + statusCode);

        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            if(Objects.requireNonNull(response.getBody()).getPayload() != null ) {

                for(SctOrder sctOrder : response.getBody().getPayload() ) {
                    logger.info("SctOrder : ");
                    logger.info("OrderID : " + sctOrder.getOrderId());
                    logger.info("Cro : " + sctOrder.getCro());
                    logger.info("Uri : " + sctOrder.getUri());
                    logger.info("Amount : ");
                    logger.info("SenderAmount : " + sctOrder.getAmount().getReceiverAmount());
                    logger.info("SenderCurrency : " + sctOrder.getAmount().getReceiverCurrency());
                    logger.info("ExchangeRate : " + sctOrder.getAmount().getExchangeRate());
                    logger.info("FeeType : " + sctOrder.getFeeType().value());
                    logger.info("Fees : ");
                    for(Fees fees : sctOrder.getFees()){
                        logger.info("Amount : " + fees.getAmount());
                        logger.info("Code : " + fees.getCode());
                        logger.info("Currency : " + fees.getCurrency());
                        logger.info("Description : " + fees.getDescription());
                        logger.info("------------------------------------");

                    }
                }
            }

        }

    } //  end



}
