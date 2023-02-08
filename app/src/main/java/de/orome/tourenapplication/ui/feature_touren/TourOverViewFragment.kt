package de.orome.tourenapplication.ui.feature_touren

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import de.orome.tourenapplication.R
import de.orome.tourenapplication.databinding.FragmentTourOverviewBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TourOverViewFragment : Fragment() {

    private var _binding: FragmentTourOverviewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTourOverviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.buttonStartTour.setOnClickListener {
            val dFragment = NewTourStartFragment()
            dFragment.show(childFragmentManager,"Test")
            //findNavController().navigate(R.id.action_TourenOverviewFragment_to_newTourStartFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}