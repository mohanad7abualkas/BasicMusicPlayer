package com.example.basicmusicplayer.Composables

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicmusicplayer.R

@Composable
fun MusicItems() {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.audio_icon),
            contentDescription = "Audio Icon",
            Modifier.size(40.dp)
        )

        Column(
            horizontalAlignment = Start,
            verticalArrangement = SpaceBetween,
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Text(text = "Song Title")
            Text(
                text = "Song Artist",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun ArtistItems() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.artist), contentDescription = "artist",
            modifier = Modifier
                .padding(all = 8.dp)
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(text = "Artist Name ")
    }
}

@Composable
fun PlaySampleAudio(context: Context) {

    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {

        val sampleSong: MediaPlayer by remember {
            mutableStateOf(
                MediaPlayer.create(context,R.raw.sample_song_audio)
            )
        }
        var isPlaying by remember {
            mutableStateOf(false)
        }

        Card(
            modifier = Modifier
                .padding(all = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Color.Gray),
                horizontalArrangement = SpaceBetween
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.audio_icon),
                        contentDescription = "audio_icon",
                        Modifier
                            .size(40.dp)
                            .padding(start = 4.dp)
                    )
                    Column(
                        horizontalAlignment = Start,
                        verticalArrangement = SpaceBetween,
                        modifier = Modifier.padding(all = 8.dp)
                    ) {
                        Text(text = "Sample Song")
                        Text(
                            text = "Artist",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )

                    }
                }

                // Control Button
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.previous_icon),
                        contentDescription = "Back Button",
                        Modifier.size(40.dp)
                    )
                    // Check
                    IconButton(onClick = {
                        if (isPlaying) {
                            isPlaying = false
                            sampleSong.pause()
                        } else {
                            isPlaying = true
                            sampleSong.start()
                        }
                    }) {
                        Icon(
                            painter = painterResource(
                                id =
                                if (isPlaying) R.drawable.pause_icon else R.drawable.play_icon
                            ),
                            contentDescription = "Play/pause icons",
                            Modifier.size(40.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.next_icon),
                        contentDescription = "next icon",
                        Modifier
                            .size(40.dp)
                            .padding(end = 4.dp)
                    )
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ItemsPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        ArtistItems()
        MusicItems()
        PlaySampleAudio(LocalContext.current)
    }

}