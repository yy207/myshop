package io.gongyu.modules.qny;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.gongyu.common.utils.R;
@RestController
@RequestMapping("qny/test")
public class QnyTest {

	/**
	 * 上传到七牛云上
	 * 
	 */
	@PostMapping("/uploading")
	public R testBase64(@RequestParam MultipartFile file) throws Exception {
		String imageName = UUID.randomUUID().toString();
		String url = QiNiu.updateFile(file, imageName);
		String url2 = "http://"+url;
		return R.ok().put("url", url2);
	}
	
	/**
	 * 将七牛云上面的文件删除
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/delete")
	public R delete(@RequestParam MultipartFile file) throws Exception {
		String result = QiNiu.delete("c7d5d711-8bef-4f5e-b5ff-7b4dcf3136f1");
		return R.ok().put("message", result);
	}
}
