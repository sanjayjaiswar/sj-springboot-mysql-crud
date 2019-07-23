package com.sj.backend.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Sanjay Jaiswar
 *
 * Date: 7/23/19
 */
@javax.persistence.Entity
@Table(name = "tbl_entity_name")
@Data
public class Entity {
    private static final long serialVersionUID = 4130553732167567339L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId = 0;

    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "entity_name")
    private String entityName = "";

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "modified_at")
    private Date modifiedAt;
}