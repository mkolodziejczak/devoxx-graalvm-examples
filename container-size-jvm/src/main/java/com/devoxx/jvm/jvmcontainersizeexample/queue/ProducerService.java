package com.devoxx.jvm.jvmcontainersizeexample.queue;

import com.devoxx.jvm.jvmcontainersizeexample.model.CreditScoreResult;
import com.devoxx.jvm.jvmcontainersizeexample.model.CreditScoreRiskLevel;
import com.devoxx.jvm.jvmcontainersizeexample.model.Person;
import com.devoxx.jvm.jvmcontainersizeexample.model.RecommendationAction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.TextMessage;
import org.springframework.jms.core.JmsTemplate;

public class ProducerService {

  String topic;
  String queue;

  JmsTemplate jmsTemplate;

  public void sendToQueue() throws JsonProcessingException {
    try {
      var creditScore =
          new CreditScoreResult(
              "John", "Doe", 10000, 700, CreditScoreRiskLevel.LOW, RecommendationAction.PROCESS);
      String jsonObj =
          new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(creditScore);
      jmsTemplate.send(
          queue,
          messageCreator -> {
            TextMessage message = messageCreator.createTextMessage();
            message.setText(jsonObj);
            return message;
          });
    } catch (Exception ex) {
      System.out.println("ERROR in sending message to queue");
    }
  }

  public void sendToTopic() throws JsonProcessingException {
    try {
      var person = new Person("John", "Doe", 12000.45);
      String jsonObj =
          new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(person);
      jmsTemplate.send(
          topic,
          messageCreator -> {
            TextMessage message = messageCreator.createTextMessage();
            message.setText(jsonObj);
            return message;
          });
    } catch (Exception ex) {
      System.out.println("ERROR in sending message to queue");
    }
  }
}
