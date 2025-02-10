package com.surivalcoding.composerecipeapp.presentation.item

import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.surivalcoding.composerecipeapp.ui.AppColors

@OptIn(UnstableApi::class)
@Composable
fun VideoItem(
    videoUrl: String,
) {
    // 임시.. 추후 최상위로 올려야함
    val context = LocalContext.current

    // exoplayer 초기화
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    // dataSourceFactory
    val dataSourFactory = DefaultDataSource.Factory(context)

    // MediaSource
    val mediaSource = remember(videoUrl) {
        ProgressiveMediaSource
            .Factory(dataSourFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse(videoUrl)))
    }

    // Url 변경시마다 ExoPlayer 셋팅
    LaunchedEffect(mediaSource) {
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = false // 자동 재생 여부
    }


    // 생명 주기 종료시 ExoPlayer 메모리 해제
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(AppColors.black)
    ) {
        // AndroidView를 통한 Exoplayer 셋팅
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                    useController = true    // 컨트롤러 사용 여부
                }
            }
        )
    }


}