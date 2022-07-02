package com.company.callcenter;

public abstract class CallCenterEmployee {

    final String name;

    protected CallCenterEmployee(String name) {
        this.name = name;
    }

    interface OnCallHandled {
        void onCallHandled(CallCenterEmployee employee, Call call);
    }
}
