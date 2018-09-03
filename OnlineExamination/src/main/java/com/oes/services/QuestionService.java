package com.oes.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.oes.entities.Question;


public interface QuestionService {
	Question save(Question question);
	List<Question> listAllQuestion();
	Question findByQuestionName(String questionName);
	List<Question> findAllByCourseId(int courseId);
}
