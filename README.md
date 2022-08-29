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

大家好，我是小彭。ModularEventBus 是一款帮助 Android App 解决事件总线滥用的框架， **其解决方案是通过注解定义事件，由编译时 APT 注解处理器进行合法性检查和自动生成事件接口，以实现对事件定义、发布和订阅的强约束。**

<p align='center'>
  <a target="_blank" witth="300">
    <img width = "400" src="https://github.com/pengxurui/ModularEventBus/blob/main/images/ModularEventBusImage.png">
  </a>
</p>

### 最新版本

模块|modular-eventbus-api|modular-eventbus-compiler|modular-eventbus-annotation
---|---|---|---
最新版本|[![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-api)|[![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-compiler/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-compiler)|[![Download](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-annotation/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.pengxurui/modular-eventbus-annotation)

### Demo 展示

##### [Demo apk](https://github.com/pengxurui/ModularEventBus/blob/main/demo/apk/modular-eventbus-demo-v1.0.4.apk)

### 常见事件总线框架对比

以下从多个维度对比常见的事件总线框架：

| 事件总线 | ModularEventBus | modular-event | LiveEventBus | LiveDataBus | EventBus | RxBus |
| --- | --- | --- | --- | --- | --- | --- |
| 开发者 | @彭旭锐 | @美团 | @JeremyLiao | / | @greenrobot | / |
| Github Star | 0 | 未开源 | 3.4k | / | 24.1k | / |
| 生成事件文档 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 非空数据拦截 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 无数据事件 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 泛型事件 | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| 自动清除空闲事件 | ✅ | ❌ | ✅ | ❌ | ❌ | ❌ |
| 事件强约束 | ✅ | ✅ | ❌ | ❌ | ❌ | ❌ |
| 生命周期感知 | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ |
| 延迟发送事件 | ✅ | ✅ | ✅ | ✅ | ❌ | ❌ |
| 有序接收事件 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| 订阅 Sticky 事件 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| 移除 Sticky 事件 | ✅ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 线程调度 | ❌ | ❌ | ❌ | ❌ | ✅ | ✅ |
| 跨进程 / 跨 App | ❌（可支持） | ❌ | ✅ | ❌ | ❌ | ❌ |

### ModularEventBus 特性一览

**1、事件强约束**

✅  支持零配置快速使用；

✅  支持 APT 注解处理器自动生成事件接口类；

✅  支持编译时合法性校验和警告提示；

✅  支持自动生成事件文档；

✅  支持增量编译；

**2、Lifecycle 生命周期感知**

✅  内置基于 LiveData 的 LiveDataBus；

✅   支持自动取消订阅，避免内存泄漏；

✅  支持安全地发送事件与接收事件，避免产生空指针异常或不必要的性能损耗

✅  支持自动清除没有关联订阅者的 LiveData 以释放内存；

**3、更多特性支持**

✅  支持 Java / Kotlin；

✅  支持 AndroidX；

✅  支持订阅 Sticky 粘性事件，支持移除 Sticky 粘性事件；

✅  支持永久订阅事件；

✅  支持 Generic 泛型事件，如 List<String> 事件；

✅   支持不携带数据的事件；

✅  支持延迟发送事件；

✅  支持有序接收事件。

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

- **3、定义事件：** 使用接口定义事件名和事件数据类型，并使用 `@EventGroup` 注解修饰该接口。以下事件定义在编译时注解处理后将自动生成事件类 `EventDefineOfLoginEvents`，发布者和订阅者将使用该事件类进行通信。

`com.pengxr.sampleloginlib.LoginEvents.kt`

```kotlin
@EventGroup
interface LoginEvents {

  // 事件名：login
  fun login(): UserInfo

  // 事件名：logout
  fun logout()
}
```

- **4、订阅事件**

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

- **5、发布事件**

`发布者示例`

```kotlin
EventDefineOfLoginEvents.login().post(UserInfo("XIAOPENG"))

EventDefineOfLoginEvents.logout().post(null)
```

- **6、添加混淆规则（如果使用了 minifyEnabled true）：**

```
-dontwarn com.pengxr.modular.eventbus.generated.**
-keep class com.pengxr.modular.eventbus.generated.** { *; }
-keep @com.pengxr.modular.eventbus.facade.annotation.EventGroup class * {*;} # 可选
```

以上示例事件由注解处理器自动生成的代码如下：

`EventDefineOfLoginEvents.java`

```kotlin
/**
 * Auto generate code, do not modify!!!
 * @see com.pengxr.sampleloginlib.events.LoginEvents */
@SuppressWarnings("unchecked")
public class EventDefineOfLoginEvents implements IEventGroup {
  private EventDefineOfLoginEvents() {
  }

  public static IEvent<UserInfo> login() {
    return (IEvent<UserInfo>)(ModularEventBus.INSTANCE.createObservable("com.pengxr.sampleloginlib.events$$login", UserInfo.class,false,true));
  }

  public static IEvent<Void> logout() {
    return (IEvent<Void>)(ModularEventBus.INSTANCE.createObservable("com.pengxr.sampleloginlib.events$$logout", Void.class,true,false));
  }
}
```

## 认识事件总线

### 事件总线的优点

事件总线框架最大的优点是 ”解耦“，即事件发布者与事件订阅者的解耦，事件的发布者不需要关心是否有人订阅该事件，也不需要关心是谁订阅该事件，代码耦合度较低。因此，事件总线框架更适合作为全局的事件通信方案，或者组件间通信的辅助方案。

### 事件总线的缺点

然而，成也萧何败萧何，彻底地解耦也容易让事件总线被滥用，用时一时爽，维护火葬场。我将事件总线框架存在的问题概括为以下 5 种常见问题：

- **1、消息难溯源：** 在阅读源码的过程中，如果需要查找发布事件或订阅事件的地方，只能通过查找事件引用的方式进行溯源，增大梳理代码逻辑的难度。特别是当项目中到处是临时事件时，难度会大大增加；
- **2、临时事件滥用：** 由于事件总线框架对事件定义没有强制的约束，开发者可以在项目的各个角落随意定义事件，增大后期维护的难度；
- **3、数据类型转换错误：** 当订阅方使用与发送方不一致的数据类型来接收事件时，会在运行时发生类型转换错误。在发生事件命名冲突和事件命名疏忽时，会大大增加发生类型转换错误的概率。
- **4、事件命名重复：** 由于事件总线框架对事件命名没有强制的约束，有可能出现不同组件恰好定义了重名的事件，订阅方就会收到并没有真正发生的事件，产生逻辑混乱。如果重名的事件使用了不同的数据类型，那么还会出现运行时类型转换错误；
- **5、事件命名疏忽：** 与 ”事件命名重复“ 类似，由于事件总线框架对事件命名没有强制的约束，有可能出现开发者复制粘贴后忘记修改事件变量值的问题，或者变量值拼写错误（例如 `login_success` 拼写为 `login_succese`），那么订阅方将永远收不到事件。

### ModularEventBus 的优点

ModularEventBus 组件化事件总线框架的优点： **在保持发布者与订阅者的解耦的优势下，解决上述事件总线框架中存在的通病。** 具体通过以下 5 个手段实现：

- **1、事件声明聚合：** 发布者和订阅者只能使用预定义的事件，严格禁止使用临时事件，事件需要按照约定聚合定义在一个文件中（解决临时事件滥用问题）；
- **2、区分不同组件的同名事件：** 在定义事件时需要指定事件所属 moduleName，框架自动使用 `”[moduleName]$$[eventName]“` 作为最终的事件名（解决事件命名重复问题）；
- **3、事件数据类型声明：** 在定义事件时需要指定事件的数据类型，框架自动使用该数据类型发送事件（解决数据类型转换错误问题）；
- **4、接口强约束：** 运行时使用事件接口进行消息发布和订阅，而不需要手动输入事件名和数据类型（解决事件命名命名错误）；
- **5、APT 生成接口类：** 框架在编译时使用 APT 注解处理器自动生成事件接口类。

## 完整使用文档

### 1、定义事件

- **使用注解定义事件：** 模板程序如下：

`com.pengxr.sample.events.MainEvents.kt`
```
@EventGroup
interface MainEvents {

    // 可以省略 @Event
    @Event
    fun eventName(): String
}
```

- **@EventGroup 注解：** `@EventGroup` 注解用于定义事件组，


> **提示：** 兼容使用


## 常见问题 Q&A

收不到粘性事件

## 版本说明

| 版本 | 功能 |
| --- | --- |
| 1.0.x | 初始版本，包含 annotation、api、compiler 三个核心功能模块 |

## 主要功能提交记录

- 发布 1.0.4 初始化版本（Aug 29, 2022）
- 优化演示程序（Aug 29, 2022）
- 处理 @Deprecated 注解（Aug 28, 2022）
- 完成 MavenCentral 发布脚本（Aug 24, 2022）
- 完成自动清理空闲事件功能（Aug 17, 2022）
- 完成自动生成事件文档功能（Aug 17, 2022）
- 新增 @Ignore 注解（Aug 17, 2022）
- 完成演示程序（Aug 16, 2022）
- 完成代码注释与性能优化（Aug 15, 2022）
- 完成主体功能（Aug 14, 2022）

## 未来功能规划

- 支持跨进程 / 跨 App：LiveEventBus 框架支持跨进程 / 跨 App，未来根据使用反馈考虑实现该 Feature；
- 支持替换内部 EventBus 工厂：ModularEventBus 已预设计事件总线工厂 IEventFactory，未来根据使用反馈考虑公开该 API；
- 编译时检查在不同 @EventGroup 中设置相同 modulaName 且相同 eventName，但事件数据类型不同的异常。

## 参考资料

- [Android 消息总线的演进之路：用 LiveDataBus 替代 RxBus、EventBus](https://tech.meituan.com/2018/07/26/android-livedatabus.html) —— 海亮（美团）著
- [Android 组件化方案及组件消息总线 modular-event 实战](https://tech.meituan.com/2018/12/20/modular-event.html) —— 海亮（美团）著

## 共同成长

- 欢迎提 Issue 帮助修复缺陷；
- 欢迎提 Pull Request 增加新的 Feature，让 ModularEventBus 变得更加强大，你的 ID 会出现在 Contributors 中；
- 欢迎加微信与作者交流，加入交流群找到志同道合的伙伴。

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
