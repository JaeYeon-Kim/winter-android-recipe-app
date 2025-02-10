package com.surivalcoding.composerecipeapp.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


// Firebase Messaging Service
@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        remoteMessage.notification?.let { result ->
            showNotification(result.title ?: "UNKNOWN", result.body ?: "UNKNOWN")
        }
    }

    // 새로운 토큰 발급시
    override fun onNewToken(token: String) {
        Logger.e("newToken: $token")
    }


    // 알림 구현 체
    private fun showNotification(title: String?, message: String?) {
        val channelId = "fcm_default_channel"
        // NotiManager
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 오레오 버전 이상부터 channelId 필수
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "FCM_NOTIFICATIONS", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }


        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(Random.nextInt(), notification)

    }
}