package barrera.alejandro.rickandmortyapp.feature_explore.data.mappers

import androidx.paging.PagingData
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class PagingDataMappersTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `pagingData collectData returns data list`() = runTest {
        val expectedData = listOf(1, 2, 3, 4)
        val pagingData = PagingData.from(listOf(1, 2, 3, 4))
        val result = pagingData.collectData(StandardTestDispatcher(testScheduler))

        Truth.assertThat(result).isEqualTo(expectedData)
    }
}