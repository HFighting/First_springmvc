package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
	
	//在页面中传入的参数会注入到product中去
	@RequestMapping(value="/addProduct")
	public ModelAndView addProduct(Product pojo) throws Exception{
		
		ModelAndView mv = new ModelAndView("showProduct");
		return mv;
	}
}
