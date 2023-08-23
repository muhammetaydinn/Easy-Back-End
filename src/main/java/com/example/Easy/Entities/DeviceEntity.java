package com.example.Easy.Entities;

import com.example.Easy.Models.DeviceType;
import com.google.firebase.database.annotations.NotNull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Devices")
public class DeviceEntity {

    @Id
    @UuidGenerator
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID deviceId;

    private String timeZone;

    @Column(columnDefinition = "enum('IOS','ANDROID')")
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    private String deviceToken;

    @OneToOne
    private UserEntity user;
}
