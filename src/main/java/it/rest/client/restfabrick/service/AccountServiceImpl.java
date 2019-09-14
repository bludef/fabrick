package it.rest.client.restfabrick.service;

import it.rest.common.AccountBalance;
import it.rest.common.RequestSctOrder;
import it.rest.common.ResponseAccountBalance;
import it.rest.common.ResponseSctOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService {

    private RestTemplate restTemplate;

    @Autowired
    public AccountServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves the balance of a cash account.
     * @param accountId The ID of the account.
     * @return ResponseAccountBalance
     */
    @Override
    public ResponseEntity<ResponseAccountBalance> getAccountBalanceById(String accountId) {

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
        return restTemplate.exchange(url,HttpMethod.GET, entity, ResponseAccountBalance.class);

    }

    @Override
    public ResponseEntity<ResponseSctOrder> createSctPaymentOrder(String accountId) {

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
        requestSctOrder.setReceiverName("Dan Dan");
        requestSctOrder.setDescription("Payment invoice 75/2017");
        requestSctOrder.setAmount("900.00");
        requestSctOrder.setCurrency("EUR");
        requestSctOrder.setExecutionDate("13/09/2019");
        requestSctOrder.setFeeType("");

        HttpEntity<RequestSctOrder> entity = new HttpEntity<>(requestSctOrder,requestHeaders);

        // Send request with POST method, and Headers.
        return restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseSctOrder.class);
    }
}
