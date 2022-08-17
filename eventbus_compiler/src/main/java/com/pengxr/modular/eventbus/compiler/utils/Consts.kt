package com.pengxr.modular.eventbus.compiler.utils

/**
 * Some consts used in processors
 * <p>
 * Created by pengxr on 10/8/2022
 */

// Generate
const val SEPARATOR: String = "$$"
const val PROJECT = "ModularEventBus"
const val TAG = "$PROJECT::"

const val PACKAGE_OF_GENERATE_FILE = "com.pengxr.modular.eventbus.generated.events"
const val PACKAGE_OF_GENERATE_DOCS = "com.pengxr.modular.eventbus.generated.docs"

private const val FACADE_PACKAGE = "com.pengxr.modular.eventbus.facade"
private const val TEMPLATE_PACKAGE = ".template"
private const val LAUNCHER_PACKAGE = ".launcher"

const val FACADE_MODULAR_EVENT_BUS = "$FACADE_PACKAGE$LAUNCHER_PACKAGE.ModularEventBus"

// Template class
const val INTERFACE_IEVENT_GROUP = "$FACADE_PACKAGE$TEMPLATE_PACKAGE.IEventGroup"
const val INTERFACE_IEVENT = "$FACADE_PACKAGE$TEMPLATE_PACKAGE.IEvent"

const val VOID = "java.lang.Void"
const val SUPPRESS_WARNINGS = "java.lang.SuppressWarnings"

// Log
const val PREFIX_OF_LOGGER = "$PROJECT::Compiler "
const val NO_MODULE_NAME_TIPS = "Module name needed for generating doc at 'build.gradle', like :\n" +
        "android {\n" +
        "    defaultConfig {\n" +
        "        ...\n" +
        "        javaCompileOptions {\n" +
        "            annotationProcessorOptions {\n" +
        "                arguments = [MODULAR_EVENTBUS_GENERATE_DOC: \"enable\"]\n," +
        "                arguments = [MODULAR_EVENTBUS_MODULE_NAME: project.getName()]\n" +
        "            }\n" +
        "        }\n" +
        "    }\n" +
        "}\n"

// Options of processor
const val KEY_GENERATE_DOC = "MODULAR_EVENTBUS_GENERATE_DOC"
const val KEY_MODULE_NAME = "MODULAR_EVENTBUS_MODULE_NAME"

const val VALUE_ENABLE = "enable"

