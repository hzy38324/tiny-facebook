package com.b4u.tinyfacebook.exception;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/07
 */
public class ErrorInfo {
    private int errorCode;
    private String errorInfo;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo(int errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public ErrorInfo() {
    }
}
