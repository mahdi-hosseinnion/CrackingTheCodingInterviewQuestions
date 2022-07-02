package com.company.callcenter;

public class Director extends CallCenterEmployee {


    protected Director(String name) {
        super(name);
    }

    public void handleCall(Call call, OnCallHandled onCallHandled) {
        System.out.println("Manager with name: " + name + " is handling the " + call.callerName + " call.");
        try {
            Thread.sleep(call.callDuration * 1_000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Call finished!");
        onCallHandled.onCallHandled(this, call);
    }
}
