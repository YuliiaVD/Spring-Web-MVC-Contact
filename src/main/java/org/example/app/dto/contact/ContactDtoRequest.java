package org.example.app.dto.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ContactDtoRequest(
        Long id,
        String firstName,
        String lastName,
        String phone) {

}
