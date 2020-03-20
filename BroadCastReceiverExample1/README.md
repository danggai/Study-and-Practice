# BroadcastReceiver Example

Broadcast Receiver을 구현하고, 다른 어플리케이션에서 해당 receiver을 호출해보는 예제.

# 중요 학습 내용

1. 안드로이드 내장 어플리케이션중 일부는 이미 사용할 수 있도록 제공 되어 있음.

2. 명시적 인텐트와 암시적 인텐트.
    - 명시적 인텐트는 intent.setClassName(패키지이름, 클래스이름)
    - 암시적 인텐트는 intent = Intent("미리 설정해둔 BR의 이름")
      - 암시적 인텐트는 안드로이드 8.0부터 일부 리시버 외에는 사용 불가능.
      - 일부 리시버란, 실행중인 앱의 리시버.

# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/BroadCastReceiverExample1/preview.gif?raw=true)

 