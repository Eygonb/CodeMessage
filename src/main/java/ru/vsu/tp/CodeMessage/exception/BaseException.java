package ru.vsu.tp.CodeMessage.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
    private ApiError apiError;
    private HttpStatus httpStatus;

    public BaseException(ApiError apiError, HttpStatus httpStatus) {
        this.apiError = apiError;
        this.httpStatus = httpStatus;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
