package com.al.mond.typer

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.*

object Typer {

    private val handler: Handler = Handler(Looper.myLooper()!!)
    private var loopRunnable: Runnable = Runnable {}

    fun typing(
        target: TextView,
        source: String,
        useCursor: Boolean = true,
        endCallback: () -> Unit = {}
    ) {
        val playList = StringSlicer.slice(source, useCursor)
        play(playList, target, useCursor, endCallback)
    }

    fun stop() {
        handler.removeCallbacks(loopRunnable)
    }

    fun erasing(textView: TextView,
                useCursor: Boolean = true,
                endCallback: () -> Unit = {}) {
        val playList = StringSlicer.slice(textView.text.toString(), useCursor)
        playList.add(0, "")
        playList.reverse()
        play(playList, textView, useCursor, endCallback)
    }

    private fun play(
        playList: MutableList<String>,
        textView: TextView,
        useCursor: Boolean,
        callback: () -> Unit = { }
    ) {
        val iterator = playList.iterator()
        handler.removeCallbacks(loopRunnable)
        loopRunnable = object : Runnable {
            var tic: String? = null
            var toc: String? = null
            override fun run() {
                val delayMillis = Random().nextInt(3) * 100L
                if (iterator.hasNext()) {
                    textView.text = iterator.next()
                    handler.postDelayed(this, delayMillis)
                    if (iterator.hasNext().not())
                        callback()
                } else {
                    if (useCursor) {
                        cursorLoop()
                        handler.postDelayed(this, 500)
                    } else {
                        handler.removeCallbacks(loopRunnable)
                    }
                }
            }

            private fun cursorLoop() {
                setCursorTicToc()
                if (textView.text.toString() == tic) {
                    textView.text = toc
                } else {
                    textView.text = tic
                }
            }

            private fun setCursorTicToc() {
                if (tic == null) {
                    tic = textView.text.toString()
                    toc = if (tic!!.isNotEmpty())
                        tic!!.removeRange(tic!!.lastIndex..tic!!.lastIndex)
                    else
                        "|"
                }
            }
        }
        loopRunnable.run()
    }


}

