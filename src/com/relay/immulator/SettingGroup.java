package com.relay.immulator;

import java.util.Map;

public class SettingGroup {
    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    Map<String, String> settings;

    public Map<String, String> getEquations() {
        return equations;
    }

    public void setEquations(Map<String, String> equations) {
        this.equations = equations;
    }

    Map<String, String> equations;
}
