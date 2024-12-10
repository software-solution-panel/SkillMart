package com.swlc.skillmart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rate implements Serializable {
    @TableGenerator(name="rtbl", initialValue= 40000)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="rtbl")
    private Integer rateId;
    private String username;
    private String contact;
    private String comment;
    @Column(nullable = false)
    private Integer stars;
    private Boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
