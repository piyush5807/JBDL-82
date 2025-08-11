package com.example.major_project.services;

import com.example.major_project.dto.CreateTransactionDTO;
import com.example.major_project.model.Transaction;
import com.example.major_project.model.TransactionStatus;
import com.example.major_project.repositories.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TRANSACTION_CREATED_TOPIC = "transaction-created";
    private static final String WALLET_UPDATED_TOPIC = "wallet-updated";

    private JSONParser jsonParser = new JSONParser();

    @Autowired
    ObjectMapper objectMapper;

    public Transaction send(CreateTransactionDTO createTransactionDTO){

        Transaction transaction = createTransactionDTO.to();
        transaction.setStatus(TransactionStatus.PENDING);
        transaction = this.transactionRepository.save(transaction);

        //TODO: Publish kafka events
        try {
            this.kafkaTemplate.send(TRANSACTION_CREATED_TOPIC, objectMapper.writeValueAsString(transaction));
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return transaction;
    }

    @KafkaListener(topics = WALLET_UPDATED_TOPIC, groupId = "transaction-group")
    public void updateTransaction(String msg) throws ParseException {

        JSONObject eventData = (JSONObject) jsonParser.parse(msg);

        String walletUpdateStatus = (String) eventData.get("status");
        String externalTransactionId = (String) eventData.get("externalTransactionId");

//        String sender =  (String) eventData.get("sender");
//        String receiver = (String) eventData.get("receiver");

        TransactionStatus transactionStatus = walletUpdateStatus.equals("SUCCESS") ? TransactionStatus.SUCCESS : TransactionStatus.FAILED;
        this.transactionRepository.updateTransaction(externalTransactionId, transactionStatus);

        // TODO: Publish transaction completed event (which will be listened by a notification service to send out relevant communication)
    }

}
