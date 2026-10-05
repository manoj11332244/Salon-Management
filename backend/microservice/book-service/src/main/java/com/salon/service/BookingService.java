package com.salon.service;

import com.salon.domain.BookingStatus;
import com.salon.dto.BookingRequest;
import com.salon.dto.ServiceDTO;
import com.salon.modal.Booking;
import com.salon.dto.UserDTO;
import com.salon.dto.SalonDTO;
import com.salon.modal.SalonReport;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking,
                          UserDTO  userDTO,
                          SalonDTO salonDTO,
                          Set<ServiceDTO> serviceDTOSet);

    List<Booking> getBookingByCustomer(Long customerId);
    List<Booking> getBookingSalon(Long salonId);
    Booking getBookingById(Long id);
    Booking updateBooking(Long bookingId, BookingStatus status);
    List<Booking> getBookingByDate(LocalDate date, Long salonId);

    SalonReport getSalonReport(Long salonId);
}
