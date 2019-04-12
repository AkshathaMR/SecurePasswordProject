package com.akshatha.spring.controller.securephrase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akshatha.spring.constants.AppConstants;
import com.akshatha.spring.controller.SignUp.SignUPController;
import com.akshatha.spring.dto.securephrase.SecurePhraseDTO;
import com.akshatha.spring.service.securephrase.SecurePhraseService;

@Controller
@RequestMapping("/")
public class SecurePhraseController {

	private final static Logger logger = LoggerFactory.getLogger(SecurePhraseController.class);
	
	@Autowired
	private SecurePhraseService securePhraseService;
	public SecurePhraseController() {
		logger.info("Created : \t"+this.getClass().getSimpleName());
	}
	
@RequestMapping(value="/securephrase", method=RequestMethod.POST)
	public ModelAndView saveSecurePhrase(SecurePhraseDTO dto , HttpServletRequest req , ModelMap model) {
		logger.info("Invoking savesecurephrase....\t");
		try {
		HttpSession httpSession =req.getSession(false);
		String userName =(String) httpSession.getAttribute("username");
		dto.setUsername(userName);
	HashMap<String ,String> map = securePhraseService.CheckingSecurePhrase(dto);
	if(map.containsKey("valid")) {
		return new ModelAndView(AppConstants.PAGE_WELCOME ,"user",userName);
	}
		}catch(Exception e) {
			
	logger.error("Exception found :\t"+e.getMessage());
		}
		return null;
}
}
