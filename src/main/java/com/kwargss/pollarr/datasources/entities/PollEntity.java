package com.kwargss.pollarr.datasources.entities;

import com.kwargss.pollarr.datasources.enums.PollStatus;

import java.util.Date;

public class PollEntity {

    private String uuid;

    private String name;

    private String description;

    private PollStatus status;

    private Date createdDate;

    private Date updatedDate;

    private Date closedDate;

}
