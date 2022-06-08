package com.example.navigationexersice

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.navigationexersice.fragments.MainFragment
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTests {

    @Test
    private fun navigate_to_box_nav_component(){
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val mainFragmentScenario = launchFragmentInContainer<MainFragment>(themeResId = R.style.Theme_NavigationExersice)

        mainFragmentScenario.onFragment{ fragment ->
            navController.setGraph(R.id.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.btnOpenGreenBox))
            .perform(click())

        assertEquals(navController.currentDestination?.id, R.id.boxFragment)
    }
}