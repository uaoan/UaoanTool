### ByRecyclerView、ViewPager2、MMKV的封装项目

### 集成
 **1.在 project 的 settings.gradle 文件中找到 allprojects{} 代码块添加以下代码：** 

```
allprojects {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }      //增加 jitPack Maven 仓库
    }
}
```
 **在 app 的 build.gradle 文件中找到 dependencies{} 代码块，并在其中加入以下语句：** 

```
implementation 'com.github.uaoan:UaoanTool:1.0'
implementation 'com.github.youlookwhat:ByRecyclerView:1.3.6'
implementation 'androidx.viewpager2:viewpager2:1.1.0-beta01'
implementation 'com.tencent:mmkv-static:1.3.0'
```

### [ByRecyclerView封装例子](https://github.com/uaoan/UaoanTool/blob/master/UaoanLibrary/src/main/java/com/uaoanlao/uaoanlibrary/RecyclerView/UaoanByRecyclerView.java)
### [ViewPager2封装例子](https://github.com/uaoan/UaoanTool/blob/master/UaoanLibrary/src/main/java/com/uaoanlao/uaoanlibrary/ViewPager2/UaoanViewPager2.java)
### [MMKV封装例子](https://github.com/uaoan/UaoanTool/blob/master/UaoanLibrary/src/main/java/com/uaoanlao/uaoanlibrary/UaoanMMKV.java)
