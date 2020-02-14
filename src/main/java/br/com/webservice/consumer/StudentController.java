package br.com.webservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired private StudentClient studentClient;
	
	@GetMapping("/{country}")
	public ResponseEntity<?> consulta(
			@PathVariable("country") String student) {
		return ResponseEntity.ok(studentClient.getStudent(student));
	}
	

}
