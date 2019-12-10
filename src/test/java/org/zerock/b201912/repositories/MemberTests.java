package org.zerock.b201912.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b201912.domain.MemberRoles;
import org.zerock.b201912.domain.Members;

import lombok.extern.slf4j.Slf4j;

/**
 * MemberTests
 */
@SpringBootTest
@Slf4j
public class MemberTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder pwencoder;
    
    @Test
    public void pwencoder() {

        assertNotNull(pwencoder);
        log.info("" + pwencoder);
    }

    @Test
    public void addMembers(){

        IntStream.range(1,11).forEach(i -> {
            Members member = Members.builder().mid("USER" + i).mpw("PW" +i).mname("사용자"+i).build();

            log.info("" +memberRepository.save(member));
        });
    }

    @Commit
    @Transactional
    @Test
    public void updatePw() {

        IntStream.range(1,11).forEach(i -> {
            String mid = "USER" + i;
            String enPw = pwencoder.encode("pw" + i);

            log.info("" +memberRepository.updatePassword(mid, enPw));

        });

    }

    @Commit
    @Transactional
    @Test
    public void setRoles() {

        IntStream.range(1, 10).forEach(i -> {

            Members member = memberRepository.getOne("USER" + i);

            MemberRoles role = new MemberRoles();
            role.setAuth("ROLE_USER");

            member.addRole(role);

            memberRepository.save(member);


        });

    }

    @Test
    public void readMember() {

        Members member = memberRepository.findById("USER5").get();

        log.info("" + member);

    }
}