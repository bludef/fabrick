package it.rest.client.restfabrick.service;


import it.rest.common.ResponseAccountBalance;
import it.rest.common.ResponseSctOrder;
import org.springframework.http.ResponseEntity;

public interface AccountService {

   ResponseEntity<ResponseAccountBalance> getAccountBalanceById(String id);

   ResponseEntity<ResponseSctOrder> createSctPaymentOrder(String id);
}
