package com.management.studentmanegement.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "results")
public class ResultDataModel extends BaseClass{


    @JsonProperty(value = "studentId")
    Long studentId;
    @JsonProperty(value = "courseId")
    Long courseId;
    Grade grade;

}
