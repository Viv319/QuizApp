package com.vivek.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.quizapp.model.Question;
import com.vivek.quizapp.serivce.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{param}")
	public List<Question> getAllQuestionsByCategory(@PathVariable String param){
		return questionService.getQuestionByCategory(param);
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question); 
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestionById(id);
	}
	
	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@PathVariable Integer id, @RequestBody Question question){
		return questionService.updateQuestionById(id, question);
	}
}
