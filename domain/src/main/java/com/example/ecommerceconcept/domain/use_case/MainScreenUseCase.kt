package com.example.ecommerceconcept.domain.use_case

import com.example.ecommerceconcept.data.model.main.MainModel
import com.example.ecommerceconcept.domain.repository.EcommerceRepository
import com.example.ecommerceconcept.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class MainScreenUseCase @Inject constructor(
    private val repository: EcommerceRepository
) {
    operator fun invoke() : Flow<Resource<MainModel>> = flow {
        try {
            emit(Resource.Loading())
            val dataMain = repository.getMainData()
            emit(Resource.Success(dataMain))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : java.io.IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}