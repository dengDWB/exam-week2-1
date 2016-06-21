
## android尺寸 ##

### 屏幕尺寸 ###

指实际的物理尺寸，为屏幕对角线的测量。

为了简单起见，Android把实际屏幕尺寸分为四个广义的大小：小，正常，大，特大

### 屏幕分辨率

屏幕分辨率是指在横纵向上的像素点数，单位是px，1px=1个像素点。一般以纵向像素*横向像素，如1960\*1080。 

### dp、dip、dpi、sp、px ###

**px**:代表屏幕上一个物理的像素点代表屏幕上一个物理的像素点。

**屏幕密度**

为解决Android设备碎片化，引入一个概念DP，也就是密度。指在一定尺寸的物理屏幕上显示像素的数量，通常指分辨率。 为了简单起见，Android把屏幕密度分为了四个广义的大小：低（120dpi）、中（160dpi）、高（240dpi）和超高（320dpi） 像素= DP \* （ DPI / 160 ) 例如，在一个240dpi的屏幕里，1DP等于1.5PX。

于设计来说，选取一个合适的尺寸作为正常大小和中等屏幕密度（尺寸的选取依据打算适配的硬件，建议参考现主流硬件分辨率），然后向下和向上 做小、大、特大和低、高、超高的尺寸与密度比如UI设计、Android原生API都会以px作为统一的计量单位，像是获取屏幕宽高等。

**dip**和**dp**是一个意思，都是Density Independent Pixels的缩写，即密度无关像素，上面我们说过，dpi是屏幕像素密度，假如一英寸里面有160个像素，这个屏幕的像素密度就是160dpi，那么在这种情况下，dp和px如何换算呢？在Android中，规定以160dpi为基准，1dip=1px，如果密度是320dpi，则1dip=2px，以此类推。

假如同样都是画一条320px的线，在480\*800分辨率手机上显示为2/3屏幕宽度，在320\*480的手机上则占满了全屏，如果使用dp为单位，在这两种分辨率下，160dp都显示为屏幕一半的长度。这也是为什么在Android开发中，写布局的时候要尽量使用dp而不是px的原因。

而**sp**，即scale-independent pixels，与dp类似，但是可以根据文字大小首选项进行放缩，是设置字体大小的御用单位。

mdpi、hdpi、xdpi、xxdpi

其实之前还有个ldpi，但是随着移动设备配置的不断升级，这个像素密度的设备已经很罕见了，所在现在适配时不需考虑。

mdpi、hdpi、xdpi、xxdpi用来修饰Android中的drawable文件夹及values文件夹，用来区分不同像素密度下的图片和dimen值




### 对于分辨率繁多的android设备，为了方便原生应用的界面适配，Google按照dpi大小将它们分成了4中模式 ###

LDPI (Low Density Screen，120 DPI)，其图标大小为 36 x 36 px。



MDPI (Medium Density Screen, 160 DPI)，其图标大小为 48 x 48 px。
![](http://i.imgur.com/9Sbf0st.png)


HDPI (High Density Screen, 240 DPI)，其图标大小为 72 x 72 px。
![](http://i.imgur.com/hihd5gk.png)


xhdpi (Extra-high density screen, 320 DPI)，其图标大小为 96 x 96 px。
![](http://i.imgur.com/n8f8bHD.png)


xxhdpi（xx-high density screen, 480 DPI）,其图标大小为144 x 144 px。
![](http://i.imgur.com/86EbC69.png)


上述的图片例子是在1080\*1920分辨率的手机上运行的，通过设置应用程序不同分辨率的应用图标，发现在分辨率越高的手机上需要的应用图标的分辨率也是要高的，但是换算原则是什么了，为什么240dpi、320dpi、480dpi的应用图标上应用图标这么小，图片都是一样的只是分辨率不同而已，为什么差距这么大了

1080\*1920它的dpi是480DPI是怎么算出来的了，先是用勾股定理，在用勾股定理算出的值除以屏幕尺寸，就可以得到了。

举一个例子，假设有一个1080\*1920的5英寸手机，算法就是 1928^2+1080^2=2202^2,然后用2202/5差不多等于440，也就是440dpi,也就接近480dpi，所以也是为什么xxhdpi显示的最好，为什么其他几个尺寸为什么这么小了，可以这么理解吧，160dpi、240dpi、320dpi代表一些东西的数量，我有一个坑，要填满，假设我们知道要多少数量的东西可以填满坑，如果比这个数量小的数量东西来填的话，就会显的坑周围还有很多地方可以填。所以这个也是为什么比480dpi小的,在手机上显示的图标小。

为什么160dpi是48x48px了，我找到的规律来看，用160/48=3.333，其他的也是，你可以记作1dpi==3.33px



### Android安卓系统dp/sp/px换算表 ###

![](http://i.imgur.com/lIqo9sZ.png)

### 主流Android手机分辨率和尺寸 ###

![](http://i.imgur.com/VOEzhoC.png)

### 应用图标的尺寸 ###

####底部菜单图标 ####

**大屏:**

完整图片（红色）: 72 x 72 px

图标（蓝色）: 48 x 48 px

图标外边框（粉色）: 44 x 44 px

**中屏:**

完整图片: 48 x 48 px

图标: 32 x 32 px

图标外边框: 30 x 30 px

**小屏:**

完整图片: 36 x 36 px

图标: 24 x 24 px

图标外边框: 22 x 22 px

#### 3. 弹出对话框顶部图标 ####

小屏 24 x 24 px Low density screen (ldpi)

中屏 32 x 32 px Medium density screen (mdpi)

大屏 48 x 48 px High density screen (hdpi)

#### 4. 长列表内部列表项图标 ####

小屏 24 x 24 px Low density screen (ldpi)

中屏 32 x 32 px Medium density screen (mdpi)

大屏 48 x 48 px High density screen (hdpi)

#### 5. 底部或顶部tab标签图标 ####

**大屏 (hdpi) screens:**

完整图片（红色）: 48 x 48 px

图标（蓝色）: 42 x 42 px

**中屏 (mdpi) screens:**

完整图片: 32 x 32 px

图标: 28 x 28 px

**小屏(ldpi) screens:**

完整图片: 24 x 24 px

图标: 22 x 22 px
 

#### 6. 底部状态栏图标 ####

ldpi (120 dpi) 18 x 18 px 小屏

mdpi (160 dpi) 24 x 24 px 中屏

hdpi (240 dpi) 36 x 36 px 大屏

xhdpi (320 dpi) 48 x 48 px 特大屏



