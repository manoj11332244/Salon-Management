package com.salon.controller;


import com.salon.mapper.SalonMapper;
import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salon")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.createSalon(salonDTO,userDTO);
        SalonDTO salonDTO1= SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(@RequestBody SalonDTO salonDTO,@PathVariable("id") Long salonId) throws Exception {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1= SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SalonDTO> getSalon(@RequestBody SalonDTO salonDTO,@PathVariable("id") Long salonId) throws Exception {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1L);
        Salon salon=salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1= SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
    }
}
