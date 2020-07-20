package cn.cps.springbootexample.bdqn.web;

import cn.cps.springbootexample.bdqn.annotation.Token;
import cn.cps.springbootexample.bdqn.core.R;
import cn.cps.springbootexample.bdqn.core.ResultCode;
import cn.cps.springbootexample.bdqn.entity.user.to.UserInfoTO;
import cn.cps.springbootexample.bdqn.utils.TokenUtils;
import cn.cps.springbootexample.bdqn.context.UserContext;
import cn.cps.springbootexample.bdqn.entity.user.to.UserLoginTO;
import cn.cps.springbootexample.bdqn.entity.user.vo.UserInfoVO;
import cn.cps.springbootexample.bdqn.service.UserService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 12:04
 * @Description: 用户接口Controller
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/getUserById")
    @ApiOperation(value="1.根据ID查询用户信息 - BaseMapper自带方法")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId", dataType = "Long", required = true, value = "用户ID"),
    })
    public Object getUserById(Long userId){
        log.info("/getUserById，参数为{}", userId);
        if(StringUtils.isEmpty(userId)){
            return R.genFailResult("请输入完整参数...");
        };
        UserInfoVO userInfoVO = userService.getUserById(userId);
        if(userInfoVO==null){
            return R.genFailResult("用户不存在...");
        }
        return R.genSuccessResult(userInfoVO);
    }


    /**
     * 当我们多个接口 共用一个对象当参数时，我们无法区分 各个接口对应的参数
     * 这时我们可以使用 @ApiImplicitParam 仅仅是为了在swagger文档中 提示那些参数是需要输入的
     * 在swagger的@ApiImplicitParam中输入数据 发送请求 后台并不处理；因为我们后台使用的对象接受 仍采用类型为对象的参数
     * @param userInfoTO
     * @return
     */
    @PostMapping("/getUserByIdPlus")
    @ApiOperation(value="2.根据ID查询用户信息 - BaseMapper自带方法 - getUserByIdPlus")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId", dataType = "Long", required = true, value = "用户ID"),
    })
    public Object getUserByIdPlus(@RequestBody UserInfoTO userInfoTO){
        log.info("/getUserById，参数为{}", userInfoTO.toString());
        if(StringUtils.isEmpty(userInfoTO) || StringUtils.isEmpty(userInfoTO.getId())){
            return R.genFailResult("请输入完整参数...");
        };
        UserInfoVO userInfoVO = userService.getUserById(userInfoTO.getId());
        if(userInfoVO==null){
            return R.genFailResult("用户不存在...");
        }
        return R.genSuccessResult(userInfoVO);
    }


    /**
     * 查询用户集合
     * 使用Mybatis-Plus分页 自定义SQL
     * @param userInfoTO
     * @return
     */
    @PostMapping("/getUserList")
    @ApiOperation(value="3.查询每个用户及角色 信息 - 自定义SQL查询并分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "current",  dataType = "Long",  required = true, value = "当前页"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "Long", required = true, value = "页容量"),
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = false, value = "用户名")
    })
    public Object getUserList(@RequestBody UserInfoTO userInfoTO){
        log.info("/getUserList，参数为{}", userInfoTO.toString());
        if(userInfoTO == null || userInfoTO.getCurrent() == null || userInfoTO.getPageSize() == null){
            return R.genFailResult("请输入完整参数...");
        };
        IPage<UserInfoVO> userInfoVOIPage = userService.getUserList(userInfoTO);
        return R.genSuccessResult(userInfoVOIPage);
    }



    /**
     * 用户登录同时返回Token
     * @param userLoginTO
     * @return
     */
    @PostMapping("/userLogin")
    @ApiOperation(value="4.用户登录同时返回Token - QueryWrapper定义查询条件")
    public Object userLogin(@RequestBody UserLoginTO userLoginTO,HttpServletRequest request) throws JsonProcessingException {
        log.info("/userLogin，参数为{}", userLoginTO.toString());

        if(userLoginTO==null || userLoginTO.getPassword() == null || userLoginTO.getUsername() == null || "".equals(userLoginTO.getPassword()) || "".equals(userLoginTO.getUsername()) ){
            return R.genFailResult("请输入完整参数...");
        }

        UserInfoVO userInfoVO = userService.userLogin(userLoginTO);

        if(userInfoVO==null){
            return R.genFailResult("用户名或密码错误...");
        }

        //对数据进行加密 当作Token
        String token = TokenUtils.getToken(userInfoVO.getUsername());

        log.info("token生成成功：{}",token);

        //jackson 处理成JSON格式 类似 FASTJSON
        ObjectMapper objectMapper = new ObjectMapper();
        String userInfoVOJson = objectMapper.writeValueAsString(userInfoVO);

        //Token 暂时存在session中 后面会存在redis中
        request.getSession().setAttribute(token,userInfoVOJson);

        return R.genSuccessResult(token);
    }


    /**
     * 验证Token并返回用户信息
     * 添加了Token注解，我们在自定义的拦截器中会进行一些Token的处理
     * @return
     */
    @Token
    @PostMapping("/checkToken")
    @ApiOperation(value="5.验证Token并返回用户信息")
    @ApiImplicitParam(paramType = "header", name = "token", dataType = "String", required = true, value = "Token值")
    public Object getUserByToken(){
        UserInfoVO userInfoVO = UserContext.getUserInfoVO();
        return R.genSuccessResult(userInfoVO);
    }



    /**
     * token校验失败跳转接口
     * @param request
     * @return
     */
    @PostMapping("/returnLogin")
    public Object returnLogin(HttpServletRequest request) {
        String token_error = (String) request.getAttribute("token_error");
        log.error("tokenIptor校验失败跳转接口.{}",token_error);
        return R.genResult(ResultCode.UNAUTHORIZED,token_error);
    }


}
