package com.kwargss.pollarr.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreatePollRequest {

    @JsonProperty("poll_name")
    private String pollName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("choiceList")
    private List<ChoiceRequest> choiceList;

}
