package org.zerock.b201912.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b201912.repositories.MemberRepository;
import org.zerock.b201912.security.dto.CustomMembers;

import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService
 */
@Component
@Slf4j
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        log.info("loadUserByUsername......." + username);

        return new CustomMembers(memberRepository.getOne(username));
    }

}