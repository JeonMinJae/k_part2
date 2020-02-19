package com.example.part3_mission;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

public class SettingPreferenceFragment extends PreferenceFragment {
    SharedPreferences prefs;

    ListPreference networkPreference;
    PreferenceScreen apnPreference;
    PreferenceScreen npcPreference;
    SwitchPreference roamingPreference;
    SwitchPreference lteModePeference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_preference);

        networkPreference = (ListPreference)findPreference("network");
        apnPreference = (PreferenceScreen)findPreference("apn");
        npcPreference = (PreferenceScreen)findPreference("network_npc");
        roamingPreference = (SwitchPreference)findPreference("roaming");
        lteModePeference = (SwitchPreference)findPreference("4g");

        prefs= PreferenceManager.getDefaultSharedPreferences(getActivity());

//        키값의 데이터가 뭔가 저장되어있는게 있다면 그대로 저장한다. 왜냐면 낫(!)이 쓰였으므로 (화면 초기)
        if (!prefs.getString("network","").equals("")){
            networkPreference.setSummary(prefs.getString("network","LTE(권장)"));
        }

        prefs.registerOnSharedPreferenceChangeListener(prefListener);
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener=
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if (key.equals("network")){
//                        위에값이랑 동일하게(유저가 변경할떄)
                        networkPreference.setSummary(prefs.getString("network","LTE(권장)"));
                    }
                }
            };
}
