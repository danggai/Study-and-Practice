# Service Example

안드로이드 4대 구성요소 중 하나인 서비스를 이해하고, 실습해보며 어떤 원리로 작동하는지 이해해보자.

# 주요 학습 내용

1. Service
    - 백그라운드에서 실행되며, 사용자에게는 보이지 않음.

2. Intent Service
    - Service 내부에서 Thread를 운영하고자 할 때 사용하는 서비스.

3. Foreground Service
    - 서비스는 메모리가 부족할 시 제거됨. Foreground의 경우는, 반드시 끝까지 작동을 보장받음.
    - 5초안에 notification message를 띄워주지 않으면, 액티비티가 종료됨.

# Preview

Service는 메모리에서 일어나는 작업이기에, 별도의 프리뷰가 없습니다.