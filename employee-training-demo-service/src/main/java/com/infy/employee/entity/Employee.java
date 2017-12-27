package com.infy.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
@ToString
public class Employee {

    @Getter
    @Setter
    @NotNull
    @Id
    @Type(type="uuid-char")
    @Access(AccessType.PROPERTY)
    @Column(columnDefinition = "VARCHAR(36)", name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    @Column(name="firstName")
    String empFirstName;

    @Column(name="lastName")
    String empLastName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonBackReference
    List<Registration> employeeRegistrations;

}
