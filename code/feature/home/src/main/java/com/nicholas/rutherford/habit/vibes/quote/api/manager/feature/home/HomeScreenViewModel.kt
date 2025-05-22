package com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Upload
import androidx.lifecycle.ViewModel
import com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources.R
import com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources.StringResources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeScreenViewModel(
    private val navigation: HomeScreenNavigation,
    private val stringResources: StringResources
) : ViewModel() {

    internal val homeMutableStateFlow = MutableStateFlow(value = HomeScreenState(items = buildCategorizedHomeItems()))
    val homeStateFlow = homeMutableStateFlow.asStateFlow()

    fun groupItemsByCategory(labels: List<String>): Map<String, List<HomeItem>> {
        return labels.map { label ->
            when {
                label.contains(stringResources.getString(R.string.fetch), ignoreCase = true) -> HomeItem(label = label, category = stringResources.getString(R.string.fetch_category), icon = Icons.Default.CloudDownload)
                label.contains(stringResources.getString(R.string.post), ignoreCase = true) -> HomeItem(label = label, category = stringResources.getString(R.string.post_category), icon = Icons.Default.Upload)
                label.contains(stringResources.getString(R.string.delete), ignoreCase = true) -> HomeItem(label = label, category = stringResources.getString(R.string.delete_category), icon = Icons.Default.Delete)
                else -> HomeItem(label = label, category = stringResources.getString(R.string.other_category), icon = Icons.AutoMirrored.Filled.Help)
            }
        }.groupBy { it.category }
    }

    fun buildCategorizedHomeItems(): Map<String, List<HomeItem>> {
        val labels = listOf(
            R.string.delete_a_quote,
            R.string.delete_a_pending_quote,
            R.string.fetch_all_quotes,
            R.string.fetch_all_pending_quotes,
            R.string.fetch_quote_by_title,
            R.string.fetch_pending_quote_by_title,
            R.string.fetch_a_random_quote,
            R.string.post_one_quote,
            R.string.post_one_pending_quote,
            R.string.post_multiple_quotes,
            R.string.post_multiple_pending_quotes,
            R.string.promote_a_pending_quote
        ).map { id -> stringResources.getString(id = id) }

        return groupItemsByCategory(labels = labels)
    }

    fun onItemClicked() {
        navigation.navigateToSettings()
    }
}