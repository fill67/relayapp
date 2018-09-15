package com.relay.bitwords;

import com.relay.immulator.InputManager;
import com.relay.immulator.SettingManager;

import java.util.Map;

public abstract class WordBitBase {
    protected Map<String,String> settings = SettingManager.getInstance().getActiveSettingGroup().getSettings();
    protected String getCurrentInputValue(String input){
       return InputManager.getInstance().getInputValues().get(input);
    }
    public abstract boolean evaluateWordBit();
}
