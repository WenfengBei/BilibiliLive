# Bilibili Live Android APP

直接套用 Andorid WebView 来显示B站直播页面，而不必安装B站APP或者打开浏览器。

## Android 部分

使用 Android Studio 开发，最早始于2021年10月10日中午（真怀念啊），直到2023年的现在才又继续开发。

### v1.0.1

是最早期的版本，已经实现了Section的使用，可以直接观看3个网页；但是由于只能竖屏，因此真的不太好用。

### v1.1.3

是最近开发的，也是最后一个竖屏的版本，已经知道如何使用FAB的功能了。

### v1.2.0

从这个版本开始，强制横屏+全屏，并且已经放弃了Section的代码，全靠一个导航页来选择直播间，大大方便了后续持续优化体验。

### v1.3.0

允许用户自行切换横屏或者竖屏模式，非常推荐使用。

本来计划使用下述的代码来实现屏幕方向的切换，效果不错。但是我想在两个屏幕方向上，各自使用不同的主题（竖屏有状态栏和标题栏，横屏彻底全屏），因此只能放弃这样的办法。

还需注意的是，如果没有指定屏幕方向，activity一开始会是一开始会是 `ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED` ，这也是下述代码要对 `getRequestedOrientation()` 总共判断高达3次的原因。

```java
    public void setScreenOrientation() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        else if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        else
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
```

于是，我就设计了两个activity，各自对应两套theme和layout，大力出奇迹！

### 导航页

请使用者自己替换 `tv.b23.live.MyStrings.java` 中的 `你自己的网站` 。

## LiveNaviPage 部分

很简单的一个静态网页，就是一堆超链接罢了。将其部署到官网服务器上即可使用。

## ⚠ 声明与警告

声明：APP与网页作者不负有该网页之任何版权，所有组成部分之版权归各相关方所有。

警告：请勿使用该网页进行任何违法违规之活动。

