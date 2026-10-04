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

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    //    http://localhost:5002/api/salons
    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDTO, userDTO);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
    }

    //    http://localhost:5002/api/salons/2
    @PatchMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(@RequestBody SalonDTO salonDTO, @PathVariable("id") Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDTO, userDTO, salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
        return new ResponseEntity<>(salonDTO1, HttpStatus.OK);
    }

    //    http://localhost:5002/api/salons
    @GetMapping
    public ResponseEntity<List<SalonDTO>> getSalon() throws Exception {
        List<Salon> salon = salonService.getAllSalons();
        List<SalonDTO> salonDTOS = salon.stream().map((salons) -> {
            SalonDTO salonDTO = SalonMapper.mapToDTO(salons);
            return salonDTO;
        }).toList();
        return new ResponseEntity<>(salonDTOS, HttpStatus.OK);
    }

    //    http://localhost:5002/api/salons/5
    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long salonId) throws Exception {

        Salon salon=salonService.getSalonById(salonId);
        SalonDTO salonDTO=SalonMapper.mapToDTO(salon);

        return new ResponseEntity<>(salonDTO, HttpStatus.OK);
    }

    //    http://localhost:5002/api/salons/search?city=mumbai
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(@RequestParam("city") String city) throws Exception {
        List<Salon> salon = salonService.searchSalonByCity(city);
        List<SalonDTO> salonDTOS = salon.stream().map((salons) -> {
            SalonDTO salonDTO = SalonMapper.mapToDTO(salons);
            return salonDTO;
        }).toList();
        return new ResponseEntity<>(salonDTOS, HttpStatus.OK);
    }

    //    http://localhost:5002/api/salons/5
    @GetMapping("/owner")
    public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);

        Salon salon=salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO=SalonMapper.mapToDTO(salon);

        return new ResponseEntity<>(salonDTO, HttpStatus.OK);
    }
}
