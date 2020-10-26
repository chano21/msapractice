package com.auth.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="t_member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "member_no", unique = true, nullable = false)
    private int id;
    @Column(name = "member_nm", length = 20,nullable = false)
    private String name;
    @Column(name = "member_eamil", length = 20,nullable = false)
    private String email;
    @Column(name="member_pw",length = 100, nullable = false)
    private String password;
    @Column(name = "member_role", nullable = false)
    private int role;
    @Column(name = "member_regdate",nullable = false)
    private Date date;
    @Column(name = "delete_flag",nullable = false)
    private int delete;
    
}