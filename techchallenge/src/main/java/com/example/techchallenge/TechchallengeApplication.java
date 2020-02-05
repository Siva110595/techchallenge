package com.example.techchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.techchallenge.dao.InterestCalculationDao;
import com.example.techchallenge.model.Interest;
@Controller
@SpringBootApplication
public class TechchallengeApplication {
	@Autowired
	private InterestCalculationDao interestCalcualtionDao;
	
	@RequestMapping("/")
	String home() {
		return "index";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)  
	public ModelAndView  save(@ModelAttribute Interest interest){
		Double result=interestCalcualtionDao.getResult(interest);
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.setViewName("result");      
		modelAndView.addObject("value", result);    
		return modelAndView;  

	}
	public static void main(String[] args) {
		SpringApplication.run(TechchallengeApplication.class, args);
	}

}
