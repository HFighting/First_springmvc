package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	//页面跳转
	@RequestMapping(value="/jump")
	public ModelAndView jump(){
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}
	
	@RequestMapping(value="/check")
	public ModelAndView check(HttpSession session){
		//得到session的次数，如果在session中没有找到关键字，则返回null
		Integer i = (Integer) session.getAttribute("count");
		//首次访问时得到的会话次数是null
		if (i==null) {
			i=0;
		}
		i++;
		session.setAttribute("count", i);
		ModelAndView mv = new ModelAndView("check");
		return mv;
	}
	//清除session会话中的次数
	@RequestMapping(value="/clear")
	public ModelAndView clear(HttpSession session){
		session.setAttribute("count", -1);
		ModelAndView mv = new ModelAndView("redirect:/check");
		return mv;
	}
	
}