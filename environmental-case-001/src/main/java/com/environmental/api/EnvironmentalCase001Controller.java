package com.environmental.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.environmental.model.EnvironmentalMetrics;
import com.environmental.model.PolutionEvaluation;
import com.environmental.service.EvaluatingPolluantConcentration;


@RestController
@RequestMapping("/api")
public class EnvironmentalCase001Controller
{

	 @Autowired
	  EvaluatingPolluantConcentration evaluatingservice;
	
	
	 @GetMapping("/test")
	 public String test() 
	 {
	      return "Success";
	 }
	 
	 @PostMapping("/evaluate")
	 public ResponseEntity<PolutionEvaluation> calculateConcentration(@RequestBody EnvironmentalMetrics em) 
	 {	 
		 PolutionEvaluation evaluation = evaluatingservice.calculateConcentration(em);
		 return ResponseEntity.ok(evaluation);
	 }
	 
}
