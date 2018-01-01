package com.hushangjie.dao;

import com.hushangjie.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zhouhs on 2016/12/30.
 */
public interface UserDao extends CrudRepository<User, Long> {

    public User findById(Long id);

}