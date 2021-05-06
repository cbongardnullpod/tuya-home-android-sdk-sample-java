package com.tuya.smart.android.demo.camera;

import android.content.Context;
import android.content.Intent;

import com.tuya.smart.android.camera.sdk.TuyaIPCSdk;
import com.tuya.smart.android.camera.sdk.api.ITuyaIPCCore;

import static com.tuya.smart.android.demo.camera.utils.Constants.INTENT_DEV_ID;

public class CameraUtils {

    public static boolean ipcProcess(Context context, String devId) {
        ITuyaIPCCore cameraInstance = TuyaIPCSdk.getCameraInstance();
        if (cameraInstance != null) {
            if (cameraInstance.isIPCDevice(devId)) {
                Intent intent = new Intent(context, CameraPanelActivity.class);
                intent.putExtra(INTENT_DEV_ID, devId);
                context.startActivity(intent);
                return true;
            }
        }
        return false;
    }
}
