package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
	//�ṩhandleRequest����������
	@RequestMapping(value="/index")//����صķ���·��ӳ�䵽�÷���������
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * ͨ��ModelAndView��ģ�ͺ���ͼ�����һ��
		 * 		��ͼ�� index.jsp
		 * 		ģ��������message
		 * 		������Hello Spring MVC
		 */
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Hello Spring MVC");
		return mav;//��󷵻���һ��ModelAndView����
	}
	
	
	
}