package idv.tungfanhall.common.model.common

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

fun NavDestination?.route(): String {
    return this?.route ?: ""
}

fun NavDestination?.isSelected(route: String) =
    this?.hierarchy?.any {
        it.route?.contains(route, true) ?: false
    } ?: false
