package org.zerock.b201912.domain;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Members
 */
@Entity
@Table(name = "tbl_members")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Members {

    @Id
    private String mid;
    
    private String mpw;
    
    private String mname;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="tbl_member_roles")
    private Collection<MemberRoles> memberRoles;


    @CreationTimestamp
    private LocalDateTime regdate;
    
    @UpdateTimestamp
    private LocalDateTime updateDate;

    public void addRole(MemberRoles roles){
        if(roles == null){
            this.memberRoles = new HashSet<>();
        }
        this.memberRoles.add(roles);
    }
    
}

