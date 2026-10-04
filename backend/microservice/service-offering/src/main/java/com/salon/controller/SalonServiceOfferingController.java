package com.salon.controller;

import com.salon.dto.CategoryDTO;
import com.salon.dto.SalonDTO;
import com.salon.dto.ServiceDTO;
import com.salon.model.ServiceOffering;
import com.salon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO){
        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);
        CategoryDTO categoryDTO=new CategoryDTO();
//        categoryDTO.setId(1L);
        categoryDTO.setId(serviceDTO.getCategory());

        ServiceOffering serviceOffering=serviceOfferingService.createService(salonDTO,serviceDTO,categoryDTO);
        return ResponseEntity.ok(serviceOffering);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering
            ) throws Exception {
        SalonDTO salonDTO=new SalonDTO();
        salonDTO.setId(1L);
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(1L);

        ServiceOffering serviceOfferings=serviceOfferingService.updateService(id,serviceOffering);
        return ResponseEntity.ok(serviceOfferings);
    }


}
