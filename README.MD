# Bilibili Live Android APP

直接套用 Andorid WebView 来显示B站直播页面，而不必安装B站APP或者打开浏览器。

## Android 部分

使用 Android Studio 开发，最早始于2021年10月10日中午（真怀念啊），直到2023年的现在才又继续开发。

最早期的1.0.1版本即已经实现了Section的使用，可以直接观看3个网页；但是由于只能竖屏，因此真的不太好用。

1.1.3版本是最近开发的，也是最后一个竖屏的版本，已经知道如何使用FAB的功能了。

现在的1.2.0版本强制横屏+全屏，并且已经放弃了Section的代码，全靠一个导航页来选择直播间，大大方便了后续持续优化体验。

### 导航页

请使用者自己替换 `tv.b23.live.MainActivity.displayLiveNaviPage()` 中的 `webView.loadUrl("http://你自己的网站/live/");` 。

### 请注意APK文件备注

\app\release目录下的APK文件备注：

- Bilibili Live 1.1.3 release (竖屏最终版).apk 竖屏版本
- Bilibili Live 1.2.0 release (横屏版).apk 横屏版本

## LiveNaviPage 部分

很简单的一个静态网页，就是一堆超链接罢了。将其部署到官网服务器上即可使用。

## ⚠ 声明与警告

声明：APP与网页作者不负有该网页之任何版权，所有组成部分之版权归各相关方所有。

警告：请勿使用该网页进行任何违法违规之活动。

