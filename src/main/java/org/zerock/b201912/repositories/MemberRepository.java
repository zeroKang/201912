package org.zerock.b201912.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b201912.domain.Members;

/**
 * MemberRepository
 */
public interface MemberRepository extends JpaRepository<Members, String>{

    
}