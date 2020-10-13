package es.babel.easymvvm.presentation.injection

import android.app.Activity
import androidx.navigation.NavController
import es.babel.easymvvm.android.ui.EmaFragmentActivity
import es.babel.easymvvm.presentation.ui.MainActivityNavigator
import es.babel.easymvvm.presentation.ui.data.GameDataNavigator
import es.babel.easymvvm.presentation.ui.list.GamesListNavigator
import es.babel.easymvvm.presentation.ui.totalGames.TotalGamesNavigator
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */

fun activityInjection(activity: Activity) = Kodein.Module(name = "ActivityModule") {

    bind<Activity>() with singleton { activity }

    bind<MainActivityNavigator>() with singleton { MainActivityNavigator(instance()) }

    bind<NavController>() with singleton { (activity as EmaFragmentActivity).let { it.navController } }

    bind<GamesListNavigator>() with singleton { GamesListNavigator(instance()) }

    bind<GameDataNavigator>() with singleton { GameDataNavigator(instance()) }

    bind<TotalGamesNavigator>() with singleton { TotalGamesNavigator(instance()) }

}