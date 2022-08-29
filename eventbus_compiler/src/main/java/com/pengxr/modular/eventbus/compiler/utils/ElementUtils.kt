package com.pengxr.modular.eventbus.compiler.utils

import javax.lang.model.element.ExecutableElement
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror

/**
 * Element helper.
 * <p>
 * Created by pengxr on 16/8/2022
 */
/**
 * Check if the element is annotated with Nullable, return true if empty annotation.

 * This function will checkout the follow annotation:
 *
 * org.jetbrains.annotations.Nullable - return true
 * android.annotation.Nullable        - return true
 * androidx.annotation.Nullable       - return true
 *
 * org.jetbrains.annotations.NotNull  - return false
 * android.annotation.NonNull         - return false
 * androidx.annotation.NonNull        - return false
 *
 * else                               - return true
 *
 * @return nullable or not.
 */
fun ExecutableElement.isAnnotatedWithNullable(): Boolean {
    for (annotation in annotationMirrors) {
        return when (annotation.toString()) {
            "@org.jetbrains.annotations.Nullable" -> true
            "@android.annotation.Nullable" -> true
            "@androidx.annotation.Nullable" -> true
            "@org.jetbrains.annotations.NotNull" -> false
            "@android.annotation.NonNull" -> false
            "@androidx.annotation.NonNull" -> false
            else -> continue
        }
    }
    return true
}

/**
 * Check if the type is equals to void, return true if empty annotation.
 *
 * void in Java      - return true
 * Void in Java      - return true
 *
 * [empty] in Kotlin - return true
 * Unit in Kotlin    - return true
 * Unit? in Kotlin   - return true
 *
 * else - return false
 *
 * @return void or not.
 */
fun TypeMirror.isVoidReturnType():Boolean{
    return kind == TypeKind.VOID || toString() == "kotlin.Unit"
}