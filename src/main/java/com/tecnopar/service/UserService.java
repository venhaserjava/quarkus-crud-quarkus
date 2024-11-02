package com.tecnopar.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.tecnopar.entity.UserEntity;
import com.tecnopar.exception.UserNotFoundException;
import com.tecnopar.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class UserService {
//    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity userEntity) {
//    Padrão Active Record
//    UserEntity.persist(userEntity);

//    Padrão Repository
       userRepository.persist(userEntity);

       return userEntity;
    }
    public List<UserEntity> findAll(Integer page, Integer pageSize){

//    Padrão Active Record
//        return UserEntity.findAll()
//                .page(page,pageSize)
//                .list();

//    Padrão Repository
        return userRepository.findAll()
            .page(page,pageSize)
            .list();
    }
    public UserEntity findById(Long id) {
//    Padrão Active Record
//        return (UserEntity) UserEntity.findByIdOptional(id)
//                .orElseThrow(UserNotFoundException::new);

//    Padrão Repository
        return  (UserEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }
    public UserEntity update(Long id, UserEntity userEntity){

        var user = findById(id);
//    Padrão Active Record
//        user.name = userEntity.name;
//        UserEntity.persist(user);

//    Padrão Repository
        user.setName(userEntity.getName());
        userRepository.persist(user);
        return user;

    }

    public void delete(Long id) {
//    Padrão Active Record
//        var user = findById(id);
//        UserEntity.deleteById(user.Id);

//    Padrão Repository
        userRepository.deleteById(id);
        if (findById(id).getId().equals(id)) {
            userRepository.deleteById(id);
            
        }
    }
}
