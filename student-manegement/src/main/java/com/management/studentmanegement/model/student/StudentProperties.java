package com.management.studentmanegement.model.student;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Entity
@Table(name = "students")
public class StudentProperties extends StudentBaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(value = "id")
    Long id;

    @NotEmpty
    @Size(min = 1)
    String firstName;
    @NotEmpty
    @Size(min = 1)
    String lastName;
    @NotEmpty
    String dateOfBirth;
}
