package cn.main.utils; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream; 
import java.util.Properties;   
/**
 * 工具类: 配置文件读取
 * @author sff
 *
 */
public class Property {
	private static Properties properties = null;//静态资源按照顺序从前往后依次进行初始化
	private static InputStream is=null; 
	static {
		init() ;
	} 
	public static void init() {
		properties = new Properties(); 
		try {
			 //1.加载配置文件
			 is=Property.class.getClassLoader().getResourceAsStream("params.properties");
			 //2.加载到资源文件 
			 properties.load(is);
			 //3.读取资源文件
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	public static String getPropertyValue(String key){
		String value=null;
		value = (String) properties.get(key);
		return value;
	}
}
