package com.enyason.payoneerapp.common;

import java.io.IOException;

import retrofit2.HttpException;
import retrofit2.Response;

public class ErrorUtils {

    private static final String UNEXPECTED_ERROR_MSG = "Some error occurred, please try again later";

    public static String extractErrorMessage(Throwable throwable) {
        String msg = null;
        if (throwable != null) {
            if (throwable instanceof HttpException) {
                Response<?> response = ((HttpException) throwable).response();
                int code = response != null ? response.code() : -1;
                switch (code) {
                    case 404:
                        msg = "The requested resource could not be found, please contact the admin";
                        break;
                    case 500:
                        msg = "Service is temporarily unavailable at the moment, please check back later.";
                        break;
                }
            } else if (throwable instanceof IOException) {
                msg = "We can not establish connection with server, please turn on WIFI an try again";
            } else {
                msg = UNEXPECTED_ERROR_MSG;
            }

        } else {
            msg = UNEXPECTED_ERROR_MSG;
        }
        return msg;
    }
}
