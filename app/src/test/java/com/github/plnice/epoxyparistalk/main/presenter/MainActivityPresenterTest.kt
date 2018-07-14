package com.github.plnice.epoxyparistalk.main.presenter

import com.github.plnice.epoxyparistalk.main.MainActivityMvp
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.*
import com.github.plnice.epoxyparistalk.util.TrampolineSchedulersProvider
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.joda.time.LocalDate
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainActivityPresenterTest {

    @Mock
    lateinit var fetcher: MainActivityMvp.Fetcher

    @Mock
    lateinit var view: MainActivityMvp.View

    private lateinit var presenter: MainActivityPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainActivityPresenter(fetcher, view, DataTransformer(), TrampolineSchedulersProvider())
    }

    @Test
    fun `Should parse data and pass to view`() {
        val data = Data(listOf(DataItem(id = 0, date = LocalDate(2018, 7, 1), text = "Test")))
        val expectedListItems = listOf(ListItem(id = 0, title = "Test", subtitle = "niedziela, 1 lipca 2018"))

        whenever(fetcher.getData()).thenReturn(Flowable.just(data))
        whenever(view.listItemClicks()).thenReturn(Flowable.empty())

        presenter.start()

        verify(view).setListItems(expectedListItems)
    }

    @Test
    fun `Should show toast on list item click`() {
        whenever(fetcher.getData()).thenReturn(Flowable.empty())
        whenever(view.listItemClicks()).thenReturn(Flowable.just(1))

        presenter.start()

        verify(view).showToast("1")
    }

}
