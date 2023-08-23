package com.example.Easy.Services;

import com.example.Easy.Entities.DeviceEntity;
import com.example.Easy.Models.DeviceType;
import com.example.Easy.Repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeviceServiceTest {

    @Autowired
    DeviceRepository deviceRepository;

    @Test
    void  addNewDeviceTest(){
        String token = "eYsHNOnxQ3K83vJB5vCkwQ:APA91bFp2N_MRa3penVKoSfFSCQl1er3FSZtfhTFKP-NcRWrtMIxhumE9Dp5NE2MoU2A-7Z-8XG_6LQ4r4GgPe3Nl7Q-byJBe92xbLZ3m_BGEMZb2xC_BkyDA63D_yzdqnd7RPxfJbZc";
        System.out.println(token.length());
        DeviceEntity deviceEntity = DeviceEntity.builder()
                .timeZone("GMT+03:00")
                .deviceType(DeviceType.IOS)
                .deviceToken("eYsHNOnxQ3K83vJB5vCkwQ:APA91bFp2N_MRa3penVKoSfFSCQl1er3FSZtfhTFKP-NcRWrtMIxhumE9Dp5NE2MoU2A-7Z-8XG_6LQ4r4GgPe3Nl7Q-byJBe92xbLZ3m_BGEMZb2xC_BkyDA63D_yzdqnd7RPxfJbZc")
                .build();
        deviceRepository.save(deviceEntity);
    }
}