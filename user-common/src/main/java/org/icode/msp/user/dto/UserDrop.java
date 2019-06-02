package org.icode.msp.user.dto;

import lombok.Data;

/**
 *  用户下拉框所需数据
 */
@Data
public class UserDrop {
    private String account;
    private String nickname;
    private String remark;
}
