package cn.cps.springbootexample.bdqn.entity.user.vo;

import cn.cps.springbootexample.bdqn.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author _Cps
 * @create 2019-02-14 10:12
 * @Description: 用户信息 VO实体类(后台到前端)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO extends User {

    private Long userId;

    private Long roleId;

    private String roleName;

    private String genderName;

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }
}
