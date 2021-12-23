package com.enyason.payoneerapp.core.domain;

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

    public static Result<Throwable> error(Throwable data) {
        return new Result<>(Status.ERROR, data, "Successful");
    }

    public enum Status {ERROR, SUCCESS}
}



