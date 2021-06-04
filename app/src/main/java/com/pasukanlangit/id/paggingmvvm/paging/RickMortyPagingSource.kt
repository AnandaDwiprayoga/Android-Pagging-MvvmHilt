package com.pasukanlangit.id.paggingmvvm.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pasukanlangit.id.paggingmvvm.api.ApiService
import com.pasukanlangit.id.paggingmvvm.models.ResultsItem
import java.lang.Exception

class RickMortyPagingSource(private val apiService: ApiService) : PagingSource<Int, ResultsItem>() {
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        return try{
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<ResultsItem>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}