package com.pengxr.modular.eventbus.facade.annotation

/**
 * __   __  _____               ____    _____    ______   _   _    _____
 * \ \ / / |_   _|     /\      / __ \  |  __ \  |  ____| | \ | |  / ____|
 *  \ V /    | |      /  \    | |  | | | |__) | | |__    |  \| | | |  __
 *   > <     | |     / /\ \   | |  | | |  ___/  |  __|   | . ` | | | |_ |
 *  / . \   _| |_   / ____ \  | |__| | | |      | |____  | |\  | | |__| |
 * /_/ \_\ |_____| /_/    \_\  \____/  |_|      |______| |_| \_|  \_____|
 *
 * Annotation used to define a group of event.
 * <p>
 * Created by pengxr on 10/8/2022
 */
@kotlin.annotation.Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class EventGroup(

    /**
     * Define module name, use package name if empty.
     */
    val moduleName: String = "",

    /**
     * Define autoClear flag, use false if empty.
     */
    val autoClear: Boolean = false
)