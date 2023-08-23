package com.example.Easy.Mappers;

import com.example.Easy.Entities.NotificationEntity;
import com.example.Easy.Models.NotificationDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationMapper {
    NotificationDTO toNotificationDTO(NotificationEntity notificationEntity);
    NotificationEntity toNotificationEntity(NotificationDTO notificationDTO);
}
