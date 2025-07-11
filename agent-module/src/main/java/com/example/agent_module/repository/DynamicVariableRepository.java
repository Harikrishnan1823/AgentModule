package com.example.agent_module.repository;

import com.example.agent_module.model.DynamicVariable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DynamicVariableRepository extends JpaRepository<DynamicVariable, Long> {
    List<DynamicVariable> findByAgentId(Long agentId);
}
