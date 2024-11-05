package edu.iesam.dam2024.features.fragmenB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.dam2024.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentBeta : Fragment() {

    companion object {
        fun newInstance() = FragmentBeta()
    }

    private val viewModel: FragmentBetaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_fragment_beta, container, false)
    }
}