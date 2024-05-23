package com.restful.restful.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
    @NotEmpty(message = "First Name should not be empty")
    String firstname,
    @NotEmpty(message = "Last Name should not be empty")
    String lastname,
    @NotEmpty
    String email,
    Integer school_id
) {

}
