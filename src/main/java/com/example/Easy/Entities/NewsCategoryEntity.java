package com.example.Easy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "News Categories")
public class NewsCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private NewsCategoryEntity parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<NewsCategoryEntity> children;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<NewsEntity> news;

    @OneToMany(mappedBy = "newsCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RecordsEntity> categoryRecord;

}
