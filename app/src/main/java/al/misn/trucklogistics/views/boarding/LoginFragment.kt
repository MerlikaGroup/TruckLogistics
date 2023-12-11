package al.misn.trucklogistics.views.boarding

import al.misn.trucklogistics.data.User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import al.misn.trucklogistics.R
import al.misn.trucklogistics.databinding.FragmentLoginBinding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private val viewModel: BoardingViewModel by activityViewModels()


    // Make sure userData is nullable
    var userData: al.misn.trucklogistics.data.dataDTO.User? = null

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the binding layout
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        binding.viewModel = viewModel;

        val user = User(username = "kkk", email = "sdfsdf")

        // Assuming you have initialized userData somewhere
        var UserData: al.misn.trucklogistics.data.dataDTO.User = al.misn.trucklogistics.data.dataDTO.User(username = "aaaa", email = "assddd")

        // Directly assign userData to binding.userData
        binding.userData = UserData


//        runBlocking() {
//            viewModel.insertDataToUser(User(username = "Login", email = "login@gmail.com"))
//
//        }
        return binding.root
    }
}
