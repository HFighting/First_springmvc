package pojo;

import org.springframework.web.multipart.MultipartFile;

public class uploadImageFile {
	MultipartFile image;//���������ϴ��ļ�����Ϣ
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String toString(){
		//�õ��ϴ��ļ��������ļ���
		return image.getOriginalFilename();
	}
}
