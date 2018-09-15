package com.relay.immulator;

import com.relay.immulator.SettingManager;

import java.util.Map;

public class RelayImmulator {

    public void executeImmulation(){
        Map<String, String> equations = SettingManager.getInstance().getActiveSettingGroup().getEquations();
        for(String equationName : equations.keySet()){
            System.out.println(equationName + ":" + equations.get(equationName));
        }
    }
}
