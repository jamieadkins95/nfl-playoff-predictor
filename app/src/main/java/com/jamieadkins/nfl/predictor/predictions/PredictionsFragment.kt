package com.jamieadkins.nfl.predictor.predictions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamieadkins.nfl.predictor.databinding.FragmentPredictionsBinding

class PredictionsFragment : Fragment() {

    private var binding: FragmentPredictionsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val newBinding = FragmentPredictionsBinding.inflate(inflater, container, false)
        binding = newBinding
        return newBinding.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
