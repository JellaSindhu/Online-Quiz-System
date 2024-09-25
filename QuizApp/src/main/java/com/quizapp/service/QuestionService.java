package com.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.dao.QuestionDao;
import com.quizapp.entity.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>>getAllQuestions() {
	try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	public List<Question> getQuestionByCategory(String category){
		return questionDao.findByCategory(category);
	}
	public String  addQuestion(Question question) {
		questionDao.save(question);
		return "Question added successfully";
		
	}
	public String deleteQuestion(int id) {
		questionDao.deleteById(id);
		return "Question deleted successfully";
	}
	public String updateQuestion(int id,Question question) {
			Question question2=questionDao.findById(id). get();
			BeanUtils.copyProperties(question, question2);
			questionDao.save(question2);
			return "Question updated successfully";
	}
}