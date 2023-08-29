package com.example.Easy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.firebase.database.annotations.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Users")
public class UserEntity {

    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID userId;

    @NotNull
    @NotBlank
    private String name;

    private String image;

    @NotNull
    @NotBlank
    private String userToken;

    @JsonIgnore
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<NewsEntity> news;

    @JsonIgnore
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

    private Integer role;
}
