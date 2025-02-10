package com.surivalcoding.composerecipeapp.util

import com.google.firebase.messaging.FirebaseMessaging
import javax.inject.Inject
import javax.inject.Singleton


// 토큰 발급을 관리 하는 매니저 -> 등록된 토큰을 가져옴
@Singleton
class FirebaseTokenManager @Inject constructor(
    private val firebaseMessaging: FirebaseMessaging
) {
    fun getToken(onTokenReceived: (String?) -> Unit) {
        // 실패하거나 성공할시에
        firebaseMessaging.token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onTokenReceived(task.result)
            } else {
                onTokenReceived(null)
            }
        }
    }
}