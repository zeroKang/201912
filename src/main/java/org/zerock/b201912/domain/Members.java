package org.zerock.b201912.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    private LocalDateTime regdate;
    
    private LocalDateTime updateDate;
    
}

