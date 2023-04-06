package com.example.xiaoheihe.TestMain.DemoLearn;

import com.example.xiaoheihe.TestMain.DemoLearn.DemoPojo.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DemoThreadPoolMain {
    Logger log = LoggerFactory.getLogger(DemoThreadPoolMain.class);

    public static void main(String[] args) {

    }

    public void sealTicket(Ticket ticket){
        if (ticket.getNum()>0){
            Integer nowNum = ticket.getNum();
            nowNum--;
            ticket.setNum(nowNum);
        }
    }
}
