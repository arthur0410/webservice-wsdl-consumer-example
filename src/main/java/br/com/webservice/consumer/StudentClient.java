package br.com.webservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.consumingwebservice.wsdl.StudentDetailsRequest;
import com.example.consumingwebservice.wsdl.StudentDetailsResponse;

public class StudentClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(StudentClient.class);

  public StudentDetailsResponse getStudent(String student) {

    StudentDetailsRequest request = new StudentDetailsRequest();
    request.setName(student);

    log.info("Requesting location for " + student);

    StudentDetailsResponse response = (StudentDetailsResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8080/service/student-details", request);

    return response;
  }

}