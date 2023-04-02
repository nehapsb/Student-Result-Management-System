package com.management.studentmanegement.model.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
public abstract class StudentBaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(value = "id")
    Long id;
}
