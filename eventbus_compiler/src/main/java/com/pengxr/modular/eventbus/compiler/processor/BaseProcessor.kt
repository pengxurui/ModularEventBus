package com.pengxr.modular.eventbus.compiler.processor

import com.pengxr.modular.eventbus.compiler.utils.*
import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import java.io.IOException
import java.io.Writer
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Filer
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.StandardLocation

/**
 * Base Processor
 * <p>
 * Created by pengxr on 10/8/2022
 */
abstract class BaseProcessor : AbstractProcessor() {

    /**
     * File Generator.
     */
    lateinit var mFiler: Filer

    /**
     * Logger helper.
     */
    lateinit var logger: Logger

    /**
     * Type information helper.
     */
    lateinit var types: Types

    /**
     * Element helper.
     */
    lateinit var elementUtils: Elements

    /**
     * Writer used for write event doc.
     */
    var docWriter: Writer? = null

    /**
     * Generate event doc or not.
     */
    var generateDoc = false

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)

        mFiler = processingEnv.filer
        types = processingEnv.typeUtils
        elementUtils = processingEnv.elementUtils
        logger = Logger(processingEnv.messager)
        logger.info("ModularEventBus APT processor init");
        // Attempt to get user configuration [MODULAR_EVENTBUS_GENERATE_DOC] and [MODULAR_EVENTBUS_MODULE_NAME]
        var optionGenerateDoc = false
        var optionModuleName: String? = ""
        val options = processingEnv.options
        if (!options.isNullOrEmpty()) {
            optionGenerateDoc = VALUE_ENABLE == options[KEY_GENERATE_DOC]
            optionModuleName = options[KEY_MODULE_NAME]
        }

        generateDoc = optionGenerateDoc

        if (generateDoc) {
            if (optionModuleName.isNullOrEmpty()) {
                // Module name needed for generating doc.
                logger.error(NO_MODULE_NAME_TIPS)
                throw RuntimeException("$PREFIX_OF_LOGGER >>> No module name, for more information, look at gradle log.")
            }

            docWriter = try {
                mFiler.createResource(StandardLocation.SOURCE_OUTPUT, PACKAGE_OF_GENERATE_DOCS, "eventgroup-of-$optionModuleName.json").openWriter()
            } catch (e: IOException) {
                logger.error("Create doc writer failed, because " + e.message)
                null
            }
        }
    }

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latestSupported();

    override fun getSupportedOptions(): MutableSet<String> = hashSetOf(
        KEY_GENERATE_DOC,
        KEY_MODULE_NAME
    )

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return hashSetOf(
            EventGroup::class.java.canonicalName,
        )
    }
}