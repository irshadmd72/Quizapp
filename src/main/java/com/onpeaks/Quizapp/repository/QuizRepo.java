package com.onpeaks.Quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onpeaks.Quizapp.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	

}
