package barrera.alejandro.rickandmortyapp.core.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AdaptableColumn(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    bottomBarPadding: Dp = 0.dp,
    topBarPadding: Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    val landscapeOrientation = LocalConfiguration.current.orientation ==
            Configuration.ORIENTATION_LANDSCAPE

    Column(
        modifier = if (landscapeOrientation) {
            modifier
                .padding(
                    top = topBarPadding,
                    bottom = bottomBarPadding
                )
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        } else {
            modifier
                .padding(
                    top = topBarPadding,
                    bottom = bottomBarPadding
                )
                .fillMaxSize()
        },
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        content()
    }
}