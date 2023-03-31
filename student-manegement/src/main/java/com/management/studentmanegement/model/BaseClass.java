package com.management.studentmanegement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public abstract class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(value = "id")
    Long id;
}
