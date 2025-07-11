package com.example.agent_module.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DynamicVariable> dynamicVariables;


   String name;
   String email;
   String phoneNumber;

}
