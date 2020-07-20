package cn.cps.springbootexample.bdqn.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Cai Peishen
 * @Date: 2020/7/1 19:51
 * @Description: 角色PO持久实体类(跟数据库字段一一对应)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class Role implements Serializable {

    //Mybatis-Plus主键类型
    @TableId(type = IdType.AUTO)
    private Long id;

    private String roleName;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
