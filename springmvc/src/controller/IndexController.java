package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
	//提供handleRequest来处理请求
	@RequestMapping(value="/index")//将相关的访问路径映射到该方法来处理
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 通过ModelAndView把模型和视图结合在一起
		 * 		视图是 index.jsp
		 * 		模型数据是message
		 * 		内容是Hello Spring MVC
		 */
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Hello Spring MVC");
		return mav;//最后返回了一个ModelAndView对象
	}
	
	
	
}