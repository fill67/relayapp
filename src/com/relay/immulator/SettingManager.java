package com.relay.immulator;

import java.util.HashMap;
import java.util.Map;

public class SettingManager {
    private static SettingManager setting_manager = null;
    private Map<Integer, SettingGroup> settings = new HashMap();
    private  SettingGroup activeGroup;
    public  SettingGroup getActiveSettingGroup(){
        return activeGroup;
    }
    public  void addSettingGroup(Integer groupId, SettingGroup group){
        settings.put(groupId, group);
        if(groupId.equals(1)){
            activeGroup = group;
        }
    }
    public  void changeActiveGroup(Integer newGroupId){
        if(settings.keySet().contains(newGroupId)){
            activeGroup=settings.get(newGroupId);
        }
    }

    public static SettingManager getInstance(){
        if(setting_manager == null){
            setting_manager = new SettingManager();
        }
        return setting_manager;
    }
    private SettingManager(){

    }
}
