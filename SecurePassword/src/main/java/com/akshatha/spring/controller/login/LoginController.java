package com.akshatha.spring.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akshatha.spring.constants.AppConstants;
import com.akshatha.spring.controller.SignUp.SignUPController;
import com.akshatha.spring.dto.Login.LogInDTO;
import com.akshatha.spring.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	public LoginController() {
		logger.info("Controller Created : \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public ModelAndView logIn(LogInDTO dto, HttpServletRequest req) {
		logger.info("invoked LoginControler \t" + dto);
		System.out.println("Comming.............................");
		System.out.println(dto);
		try {
			System.out.println("Inside try block....");
			boolean userPresent = loginService.logIn(dto);
			System.out.println(userPresent);
			if (userPresent) {
				HttpSession session = req.getSession(true);
				session.setAttribute("userName", dto.getUsername());
				return new ModelAndView(AppConstants.PAGE_SECUREPHRASE);
			} else {
				return new ModelAndView(AppConstants.PAGE_SIGN_UP);
			}
		} catch (Exception e) {
			logger.info("Exception found \t {} message is {}", e, e.getMessage());
		}
		return new ModelAndView(AppConstants.PAGE_SIGN_UP);
	}
}
