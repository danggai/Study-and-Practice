package danggai.app.basiclayoutsincomposesample.layout

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun GuideConstraintLayoutContent() {
    ConstraintLayout (modifier = Modifier.size(200.dp)) {
        val (text1, text2) = createRefs()

        val guideLineFromTop5f = createGuidelineFromTop(0.5f)
        val guideLineFromTop20dp = createGuidelineFromTop(20.dp)
        val guideLineFromEnd20dp = createGuidelineFromEnd(20.dp)

        Text(
            "50% from top",
            modifier = Modifier.constrainAs(text1) {
                top.linkTo(guideLineFromTop5f)
            }
        )

        Text(
            "Top 20dp End 20dp",
            modifier = Modifier.constrainAs(text2) {
                top.linkTo(guideLineFromTop20dp)
                end.linkTo(guideLineFromEnd20dp)
            }
        )

    }
}