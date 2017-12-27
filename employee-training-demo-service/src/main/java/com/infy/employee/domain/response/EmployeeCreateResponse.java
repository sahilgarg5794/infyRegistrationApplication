package com.infy.employee.domain.response;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeCreateResponse {

    private int httpStatus;
    private String message;

    public EmployeeCreateResponse(int httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }
}
