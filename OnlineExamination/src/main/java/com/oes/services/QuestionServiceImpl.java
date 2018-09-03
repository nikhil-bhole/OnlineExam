package com.oes.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.entities.Question;
import com.oes.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionsRepository;
	
	@Autowired
	public void setQuestionRepository(QuestionRepository questionsRepository) {
	      this.questionsRepository= questionsRepository;
	}
	
	
	public List<Question> listAllQuestion() {
		return (List<Question>) questionsRepository.findAll();
	}


	@Override
	public Question save(Question question) {
		return questionsRepository.save(question);
	}


	@Override
	public Question findByQuestionName(String questionName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Question> findAllByCourseId(int courseId) {
		return (List<Question>) questionsRepository.findAllByCourseId(courseId);
	}

}
