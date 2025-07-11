package com.example.agent_module.controller;

import com.example.agent_module.model.DynamicVariable;
import com.example.agent_module.service.DynamicVariableService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/agents/{agentId}/variables")
public class DynamicVariableController {

    private final DynamicVariableService service;

    public DynamicVariableController(DynamicVariableService service) {
        this.service = service;
    }

    @Operation(summary = "Get all dynamic variables for an agent")
    @GetMapping
    public List<DynamicVariable> getVariables(@PathVariable Long agentId) {
        return service.getAllDynamicVariables(agentId);
    }

    @Operation(summary = "Create a new dynamic variable for an agent")
    @PostMapping
    public ResponseEntity<DynamicVariable> createVariable(@PathVariable Long agentId,
                                                          @RequestBody @Valid DynamicVariable variable) {
        DynamicVariable created = service.createDynamicVariable(agentId, variable);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @Operation(summary = "Update an existing dynamic variable")
    @PutMapping("/{id}")
    public ResponseEntity<DynamicVariable> updateVariable(@PathVariable Long agentId,
                                                          @PathVariable Long id,
                                                          @RequestBody DynamicVariable variable) {
        DynamicVariable updated = service.updateDynamicVariable(id, variable);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Operation(summary = "Delete a dynamic variable")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariable(@PathVariable Long agentId,
                                               @PathVariable Long id) {
        service.deleteDynamicVariable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

