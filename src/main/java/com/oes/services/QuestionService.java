package com.oes.services;

import java.util.List;

import com.oes.entities.Question;

public interface QuestionService {
	Question save(Question question);
	List<Question> listAllQuestion();
	Question findByQuestionName(String questionName);
}
