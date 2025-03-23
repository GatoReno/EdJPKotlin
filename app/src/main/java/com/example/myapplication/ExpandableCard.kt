package com.example.myapplication


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha
import com.example.myapplication.ui.theme.Shapes

@Preview
@Composable
fun ExpandableCard() {
    var expandableState = remember { mutableStateOf(false) }
    var rotationValue = animateFloatAsState(targetValue = if (expandableState.value) 180f else 0f)
    Card(modifier = Modifier
        //.fillMaxSize()
        .padding(10.dp)
        .animateContentSize(
            animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        ), shape = Shapes.medium,
        onClick = {
            expandableState.value = !expandableState.value
        }
    ) {
        Column(
            modifier = Modifier
                //.fillMaxSize()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(6f), text = "MyText",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationValue.value),
                    onClick = { expandableState.value = !expandableState.value }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop down arrow"
                    )
                }
                if (expandableState.value) {
                    Text(text = "okdoewkd doeod ewdew wdowdwod dwiodojhdw wdjwodwodd" +
                    "deopdoekdoek okde doked doekdeod edokedoke okd eodeokd okwd hewd ewdoihwd."
                    )
                }
            }
        }
    }
}
