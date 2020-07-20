package cn.cps.springbootexample.bdqn.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author _Cps
 * @create 2019-02-14 10:12
 * @Description: 用户PO持久实体类(跟数据库字段一一对应)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    //Mybatis-Plus主键类型
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    private Integer gender;

    private Integer isDelete;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", isDelete=" + isDelete +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
