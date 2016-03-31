package org.seniorsigan.mangareader

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.jetbrains.anko.find
import org.seniorsigan.mangareader.adapters.ImagePageAdapter

class ChapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter)

        val view = find<ViewPager>(R.id.chapter_view)
        val pages = intent.getStringArrayExtra(SHARED_URL).toList().filterNotNull()
        view.adapter = ImagePageAdapter(pages, applicationContext)
    }
}