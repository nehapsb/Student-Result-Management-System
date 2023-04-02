package com.management.studentmanegement.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Need to create a separate Base class for each Repository or else, the db request is going to the same table.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public abstract class ResultBaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(value = "id")
    Long id;
}
