package com.example.xiaoheihe.TestMain.sjms;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class DemoEvent {
    private List<DemoAbstractListener> listeners = new ArrayList<>();

    @Getter
    private int status;

    public void attach(DemoAbstractListener listener){
        listeners.add(listener);
    }

    public void setStatus(int status) {
        this.status = status;
        notifyAllListeners();
    }

    public void notifyAllListeners(){
        listeners.forEach(DemoAbstractListener::update);
    }
}
