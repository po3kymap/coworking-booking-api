package dev.po3kymap.workspace_booking.repository;

import dev.po3kymap.workspace_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END " +
            "FROM Booking b WHERE b.workspace.id = :workspaceId " +
            "AND (b.startTime < :endTime AND b.endTime > :startTime)")
    boolean existsOverlappingBooking(
            @Param("workspaceId") Long workspaceId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
