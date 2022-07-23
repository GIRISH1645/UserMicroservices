package com.example.userservice.user.Service;

import com.example.userservice.user.Entity.UserEntity;
import com.example.userservice.user.Repository.UserRepository;
import com.example.userservice.user.Vo.Department;
import com.example.userservice.user.Vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartmentId(Long userId) {
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        UserEntity user = userRepository.findByUserId(userId);
        log.debug("EnteringMicroservices");
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +user.getDepartmentId(),Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;

    }


}
