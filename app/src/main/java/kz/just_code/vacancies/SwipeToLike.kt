package kz.just_code.vacancies

import androidx.recyclerview.widget.RecyclerView


import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper




fun RecyclerView.swipeToLike(
    likeIconResId: Int,
    onLiked: (position: Int) -> Unit
) {
    val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (direction == ItemTouchHelper.LEFT) {
                val position = viewHolder.adapterPosition
                onLiked(position)
            }
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                if (dX < 0) {
                    val icon = ContextCompat.getDrawable(context, likeIconResId)
                    val itemView = viewHolder.itemView
                    val iconMargin = (itemView.height - icon?.intrinsicHeight!!) / 2
                    val iconLeft = itemView.right - iconMargin - icon.intrinsicWidth
                    val iconTop = itemView.top + (itemView.height - icon.intrinsicHeight) / 2
                    val iconRight = itemView.right - iconMargin
                    val iconBottom = iconTop + icon.intrinsicHeight
                    icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
                    icon.draw(c)
                }
            }
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    })

    itemTouchHelper.attachToRecyclerView(this)
}
