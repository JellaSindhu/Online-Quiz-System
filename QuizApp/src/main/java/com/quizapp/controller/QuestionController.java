package com.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.entity.Question;
import com.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	//base URI: http://localhost:8080/question/allQuestions
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("allQuestions")
	public  ResponseEntity<List<Question>> getAllQuestions(){
	return questionservice.getAllQuestions();
	}
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category){
		return questionservice.getQuestionByCategory(category);
		}
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question){
			return questionservice.addQuestion(question);
		}
	@DeleteMapping("/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return questionservice.deleteQuestion(id);
	}
	@PutMapping("update/{id}")
	public String updateQuestion(@PathVariable int id, @RequestBody Question question){
		return questionservice.updateQuestion(id,question);
		
	}
	
}