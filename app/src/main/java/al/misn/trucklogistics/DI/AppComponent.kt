package al.misn.trucklogistics.DI

import al.misn.trucklogistics.repository.Repository
import al.misn.trucklogistics.views.boarding.BoardingViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {


    fun inject(viewModel: BoardingViewModel) // Inject your ViewModel here
    fun inject(repository: Repository)
}