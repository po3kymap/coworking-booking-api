package dev.po3kymap.workspace_booking.repository;


import dev.po3kymap.workspace_booking.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

}