package es.babel.injection

import es.babel.data.manager.AndroidResourceManager
import es.babel.domain.manager.ResourceManager
import es.babel.domain.usecase.GetGamesUseCase
import es.babel.domain.usecase.GetTotalGamesUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
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

fun appDataInjection() = Kodein.Module(name = "AppDataModule") {

    bind<es.babel.domain.repository.Repository>() with singleton { es.babel.data.repository.Repository() }

    bind<GetGamesUseCase>() with provider { GetGamesUseCase(instance()) }

    bind<GetTotalGamesUseCase>() with provider { GetTotalGamesUseCase(instance()) }

    bind<ResourceManager>() with singleton { AndroidResourceManager(instance()) }
}