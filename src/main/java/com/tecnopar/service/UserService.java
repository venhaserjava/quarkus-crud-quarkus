package com.tecnopar.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tecnopar.entity.UserEntity;
import com.tecnopar.exception.UserNotFoundException;
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
    public UserEntity findById(Long id) {
        return (UserEntity) UserEntity.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }
    public UserEntity update(Long id, UserEntity userEntity){
//        var  userData =  (UserEntity) UserEntity.findByIdOptional(id)
//                        .orElseThrow(UserNotFoundException::new);
//        UserEntity.persist(userData);
        var user = findById(id);
        user.name = userEntity.name;
//        user.setName(userEntity.getName());
        UserEntity.persist(user);
        return  user;

    }
}
