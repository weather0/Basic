package com.yd.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yd.mvc.dep.DepMapper;
import com.yd.mvc.dep.DepVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@Autowired
	DepMapper mapper;

	@RequestMapping("/dep")
	public String dep(DepVO vo, Model model) {
		logger.info("파라미터: " + vo.toString());
		model.addAttribute("dep", mapper.getDep(vo));
		return "dep";
	}
	
	@RequestMapping("/depList")
	public String depList(Model model) {
		model.addAttribute("deps", mapper.getDepList());
		return "depList";
	}
	
	
}
