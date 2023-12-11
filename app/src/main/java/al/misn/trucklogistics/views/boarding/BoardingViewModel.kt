package al.misn.trucklogistics.views.boarding

import al.misn.trucklogistics.data.User
import al.misn.trucklogistics.useCases.BoardingUseCase
import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardingViewModel @Inject constructor(
    private val useCase: BoardingUseCase
) : ViewModel() {



    private val userDataSubject: BehaviorSubject<List<User>> = BehaviorSubject.create()


    @SuppressLint("CheckResult")
    fun fetchData(): io.reactivex.rxjava3.core.Observable<List<User>> {
        useCase.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { users -> userDataSubject.onNext(users) },
                { error -> /* Handle error */ }
            )
        return userDataSubject.hide()
    }

    fun onClick(){
        Log.d("TAG", "onClick: ")
    }
    fun insertDataToUserWithParameters(user: User) {

        Log.d("clicked", "clicked")
        viewModelScope.launch {

            insertDataToUser(user)

        }
    }
    suspend fun insertDataToUser(user: User){
        return useCase.insertDataToUser(user)
    }




}