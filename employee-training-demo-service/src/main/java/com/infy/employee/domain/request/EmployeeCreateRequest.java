package com.infy.employee.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeCreateRequest {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("secondName")
    private String lastName;

}
