package com.example.part7_19;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals("android.intent.action.NEW_OUTGOING_CALL")){
//            폰넘버 추출 후 dialog에 넘버를 넘긴다.
            String phoneNumber=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Intent intent1=new Intent(context, DialogActivity.class);
            intent1.putExtra("number", phoneNumber);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }else if(action.equals("android.intent.action.PHONE_STATE")){
//            전화 끝난상태, 대기상태 등을 구분하려고
            Bundle bundle=intent.getExtras();
            String state=bundle.getString(TelephonyManager.EXTRA_STATE);
            String phoneNumber=bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
//            전화가 울리는 상태라면
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING) && phoneNumber != null){
                Intent intent1=new Intent(context, DialogActivity.class);
                intent1.putExtra("number", phoneNumber);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        }
    }
}
