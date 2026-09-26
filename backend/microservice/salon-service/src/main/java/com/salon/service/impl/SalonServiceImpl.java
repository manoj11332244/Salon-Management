package com.salon.service.impl;

import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.repository.SalonRepository;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;



    @Override
    public Salon createSalon(SalonDTO req, UserDTO user) {
        Salon salon=new Salon();
        salon.setName(req.getName());
        salon.setEmail(req.getEmail());
        salon.setAddress(req.getAddress());
        salon.setCity(req.getCity());
        salon.setImages(salon.getImages());
        salon.setOwnerId(user.getId());
        salon.setOpenTime(req.getOpenTime());
        salon.setCloseTime(req.getCloseTime());
        salon.setPhoneNumber(req.getPhoneNumber());
        return salonRepository.save(salon);
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long salonId) throws Exception {
        Salon existingSalon=salonRepository.findById(salonId).orElse(null);
        if(existingSalon !=null && salon.getOwnerId().equals(user.getId())){
            existingSalon.setCity(salon.getCity());
            existingSalon.setName(salon.getName());
            existingSalon.setAddress(salon.getAddress());
            existingSalon.setImages(salon.getImages());
            existingSalon.setPhoneNumber(salon.getPhoneNumber());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setOpenTime(salon.getOpenTime());
            existingSalon.setCloseTime(salon.getCloseTime());
            existingSalon.setOwnerId(user.getId());
        }
        throw new Exception("salon not exist");
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon= salonRepository.findById(salonId).orElse(null);

        if(salon==null){
             throw new Exception("Salon is not exist");
        }
        return salon;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
       return salonRepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Salon> searchSalonByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
