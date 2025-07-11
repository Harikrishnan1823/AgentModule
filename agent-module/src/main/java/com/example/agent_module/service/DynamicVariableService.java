package com.example.agent_module.service;

import com.example.agent_module.model.Agent;
import com.example.agent_module.model.DynamicVariable;
import com.example.agent_module.repository.AgentRepository;
import com.example.agent_module.repository.DynamicVariableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicVariableService {

    private final DynamicVariableRepository dynamicVariableRepository;
    private final AgentRepository agentRepository;

    public DynamicVariableService(DynamicVariableRepository dynamicVariableRepository,
                                  AgentRepository agentRepository) {
        this.dynamicVariableRepository = dynamicVariableRepository;
        this.agentRepository = agentRepository;
    }

    public List<DynamicVariable> getAllDynamicVariables(Long agentId) {
        return dynamicVariableRepository.findByAgentId(agentId);
    }

    public DynamicVariable createDynamicVariable(Long agentId, DynamicVariable variable) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + agentId));
        variable.setAgent(agent);
        return dynamicVariableRepository.save(variable);
    }

    public DynamicVariable updateDynamicVariable(Long id, DynamicVariable variable) {
        DynamicVariable existing = dynamicVariableRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dynamic variable not found with id: " + id));

        existing.setKeyName(variable.getKeyName());
        existing.setValue(variable.getValue());
        return dynamicVariableRepository.save(existing);
    }

    public void deleteDynamicVariable(Long id) {
        dynamicVariableRepository.deleteById(id);
    }
}

