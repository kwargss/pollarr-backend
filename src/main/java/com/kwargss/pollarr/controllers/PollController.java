package com.kwargss.pollarr.controllers;

import com.kwargss.pollarr.requests.CreatePollRequest;
import com.kwargss.pollarr.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/poll")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping
    public ResponseEntity<Boolean> createPoll(@RequestBody CreatePollRequest request) {
        pollService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }
}
