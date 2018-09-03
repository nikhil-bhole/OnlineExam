package com.oes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="question_id")
	private int question_id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="option_a")
	private String option_a;
	
	@Column(name="option_b")
	private String option_b;
	
	@Column(name="option_c")
	private String option_c;
	
	@Column(name="option_d")
	private String option_d;
	
	@Column(name="correct_option")
	private String correct_option;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_a() {
		return option_a;
	}

	public void setOption_a(String option_a) {
		this.option_a = option_a;
	}

	public String getOption_b() {
		return option_b;
	}

	public void setOption_b(String option_b) {
		this.option_b = option_b;
	}

	public String getOption_c() {
		return option_c;
	}

	public void setOption_c(String option_c) {
		this.option_c = option_c;
	}

	public String getOption_d() {
		return option_d;
	}

	public void setOption_d(String option_d) {
		this.option_d = option_d;
	}

	public String getCorrect_option() {
		return correct_option;
	}

	public void setCorrect_option(String correct_option) {
		this.correct_option = correct_option;
	}

	public int getCourse_id() {
		return courseId;
	}

	public void setCourse_id(int courseId) {
		this.courseId = courseId;
	}
	
}
