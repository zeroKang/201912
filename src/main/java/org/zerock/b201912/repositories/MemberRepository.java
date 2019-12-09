package org.zerock.b201912.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.b201912.domain.Members;

/**
 * MemberRepository
 */
public interface MemberRepository extends JpaRepository<Members, String>{

    @Modifying
    @Query("update from Members m set m.mpw =:pw where m.mid = :mid")
    public int updatePassword(String mid, String pw);
}