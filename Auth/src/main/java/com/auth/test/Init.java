package com.auth.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.auth.domain.Member;
import com.auth.repository.MemberRepository;

@Component
public class Init implements ApplicationRunner {

	@Autowired
    private MemberRepository UserDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//    	    private int id;
//    	    private String name;
//    	    private String email;
//    	    private String password;
//    	    private int role;
//    	    private Date date;
//    	    private String delete;
//    	 
        Member newUser = new Member();        
        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        newUser.setName("chano");
        newUser.setEmail("chano22@naver.com");
        newUser.setPassword(passwordEncoder.encode("1234"));
        newUser.setRole(0);
        newUser.setDate(new Date()); 
        newUser.setDelete(0);
        UserDao.save(newUser);
    }
}