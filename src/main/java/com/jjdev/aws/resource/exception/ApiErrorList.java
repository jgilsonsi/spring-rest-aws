package com.jjdev.aws.resource.exception;

import java.util.Date;
import java.util.List;

public class ApiErrorList extends ApiError {

    private final List<String> errors;

    public ApiErrorList(int code, String msg, Date date, List<String> errors) {
        super(code, msg, date);
        this.errors = errors;
    }

}
