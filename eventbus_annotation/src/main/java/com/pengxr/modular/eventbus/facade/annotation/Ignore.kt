package com.pengxr.modular.eventbus.facade.annotation

/**
 * The interface or method annotated with Ignore will not be processed. Sometimes you want to temporarily disable
 * processor in a single interface or method, you can use this annotation.
 * <p>
 * Tips: Use AnnotationRetention.BINARY to make it not be removed when the code is minified at build time.
 * <p>
 * Created by pengxr on 15/8/2022
 */
@kotlin.annotation.Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class Ignore
