package com.restapi1.buildrestapi.request;

import java.util.List;

public class InQueryRequest {
    private List<String> firstName;

    public List<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(List<String> firstName) {
        this.firstName = firstName;
    }
}
