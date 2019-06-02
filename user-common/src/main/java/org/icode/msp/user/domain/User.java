package org.icode.msp.user.domain;

import lombok.Data;
import java.util.Date;

/**
 * Created by sheriff on 2018/11/20.
 */
@Data
public class User {
    private String account;
    private String password;
    private String nickname;
    private String headPortrait;
    private Integer sex;
    private String email;
    private String tel;
    private Date createTime;
    private Integer level;
    private Integer state;
    private Date lastLoginTime;
    private String remark;
    private Integer count;
}
