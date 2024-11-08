package com.onpeaks.Quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onpeaks.Quizapp.model.Question;
import com.onpeaks.Quizapp.model.Response;
import com.onpeaks.Quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
		return quizservice.createquiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz( @PathVariable Integer id){
		return quizservice.getQuiz(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> getScore(@PathVariable Integer id , @RequestBody List<Response> responses){
		return quizservice.calculate(id,responses);
	}


}

