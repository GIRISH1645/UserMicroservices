package com.example.userservice.user.Vo;

import com.example.userservice.user.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private UserEntity user;
    private Department department;
}
