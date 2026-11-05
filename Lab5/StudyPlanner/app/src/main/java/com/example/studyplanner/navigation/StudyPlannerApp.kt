
package com.example.studyplanner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.studyplanner.ui.PlannerHomeRoute
import com.example.studyplanner.ui.TaskDetailRoute

@Composable
fun StudyPlannerApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PlannerHome
    ) {
        composable<PlannerHome> {
            PlannerHomeRoute(
                onTaskClick = { title ->
                    navController.navigate(TaskDetail(title))
                }
            )
        }

        composable<TaskDetail> { backStackEntry ->
            val detail: TaskDetail = backStackEntry.toRoute()

            TaskDetailRoute(
                title = detail.title,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
