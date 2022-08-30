![](https://github.com/pengxurui/AndroidFamily/blob/master/images/Android_Banner.png)

<p align='center'>
  <a href="https://www.github.com/pengxurui" target="_blank">
    <img src="https://komarev.com/ghpvc/?username=pengxurui&style=flat&label=👁%20Views">
  </a>
  <a href="https://www.apache.org/licenses/LICENSE-2.0" target="_blank">
    <img src="https://img.shields.io/badge/license-Apache--2.0-informational.svg?style=flat">
  </a>
  <a href="https://android-arsenal.com/result?level=14" target="_blank">
    <img src="https://img.shields.io/badge/API-14+-brightgreen.svg?style=flat">
  </a>
</p>

<p align='center'>
  <a href="https://www.github.com/pengxurui" target="_blank">
    <img src="https://img.shields.io/badge/作者-@小彭-brightgreen.svg?style=flat&logo=GitHub">
  </a>
  <a href="https://github.com/pengxurui/Android-NoteBook/raw/master/images/搜一搜公众号.png" target="_blank">
    <img src="https://img.shields.io/badge/公众号-彭旭锐-brightgreen.svg?style=flat&logo=WeChat">
  </a>
  <a href="https://juejin.cn/user/1063982987230392" target="_blank">
    <img src="https://img.shields.io/badge/🔥%20juejin-掘金-blue.svg?style=flat">
  </a>
  <a href="https://www.zhihu.com/people/pengxurui" target="_blank">
    <img src="https://img.shields.io/badge/zhihu-知乎-informational.svg?style=flat&logo=Zhihu">
  </a>
  <a href="https://www.toutiao.com/c/user/token/MS4wLjABAAAAbY-k9r66YVymjlqMaaGZJO67hCNYaNGa7PCoisQYmR4" target="_blank">
    <img src="https://img.shields.io/badge/toutiao-头条-red.svg?style=flat">
  </a>
  <a href="https://www.cnblogs.com/pengxurui/" target="_blank">
    <img src="https://img.shields.io/badge/cnblogs-博客园-green.svg?style=flat">
  </a>
  <a href="https://blog.csdn.net/pengxurui?spm=1000.2115.3001.5343" target="_blank">
    <img src="https://img.shields.io/badge/csdn-CSDN-9cf.svg?style=flat">
  </a>
  <a href="" target="_blank">
    <img src="https://img.shields.io/badge/jianshu-简书-orange.svg?style=flat">
  </a>
</p>

## 为什么要使用 ModularEventBus？

大家好，我是小彭。ModularEventBus 是一款帮助 Android App 解决事件总线滥用问题的框架，亦可作为组件化基础设施。 **其解决方案是通过注解定义事件，由编译时 APT 注解处理器进行合法性检查和自动生成事件接口，以实现对事件定义、发布和订阅的强约束。**

<p align='center'>
  <a target="_blank" witth="300">
    <img width = "400" src="https://github.com/pengxurui/ModularEventBus/blob/main/images/ModularEventBusImage.png">
  </a>
</p>

### 最新版本

|模块|modular-eventbus-api|modular-eventbus-compiler|modular-eventbus-annotation|
|---|---|---|---|
|最新版本|[![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-api) | [![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-compiler/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-compiler) | [![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-annotation/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-annotation)

### Demo 展示

##### [Demo apk](https://github.com/pengxurui/ModularEventBus/tree/main/demo)

### 常见事件总线框架对比

以下从多个维度对比常见的事件总线框架（ ✅ 良好支持、☑ 支持、❌ 不支持）：

| 事件总线 | ModularEventBus | modular-event | SmartEventBus | LiveEventBus | LiveDataBus | EventBus | RxBus |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 开发者 | @彭旭锐 | @美团 | @JeremyLiao | @JeremyLiao | / | @greenrobot | / |
| Github Star | 0 | 未开源 | 146 | 3.4k | / | 24.1k | / |
| 生成事件文档 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 空数据拦截 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 无数据事件 | ☑ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 泛型事件 | ✅ | ❌ |  ☑ |  ☑ | ❌ | ❌ | ❌ |
| 自动清除空闲事件 | ✅ | ❌ | ✅ | ✅ | ❌ | ❌ | ❌ |
| 事件强约束 | ✅ | ☑ | ☑ | ❌ | ❌ | ❌ | ❌ |
| 生命周期感知 | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ |
| 延迟发送事件 | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ |
| 有序接收事件 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| 订阅 Sticky 事件 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| 清除 Sticky 事件 | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 移除事件 | ✅ | ❌ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 线程调度 | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 跨进程 / 跨 App | ❌（可支持） | ❌ | ✅ | ✅ | ❌ | ❌ | ❌ |
| 关键原理| APT+静态代理 | APT+动态代理| APT+静态代理 | LiveData | LiveData | APT | RxJava|

### ModularEventBus 特性一览

**1、事件强约束**

✅  支持零配置快速使用；

✅  支持 APT 注解处理器自动生成事件接口类；

✅  支持编译时合法性校验和警告提示；

✅  支持生成事件文档；

✅  支持增量编译；

**2、Lifecycle 生命周期感知**

✅  内置基于 `LiveData` 的 LiveDataBus；

✅  支持自动取消订阅，避免内存泄漏；

✅  支持安全地发送事件与接收事件，避免产生空指针异常或不必要的性能损耗；

✅  支持永久订阅事件；

✅  支持自动清除没有关联订阅者的空闲 `LiveData` 以释放内存；

**3、更多特性支持**

✅  支持 Java / Kotlin；

✅  支持 AndroidX；

✅  支持订阅 Sticky 粘性事件，支持移除事件；

✅  支持 Generic 泛型事件，如 `List<String>` 事件；

✅  支持拦截空数据；

✅  支持只发布事件不携带数据的无数据事件；

✅  支持延迟发送事件；

✅  支持有序接收事件。

## ModularEventBus 快速使用

- **1、添加依赖**

`模块级 build.gradle`

``` gradle
plugins {
    id 'com.android.application' // 或 id 'com.android.library'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
}
dependencies {
    // 替换成最新版本
    implementation 'io.github.pengxurui:modular-eventbus-api:x.x.x'
    kapt 'io.github.pengxurui:modular-eventbus-compiler:x.x.x'
    ...
}
```

- **2、定义事件数据类型（可选）：** 定义事件关联的数据类型，对于只发布事件而不需要携带数据的场景，可以不定义事件类型。

`UserInfo.kt`

```kotlin
data class UserInfo(val userName: String)
```

- **3、定义事件：** 使用接口定义事件名和事件数据类型，并使用 `@EventGroup` 注解修饰该接口：

`LoginEvents.kt`

```kotlin
@EventGroup
interface LoginEvents {

  // 事件名：login
  // 事件数据类型：UserInfo
  fun login(): UserInfo

  // 事件名：logout
  fun logout()
}
```

- **4、执行注解处理器：** 执行 `Make Project` 或 `Rebuild Project` 等多种方式都可以触发注解处理器，处理器将根据事件定义自动生成相应的事件接口。例如，`LoginEvents` 对应的事件类为：

`EventDefineOfLoginEvents.java`

```kotlin
/**
 * Auto generate code, do not modify!!!
 * @see com.pengxr.sampleloginlib.events.LoginEvents 
 */
@SuppressWarnings("unchecked")
public class EventDefineOfLoginEvents implements IEventGroup {
    private EventDefineOfLoginEvents() {
    }

    public static IEvent<UserInfo> login() {
        return (IEvent<UserInfo>) (ModularEventBus.INSTANCE.createObservable("com.pengxr.sampleloginlib.events.LoginEvents$$login", UserInfo.class, false, true));
    }

    public static IEvent<Void> logout() {
        return (IEvent<Void>) (ModularEventBus.INSTANCE.createObservable("com.pengxr.sampleloginlib.events.LoginEvents$$logout", Void.class, true, false));
    }
}
```

- **5、订阅事件：** 使用 `EventDefineOfLoginEvents` 事件类提供的静态方法订阅事件：

`订阅者示例`

```kotlin
// 以生命周期感知模式订阅事件（不需要手动注销订阅）
EventDefineOfLoginEvents.login().observe(this) { value: UserInfo? ->
    // Do something.
}

// 以永久模式订阅事件（需要手动注销订阅）
EventDefineOfLoginEvents.logout().observeForever { _: Void? ->
    // Do something.
}
```

- **6、发布事件：** 使用 `EventDefineOfLoginEvents` 提供的静态方法发布事件：

`发布者示例`

```kotlin
EventDefineOfLoginEvents.login().post(UserInfo("XIAOPENG"))

EventDefineOfLoginEvents.logout().post(null)
```

- **7、添加混淆规则（如果使用了 minifyEnabled true）：**

```
-dontwarn com.pengxr.modular.eventbus.generated.**
-keep class com.pengxr.modular.eventbus.generated.** { *; }
-keep @com.pengxr.modular.eventbus.facade.annotation.EventGroup class * {*;} # 可选
```

## 认识事件总线

### 事件总线的优点

事件总线框架最大的优点是 ”解耦“，即事件发布者与事件订阅者的解耦，事件的发布者不需要关心是否有人订阅该事件，也不需要关心是谁订阅该事件，代码耦合度较低。因此，事件总线框架更适合作为全局的事件通信方案，或者组件间通信的辅助方案。

### 事件总线的缺点

然而，成也萧何败萧何。有人觉得事件总线好用，亦有人觉得事件总线不好用，归根结底还是因为事件总线太容易被滥用了，用时一时爽，维护火葬场。我将事件总线框架存在的问题概括为以下 5 种常见问题：

- **1、消息难溯源：** 在阅读源码的过程中，如果需要查找发布事件或订阅事件的地方，只能通过查找事件引用的方式进行溯源，增大了理解代码逻辑的难度。特别是当项目中到处是临时事件时，难度会大大增加；

- **2、临时事件滥用：** 由于框架对事件定义没有强制约束，开发者可以随意地在项目的各个角落定义事件。导致整个项目都是临时事件飞来飞去，增大后期维护的难度；

- **3、数据类型转换错误：** LiveDataBus 等事件总线框架需要开发者手动输入事件数据类型，当订阅方与发送方使用不同的数据类型时，会发生类型转换错误。在发生事件命名冲突时，出错的概率会大大增加，存在隐患；

- **4、事件命名重复：** 由于框架对事件命名没有强制约束，不同组件有可能定义重名的事件，产生逻辑错误。如果重名的事件还使用了不同的数据类型，还会出现类型转换错误，存在隐患；

- **5、事件命名疏忽：** 与 ”事件命名重复“ 类似，由于框架对事件命名没有检查，有可能出现开发者复制粘贴后忘记修改事件变量值的问题，或者变量值拼写错误（例如 `login_success` 拼写为 `login_succese`），那么订阅方将永远收不到事件。

### ModularEventBus 的优点

ModularEventBus 组件化事件总线框架的优点： **在保持发布者与订阅者的解耦的优势下，解决上述事件总线框架中存在的通病。** 具体通过以下 5 个手段实现：

- **1、事件声明聚合：** 发布者和订阅者只能使用预定义的事件，严格禁止使用临时事件，事件需要按照约定聚合定义在一个文件中（解决临时事件滥用问题）；

- **2、区分不同组件的同名事件：** 在定义事件时需要指定事件所属 `moduleName`，框架自动使用 `"[moduleName]$$[eventName]"` 作为最终的事件名（解决事件命名重复问题）；

- **3、事件数据类型声明：** 在定义事件时需要指定事件的数据类型，框架自动使用该数据类型发送和订阅事件（解决数据类型转换错误问题）；

- **4、接口强约束：** 运行时使用事件类发布和订阅事件，框架自动使用事件定义的事件名和数据类型，而不需要手动输入事件名和数据类型（解决事件命名命名错误）；

- **5、APT 生成接口类：** 框架在编译时使用 APT 注解处理器自动生成事件接口类。

### 与美团 modular-event 对比有哪些什么不同？  

- **modular-event 使用静态常量定义事件，为什么 ModularEventBus 用接口定义事件？**
  
  美团 modular-event 使用常量引入了重复信息，存在不一致风险。例如开发者复制一行常量后，只修改常量名但忘记修改值，这种错误往往很难被发现。而 ModularEventBus 使用方法名作为事件名，方法返回值作为事件数据类型，不会引入重复信息且更加简洁。

`modular-event 事件定义`

<img width="700" alt="image" src="https://user-images.githubusercontent.com/25008934/187362798-5bdea631-8fca-426a-967f-beeca38c7e9a.png">

- **modular-event 使用动态代理，为什么 ModularEventBus 不需要？**
  
  美团 modular-event 使用动态代理 API 统一接管了事件的发布和订阅，但考虑到这部分代理逻辑非常简单（获取事件名并交给 LiveDataBus 完成后续的发布和订阅逻辑），且框架本身已经引入了编译时 APT 技术，完全可以在编译时生成这部分代理逻辑，没必要使用动态代理 API。

- **更多特性支持：** 
  
  此外 ModularEventBus 还支持生成事件文档、空数据拦截、泛型事件、自动清除空闲事件等特性。

## 完整使用文档

### 1、定义事件

- **使用注解定义事件：** 

  - **`@EventGroup` 注解：** `@EventGroup` 注解用于定义事件组，修饰于 interface 接口上，在该类中定义的每个方法均视为一个事件定义；
  
  - **`@Event` 注解：** `@Event` 注解用于事件组中的事件定义，亦可省略。

模板程序如下：

`com.pengxr.sample.events.MainEvents.kt`
```
// 事件组
@EventGroup
interface MainEvents {

    // 事件
    // @Event 可以省略
    @Event
    fun open(): String
}
```

> **提示：** 以上即定义了一个 `MainEvents` 事件组，其中包含一个 `com.pengxr.sample.events.MainEvents$$open` 事件且数据类型为 `String` 类型。

亦兼容将 `@EventGroup` 修饰于 class 类而非 interface 接口，但会有编译时警告： `Annotated @EventGroup on a class type [IllegalEvent], expected a interface. Is that really what you want？`

`错误示例`

```
@EventGroup
class IllegalEvent {

    fun illegalEvent() {

    }
}
```

- **使用 `@Ignore` 注解忽略定义：** 使用 `@Ignore` 注解可以排除事件类或事件方法，使其不被视为事件定义。

`示例程序`

```
// 可以修饰于事件组
@Ignore
@EventGroup
interface IgnoreEvent {

    // 亦可修饰于事件
    @Ignore
    fun ignoredMethod()

    fun method()
}
```

- **使用 `@Deprecated` 注解提示过时：** 使用 `@Deprecated` 注解可以标记事件为过时。与 `@Ignore` 不同是，`@Deprecated` 修饰的类或方法依然是有效的事件定义。

`示例程序`

```
// 虽然过时，但依然是有效的事件定义
@Deprecated("Don't use it.")
@EventGroup
interface DeprecatedEvent {

    @Deprecated("Don't use it.")
    fun deprecatedMethod()
}
```

- **定义事件数据类型：** 事件方法返回值即表示事件数据类型，支持泛型（如 `List<String>`），支持不携带数据的无数据事件。以下均为合法定义：

`Java 示例程序`

```
// 事件数据类型为 String
String stringEventInJava();

// 事件数据类型为 List<String>
List<String> listEventInJava();

// 以下均视为无数据事件
void voidEventInJava1();
Void voidEventInJava2();
```

`Kotlin 示例程序`
```
// 事件数据类型为 String
fun stringEventInKotlin(): String

// 事件数据类型为 List<String>
fun listEventInKotlin(): List<String>

// 以下均视为无数据事件
fun voidEventInKotlin1()
fun voidEventInKotlin2(): Unit
fun voidEventInKotlin3(): Unit?
```

- **定义事件数据可空性：** 使用 `@Nullable` 或 `@NonNull` 注解表示事件数据可空性，默认为可空类型。以下均为合法定义：

`Java 示例程序`

```
@NonNull
String nonNullEventInJava();

@Nullable
String nullableEventInJava();

// 默认视为 @Nullable
String eventInJava();
```

`Kotlin 示例程序`

```
fun nonNullEventInKotlin(): String

// 提示：Kotlin 编译器将返回类型上的 ? 号视为 @org.jetbrains.annotations.Nullable
fun nullableEventInKotlin(): String?
```

以下为支持的可空性注解：

```
org.jetbrains.annotations.Nullable
android.annotation.Nullable
androidx.annotation.Nullable

org.jetbrains.annotations.NotNull
android.annotation.NonNull
androidx.annotation.NonNull
```

- **定义自动清除事件：** 支持配置在事件没有关联的订阅者时自动被清除（以释放内存），默认值为 false。可以使用 `@EventGroup` 注解或 `@Event` 注解进行修改，以 `@Event` 的取值优先。

`示例程序`

```
@EventGroup(autoClear = true)
interface MainEvents {

    @Event(autoClear = false)
    fun normalEvent(): String
    
    // 继承 @EventGroup 中的 autoClear 取值
    fun autoClearEvent(): String
}
```

- **定义事件所属组件名：** 为避免不同组件中的事件名重复，框架自动使用 `"[moduleName]$$[eventName]"` 作为最终的事件名。默认使用事件组的 `[全限定类名]` 作为 `moduleName`，可以使用 `@EventGroup` 注解进行修改。

`示例程序`

`com.pengxr.sample.events.MainEvents.kt`
```
@EventGroup(moduleName = "main")
interface MainEvents {

    fun open(): String
}
```

> **提示：** 以上即定义了一个 `MainEvents` 事件组，其中包含一个 `main$$open` 事件且数据类型为 `String` 类型。

### 2、执行注解处理器

在完成事件定义后，执行 `Make Project` 或 `Rebuild Project` 等多种方式都可以触发注解处理器，处理器将根据事件定义自动生成相应的事件接口。例如， `MainEvents` 对应的事件接口为：

`com.pengxr.modular.eventbus.generated.events.com.pengxr.sample.events.EventDefineOfMainEvents.java`
```
/**
 * Auto generate code, do not modify!!!
 * @see com.pengxr.sample.events.MainEvents 
 */
@SuppressWarnings("unchecked")
public class EventDefineOfMainEvents implements IEventGroup {
    private EventDefineOfMainEvents() {
    }

    public static IEvent<String> open() {
        return (IEvent<String>) (ModularEventBus.INSTANCE.createObservable("main$$open", String.class, false, false));
    }
}
```

`EventDefineOfMainEvents` 中的静态方法与 `MainEvent` 事件组中的每个事件一一对应，直接通过静态方法即可获取事件实例，而不再通过手动输入事件名字符串或事件数据类型，故可避免事件名错误或数据类型错误等问题。

所有的事件实例均是 `IEvent` 泛型接口的实现类，例如 `open` 事件属于 `IEvent<String>` 类型的事件实例。发布事件和订阅事件需要用到 `IEvent` 接口中定义的一系列 post 方法和 observe 方法，`IEvent` 接口的完整定义如下：

`IEvent.kt`
```
interface IEvent<T> {

    /**
     * 发布事件，允许在子线程发布
     */
    @AnyThread
    fun post(value: T?)

    /**
     * 延迟发布事件，允许在子线程发布
     */
    @AnyThread
    fun postDelay(value: T?, delay: Long)

    /**
     * 延迟发布事件，在准备发布前会检查 producer 处于活跃状态，允许在子线程发布
     *
     * @param producer 发布者的 LifecycleOwner
     */
    @AnyThread
    fun postDelay(value: T?, delay: Long, producer: LifecycleOwner)

    /**
     * 发布事件，允许在子线程发布，确保订阅者按照发布顺序接收事件
     */
    @AnyThread
    fun postOrderly(value: T?)

    /**
     * 以生命周期感知模式订阅事件（不需要手动注销订阅）
     */
    @AnyThread
    fun observe(consumer: LifecycleOwner, observer: Observer<T?>)

    /**
     * 以生命周期感知模式粘性订阅事件（不需要手动注销订阅）
     */
    @AnyThread
    fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>)
    
    /**
     * 以永久模式订阅事件（需要手动注销订阅）
     */
    fun observeForever(observer: Observer<T?>)

    /**
     * 以永久模式粘性订阅事件（需要手动注销订阅）
     *
     * @param observer Event observer.
     */
    @AnyThread
    fun observeStickyForever(observer: Observer<T?>)

    /**
     * 注销订阅者
     */
    @AnyThread
    fun removeObserver(observer: Observer<T?>)

    /**
     * 移除事件，关联的订阅者关系也会被解除
     */
    @AnyThread
    fun removeEvent()
}
```

### 3、订阅事件

使用 `IEvent` 接口定义的一系列 `observe()` 接口订阅事件，使用示例：

`示例程序`
```
// 以生命周期感知模式订阅（不需要手动注销订阅）
EventDefineOfMainEvents.open().observe(this) {
    // do something.
}

// 以生命周期感知模式、且粘性模式订阅（不需要手动注销订阅）
EventDefineOfMainEvents.open().observeSticky(this) {
    // do something.
}

val foreverObserver = Observer<String?> {
    // do something.
}

// 以永久模式订阅（需要手动注销订阅）
EventDefineOfMainEvents.open().observeForever(foreverObserver)

// 以永久模式，且粘性模式订阅（需要手动注销订阅）
EventDefineOfMainEvents.open().observeStickyForever(foreverObserver)

// 移除观察者
EventDefineOfMainEvents.open().removeObserver(foreverObserver)
```

### 4、发布事件

使用 `IEvent` 接口定义的一系列 `post()` 接口发布事件，使用示例：
  
`示例程序`
```
// 发布事件，允许在子线程发布
EventDefineOfMainEvents.open().post("XIAO PENG")

// 延迟发布事件，允许在子线程发布
EventDefineOfMainEvents.open().postDelay("XIAO PENG", 5000)

// 延迟发布事件，在准备发布前会检查 producer 处于活跃状态，允许在子线程发布。
EventDefineOfMainEvents.open().postDelay("XIAO PENG", 5000, this)

// 发布事件，允许在子线程发布，确保订阅者按照发布顺序接收事件
EventDefineOfMainEvents.open().postOrderly("XIAO PENG")
  
// 移除事件
EventDefineOfMainEvents.open().removeEvent()
```
  
### 5、更多功能

- **生成事件文档（可选）：** 支持生成事件文档，需要在 Gradle 配置中开启：

`模块级 build.gradle`

```
// 需要生成事件文档的模块就增加配置：
android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [
                        MODULAR_EVENTBUS_GENERATE_DOC: "enable",
                        MODULAR_EVENTBUS_MODULE_NAME : project.getName()
                ]
            }
        }
    }
}
```

文档生成路径： `build/generated/source/kapt/[buildType]/com/pengxr/modular/eventbus/generated/docs/eventgroup-of-[MODULAR_EVENTBUS_MODULE_NAME].json`

- **配置（可选）：**
  - **debug(Boolean)：** 调试模式开关；
  - **throwNullEventException(Boolean)：** 非空事件发布空数据时是否抛出 `NullEventException` 异常，在 `release` 模式默认为只拦截不抛出异常，在 `debug` 模式默认为拦截且抛出异常；
  - **setEventListener(IEventListener)：** 全局监听接口。
  
`示例程序`
  
```
ModularEventBus.debug(true)
    .throwNullEventException(true)
    .setEventListener(object : IEventListener {
        override fun <T> onEventPost(eventName: String, event: BaseEvent<T>, data: T?) {
            Log.i(TAG, "onEventPost: $eventName, event = $event, data = $data")
        }
    })
```

## 版本说明

| 版本 | 功能 |
| --- | --- |
| 1.0.x | 初始版本，包含 annotation、api、compiler 三个核心功能模块 |

## 主要功能变更记录

- 发布 v1.0.5（Aug 30, 2022）
- 使用事件定义类的 `[全限定类名]` 代替 `[包名]` 作为事件的组件名，避免组件内事件冲突（Aug 30, 2022）
- 发布 v1.0.4 初始化版本（Aug 29, 2022）
- 优化演示程序（Aug 29, 2022）
- 处理 `@Deprecated` 注解（Aug 28, 2022）
- 完成 MavenCentral 发布脚本（Aug 24, 2022）
- 完成自动清理空闲事件功能（Aug 17, 2022）
- 完成自动生成事件文档功能（Aug 17, 2022）
- 新增 `@Ignore` 注解（Aug 17, 2022）
- 完成演示程序（Aug 16, 2022）
- 完成代码注释与性能优化（Aug 15, 2022）
- 完成主体功能（Aug 14, 2022）

## 未来功能规划

- 支持跨进程 / 跨 App：LiveEventBus 框架支持跨进程 / 跨 App，未来根据使用反馈考虑实现该 Feature；
- 支持替换内部 EventBus 工厂：ModularEventBus 已预设计事件总线工厂 `IEventFactory`，未来根据使用反馈考虑公开该 API；
- 支持基于 Kotlin Flow 的 IEventFactory 工厂；
- 编译时检查在不同 `@EventGroup` 中设置相同 modulaName 且相同 `eventName`，但事件数据类型不同的异常。

## 参考资料

- [Android 消息总线的演进之路：用 LiveDataBus 替代 RxBus、EventBus](https://tech.meituan.com/2018/07/26/android-livedatabus.html) —— 海亮（美团）著
- [Android 组件化方案及组件消息总线 modular-event 实战](https://tech.meituan.com/2018/12/20/modular-event.html) —— 海亮（美团）著

## 共同成长

- 欢迎提 Issue 帮助修复缺陷；
- 欢迎提 Pull Request 增加新的 Feature，让 ModularEventBus 变得更加强大，你的 ID 会出现在 Contributors 中；
- 欢迎加 [作者微信](https://github.com/pengxurui/AndroidFamily/blob/master/images/%E4%B8%AA%E4%BA%BA%E5%BE%AE%E4%BF%A1.jpeg) 与作者交流，欢迎加入交流群找到志同道合的伙伴

## 小彭的其它开源项目

- [AndroidFamily](https://github.com/pengxurui/AndroidFamily) 【Android 面经 + Android 学习指南】一份面向 Android 开发者的成长和进阶的学习路线；🔥
- [AndroidPlatforms](https://github.com/pengxurui/AndroidPlatforms) 每个 Android 开发都要收藏的系统适配手册，带你全面体系化地解读 Android 系统更新；🔥
- [EasyTrack](https://github.com/pengxurui/EasyTrack) 基于西瓜视频前端视图树埋点方案实现的埋点方案；
- [EasyPrivacy](https://github.com/pengxurui/EasyPrivacy) 一个帮助开发者快速解决整改问题的工具；
- [LeetCode-Kotlin](https://github.com/pengxurui/LeetCode-Kotlin) LeetCode 高频题解 - Kotlin 版本。

更多内容，请 [点击](https://juejin.cn/user/1063982987230392)

## Donate

如果本仓库对你有帮助，可以请小彭喝杯速溶咖啡。

![](https://github.com/pengxurui/AndroidFamily/blob/master/images/%E8%AF%B7%E5%B0%8F%E5%BD%AD%E5%96%9D%E6%9D%AF%E9%80%9F%E6%BA%B6%E5%92%96%E5%95%A1.png)

## License

Copyright [2022] [Peng Xurui]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
