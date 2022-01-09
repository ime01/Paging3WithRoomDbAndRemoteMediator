package com.example.paging3withroomdbandremotemediator.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3withroomdbandremotemediator.data.remote.UnSplashApi
import com.example.paging3withroomdbandremotemediator.model.UnsplashImage
import com.example.paging3withroomdbandremotemediator.util.Constants.ITEMS_PER_PAGE


class SearchPagingSource(private val unsplashApi: UnSplashApi, private val query: String) : PagingSource<Int, UnsplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response = unsplashApi.searchImages(query = query, per_page = ITEMS_PER_PAGE)

            val endOfPaginationReached = response.images.isEmpty()

            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }

}
