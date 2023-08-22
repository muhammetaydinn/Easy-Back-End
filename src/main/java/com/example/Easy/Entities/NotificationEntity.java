package com.example.Easy.Entities;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Notification_Table")
public class NotificationEntity {
        @Id
        @UuidGenerator
        @JdbcTypeCode(SqlTypes.CHAR)
        @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
        private UUID uuid;

        @NotNull
        private String userToken;

        @NotNull
        @Column(length = 50)
        private String title;
        @NotNull
        private String body;
        @Nullable
        private String image;
        private String text;
}
