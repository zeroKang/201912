package org.zerock.b201912.security.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.b201912.domain.Members;

import lombok.Data;

/**
 * CustomMembers
 */

public class CustomMembers extends User {

    private Members member;


    public CustomMembers(Members member){
        super(member.getMid(), member.getMpw(), member.getMemberRoles().stream().map(role -> new SimpleGrantedAuthority(role.getAuth())).collect(Collectors.toList()));
        this.member = member;
    }

    public CustomMembers(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public Members getMember() {
        return this.member;
    }



    
}