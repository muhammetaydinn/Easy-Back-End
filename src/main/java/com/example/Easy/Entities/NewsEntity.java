package com.example.Easy.Entities;

import com.example.Easy.Models.NewsCategories;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SerializableType;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column(name = "Categories",columnDefinition = "enum('SOFTWARE_ENGINEERING', 'MACHINE_LEARNING','DATA_SCIENCE','WEB_DEVELOPMENT')")
    @Enumerated(EnumType.STRING)
    private NewsCategories newsCategories;

    @NotNull
    @NotBlank
    @Column(name = "Title", length = 50)
    private String title;

    @NotNull
    @NotBlank
    @Column(length = 400)
    private String text;

    private String image;

    @NotNull
    @NotBlank
    @Column(updatable = false)
    private LocalDateTime creationTime;

    @NotNull
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "AuthorId")
    private UUID authorId;


}
