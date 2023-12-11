package al.misn.trucklogistics.useCases

import al.misn.trucklogistics.data.User
import al.misn.trucklogistics.repository.Repository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class BoardingUseCase  @Inject constructor(private val repository: Repository){

     fun getData(): Observable<List<User>> {
        return repository.getData()
    }

    suspend fun insertDataToUser(user: User){
        return repository.insertDataToUser(user)
    }
}