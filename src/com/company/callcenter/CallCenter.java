package com.company.callcenter;


import com.company.util.Queue;

public class CallCenter implements CallCenterEmployee.OnCallHandled, Respondent.RespondentInteraction, Manager.ManagerInteraction {

    Queue<Respondent> freeRespondents = new Queue<>();
    Queue<Manager> freeManagers = new Queue<>();
    Queue<Director> freeDirectors = new Queue<>();

    public CallCenter() {
        initializeWithTestData();
    }

    public void dispatchCall(Call call) {
        Respondent respondent = freeRespondents.dequeue();
        if (respondent == null) {
            System.out.println("Cannot dispatch the call, no respondent is free");
            return;
        }
        respondent.handleCall(call, this, this);
    }

    @Override
    public void onCallHandled(CallCenterEmployee employee, Call call) {
        if (employee instanceof Respondent) {
            freeRespondents.enqueue((Respondent) employee);

        } else if (employee instanceof Manager) {
            freeManagers.enqueue((Manager) employee);

        } else if (employee instanceof Director) {
            freeDirectors.enqueue((Director) employee);
        }
    }

    @Override
    public void dispatchCallToManager(Call call) {
        Manager manager = freeManagers.dequeue();
        if (manager != null) {
            manager.handleCall(call, this, this);
            return;
        }
        Director director = freeDirectors.dequeue();
        if (director == null) {
            System.out.println("Cannot dispatch the call to the manager or director, no manager or director is free");
            return;
        }
        director.handleCall(call, this);
    }

    @Override
    public void dispatchCallToDirector(Call call) {
        Director director = freeDirectors.dequeue();
        if (director == null) {
            System.out.println("Cannot dispatch the call to the director, no director is free");
            return;
        }
        director.handleCall(call, this);
    }

    private void initializeWithTestData() {
        freeRespondents.add(new Respondent("Ali     yeki"));
        freeRespondents.add(new Respondent("mamad   yeki"));
        freeRespondents.add(new Respondent("Javad   yeki"));
        freeRespondents.add(new Respondent("Hossein yeki"));

        freeManagers.add(new Manager("Mahdi doki"));
        freeManagers.add(new Manager("Arash doki"));
        freeManagers.add(new Manager("Hesam doki"));

        freeDirectors.add(new Director("Abol seki"));
        freeDirectors.add(new Director("Jax  seki"));

    }
}
