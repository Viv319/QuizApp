package com.vivek.quizapp.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.quizapp.dao.QuestionDao;
import com.vivek.quizapp.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		return questionDao.findAll();
		
	}

	public List<Question> getQuestionByCategory(String param) {
		
		return questionDao.findQuestionByCategory(param);
	}

	public String addQuestion(Question question) {
		
		 questionDao.save(question);
		 return "success";
	}

	public String deleteQuestionById(Integer id) {
		
		questionDao.deleteById(id);
		return "success";
	}

	public String updateQuestionById(Integer id, Question question) {
		if(question.getId()==id)
		{
			 questionDao.save(question);
			 return "success";
		}
		return "fail";
			
	}
}

