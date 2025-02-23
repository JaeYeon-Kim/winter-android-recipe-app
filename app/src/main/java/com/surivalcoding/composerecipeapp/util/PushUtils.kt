package com.surivalcoding.composerecipeapp.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.PowerManager

// 잠금 화면일 경우 PowerManager를 사용하여 알림을 통해 깨움
object PushUtils {
    private var mWakeLock: PowerManager.WakeLock? = null

    @SuppressLint("InvalidWakeLockTag")
    fun acquireWakeLock(context: Context) {
        val pm = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        mWakeLock = pm.newWakeLock(
            PowerManager.FULL_WAKE_LOCK or
                    PowerManager.ACQUIRE_CAUSES_WAKEUP or
                    PowerManager.ON_AFTER_RELEASE, "WAKEUP"
        )
        mWakeLock!!.acquire(3000)
    }

    fun releaseWakeLock() {
        if (mWakeLock != null) {
            mWakeLock!!.release()
            mWakeLock = null
        }
    }
}