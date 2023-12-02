package com.vivek.quizapp.serivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivek.quizapp.dao.QuestionDao;
import com.vivek.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String param) {
		try {
			return new ResponseEntity<>(questionDao.findQuestionByCategory(param), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
		 questionDao.save(question);
		 return new ResponseEntity<>(new String("success"), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);
		 
	}

	public ResponseEntity<String> deleteQuestionById(Integer id) {
		try {
		questionDao.deleteById(id);
		return new ResponseEntity<>(new String("success"),HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new String(),HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> updateQuestionById(Integer id, Question question) {
		try {
		if(question.getId()==id)
		{
			 questionDao.save(question);
			 return new ResponseEntity<>(new String("success"),HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<>(new String("wrong id"),HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new String(),HttpStatus.BAD_REQUEST);
			
	}
}

