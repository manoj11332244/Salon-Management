package com.salon.service.impl;

import com.salon.domain.BookingStatus;
import com.salon.dto.BookingRequest;
import com.salon.dto.SalonDTO;
import com.salon.dto.ServiceDTO;
import com.salon.dto.UserDTO;
import com.salon.modal.Booking;
import com.salon.modal.SalonReport;
import com.salon.repository.BookingRepository;
import com.salon.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(BookingRequest booking,
                                 UserDTO userDTO,
                                 SalonDTO salonDTO,
                                 Set<ServiceDTO> serviceDTOSet) {
//        int totalDuration =
        return null;
    }

    @Override
    public List<Booking> getBookingByCustomer(Long customerId) {
        return List.of();
    }

    @Override
    public List<Booking> getBookingSalon(Long salonId) {
        return List.of();
    }

    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) {
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate date, Long salonId) {
        return List.of();
    }

    @Override
    public SalonReport getSalonReport(Long salonId) {
        return null;
    }
}
