package com.company;


import com.company.callcenter.Call;
import com.company.callcenter.CallCenter;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        while (true) {
            System.out.println("Insert call information");
            System.out.println("What is the caller name?");
            String callerName = sc.nextLine();
            System.out.println("What is the call duration?");
            int callDuration = sc.nextInt();
            sc.nextLine();
            System.out.println("What is your desire call handler? r,m,d");
            char handler = sc.nextLine().charAt(0);
            Call.CallHandler callHandler = Call.CallHandler.RESPONDENT;
            if (handler == 'm') {
                callHandler = Call.CallHandler.MANAGER;
            } else if (handler == 'd') {
                callHandler = Call.CallHandler.DIRECTOR;
            }
            Call call = new Call(callerName, callDuration, callHandler);
            callCenter.dispatchCall(call);
        }
    }


}