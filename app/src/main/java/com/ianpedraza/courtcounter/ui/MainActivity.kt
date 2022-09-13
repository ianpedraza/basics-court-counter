package com.ianpedraza.courtcounter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.courtcounter.databinding.ActivityMainBinding
import com.ianpedraza.courtcounter.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: CourtCounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btn1PointsTeamA.setOnClickListener { viewModel.countTeamA(1) }
            btn2PointsTeamA.setOnClickListener { viewModel.countTeamA(2) }
            btn3PointsTeamA.setOnClickListener { viewModel.countTeamA(3) }

            btn1PointsTeamB.setOnClickListener { viewModel.countTeamB(1) }
            btn2PointsTeamB.setOnClickListener { viewModel.countTeamB(2) }
            btn3PointsTeamB.setOnClickListener { viewModel.countTeamB(3) }

            btnReset.setOnClickListener { viewModel.reset() }
        }

        viewModel.scoreTeamA.observe(this) { score ->
            score?.let {
                binding.tvScoreTeamA.text = score.toString()
            }
        }

        viewModel.scoreTeamB.observe(this) { score ->
            score?.let {
                binding.tvScoreTeamB.text = score.toString()
            }
        }
    }
}