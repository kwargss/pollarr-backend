package com.kwargss.pollarr.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePollRequest {

    @JsonProperty("name")
    private String pollName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("choices")
    private List<ChoiceRequest> choiceList;

}
