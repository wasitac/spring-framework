package himedia.project.ver3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("생성이되긴한거지?");
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "/test";
	}
	
	
}
