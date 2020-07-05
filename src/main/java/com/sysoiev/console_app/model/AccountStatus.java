package com.sysoiev.console_app.model;

public enum AccountStatus {
    ACTIVE("active"), BANNED("banned"), DELETED("deleted");

    private String status;

    AccountStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
