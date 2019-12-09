package org.zerock.b201912.domain;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * MemberRoles
 */
@Embeddable
@Data
public class MemberRoles {

    private String auth;
    
}