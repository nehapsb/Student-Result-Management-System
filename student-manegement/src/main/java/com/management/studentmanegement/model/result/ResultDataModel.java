package com.management.studentmanegement.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.management.studentmanegement.model.Grade;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Entity
@Table(name = "results")
public class ResultDataModel extends ResultBaseClass{

    @JsonProperty(value = "studentId")
    Long studentId;
    @JsonProperty(value = "courseId")
    Long courseId;
    Grade grade;

}
