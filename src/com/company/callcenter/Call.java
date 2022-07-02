package com.company.callcenter;


public class Call {

    final String callerName;
    final int callDuration;
    final CallHandler desireCallHandler;


    public Call(String callerName, int callDuration, CallHandler desireCallHandler) {
        this.callerName = callerName;
        this.callDuration = callDuration;
        this.desireCallHandler = desireCallHandler;
    }

    public enum CallHandler {
        RESPONDENT, MANAGER, DIRECTOR
    }
}
