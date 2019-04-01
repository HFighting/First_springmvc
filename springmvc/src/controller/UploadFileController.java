package controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.uploadImageFile;

@Controller
public class UploadFileController {
	@RequestMapping(value="/uploadfile")
	public ModelAndView upload(HttpServletRequest request,uploadImageFile imageFile) throws Exception, IOException{
		
		//��ȡ�ϴ��ļ���
		String imagename = imageFile.toString();
		//�õ��ļ��ĺ�׺��
		String exeString = FilenameUtils.getExtension(imagename);
		//ͨ����׺�������һ���ļ���
		String filename = UUID.randomUUID().toString()+"."+exeString;
		//�����洢�ϴ��ļ����ļ���
		String saveFile = request.getServletContext().getRealPath("/image");
		File files = new File(saveFile);
		if (!files.exists()) {//����ļ������ڣ��ʹ���һ��
			files.mkdirs();
		}
		//��filenameΪ������image�ļ����´���һ���ļ�
		File file = new File(saveFile, filename);
		//�洢�ļ���Ϣ
		imageFile.getImage().transferTo(file);
		
		ModelAndView mv = new ModelAndView("showUploadFile");
		mv.addObject("imageName", filename);//���ļ���Ϣ������ͼ��
		return mv;
	}
	
	public ModelAndView download(HttpServletRequest request,uploadImageFile imageFile){
		
		ModelAndView mv = new ModelAndView("showUploadFile");
		return mv;
	}
	
}
