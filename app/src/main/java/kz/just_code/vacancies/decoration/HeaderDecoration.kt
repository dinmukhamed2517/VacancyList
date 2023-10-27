package kz.just_code.vacancies.decoration

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import androidx.core.view.children
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kz.just_code.vacancies.VacancyAdapter

class HeaderDecoration : ItemDecoration() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var currentBitmap: Bitmap? = null

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val holders = parent.children
            .map { parent.findContainingViewHolder(it) }
            .filter { it is VacancyAdapter.HeaderViewHolder }

        holders.forEach { it?.itemView?.alpha = 1f }

        val viewHolder = holders.firstOrNull()
        val viewY = viewHolder?.itemView?.y ?: 0f

        if (currentBitmap == null || viewY <= 0 && viewHolder != null) {
            val width = parent.width
            val height = parent.height
            currentBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(currentBitmap!!)
            viewHolder?.itemView?.draw(canvas)
        }

        val bitmapHeight = currentBitmap?.height ?: 0
        val bitmapOffset = if (viewY > 0 && viewY <= bitmapHeight) viewY - bitmapHeight
        else 0f

        viewHolder?.itemView?.alpha = if (viewY < 0f) 0f else 1f

        currentBitmap?.let {
            val left = 16f.dp // Adjust the left position as needed
            val top = bitmapOffset // Use the calculated offset
            val dstRect = Rect(left.toInt(), top.toInt(), left.toInt() + it.width, top.toInt() + it.height)
            c.drawBitmap(it, null, dstRect, paint)
        }
    }
}
