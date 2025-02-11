package com.surivalcoding.composerecipeapp.presentation.item

import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
import coil3.compose.rememberAsyncImagePainter
import com.surivalcoding.composerecipeapp.ui.AppColors

@OptIn(UnstableApi::class)
@Composable
fun VideoItem(
    videoUrl: String,
    image: String
) {
    // 임시.. 추후 최상위로 올려야함
    val context = LocalContext.current

    // exoplayer 초기화
    val exoPlayer = remember { ExoPlayer.Builder(context).build() }

    // dataSourceFactory
    val dataSourFactory = DefaultDataSource.Factory(context)

    var isPlaying by remember { mutableStateOf(false) }

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

        if (isPlaying) {
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
        } else {
            // 비디오의 프리뷰 이미지
            Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = "Video Preview",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            // 플레이 버튼
            IconButton(
                onClick = {
                    isPlaying = true // 비디오 재생 시작
                    // 이미지 클릭 시 바로 비디오 재생
                    exoPlayer.playWhenReady = true
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = AppColors.white
                )
            }
        }
    }
}