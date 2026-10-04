package com.salon.service.impl;

import com.salon.dto.CategoryDTO;
import com.salon.dto.SalonDTO;
import com.salon.dto.ServiceDTO;
import com.salon.model.ServiceOffering;
import com.salon.repository.ServiceOfferingRepository;
import com.salon.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    @Override
    public ServiceOffering createService(SalonDTO salonDTO,
                                         ServiceDTO serviceDTO,
                                         CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = ServiceOffering.builder()
                .image(serviceDTO.getImage())
                .salonId(salonDTO.getId())
                .name(serviceDTO.getName())
                .description(serviceDTO.getDescription())
                .categoryId(serviceDTO.getCategory())
                .price(serviceDTO.getPrice())
                .duration(serviceDTO.getDuration())
                .build();
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        ServiceOffering serviceOffering1 = serviceOfferingRepository.findById(serviceId).orElse(null);

        if (serviceOffering1 == null) {
            throw new Exception("service not exist with id " + serviceId);
        }
        ServiceOffering serviceOffering = ServiceOffering.builder()
                .image(service.getImage())
                .name(service.getName())
                .description(service.getDescription())
                .price(service.getPrice())
                .duration(service.getDuration())
                .build();
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalon(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = serviceOfferingRepository.findBySalonId(salonId);

        if (categoryId != null) {
            services = services.stream().filter((service) -> service.getCategoryId() != null &&
                    service.getCategoryId().equals(categoryId)).collect(Collectors.toSet());
        }
        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services= serviceOfferingRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering serviceOffering=serviceOfferingRepository.findById(id).orElse(null);
        if(serviceOffering==null){
            throw new Exception("service not exist with id "+id);
        }
        return serviceOffering;
    }
}
