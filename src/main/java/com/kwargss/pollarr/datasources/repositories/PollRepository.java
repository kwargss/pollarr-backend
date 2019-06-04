package com.kwargss.pollarr.datasources.repositories;

import com.kwargss.pollarr.datasources.enums.PollStatus;
import com.kwargss.pollarr.requests.ChoiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
public class PollRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createSimplePoll(String uuid, String name, String desc) {
        StringJoiner insertPollQuery = new StringJoiner("");
        insertPollQuery.add("INSERT INTO TABLE `poll` (uuid, name, desc, total_vote,) VALUES(");
        insertPollQuery.add(uuid);
        insertPollQuery.add(",");
        insertPollQuery.add(name);
        insertPollQuery.add(",");
        insertPollQuery.add(desc);
        insertPollQuery.add(",");
        insertPollQuery.add("0");
        insertPollQuery.add(",");
        insertPollQuery.add(PollStatus.OPEN.name());
        insertPollQuery.add(",");
        insertPollQuery.add("NOW()");
        insertPollQuery.add(",");
        insertPollQuery.add("NOW()");
        insertPollQuery.add(",");
        insertPollQuery.add("NULL");
        int success = jdbcTemplate.update(insertPollQuery.toString());
    }

    public void createChoice(String uuid, List<ChoiceRequest> choiceList) {

    }
}
