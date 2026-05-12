package dev.po3kymap.workspace_booking.service;

import dev.po3kymap.workspace_booking.entity.Booking;
import dev.po3kymap.workspace_booking.entity.Workspace;
import dev.po3kymap.workspace_booking.repository.BookingRepository;
import dev.po3kymap.workspace_booking.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final WorkspaceRepository workspaceRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        Workspace workspace = workspaceRepository.findById(booking.getWorkspace().getId())
                .orElseThrow(() -> new IllegalArgumentException("Workspace not found"));

        if (booking.getStartTime().isAfter(booking.getEndTime()) || booking.getStartTime().isEqual(booking.getEndTime())) {
            throw new IllegalArgumentException("Start time must be strictly before end time");
        }

        boolean isOverlapping = bookingRepository.existsOverlappingBooking(
                workspace.getId(),
                booking.getStartTime(),
                booking.getEndTime()
        );

        if (isOverlapping) {
            throw new IllegalArgumentException("This workspace is already booked for the selected time");
        }

        booking.setWorkspace(workspace);
        return bookingRepository.save(booking);
    }
}
