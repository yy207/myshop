package io.gongyu.aliyun.oss;

import io.gongyu.aliyun.util.UpdateFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.gongyu.common.utils.R;

/**
 * @create 2020-04-23 14:43
 */

@RestController
@RequestMapping("/oss")
@Api(tags = "文件上传接口")
public class FileUpload {

	@PostMapping("upload")
	@ApiOperation(value = "上传图片")
	public R uploadTeacherImg11(@RequestParam("file") MultipartFile file) throws Exception {

		String uploadUrl = UpdateFileUtils.updateFile(file);

		return R.ok().put("imgUrl", uploadUrl);
	}

}
