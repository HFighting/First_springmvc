package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
	
	//��ҳ���д���Ĳ�����ע�뵽product��ȥ
	@RequestMapping(value="/addProduct")
	public ModelAndView addProduct(Product pojo) throws Exception{
		
		ModelAndView mv = new ModelAndView("showProduct");
		return mv;
	}
}
