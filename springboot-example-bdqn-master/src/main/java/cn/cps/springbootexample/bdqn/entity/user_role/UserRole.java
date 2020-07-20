package cn.cps.springbootexample.bdqn.entity.user_role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Cai Peishen
 * @Date: 2020/7/2 10:21
 * @Description: 用户角色关系 PO持久实体类(跟数据库字段一一对应)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_role")
public class UserRole {

    //Mybatis-Plus主键类型
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long roleId;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
