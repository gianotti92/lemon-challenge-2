package com.l2.challenge.model;

public class UserRequest {
    private static final Integer INITIAL_REQUEST_NUMBER = 0;

    private Integer numberOfRequest;
    private Long timeStamp;

    public UserRequest() {
        this.numberOfRequest = INITIAL_REQUEST_NUMBER;
        this.timeStamp = System.currentTimeMillis();
    }

    public Integer getNumberOfRequest() {
        return numberOfRequest;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void addRequest() {
        numberOfRequest++;
    }
}
