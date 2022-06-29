package danggai.app.basiclayoutsincomposesample.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun BarrierConstraintLayoutContent() {
    ConstraintLayout (modifier = Modifier.size(height = 100.dp, width = 300.dp)) {
        val (text1, text2, text3) = createRefs()

        createVerticalChain(text1, text2, chainStyle = ChainStyle.Spread)

        val endBarrier = createEndBarrier(text1, text2)

        Text(
            "long text 1",
            modifier = Modifier.constrainAs(text1) { }
        )

        Text(
            "text 2",
            modifier = Modifier.constrainAs(text2) { }
        )

        Text(
            "End of text 1,2",
            modifier = Modifier.constrainAs(text3) {
                start.linkTo(endBarrier)
                centerVerticallyTo(parent)
            }
        )

    }
}