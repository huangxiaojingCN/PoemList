## Architecutre Component 用来解决什么问题
architecutre component 是多个库组合而成，使用架构组件技术使得 android 应用更加强大、可测试、便于管理。因为架构组件库内容比较多，不得不分为几小节来说： 

## Lifecycle-Aware Components (可感知生命周期组件)
lifecycle-aware component 存储组件（Activity or Fragment）的生命周期状态，其他的对象可以通过观察的方式获其状态。这样做使得代码结构更加清晰、便于管理。 详细文章链接：[lifecycle-aware](http://www.ssguizhou.cn:10088/myblogs/2018/12/26/myblogs/arch-component-lifecycle-aware/#more)

## ViewModel (管理和存储跟 UI 相关的数据)
ViewModel 就是用来管理和存储跟 UI 相关的数据。优势在于：不会随着配置改变而丢掉数据、数据驱动 UI变化、方便在不同的组件中共享数据。详细文章链接：[ViewModel](http://www.ssguizhou.cn:10088/myblogs/2018/12/26/myblogs/arch-component-viewmodel/#more)

## LiveData (可被观察的数据存储类)
简单来说 LiveData 是在组件（Activity or Fragment）处于活动状态才能发送数据的可被观察对象。它的优点： UI 和数据一一绑定、没有内存泄漏风险、没有崩溃导致 activity 停止、数据分享方便、配置发生改变不会丢掉数据。注意的是：LiveData 需要集合 ViewModel 来使用。详细文章链接：[LiveData](http://www.ssguizhou.cn:10088/myblogs/2018/12/26/myblogs/arch-component-livedata/#more)

## Room (抽象层面的数据库操作)
在 SQlite 之上做了一层抽象层，使得能更加优雅的去操作数据库。

[demo 地址](https://github.com/huangxiaojingCN/PoemList)
