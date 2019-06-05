package com.kwargss.pollarr.datasources.repositories;

import com.kwargss.pollarr.datasources.enums.PollStatus;
import com.kwargss.pollarr.requests.ChoiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
@Slf4j
public class PollRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createSimplePoll(String name, String desc) {
        // uuid should be in the util instead
        String uuid = "aaa";
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, uuid);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, desc);
                preparedStatement.setInt(4, 0);
                preparedStatement.setString(5, PollStatus.OPEN.name());
                preparedStatement.setDate(6, new Date(System.currentTimeMillis()));
                preparedStatement.setDate(7, new Date(System.currentTimeMillis()));
                preparedStatement.setDate(8, null);
            }
        };
        int success = jdbcTemplate.update("INSERT INTO `poll` VALUE (?, ?, ?, ?, ?, ?, ?, ?)", preparedStatementSetter);
    }

    public void createChoice(String pollId, List<ChoiceRequest> choiceList) {
        String uuid = "aaa";
        BatchPreparedStatementSetter batchPreparedStatementSetter = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                ChoiceRequest choiceRequest = choiceList.get(i);
                preparedStatement.setString(1, uuid);
                preparedStatement.setString(2, pollId);
                preparedStatement.setString(3, choiceRequest.getChoiceName());
                preparedStatement.setString(4, choiceRequest.getDescription());
                preparedStatement.setInt(5, 0);
                preparedStatement.setDate(6, new Date(System.currentTimeMillis()));
                preparedStatement.setDate(7, new Date(System.currentTimeMillis()));
            }

            @Override
            public int getBatchSize() {
                return choiceList.size();
            }
        };
        jdbcTemplate.batchUpdate("INSERT INTO `poll_choice` VALUE (?, ?, ?, ?, ?, ?)", batchPreparedStatementSetter);
    }
}
