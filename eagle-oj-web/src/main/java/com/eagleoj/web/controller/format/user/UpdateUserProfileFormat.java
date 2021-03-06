package com.eagleoj.web.controller.format.user;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author Smith
 **/
public class UpdateUserProfileFormat {

    @NotNull
    @NotBlank
    @Length(max = 20)
    private String nickname;

    @Length(max = 50)
    private String motto;

    @NotNull
    @Range(min = 0, max = 2)
    private Integer gender;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
