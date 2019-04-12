package com.akshatha.spring.controller.SignUp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akshatha.spring.constants.AppConstants;
import com.akshatha.spring.dto.SignUp.SignUpDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.service.SignUpService;

@Controller
@RequestMapping("/")
public class SignUPController {

	@Autowired
	private SignUpService signUpService;

	private final static Logger logger = LoggerFactory.getLogger(SignUPController.class);

	public SignUPController() {
	logger.info("Created : \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/signUpFrom", method = RequestMethod.POST)
	public ModelAndView userSignUp(SignUpDTO signUpdto, ModelMap model) {
		logger.info("invoked saveSignUp method");
	
		SignUpEntity datafromsignUp = signUpService.signUpService(signUpdto);
		logger.info("data from database\t"+datafromsignUp);
		return  new ModelAndView(AppConstants.PAGE_SIGN_UP , "msg","Invalid credentials");

	}

}
