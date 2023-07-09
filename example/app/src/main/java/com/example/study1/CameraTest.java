package com.example.study1;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.hardware.camera2.*;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CameraTest extends AppCompatActivity{
    private static final String[] REQUIRED_RUNTIME_PERMISSIONS = new String[] {android.Manifest.permission.CAMERA,};
    private static final int PERMISSION_REQUESTS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_test);
        if (!allRuntimePermissionsGranted()) {
            getRuntimePermissions();
        }
    }
    private boolean allRuntimePermissionsGranted() {
        for (String permission : REQUIRED_RUNTIME_PERMISSIONS) {
            if (!isPermissionGranted(this, permission)) {
                return false;
            }
        }
        return true;
    }
    private void getRuntimePermissions() {
        List<String> permissionsToRequest = new ArrayList<>();
        for (String permission : REQUIRED_RUNTIME_PERMISSIONS) {
            if (!isPermissionGranted(this, permission)) {
                permissionsToRequest.add(permission);
            }
        }
        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[0]), PERMISSION_REQUESTS);
        }
    }
    private boolean isPermissionGranted(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission granted: " + permission);
            return true;
        }
        Log.i(TAG, "Permission NOT granted: " + permission);
        return false;
    }
}