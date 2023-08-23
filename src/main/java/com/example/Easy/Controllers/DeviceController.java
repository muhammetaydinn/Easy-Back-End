package com.example.Easy.Controllers;

import com.example.Easy.Entities.DeviceEntity;
import com.example.Easy.Models.DeviceDTO;
import com.example.Easy.Services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;


    @PostMapping("/new")
    public ResponseEntity addNewDevice(@RequestBody DeviceDTO deviceDTO){
        deviceService.addNewDevice(deviceDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
