package htut.manage_access;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Manage_All_Access")
public class Manage_All_AccessPlugin extends Plugin {

    private static final int APP_STORAGE_ACCESS_REQUEST_CODE = 12345;

    @PluginMethod()
    public void requestAllFilesAccessPermission(PluginCall call) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
            Uri uri = Uri.fromParts("package", this.getContext().getPackageName(), null);
            intent.setData(uri);
            saveCall(call);
            startActivityForResult(call, intent, APP_STORAGE_ACCESS_REQUEST_CODE);
        } else {
            call.resolve();
        }
    }

    @PluginMethod()
    public void checkAllFilesAccessPermission(PluginCall call) {
        JSObject ret = new JSObject();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (Environment.isExternalStorageManager()) {
                ret.put("hasPermission", true);
            } else {
                ret.put("hasPermission", false);
            }
        } else {
            ret.put("hasPermission", true);
        }
        call.resolve(ret);
    }

    @Override
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        PluginCall savedCall = getSavedCall();
        if (savedCall == null) {
            Log.w(getLogTag(), "No stored plugin call for onActivityResult.");
            return;
        }
        if (requestCode == APP_STORAGE_ACCESS_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                savedCall.resolve();
            } else {
                savedCall.reject("Permission not granted.");
            }
        }
    }
}
