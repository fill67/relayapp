package com.relay.bitwords;

public class Bit50P1 extends WordBitBase {
    @Override
    public boolean evaluateWordBit() {
        if(settings.get("E50P") != null){
            if(Integer.parseInt(settings.get("E50P")) < 1){
                return true;
            }
        }
        if((Integer.parseInt(getCurrentInputValue("IA"))) > Double.parseDouble(settings.get("50P1P"))
            || (Integer.parseInt(getCurrentInputValue("IB"))) > Double.parseDouble(settings.get("50P1P"))
             || (Integer.parseInt(getCurrentInputValue("IC"))) > Double.parseDouble(settings.get("50P1P"))){
            return true;
        }
        return false;
    }
}
