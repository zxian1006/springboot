package com.zx.dao;

import com.zx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zxian on 2017/4/17.
 */
public interface UserRepository extends JpaRepository<User,String>{

    /**
        用uname查询用户
     */
    @Query("select u from User u where u.uname= :uname")
    User findByName(@Param("uname") String uname);

    /**
     * 修改密码
     * @param uname
     * @param pwd
     */
    @Query("update User u set u.pwd= :pwd where u.uname= :uname")
    @Modifying
    @Transactional
    void updatePwd(@Param("uname") String uname,@Param("pwd") String pwd);

}
