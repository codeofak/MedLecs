package com.acode.medlecs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acode.lectureslist.viewModel.LectureViewModel
import com.acode.medlecs.ui.theme.MedLecsTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedLecsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    val lectureViewModel: LectureViewModel by viewModels()
                    Lectures(lectureViewModel = lectureViewModel)
                }
            }
        }
    }
}

@Composable
fun Lectures(lectureViewModel: LectureViewModel){
    val list = lectureViewModel.lecturesList.collectAsState()
    
    LazyColumn(){
        items(list.value){
            
            LecRow(text = it.title)
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun LecRow(text:String){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center)
        {

            Text(
                text = text,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Italic
            )
        }
        
    }
}













