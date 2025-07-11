package com.example.agent_module.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DynamicVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_name")
    private String keyName;

    @Column(name = "value_text")
    private String value;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference
    private Agent agent;

}
