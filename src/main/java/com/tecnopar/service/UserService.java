package com.tecnopar.service;

import com.tecnopar.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserEntity create(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }
    public List<UserEntity> findAll(Integer page, Integer pageSize){
        return UserEntity.findAll()
                .page(page,pageSize)
                .list();
    }
}
