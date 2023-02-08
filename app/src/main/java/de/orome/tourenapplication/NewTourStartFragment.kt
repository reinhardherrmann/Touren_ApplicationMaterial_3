package de.orome.tourenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import de.orome.tourenapplication.databinding.FragmentTourNewStartBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewTourStartFragment : DialogFragment() {

    private var _binding: FragmentTourNewStartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTourNewStartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNewTourCancel.setOnClickListener {
            dismiss()
        }

        binding.btnNewTourStep1Weiter.setOnClickListener {
            val tourNr = binding.etTourNummer.text
            Snackbar.make(binding.root,"TourNummer: $tourNr",Snackbar.LENGTH_LONG).show()
            dismiss()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}