package dev.po3kymap.workspace_booking.controller;


import dev.po3kymap.workspace_booking.entity.Workspace;
import dev.po3kymap.workspace_booking.service.WorkspaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @GetMapping
    public List<Workspace> getAll() {
        return workspaceService.getAllWorkspaces();
    }

    @PostMapping
    public Workspace create(@Valid @RequestBody Workspace workspace) {
        return workspaceService.createWorkspace(workspace);
    }
}