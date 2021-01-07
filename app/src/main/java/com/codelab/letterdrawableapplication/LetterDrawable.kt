package com.codelab.letterdrawableapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class LetterDrawable(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var cx = 0
    private var cy = 0
    private val d = 100
    val radius = 80f

    private var letter = "P"
    private val circlePaint: Paint = Paint().apply {
        Paint.ANTI_ALIAS_FLAG
        color = Color.GREEN
    }

    private val letterPaint: Paint = Paint().apply {
        Paint.ANTI_ALIAS_FLAG
        color = Color.BLACK
        textSize = 50F
        textAlign = Paint.Align.CENTER

    }

    private val textMathRect = Rect(cx - d, cy - d, cx + d, cy + d)
    val letterP = letterPaint.getTextBounds(letter, 0, 1, textMathRect)
    val letterT = textMathRect.height() / 2f

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(cx.toFloat(), cy.toFloat(), radius, circlePaint)
        canvas.drawText("POOJA", 0,2,cx.toFloat(), cy-40+80*2/3f, letterPaint)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)

        cx = width / 2
        cy = height / 2
    }


}