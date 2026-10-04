package com.salon.controller;

import com.salon.model.ServiceOffering;
import com.salon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServicesBySalonId(
            @PathVariable Long salonId,
            @RequestParam(required = false) Long categoryId) {
        Set<ServiceOffering> serviceOfferings=serviceOfferingService.getAllServiceBySalon(salonId, categoryId);
       return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServicesById(
            @PathVariable Long id) throws Exception {
        ServiceOffering serviceOffering=serviceOfferingService.getServiceById(id);
       return new ResponseEntity<>(serviceOffering, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Set<ServiceOffering>> getServicesByIds(
            @PathVariable Set<Long> ids) {
        Set<ServiceOffering> serviceOffering=serviceOfferingService.getServicesByIds(ids);
        return new ResponseEntity<>(serviceOffering, HttpStatus.OK);
    }

}
