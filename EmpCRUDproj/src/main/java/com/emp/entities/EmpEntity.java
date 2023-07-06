package com.emp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_emp")
public class EmpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emp_id")
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "This isn't valid. It accepts only alphabets.")
    @Column(name = "emp_name")
    private String name;

    @NotNull(message = "employee age shouldn't be null" )
    @Min(18)
    @Max(45)
    @Column(name = "emp_age")
    private Integer age;

    @NotEmpty
    @Pattern(regexp = "^f$|^m$", message = "it accepts only this input: (f)emale or (m)ale")
    @Column(name = "emp_gender")
    private String gender;

    @NotEmpty
    @Pattern(regexp = "^(\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$", message = "invalid mobile number entered.")
    @Column(name = "emp_ph")
    private String ph;
}
