package com.example.hanumanchalisa.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hanumanchalisa.R
import com.example.hanumanchalisa.ui.theme.BlueText
import com.example.hanumanchalisa.ui.theme.GreyishOrange
import com.example.hanumanchalisa.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    val hanumanChalisa = stringArrayResource(R.array.hanuman_chalisa)

    //val count = remember { mutableStateOf(0) };
    var count by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { CustomTopAppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GreyishOrange)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            HanumanChalisaText(count,hanumanChalisa)
            Spacer(modifier = Modifier.weight(1f))
            Buttons(
                onPrevClick = {if (count>0) count--
            },
                onNextClick = {
                    if (count<hanumanChalisa.size-1) {
                        count++
                    }
        })

            println( "count : $count")
            println("hanumanChalisa.size : ${hanumanChalisa.size}")
        }
    }
}

@Composable
fun HanumanChalisaText(count:Int,hanumanChalisa:Array<String>)
{
    if (count==0 || count==hanumanChalisa.size-1)
    {
        Text(text="दोहा",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }
    else
    {
        Text("चौपाई",
                modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }

    Spacer(modifier = Modifier.padding(24.dp))


Text(hanumanChalisa[count],
    modifier = Modifier.fillMaxWidth(),
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 29.sp)
}

@Composable
fun Buttons(onPrevClick:()->Unit,
            onNextClick:()->Unit)
{
   Row(modifier = Modifier
       .fillMaxWidth()
       .padding(start = 32.dp, end = 32.dp, bottom = 16.dp)
   ) {

       Button(onClick = { onPrevClick() },
           modifier = Modifier,
           colors = ButtonDefaults.buttonColors(containerColor = Orange)) {
       Text(text = "Previous",
           modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
               fontSize = 20.sp)
   }

       Spacer(modifier = Modifier.weight(1f))

       Button(onClick = { onNextClick() },
           modifier = Modifier,
           colors = ButtonDefaults.buttonColors(containerColor = Orange),
           ) {
           Text(text = "Next",
               modifier = Modifier.padding(5.dp),
               fontSize = 20.sp)
       }
   }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "हनुमान चालीसा ",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 26.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Orange,
            titleContentColor = BlueText
        )
    )
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(paddingValues = PaddingValues(0.dp))
}
