package com.example.Easy.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SerializableType;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "News")
public class NewsEntity {
    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "newsId", length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID newsUUID;

    @NotNull
    @NotBlank
    @Column(name = "Title", length = 50)
    private String title;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String text;

    private String image;

    @NotNull
    @Column(updatable = false)
    private LocalDateTime creationTime;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Author")
    private UserEntity author;

    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

}
