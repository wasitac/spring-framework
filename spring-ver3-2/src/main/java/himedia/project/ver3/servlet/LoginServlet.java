package himedia.project.ver3.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import lombok.extern.slf4j.Slf4j;

@WebServlet("/login")
@Slf4j
public class LoginServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		log.info("init() 실행됨");
	}
	
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException {
		log.info("service() 실행됨");
	}
}
