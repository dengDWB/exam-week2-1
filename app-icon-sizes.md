
##  苹果尺寸##

![](http://i.imgur.com/mlISdFP.png)

1.**应用程序图标**

for iPhone6 plus(@3x) : 180 x 180
for iPhone 6/5s/5/4s/4(@2x) : 120 x 120


2.**系统搜索框图标 (Spotlight search results icon)**
for iPhone6 plus(@3x) : 1024 × 1024
for iPhone6/5s/5/4s/4(@2x) : 1024 × 1024

for iPhone6 plus(@3x) : 120 x 120
for iPhone6/5s/5/4s/4(@2x) : 80 x 80


3.**系统设置图标 (Settings icon)**

for iPhone6 plus(@3x) : 87 x 87
for iPhone6/5s/5/4s/4(@2x) : 58 x 58

4. **启动图片 (launch image)**


for iPhoen5s/5(@2x) : 640 x 1136
for iPhoen4s/4(@2x) : 640 x 960

iPhone6/iPhone6 plus 建议使用 launch file 或 storyboard ；如果依然想使用图片，尺寸数值为：

for iPhone 6(@2x) : 750 x 1334

for iPhone 6 plus (@3x) : 1242 x 2208

5.**为App Store的应用程序图标 **

for iPhone6 plus(@3x) : 1024 × 1024
for iPhone6/5s/5/4s/4(@2x) : 1024 × 1024

6.**工具栏和导航栏图标**

for iPhone6 plus(@3x) : About 66 × 66

for iPhone6/5s/5/4s/4(@2x) : About 44 × 44

7.**标签栏图标**

for iPhone6 plus(@3x) : About 75 × 75   (maximum: 144 × 96)

for iPhone6/5s/5/4s/4(@2x) : About 50 × 50 (maximum: 96 × 64)


## android尺寸 ##
### 屏幕尺寸 ###

指实际的物理尺寸，为屏幕对角线的测量。

为了简单起见，Android把实际屏幕尺寸分为四个广义的大小：小，正常，大，特大

### 屏幕分辨率

屏幕分辨率是指在横纵向上的像素点数，单位是px，1px=1个像素点。一般以纵向像素*横向像素，如1960*1080。 

### dp、dip、dpi、sp、px ###

px，代表屏幕上一个物理的像素点代表屏幕上一个物理的像素点。
屏幕密度
为解决Android设备碎片化，引入一个概念DP，也就是密度。指在一定尺寸的物理屏幕上显示像素的数量，通常指分辨率。 为了简单起见，Android把屏幕密度分为了四个广义的大小：低（120dpi）、中（160dpi）、高（240dpi）和超高（320dpi） 像素= DP * （ DPI / 160 ) 例如，在一个240dpi的屏幕里，1DP等于1.5PX。
于设计来说，选取一个合适的尺寸作为正常大小和中等屏幕密度（尺寸的选取依据打算适配的硬件，建议参考现主流硬件分辨率），然后向下和向上 做小、大、特大和低、高、超高的尺寸与密度比如UI设计、Android原生API都会以px作为统一的计量单位，像是获取屏幕宽高等。

dip和dp是一个意思，都是Density Independent Pixels的缩写，即密度无关像素，上面我们说过，dpi是屏幕像素密度，假如一英寸里面有160个像素，这个屏幕的像素密度就是160dpi，那么在这种情况下，dp和px如何换算呢？在Android中，规定以160dpi为基准，1dip=1px，如果密度是320dpi，则1dip=2px，以此类推。

假如同样都是画一条320px的线，在480*800分辨率手机上显示为2/3屏幕宽度，在320*480的手机上则占满了全屏，如果使用dp为单位，在这两种分辨率下，160dp都显示为屏幕一半的长度。这也是为什么在Android开发中，写布局的时候要尽量使用dp而不是px的原因。

而sp，即scale-independent pixels，与dp类似，但是可以根据文字大小首选项进行放缩，是设置字体大小的御用单位。

mdpi、hdpi、xdpi、xxdpi

其实之前还有个ldpi，但是随着移动设备配置的不断升级，这个像素密度的设备已经很罕见了，所在现在适配时不需考虑。

mdpi、hdpi、xdpi、xxdpi用来修饰Android中的drawable文件夹及values文件夹，用来区分不同像素密度下的图片和dimen值




### 对于分辨率繁多的android设备，为了方便原生应用的界面适配，Google按照dpi大小将它们分成了4中模式 ###

LDPI (Low Density Screen，120 DPI)，其图标大小为 36 x 36 px。


MDPI (Medium Density Screen, 160 DPI)，其图标大小为 48 x 48 px。


HDPI (High Density Screen, 240 DPI)，其图标大小为 72 x 72 px。


xhdpi (Extra-high density screen, 320 DPI)，其图标大小为 96 x 96 px。


xxhdpi（xx-high density screen, 480 DPI）,其图标大小为144 x 144 px。


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



