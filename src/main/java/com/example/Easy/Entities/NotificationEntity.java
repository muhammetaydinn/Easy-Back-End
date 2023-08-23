package com.example.Easy.Entities;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "Notifications")
public class NotificationEntity {
        @Id
        @UuidGenerator
        @JdbcTypeCode(SqlTypes.CHAR)
        @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
        private UUID notificationID;

        @NotNull
        @NotBlank
        private String userToken;

        @NotNull
        private String title;

        @Nullable
        private String image;


        @NotNull
        @NotBlank
        private String text;
}
