package com.example.customseekbar

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.customseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var reAdapter:NewRecyclerAdapter = NewRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intArray = resources.getIntArray(R.array.progressGradientColors)
        binding.seekArc.setProgressGradient(*intArray)

        /*binding.seekArc.setSplitTrack(false);
        binding.seekArc.getThumb().mutate().setAlpha(0);*/

        binding.reItemTest.adapter = reAdapter
        binding.reItem2.adapter = reAdapter

        binding.mySeekBar.progress = 0
        binding.mySeekBar.max = 10

        binding.mySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    Log.d("mySeek", "$progress")
                    reAdapter.updateSelectionPosition(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }
}