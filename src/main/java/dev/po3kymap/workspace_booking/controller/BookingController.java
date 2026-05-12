package dev.po3kymap.workspace_booking.controller;

import dev.po3kymap.workspace_booking.entity.Booking;
import dev.po3kymap.workspace_booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}