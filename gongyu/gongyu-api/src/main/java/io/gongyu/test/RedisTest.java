package io.gongyu.test;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gongyu.common.RedisUtil;
import io.gongyu.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
@Api(tags="redis测试接口")
public class RedisTest {

	@Autowired
	private RedisUtil redisUtil;
	
	@GetMapping("/set")
    @ApiOperation(value="redis")
    public R set(){
		redisUtil.set("admin", "00000");
		redisUtil.securityCode("qq", "123456", 30, TimeUnit.SECONDS);
		String string = redisUtil.get("qq");
		System.out.println("---->"+string);
        return R.ok();
    }
	@GetMapping("/setTwo")
	@ApiOperation(value="redis")
	public R setTwo(String mobile){
		redisUtil.jedisSetTime(mobile);
		return R.ok();
	}
	@GetMapping("/get")
    @ApiOperation(value="redis")
    public R get(String mobile){
		redisUtil.jedisGetTime(mobile);
        return R.ok();
    }
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.select(1);
		jedis.set("asdsad","adadsada");
		jedis.expire("asdsad",20);
	}
}
