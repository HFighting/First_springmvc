package pojo;

import org.springframework.web.multipart.MultipartFile;

public class uploadImageFile {
	MultipartFile image;//用来接受上传文件的信息
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String toString(){
		//得到上传文件的完整文件名
		return image.getOriginalFilename();
	}
}
