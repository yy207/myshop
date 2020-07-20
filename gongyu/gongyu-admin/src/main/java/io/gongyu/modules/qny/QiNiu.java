package io.gongyu.modules.qny;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author 作者 Name: Mr.Wang
 * @version 创建时间：2020年1月3日 下午2:42:15
 * 
 */
public class QiNiu {

	private final static Logger logger = LoggerFactory.getLogger(QiNiu.class);

	public static final String ACCESSKEY = "QgOmhhcd2OOmOWkQ7QX_6rLx50J0m4wVGqMjEjm2";// accessKey
	public static final String SECRETKEY = "I03P-J9J-Jql2m9jv1RpkY2cNIOuPZu9Fet1zowl";// secretKey
	public static final String BUCKETNAME = "fcw";// 存储空间域名
	public static final String DOMAIN = "qiniu.fangdong365.cn";// 域名
	// 密钥配置
	private static Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
	private static Configuration cfg = new Configuration(Zone.huanan());
	// 创建上传对象
	private static UploadManager uploadManager = new UploadManager(cfg);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public static String getUpToken() {
		return auth.uploadToken(BUCKETNAME);
	}

	/**
	 * updateFile(MultipartFile file, String filename)，这个方法就是根据Spring
	 * MVC式的MultipartFile类型的图片进行上传的， 第二个参数就是保存在七牛云空间的图片名称。
	 * 
	 * @param file
	 * @param filename
	 * @return
	 * @return
	 * @throws Exception
	 */
	public static String updateFile(MultipartFile file, String filename) throws Exception {
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		try {
			InputStream inputStream = file.getInputStream();
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[600]; // buff用于存放循环读取的临时数据
			int rc = 0;
			while ((rc = inputStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}

			byte[] uploadBytes = swapStream.toByteArray();
			try {
				Response response = uploadManager.put(uploadBytes, filename, getUpToken());
				// 解析上传成功的结果
				DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
				return DOMAIN + "/" + putRet.key;

			} catch (QiniuException ex) {
				Response r = ex.response;
				System.err.println(r.toString());
				try {
					System.err.println(r.bodyString());
				} catch (QiniuException ex2) {
				}
			}
		} catch (UnsupportedEncodingException ex) {
		}
		return null;
	}

	/**
	 * 七牛上将文件删除
	 * 
	 * @param fileName
	 * @date 2016年11月22日下午1:29:13
	 */
	public static String delete(String fileName) {

		Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
		Zone z = Zone.zone0();
		Configuration c = new Configuration(z);
		// 实例化一个BucketManager对象
		BucketManager bucketManager = new BucketManager(auth, c);
		// 要测试的空间和key，并且这个key在你空间中存在
		String bucket = BUCKETNAME;
		String key = fileName;
		try {
			// 调用delete方法移动文件
			bucketManager.delete(bucket, key);
			logger.info("文件删除成功!.[fileName={}]", fileName);
			return "成功";
		} catch (QiniuException e) {
			logger.error("文件删除失败!.[fileName={}]", fileName);
			// 捕获异常信息
			Response r = e.response;
			logger.error(r.toString());
			return "失败";
		}
	}
}
