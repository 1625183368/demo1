package com.example.xiaoheihe.TestMain.sjms;

public class DemoListener extends DemoAbstractListener{
    public DemoListener(DemoEvent demoEvent) {
        this.demoEvent = demoEvent;
        demoEvent.attach(this);
    }

    @Override
    public void update() {
        System.out.println(this.getClass().getName() + "update status: " + demoEvent.getStatus());
    }
}

class Test{
    public static void main(String[] args) {
        DemoEvent demoEvent = new DemoEvent();

        DemoListener demoListener = new DemoListener(demoEvent);

        demoEvent.setStatus(2);
    }
}

