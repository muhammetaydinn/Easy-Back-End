package com.example.Easy.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Records")
public class RecordsEntity {
    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "recordId", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID recordId;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private NewsCategoryEntity newsCategory;

    @ManyToOne
    private NewsEntity news;

    private int repeat=1;
}
