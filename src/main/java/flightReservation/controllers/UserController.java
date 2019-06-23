package flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import flightReservation.model.User;
import flightReservation.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("showRegistration")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@RequestMapping( value="registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute User user) {
		// dodati poređenje pass i confirm pass preko JS i preko UserRegistrationDTO
		userRepository.save(user);
		
		return "login/loginUser";
	}
	
	@RequestMapping(value="showLogin")
	public String showLogin() {
		return "login/loginUser";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password, ModelMap modelMap) {
		LOGGER.info("Inside login method "+username+" "+password);
		
		User user = userRepository.findByUsername(username);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("message", "Invalid username or password. Please try again");
		}
		
		return "login/loginUser";
	}
}
