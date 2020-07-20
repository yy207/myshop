package cn.cps.springbootexample.bdqn.web;

import cn.cps.springbootexample.bdqn.core.R;
import cn.cps.springbootexample.bdqn.core.Result;
import cn.cps.springbootexample.bdqn.utils.FileUtils;
import cn.cps.springbootexample.bdqn.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 文件管理
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件管理")
public class FileController {

	@Value("${web.upload-path}")
	private String upLoadPath;


	/**
	 * 上传图片
	 * @param request
	 */
	@PostMapping(value = "/uploadImg")
	public Result upload(HttpServletRequest request) {
		//上传并返回结果
		return FileUtils.upLoadFile(upLoadPath,request);
	}

	/**
	 * 文件下载
	 * @param fileName
	 */
	@GetMapping("/downLoadFile")
	@ApiOperation(value = "文件下载", httpMethod = "GET", protocols = "HTTP", notes = "文件下载")
	public Result downLoadFile(String fileName, HttpServletRequest request, HttpServletResponse response) {
		//下载并返回结果
		return FileUtils.downLoadFile(fileName,upLoadPath,request,response);
	}

	/**
	 * 删除服务器文件
	 * @param fileName
	 * @return
	 */
	@PostMapping("/revomeFile")
	@ApiOperation(value = "删除服务器文件", httpMethod = "POST", protocols = "HTTP", notes = "删除服务器文件")
	public Result revomeFile(String fileName, HttpServletRequest request){
		return R.genSuccessResult(FileUtils.removeFile(fileName,upLoadPath,request));
	}

	/**
	 * 生成图片验证码
	 */
	@GetMapping(value = "/verifyCode")
	@ApiOperation(value = "生成图片验证码", httpMethod = "GET", protocols = "HTTP", notes = "生成图片验证码")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int width = 120;//宽
		int height = 40;//高
		int verifySize = 4;//验证码个数

		//生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(verifySize);
		System.err.println("验证码:"+verifyCode);
		//存入会话session
		request.getSession().setAttribute(VerifyCodeUtils.VERIFY_CODE, verifyCode);
		//生成图片
		VerifyCodeUtils.outputImage(width, height, response.getOutputStream(), verifyCode);
	}

	/**
	 * 生成图片转Base64验证码
	 */
	@GetMapping(value = "/verifyCodeBase64")
	@ApiOperation(value = "生成图片转Base64验证码", httpMethod = "POST", protocols = "HTTP", notes = "生成图片转Base64验证码", produces = "application/txt")
	public String  verifyCodeBase64(HttpServletRequest request) throws IOException {
		int width = 120;//宽
		int height = 40;//高
		int verifySize = 4;//验证码个数

		//生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(verifySize);
		//存入会话session
		request.getSession().setAttribute(VerifyCodeUtils.VERIFY_CODE, verifyCode);
		//生成图片
		String imgBase64 = VerifyCodeUtils.outputImageBase64(width, height, verifyCode);

		return imgBase64;
	}

}
