# Notification Example

기본적인 OS로의 Notification을 전송해보고, 안드로이드 버전 별로 차이를 익힘.

# 주요 학습 내용

1. 안드로이드 버전 별 Notification 구현 및 차이점 확인

  - < 4.1: Ticker, Number이 안드로이드 기기에 표시 됨.
  - >= 8.0: Channel이라는 개념 도입. 예를 들어, "대화", "공지", "광고" 등으로 구분하여 알람 전송.
    - 사용자는 특정 채널에서의 알람을 거부하거나 조절 할 수 있음.

2. Notification을 통한 Pending, Action 기능 연동.

  - 수신 된 Notification을 눌러 어플리케이션의 특정 액티비티로 이동 가능.
  - intent.putExtra를 이용하여 데이터 전송 가능.
  - Action을 이용하여 버튼에 따른 다른 intent구현 가능

# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/NotificationExample/preview.gif?raw=true)

일반 알람 프리뷰


![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/NotificationExample/pendingPreview.gif?raw=true)

pending 프리뷰