package com.onpeaks.Quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onpeaks.Quizapp.controller.QuestionWrapper;
import com.onpeaks.Quizapp.model.Question;
import com.onpeaks.Quizapp.model.Quiz;
import com.onpeaks.Quizapp.model.Response;
import com.onpeaks.Quizapp.repository.QuestionRepo;
import com.onpeaks.Quizapp.repository.QuizRepo;

@Service
public class QuizService {
	@Autowired
	private QuizRepo quizrepo;
	
	@Autowired
	private QuestionRepo questionrepo;
	
	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		List<Question>	questions = questionrepo.findRandomQuestionByCategory(category,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizrepo.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Optional<Quiz> quiz = quizrepo.findById(id);
		List<Question> quizquestionsFromDb =   quiz.get().getQuestions();
		List<QuestionWrapper> question = new ArrayList<>();
		
		for(Question quizquestions : quizquestionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(quizquestions.getId(),quizquestions.getQuestionTitle(), quizquestions.getOption1(),
					quizquestions.getOption2(), quizquestions.getOption3(), quizquestions.getOption4());
			question.add(qw);
			
		}
		
		return new ResponseEntity<>(question,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {
		Quiz quiz = quizrepo.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int i = 0;
		int right = 0;
		for(Response response  : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) 
				right++;
			
			
			i++;

		}
		
		return new ResponseEntity<>(right,HttpStatus.OK) ;
 

	}

	

}
   