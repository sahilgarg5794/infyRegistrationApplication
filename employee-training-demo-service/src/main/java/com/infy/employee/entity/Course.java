package com.infy.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="course")
public class Course {

    @Getter
    @Setter
    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR(36)", name = "id")
    private UUID id;

    @Column(name="name")
    private String courseName;

    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    private Registration courseRegistration;
}
