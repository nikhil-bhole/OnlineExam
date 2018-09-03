package com.oes.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oes.entities.Question;


@Repository("questionRepository")
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	List<Question> findAllByCourseId(int courseId);
}
