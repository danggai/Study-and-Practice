# ActionBar Example

화면 상단에 배치된 바를 의미한다.

옆에 ...을 눌러서 나오는 메뉴를 OptionMenu라고 하며, 상단에 항상 표시되는 부분을 ActionBar이라고 칭한다.

# How to use?

- showAsAction : OptionMenu인가, ActionBar인가 결정.
	- Never : (Deafult)ActionBar로 표시하지 않음. (OptionMenu로서만 사용됨.)
	- Always : 항상 ActionBar에 표시함.
	- ifRoom : 공간이 충분하면 ActionBar, 이외에는 OptionMenu로 사용.
	- collapseActionView : 접었다 폈다 하면서 뷰를 표시함.
- actionViewClass : 접었다 폈다 할 뷰를 설정.

# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/ActionBarExample/preview.gif?raw=true)



 