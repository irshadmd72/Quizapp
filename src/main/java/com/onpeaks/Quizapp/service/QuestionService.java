package com.onpeaks.Quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onpeaks.Quizapp.model.Question;
import com.onpeaks.Quizapp.repository.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo questionRepo;


	public ResponseEntity<List<Question>>  getAllquestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<> (questionRepo.findAll(),HttpStatus.OK);
			} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<> (new ArrayList<>(),HttpStatus.BAD_REQUEST);

		
	}


	public ResponseEntity<List<Question>>  getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return new ResponseEntity<> (questionRepo.findByCategory(category),HttpStatus.OK) ;
	}


	public ResponseEntity<String> addquestion(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<> ("success",HttpStatus.CREATED );
	}

}
