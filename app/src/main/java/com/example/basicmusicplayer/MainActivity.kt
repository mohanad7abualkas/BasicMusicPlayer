package com.example.basicmusicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicmusicplayer.Composables.ArtistItems
import com.example.basicmusicplayer.Composables.MusicItems
import com.example.basicmusicplayer.Composables.PlaySampleAudio
import com.example.basicmusicplayer.ui.theme.BasicMusicPlayerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicMusicPlayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    val state = rememberLazyListState()
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(fraction = 0.85f)
                            .padding(8.dp),
                        state = state
                    ) {
                        item {
                            Text(
                                text = "Artists",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        item {
                            LazyRow(modifier = Modifier.fillMaxWidth()) {
                                items(count = 10) {
                                    ArtistItems()
                                }
                            }
//                            PlaySampleAudio(context = LocalContext.current)
                        }
                        item {
                            Text(
                                text = "Songs",
                                fontSize = 24.sp,
                                fontWeight = Bold,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                        items(count = 10) {
                            MusicItems()
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 22.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    PlaySampleAudio(context = LocalContext.current)
                }
            }
        }
    }
}


