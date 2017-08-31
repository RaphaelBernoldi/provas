package br.com.intelipost.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.intelipost.model.ResponseModel;
import br.com.intelipost.model.UserModel;
import br.com.intelipost.service.UserService;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index(){
		logger.info("/");
		ResponseModel response = new ResponseModel();
		ModelAndView view = new ModelAndView(response.getPage());
		return view;
	}
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(UserModel user){
		logger.info("/login");
		ResponseModel response = userService.login(user);
		ModelAndView view = new ModelAndView(response.getPage());
		view.addObject("message", response.getMessage());
		return view;
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(){
		logger.info("/logout");
		ResponseModel responseModel = new ResponseModel();
		ModelAndView view = new ModelAndView(responseModel.getPage());
		return view;
	}

}
