package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleController {
	@RequestMapping(value="/user/{userId}/roles/{roleId}",method= RequestMethod.POST)
	public String getMethod(@PathVariable("userId") String userId,@PathVariable("roleId") String roleId){
		System.out.println("userId:"+userId);
		System.out.println("roleId:"+roleId);
		return "hello";
	}
}
