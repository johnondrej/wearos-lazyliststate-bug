package com.example.wearcomposebug.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.PositionIndicatorAlignment
import androidx.wear.compose.material.PositionIndicatorState

@Composable
fun DefaultPositionIndicator(positionIndicatorState: PositionIndicatorState) {
    PositionIndicator(
        state = positionIndicatorState,
        indicatorHeight = indicatorHeight.dp,
        indicatorWidth = indicatorWidth.dp,
        paddingHorizontal = paddingHorizontal.dp,
        position = position
    )
}

private const val indicatorHeight = 50
private const val indicatorWidth = 4
private const val paddingHorizontal = 5
private val position = PositionIndicatorAlignment.End
