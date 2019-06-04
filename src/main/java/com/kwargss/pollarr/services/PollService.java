package com.kwargss.pollarr.services;

import com.kwargss.pollarr.datasources.repositories.PollRepository;
import com.kwargss.pollarr.requests.CreatePollRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public void create(CreatePollRequest pollRequest) {
        pollRepository.createSimplePoll(pollRequest);
    }

}
