package com.surivalcoding.composerecipeapp.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
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
        remoteMessage.data.let { result ->
            Logger.e("들어온 FCM 데이터: $remoteMessage $result")
            // 딥링크 추출
            val recipeId = result["recipeId"]
            val title = result["title"]
            val body = result["body"]
            val deepLinkUrl = "app://recipe.co/recipe/$recipeId"

            showNotification(title ?: "UNKNOWN", body ?: "UNKNOWN", deepLinkUrl = deepLinkUrl)
        }
    }

    // 새로운 토큰 발급시
    override fun onNewToken(token: String) {
        Logger.e("newToken: $token")
    }

    // 알림 구현 체
    private fun showNotification(title: String?, message: String?, deepLinkUrl: String) {
        val channelId = "fcm_default_channel"
        // NotiManager
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // 오레오 버전 이상부터 channelId 필수
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "FCM_NOTIFICATIONS", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        // 1. 딥링크를 처리할 Intent 생성
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLinkUrl)).apply {
            // 앱이 실행 중이 아닐 때, 새로운 태스크로 실행
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        // 2. PendingIntent 생성
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )


        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)    // PedingIntent 설정
            .setAutoCancel(true)        // 알림 클릭시 제거
            .build()

        notificationManager.notify(Random.nextInt(), notification)

    }
}