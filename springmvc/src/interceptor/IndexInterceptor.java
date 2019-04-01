package interceptor;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.generic.NEW;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.html.HTMLAnchorElement;

public class IndexInterceptor implements HandlerInterceptor {
	
	/*
	 * 该处理器拦截不在工作时间之内的所有页面，并跳转到固定页面，工作是间为8:00~20:00
	 * 工作时间与截至时间和跳转页面在springmvc-servlet.xml配置文件中初始化
	 */
	private int openTime;
	private int closeTime;
	private String outredirectorPage;
	
	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}
	public void setCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}
	public void setOutredirectorPage(String outredirectorPage) {
		this.outredirectorPage = outredirectorPage;
	}
	/*
	 * 在访问视图之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("最后是afterCompletion()方法，在返回视图之后调用");
	}
	/*
	 * 进入controller，在返回ModelAndView之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("其次是postHandle()方法，在访问完controller之后，返回视图之前调用，注入一个日期");
	}
	/* 
	 * 在处理请求之前，执行对应的操作，
	 * 如果返回true，则执行下一个拦截器，知道所有的拦截器被执行，再执行对应的controller，
	 * 然后进入拦截器链，从最后一个拦截器的postHandle开始执行，再从最后一个afterCompletion开始执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("首先是preHandle()方法的调用：在访问controller之前被调用");
		//获取当前时间
		Calendar thistime = Calendar.getInstance();
		//获取当前小时,以12小时为周期
		int hour = thistime.get(Calendar.HOUR)+12;
		System.out.println("当前小时："+hour);
		//判断当前时间是否在工作时间内
		if (hour>=openTime&&hour<closeTime) {
			return true;//执行处理相应请求的方法
		}else {
			arg1.sendRedirect(outredirectorPage);
			return false;//不处理请求
		}
	}

}
