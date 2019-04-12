package com.akshatha.spring.controller.SignUp;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akshatha.spring.constants.AppConstants;
import com.akshatha.spring.dto.SignUp.ChangePasswordDTO;
import com.akshatha.spring.entity.SignUp.SignUpEntity;
import com.akshatha.spring.service.ChangePasswordService;

@Controller
@RequestMapping("/")
public class ChangePasswordController {
	private final static Logger logger = LoggerFactory.getLogger(SignUPController.class);
	@Autowired
	private ChangePasswordService changePasswordService;

	public ChangePasswordController() {
		logger.info("ChangeController created : \t");
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam(value = "userName") String userName) {
		logger.info("invoking changePassword \t");
		System.out.println();
		try {
	  boolean userFromDb = changePasswordService.findUserbyUserName(userName);
	  if(userFromDb) {
		  logger.debug("UserExists");
		return new ModelAndView(AppConstants.PAGE_CHANGE_PASSWORD);
	  }
		}catch(Exception e) {
		logger.error("Exception occured : \t" +e.getMessage());	
	}
	return null;
	}
	@RequestMapping(value="/changePasswords",method=RequestMethod.POST)
	public ModelAndView confirmPassword(ChangePasswordDTO dto) {
		System.out.println("here r u cmg or not tel");
		logger.debug("invoked confirmPassword...\t");
		HashMap<String,String> mapPassword = new HashMap<String ,String>();
		try {
		mapPassword = changePasswordService.changePassword(dto);
		return new ModelAndView(AppConstants.CONFIRM_PASSWORD);
		}catch(Exception e) {
			logger.error("Exception found : \t" +e.getMessage());
		}
		return null;
		
	}
	
}
