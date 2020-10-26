package com.auth.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.domain.Member;
import com.auth.domain.MemberInformation;
import com.auth.repository.MemberRepository;


@Service 
public class AuthService implements UserDetailsService {

    
	@Autowired
	private MemberRepository userrepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Member user = userrepo.findByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("wrongId"); // 저장된 ID 없음
        }
        return makeLoginUser(user);
    }

    public MemberInformation makeLoginUser(Member user) {

    	MemberInformation loginUser  = new MemberInformation();

        List<GrantedAuthority> Authoritylist = new ArrayList<>();
        switch(user.getRole()) {
            case 0 :
                // admin
                Authoritylist.add(new SimpleGrantedAuthority("ADMIN"));
            case 1 :
                // user
                Authoritylist.add(new SimpleGrantedAuthority("USER"));
            break;
        }

        loginUser.setUsername(user.getName());
        loginUser.setPassword(user.getPassword());
        loginUser.setAuthorities(Authoritylist);
        
        return loginUser;
    }
}