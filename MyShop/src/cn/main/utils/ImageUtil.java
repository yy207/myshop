package cn.main.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 图片转换工具
 * @author sff
 *
 */
public class ImageUtil {
	
	/**
	 * 图片转化为字符
	 * @param path
	 * @return
	 */
	public static String ImageConvertToString(String  path){
		byte [] data= null;//字节数组
		try {
			//获取文件
			InputStream is = new FileInputStream(path);
			//将图片转化为长度的数组
			data = new byte[is.available()];
			//读入数组
			is.read(data);
			//close
			is.close(); 
		} catch (Exception e) {
			// TODO: handle exception
		} 
		BASE64Encoder encode = new BASE64Encoder();
		
		return encode.encode(data);
	} 
	/**
	 * 字符转化为图片
	 * @param imgStr
	 * @param imgFile
	 * @return
	 */
	public static boolean StringConvertToImage(String imgStr,String imgFile){
		if(imgStr==null)
			return false;
		//base64解码
		BASE64Decoder encode = new BASE64Decoder();
		try {
			//解码
			byte[]data = encode.decodeBuffer(imgStr);
			//调整异常数据
			for(int i=0;i<data.length;i++){
				if(data[i]<0)
					data[i]+=256;
			}
			//生成图片
			String imageFilePath = imgFile;
			OutputStream out = new FileOutputStream(imageFilePath);
			out.write(data);
			out.flush();
			out.close();
			return true; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}  
	}
	
	 
	public static void main(String[] args) throws IOException {
//		String path="G:\\Resources\\QQ图片\\QQ\\default.jpg";
//		
//		String imgStr = ImageConvertToString(path);
//		System.out.println(imgStr); 
//		StringConvertToImage(imgStr, "image.png");
		 
	}
}
