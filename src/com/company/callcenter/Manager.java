package com.company.callcenter;

public class Manager extends CallCenterEmployee {

    protected Manager(String name) {
        super(name);
    }

    public void handleCall(Call call, ManagerInteraction interaction, OnCallHandled onCallHandled) {
        System.out.println("Manager with name: " + name + " is handling the " + call.callerName + " call.");
        try {
            Thread.sleep(call.callDuration * 1_000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (call.desireCallHandler != Call.CallHandler.MANAGER) {
            interaction.dispatchCallToDirector(call);
        }else {
            System.out.println("Call finished!");
        }
        onCallHandled.onCallHandled(this, call);
    }

    interface ManagerInteraction {
        void dispatchCallToDirector(Call call);
    }
}
