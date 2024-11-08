package com.onpeaks.Quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onpeaks.Quizapp.model.Question;
import com.onpeaks.Quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>>  getAllQuestions() {
		return questionService.getAllquestions();
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("addquestion")
	public ResponseEntity<String> addquestion(@RequestBody Question question) {
		return questionService.addquestion(question);
	}
	
	
}
