package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permission(val ref:Activity) {


    val CAMERA_RQ = 101
    fun check(permission: String, requestCode: Int): Int {
        if (ContextCompat.checkSelfPermission(ref, permission) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    ref,
                    permission
                )
            ) {
                ActivityCompat.requestPermissions(
                    ref,
                    arrayOf(permission), requestCode
                )
                return 404
            } else {
                ActivityCompat.requestPermissions(
                    ref,
                    arrayOf(permission), requestCode
                )
                return 404
            }
        } else {
            return 200
        }
    }

    fun result(
        requestedCode: Int, permisionString: String, requestCode: Int,
        grantResults: IntArray
    ): Int {
        return when (requestCode) {
            requestedCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            ref,
                            permisionString
                        ) ==
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        return 200
                    }
                } else {

                    return 404
                }
                return 404
            }
            else -> {
                return 404
            }
        }
    }
}