package io.gongyu.aliyun.code;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import io.gongyu.aliyun.util.SmsUtils;
import io.gongyu.common.RedisUtil;
import io.gongyu.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 验证码
 *
 */
@RestController
@RequestMapping("/YanzhengCode")
@Api(tags="验证码接口")
public class YanzhengCode {

	@Autowired
	private RedisUtil redisUtil;
	
	@GetMapping("/downCode")
    @ApiOperation(value="下发验证码")
    public R downCode(String mobileCode) throws ClientException{
		//生成验证码
		SmsUtils.setNewcode();
		//获取验证码
		String code = Integer.toString(SmsUtils.getNewcode());
		//将验证码下发到手机上
		SendSmsResponse sendSms = SmsUtils.sendSms(mobileCode,code);
		//将验证码放进redis缓存中
		redisUtil.securityCode(mobileCode, code, 65, TimeUnit.SECONDS);
		 System.out.println("验证码="+code);
		 System.out.println("短信接口返回的数据----------------");
         System.out.println("Code=" + sendSms.getCode());
         System.out.println("Message=" + sendSms.getMessage());
         System.out.println("RequestId=" + sendSms.getRequestId());
         System.out.println("BizId=" + sendSms.getBizId());
		return R.ok().put("msg", sendSms);
    }
}
