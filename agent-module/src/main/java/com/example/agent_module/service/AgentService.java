package com.example.agent_module.service;

import com.example.agent_module.model.Agent;
import com.example.agent_module.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AgentService {
 @Autowired
    private AgentRepository agentRepository;
 //Get all agents
  public List<Agent> getAllAgents(){
      return agentRepository.findAll();
  }

  // get by ID
    public Optional<Agent> getAgentById(Long id){
      return agentRepository.findById(id);
    }

   // create or update
    public Agent updateAgent(Agent agent){
      return agentRepository.save(agent);
    }

    // delete by Agent id
    public boolean deleteAgentById(Long id) {
        if (agentRepository.existsById(id)) {
            agentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
