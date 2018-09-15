package com.relay.immulator;

import java.util.HashMap;
import java.util.Map;

public class InputManager {
    private static InputManager input_manager=null;
    public  Map<String, String> getInputValues() {
        return inputValues;
    }

    private Map<String, String> inputValues = new HashMap();

    public void setInputValue(String input, String value){
        inputValues.put(input,value);
    }
    public static InputManager getInstance(){
        if(input_manager == null){
            input_manager = new InputManager();
        }
        return input_manager;
    }

    private InputManager(){

    }
}
