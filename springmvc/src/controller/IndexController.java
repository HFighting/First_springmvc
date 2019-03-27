package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	//ҳ����ת
	@RequestMapping(value="/jump")
	public ModelAndView jump(){
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}
	
	@RequestMapping(value="/check")
	public ModelAndView check(HttpSession session){
		//�õ�session�Ĵ����������session��û���ҵ��ؼ��֣��򷵻�null
		Integer i = (Integer) session.getAttribute("count");
		//�״η���ʱ�õ��ĻỰ������null
		if (i==null) {
			i=0;
		}
		i++;
		session.setAttribute("count", i);
		ModelAndView mv = new ModelAndView("check");
		return mv;
	}
	//���session�Ự�еĴ���
	@RequestMapping(value="/clear")
	public ModelAndView clear(HttpSession session){
		session.setAttribute("count", -1);
		ModelAndView mv = new ModelAndView("redirect:/check");
		return mv;
	}
	
}