package com.example.wearcomposebug.presentation

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.wear.compose.material.PositionIndicatorState
import androidx.wear.compose.material.PositionIndicatorVisibility

class RootPositionIndicatorState(
    private val lazyListState: LazyListState
) : PositionIndicatorState {

    override val positionFraction: Float
        get() {
            val itemsCount = lazyListState.layoutInfo.totalItemsCount
            return when {
                itemsCount > 0 -> {
                    val firstVisibleIndex = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.index ?: 0
                    val firstVisibleIndexIncorrect = lazyListState.firstVisibleItemIndex
                    val firstItemOffset = lazyListState.firstVisibleItemScrollOffset.toFloat()
                    val totalScrollableSpace = lazyListState.layoutInfo.totalItemsCount - lazyListState.layoutInfo.visibleItemsInfo.size

                    Log.d("PositionIndicatorState", "positionFraction: firstVisibleIndex = $firstVisibleIndex, firstVisibleIndexIncorrect = $firstVisibleIndexIncorrect), firstItemOffset = $firstItemOffset")

                    if (totalScrollableSpace > 0) {
                        (firstVisibleIndex + firstItemOffset / lazyListState.layoutInfo.viewportEndOffset) / totalScrollableSpace
                    } else {
                        1f
                    }
                }
                else -> 1f
            }
        }

    override fun sizeFraction(scrollableContainerSizePx: Float): Float {
        return 0.2f
    }

    override fun visibility(scrollableContainerSizePx: Float): PositionIndicatorVisibility {
        return PositionIndicatorVisibility.Show
    }
}