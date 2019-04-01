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
		
		//获取上传文件名
		String imagename = imageFile.toString();
		//得到文件的后缀名
		String exeString = FilenameUtils.getExtension(imagename);
		//通过后缀名随机出一个文件名
		String filename = UUID.randomUUID().toString()+"."+exeString;
		//建立存储上传文件的文件夹
		String saveFile = request.getServletContext().getRealPath("/image");
		File files = new File(saveFile);
		if (!files.exists()) {//如果文件不存在，就创建一个
			files.mkdirs();
		}
		//以filename为名字在image文件夹下创立一个文件
		File file = new File(saveFile, filename);
		//存储文件信息
		imageFile.getImage().transferTo(file);
		
		ModelAndView mv = new ModelAndView("showUploadFile");
		mv.addObject("imageName", filename);//把文件信息传到视图里
		return mv;
	}
	
	public ModelAndView download(HttpServletRequest request,uploadImageFile imageFile){
		
		ModelAndView mv = new ModelAndView("showUploadFile");
		return mv;
	}
	
}
