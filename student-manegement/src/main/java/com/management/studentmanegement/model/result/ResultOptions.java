package com.management.studentmanegement.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.management.studentmanegement.model.Grade;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ResultOptions {
    Grade grade;
}
