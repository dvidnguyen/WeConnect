package com.CURD_01.indetify_service.exception;

public enum ErrorCode {
    UNCAUGHT_EXCEPTION(1000, "An unexpected error occurred"),
    USER_EXISTED(1001, "User already exists"),
    USERNAME_INVALID(1002, "Username is invalid"),
    USERPASSWORD_INVALID(1003, "Password is invalid"),
    INVALID_MESSAGE(999, "Invalid message key"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
