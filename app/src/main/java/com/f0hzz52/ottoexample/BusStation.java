package com.f0hzz52.ottoexample;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class BusStation {
    // ThreadEnforcer.ANY is All of Thread
    // ThreadEnforcer.MAIN is main only
    private static Bus bus = new Bus(ThreadEnforcer.ANY);

    public static Bus getBus() {
        return bus;
    }
}
