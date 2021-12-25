package com.enyason.payoneerapp.common;

import javax.annotation.Nullable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    @Nullable
    Status status;

    @Nullable
    T data;

    @Nullable
    String message;

    private Result(@Nullable Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(Status.SUCCESS, data, "Successful");
    }

    public static <T>Result<T> error(String error) {
        return new Result<>(Status.ERROR, null, error);
    }

    public enum Status {ERROR, SUCCESS}
}



