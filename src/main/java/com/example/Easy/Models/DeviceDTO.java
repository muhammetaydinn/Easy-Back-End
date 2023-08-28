package com.example.Easy.Models;

import com.google.firebase.database.annotations.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DeviceDTO {

    private UUID deviceID;
    private String timeZone;
    private DeviceType deviceType;
    private String deviceToken;

}
