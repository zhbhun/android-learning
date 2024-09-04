## [LinearLayout](https://developer.android.com/reference/android/widget/LinearLayout)

Usage

- 排列方向
- 对齐方式
- 外边距

References

- [Create a linear layout](https://developer.android.com/develop/ui/views/layout/linear)

## [RelativeLayout](https://developer.android.com/develop/ui/views/layout/relative?hl=zh-cn)

ps:	RelativeLayout 是 Android 中较早的布局方式，允许子视图相对于父视图或其他子视图进行布局。在现代 Android 开发中，ConstraintLayout 是更推荐的选择，因为它提供了更强大的功能、可扩展性和更好的性能。

- [Relative Layout](https://developer.android.com/develop/ui/views/layout/relative)

## FrameLayout

FrameLayout 用于叠加视图或显示单个视图。

## [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout)

Usage

- [相对定位](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#relative-positioning)
- [外边距](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#margins)
- [居中定位](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#centering-positioning-and-bias)

    https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#circular-positioning-added-in-1.1

- [环形定位](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#circular-positioning-added-in-1.1)
- [可见性变更](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#visibility-behavior)
- [大小约束](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#dimensions-constraints)

    - 本身的最小和最大尺寸
    - 子视图的尺寸约束

- [Chain](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout#chains)

    - 当多个视图需要在水平方向或垂直方向上等间距排列。
	- 需要动态调整多个视图的位置，使它们在父布局中均匀分布或按照特定的比率排列。
	- 控制多个视图的排列顺序和对齐方式（居中、靠左、靠右等）。

## [TableLayout](https://developer.android.com/reference/android/widget/TableLayout)

TableLayout 是 Android 中较早引入的布局方式，主要用于创建表格布局。适合实现简单的表格形式布局，不支持像 GridLayout 那样的高级布局控制。

## [GridLayout](https://developer.android.com/reference/kotlin/android/widget/GridLayout)

GridLayout 是 Android 3.0（API 级别 11）之后引入的，更现代、更灵活的布局容器，可以创建复杂的网格布局，支持子视图跨越多行或多列，以及子视图之间的精细控制。

## [SlidingPaneLayout](https://developer.android.com/reference/androidx/slidingpanelayout/widget/SlidingPaneLayout)

- [Create a two-pane layout](https://developer.android.com/develop/ui/views/layout/twopane)

## [DrawerLayout](https://developer.android.com/reference/androidx/drawerlayout/widget/DrawerLayout)

...

---

- GridLayout
- TableLayout
- InlineContentView

---

- [Android 开发指南](https://developer.android.com/guide/topics/ui/declaring-layout.html)
- [Constructing View Layouts](https://guides.codepath.com/android/Constructing-View-Layouts)
- [Android Layout Tutorial](http://www.learn-android.com/2010/01/05/android-layout-tutorial/)
