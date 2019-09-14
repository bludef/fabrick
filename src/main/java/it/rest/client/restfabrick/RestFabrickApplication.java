package it.rest.client.restfabrick;

import it.rest.client.restfabrick.config.AppConfig;
import it.rest.client.restfabrick.service.AccountService;
import it.rest.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@SpringBootApplication
public class RestFabrickApplication {

    private static final Logger logger = LoggerFactory.getLogger(RestFabrickApplication.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService client = applicationContext.getBean(AccountService.class);

        //================================================================
        //========== Retrieves the balance of a cash account. ============
        //================================================================
        getAccountBalanceById(client);
        //================================================================
        //================= Creates a SCT payment order. =================
        //================================================================
        createsSctPaymentOrder(client);
    }

    private static void getAccountBalanceById(AccountService client) {
        ResponseEntity<ResponseAccountBalance> response = client.getAccountBalanceById("XXXX");

        HttpStatus statusCode = response.getStatusCode();
        logger.info("Response Satus Code: " + statusCode);

        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            if (Objects.requireNonNull(response.getBody()).getPayload() != null) {

                for (AccountBalance accountBalance : response.getBody().getPayload()) {
                    logger.info("AccountBalance : ");
                    logger.info("Date : {}", accountBalance.getDate());
                    logger.info("balance : {}", accountBalance.getBalance());
                    logger.info("availableBalance : {}", accountBalance.getAvailableBalance());
                }
            }

        }
    }

    private static void createsSctPaymentOrder(AccountService client) {

        ResponseEntity<ResponseSctOrder> response = client.createSctPaymentOrder("XXXX");

        HttpStatus statusCode = response.getStatusCode();
        logger.info("Response Satus Code: {}", statusCode);

        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            if (Objects.requireNonNull(response.getBody()).getPayload() != null) {

                for (SctOrder sctOrder : response.getBody().getPayload()) {
                    logger.info("SctOrder : ");
                    logger.info("OrderID : {}", sctOrder.getOrderId());
                    logger.info("Cro : {}", sctOrder.getCro());
                    logger.info("Uri : {}", sctOrder.getUri());
                    logger.info("Amount : ");
                    logger.info("SenderAmount : {}", sctOrder.getAmount().getReceiverAmount());
                    logger.info("SenderCurrency : {}", sctOrder.getAmount().getReceiverCurrency());
                    logger.info("ExchangeRate : {}", sctOrder.getAmount().getExchangeRate());
                    logger.info("FeeType : {}", sctOrder.getFeeType().value());
                    logger.info("Fees : ");
                    for (Fees fees : sctOrder.getFees()) {
                        logger.info("Amount : {}", fees.getAmount());
                        logger.info("Code : {}", fees.getCode());
                        logger.info("Currency : {}", fees.getCurrency());
                        logger.info("Description : {}", fees.getDescription());
                        logger.info("------------------------------------");

                    }
                }
            }

        }
    }


}
