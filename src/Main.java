import com.relay.bitwords.Bit50P1;
import com.relay.immulator.InputManager;
import com.relay.immulator.RelayImmulator;
import com.relay.immulator.SettingGroup;
import com.relay.immulator.SettingManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("//c://codebase//RelayImmulator//inputfiles//settingconfig.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            Map<String, String> map1 = null;
            Map<String, Map<String, String>> data = new HashMap();
            String procInstance = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("[")) {
                    if (!procInstance.equals("")) {
                        data.put(procInstance, map1);
                    }
                    procInstance = line;
                    map1 = new HashMap();
                } else {
                    String[] vals = line.split(",\"");
                    if (vals != null && vals.length > 1) {
                        map1.put(vals[0], vals[1].substring(0, vals[1].indexOf("\"")));
                    }

                }
            }
            for (String key : data.keySet()) {
                if(parseInteger(key.substring(key.indexOf("[")+1,key.indexOf("]")))){
                   SettingGroup group = new SettingGroup();
                   group.setSettings(data.get(key));
                   group.setEquations(data.get("[L" + key.substring(key.indexOf("[") +1,key.indexOf("]")) + "]"));
                   SettingManager.getInstance().addSettingGroup(Integer.parseInt(key.substring(key.indexOf("[") + 1,key.indexOf("]"))),group);
                }
            }
//            SettingManager.getInstance().changeActiveGroup(4);
            InputManager.getInstance().setInputValue("IA", "10");
            InputManager.getInstance().setInputValue("IB", "10");
            InputManager.getInstance().setInputValue("IC", "10");
            Bit50P1 bit = new Bit50P1();
            System.out.println(bit.evaluateWordBit());
            RelayImmulator ri = new RelayImmulator();
            ri.executeImmulation();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    static boolean parseInteger(String s)
    {
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
