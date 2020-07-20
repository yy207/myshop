package cn.cps.springbootexample.bdqn.entity.user.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author _Cps
 * @create 2019-02-14 10:12
 * @Description: 用户信息 查询条件 TO实体类(前端到后台)
 */
@Data
@ApiModel("UserInfoTO 用户信息参数")
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoTO implements Serializable{

    @ApiModelProperty(value = "当前页", example = "1", position = 1)
    private Long current;

    @ApiModelProperty(value = "页容量", example = "3", position = 2)
    private Long pageSize;

    @ApiModelProperty(value = "用户ID", position = 3)
    private Long id;

    @ApiModelProperty(value = "用户名", position = 4)
    private String username;

    @Override
    public String toString() {
        return "UserInfoTO{" +
                "current=" + current +
                ", pageSize=" + pageSize +
                ", id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
