package danggai.app.basiclayoutsincomposesample.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import danggai.app.basiclayoutsincomposesample.ui.theme.BasicLayoutsInComposeSampleTheme

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout (modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)) {
        val (button1, button2, text) = createRefs()

        createHorizontalChain(button1, button2, chainStyle = ChainStyle.Packed(0.8f)) // SpreadInside, Spread, Packed

        Button(
            onClick = { },
            modifier = Modifier.padding(8.dp).constrainAs(button1) {
                top.linkTo(parent.top, margin = 8.dp)
            }
        ) {
            Text("Button 1")
        }

        Button(
            onClick = { },
            modifier = Modifier.padding(8.dp).constrainAs(button2) {
                top.linkTo(parent.top, margin = 8.dp)
            }
        ) {
            Text("Button 2")
        }

        Text(
            "ChainStyle.Packed(0.8f)",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button1.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)
            }
        )
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    BasicLayoutsInComposeSampleTheme() {
        ConstraintLayoutContent()
    }
}