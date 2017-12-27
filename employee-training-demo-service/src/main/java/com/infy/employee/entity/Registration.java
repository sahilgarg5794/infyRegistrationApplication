package com.infy.employee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "Registration")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Registration {

    @Getter
    @Setter
    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type="uuid-char")
    @Access(AccessType.PROPERTY)
    @Column(columnDefinition = "VARCHAR(36)", name = "id")
    UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    @JsonManagedReference
    private Course course;


}
