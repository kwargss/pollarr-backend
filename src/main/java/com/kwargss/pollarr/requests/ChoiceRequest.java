package com.kwargss.pollarr.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoiceRequest {
    @JsonProperty("name")
    private String choiceName;

    @JsonProperty("description")
    private String description;
}
