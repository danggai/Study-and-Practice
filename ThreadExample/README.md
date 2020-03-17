# Thread Example

간단한 비동기적 처리를 위한 thread를 직접 구현해보고 이해하기 위한 예제.

# 중요 학습 내용

Android 8.0 이전 버전에서는 개발자가 만든 thread에서 화면에 관련된 처리 시 exception 발생.
  - runOnUiThread( Runnable{ ... } ) 를 통해 UIThread로 작업을 인계함.

# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/ThreadExample/example.gif?raw=true)