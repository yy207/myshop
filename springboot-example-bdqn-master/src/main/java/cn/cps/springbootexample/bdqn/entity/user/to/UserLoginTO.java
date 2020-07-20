package cn.cps.springbootexample.bdqn.entity.user.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Cai Peishen
 * @Date: 2020/7/2 12:58
 * @Description: 用户登录 条件 TO实体类(前端到后台)
 */
@Data
@ApiModel("UserLoginTO 用户登录参数")
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginTO implements Serializable {

    @ApiModelProperty(value = "用户姓名", position = 1)
    private String username;

    @ApiModelProperty(value = "用户密码", position = 2)
    private String password;

    @Override
    public String toString() {
        return "UserLoginTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
