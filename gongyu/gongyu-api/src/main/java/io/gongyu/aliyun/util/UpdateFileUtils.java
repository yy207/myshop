package io.gongyu.aliyun.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @create 2020-04-23 12:47
 */
public class UpdateFileUtils {

	public static String updateFile(MultipartFile file) throws Exception {
		// 获取阿里云存储相关常量
		String endPoint = "oss-cn-beijing.aliyuncs.com";
		String accessKeyId = "LTAI4G92bzv28RzQ7ho8pkxF";
		String accessKeySecret = "ltvDk5PZZ2maMLX1uA7lCLuSNnE2gy";
		String bucketName = "igugua";
		String fileHost = "gongyu/user-img";
		String uploadUrl = null;
		try {
			// 判断oss实例是否存在：如果不存在则创建，如果存在则获取
			OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
			if (!ossClient.doesBucketExist(bucketName)) {
				// 创建bucket
				ossClient.createBucket(bucketName);
				// 设置oss实例的访问权限：公共读
				ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
			}
			// 1,获取上传文件的名称
			String filename = file.getOriginalFilename();
			// 构建日期路径：avatar/2019/02/26/文件名
			String filePath = new DateTime().toString("yyyy-MM");

			// 获取上传文件流
			InputStream inputStream = file.getInputStream();
			// 文件名：uuid.扩展名
			String original = file.getOriginalFilename();
			String fileName = UUID.randomUUID().toString();
			// 获取上传文件的类型
			String fileType = original.substring(original.lastIndexOf("."));
			// 上传文件的新名字
			String newName = fileName + fileType;

			// 文件的路径
			String fileUrl = fileHost + "/" + filePath + "/" + newName;
			// 文件上传至阿里
			ossClient.putObject(bucketName, fileUrl, inputStream);
			// 关闭OSSClient。
			ossClient.shutdown();
			// 获取url地址
			uploadUrl = "http://" + bucketName + "." + endPoint + "/" + fileUrl;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploadUrl;
	}
}
