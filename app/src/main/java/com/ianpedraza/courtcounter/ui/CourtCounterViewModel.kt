package com.ianpedraza.courtcounter.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CourtCounterViewModel : ViewModel() {

    private val _scoreTeamA = MutableLiveData<Int>()
    val scoreTeamA: LiveData<Int> = _scoreTeamA

    private val _scoreTeamB = MutableLiveData<Int>()
    val scoreTeamB: LiveData<Int> = _scoreTeamB

    fun countTeamA(increment: Int) {
        if (_scoreTeamA.value == null) {
            _scoreTeamA.value = increment
        } else {
            _scoreTeamA.value = _scoreTeamA.value!!.plus(increment)
        }
    }

    fun countTeamB(increment: Int) {
        if (_scoreTeamB.value == null) {
            _scoreTeamB.value = increment
        } else {
            _scoreTeamB.value = _scoreTeamB.value!!.plus(increment)
        }
    }

    fun reset() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }

}