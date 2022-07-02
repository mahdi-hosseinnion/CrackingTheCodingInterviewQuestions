package com.company.callcenter;

public class Respondent extends CallCenterEmployee {


    protected Respondent(String name) {
        super(name);
    }

    public void handleCall(Call call, RespondentInteraction interaction, OnCallHandled onCallHandled) {
        System.out.println("Respondent with name: " + name + " is handling the " + call.callerName + " call.");
        try {
            Thread.sleep(call.callDuration * 1_000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (call.desireCallHandler != Call.CallHandler.RESPONDENT) {
            interaction.dispatchCallToManager(call);
        }else {
            System.out.println("Call finished!");
        }
        onCallHandled.onCallHandled(this, call);
    }

    interface RespondentInteraction {
        void dispatchCallToManager(Call call);
    }
}
