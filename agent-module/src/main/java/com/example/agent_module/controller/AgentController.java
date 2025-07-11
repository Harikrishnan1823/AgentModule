package com.example.agent_module.controller;

import com.example.agent_module.model.Agent;
import com.example.agent_module.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {
@Autowired
private AgentService agentService;
  //Get all agents
    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents(){
        return ResponseEntity.ok(agentService.getAllAgents());
    }
   // Get agents by id
   @GetMapping("/{id}")
        public ResponseEntity<Agent> getAgentById(@PathVariable Long id){
           return agentService.getAgentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
       }
   // create new agent
    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent){
        Agent saved=agentService.updateAgent(agent);
        return ResponseEntity.ok(saved);
    }

    // update agent by id
    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable
                                             Long id,@RequestBody Agent agent){
        return agentService.getAgentById(id).map(existing -> {
            agent.setId(id); // ensure same ID is used
            Agent updated = agentService.updateAgent(agent);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
    // Delete agent
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        boolean deleted = agentService.deleteAgentById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }

}
