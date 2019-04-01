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
	 * �ô��������ز��ڹ���ʱ��֮�ڵ�����ҳ�棬����ת���̶�ҳ�棬�����Ǽ�Ϊ8:00~20:00
	 * ����ʱ�������ʱ�����תҳ����springmvc-servlet.xml�����ļ��г�ʼ��
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
	 * �ڷ�����ͼ֮�����
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("�����afterCompletion()�������ڷ�����ͼ֮�����");
	}
	/*
	 * ����controller���ڷ���ModelAndView֮ǰִ��
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("�����postHandle()�������ڷ�����controller֮�󣬷�����ͼ֮ǰ���ã�ע��һ������");
	}
	/* 
	 * �ڴ�������֮ǰ��ִ�ж�Ӧ�Ĳ�����
	 * �������true����ִ����һ����������֪�����е���������ִ�У���ִ�ж�Ӧ��controller��
	 * Ȼ��������������������һ����������postHandle��ʼִ�У��ٴ����һ��afterCompletion��ʼִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("������preHandle()�����ĵ��ã��ڷ���controller֮ǰ������");
		//��ȡ��ǰʱ��
		Calendar thistime = Calendar.getInstance();
		//��ȡ��ǰСʱ,��12СʱΪ����
		int hour = thistime.get(Calendar.HOUR)+12;
		System.out.println("��ǰСʱ��"+hour);
		//�жϵ�ǰʱ���Ƿ��ڹ���ʱ����
		if (hour>=openTime&&hour<closeTime) {
			return true;//ִ�д�����Ӧ����ķ���
		}else {
			arg1.sendRedirect(outredirectorPage);
			return false;//����������
		}
	}

}
