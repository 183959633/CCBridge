package cordova-plugin-ccbridge;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class CCBridge extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
          case "exit":
            this.exit(args, callbackContext);
            return true;
          case "getAppVersion":
            this.getAppVersion(args, callbackContext);
            return true;
        }
        return false;
    }

    private void exit(JSONArray args, CallbackContext callbackContext) {
      callbackContext.success();
      cordova.getActivity().finish();
      android.os.Process.killProcess(android.os.Process.myPid());
      System.exit(0);
    }

    private void getAppVersion(JSONArray args, CallbackContext callbackContext) {
        String versionName = "";
        try {
            PackageInfo pkgInfo = cordova.getContext().getPackageManager().getPackageInfo(cordova.getContext().getPackageName(), 0);
            versionName = pkgInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.d(e);
        }
        callbackContext.success(versionName);
    }
    
}
