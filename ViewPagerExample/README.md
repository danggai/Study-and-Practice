# ViewPager_Example
viewpager1 연습.

# 중요 학습 내용
1. 한 화면에 여러 뷰 표현하기.
  - ViewPager1에서는 어댑터에서 getPageWidth를 override하여 구현 가능. (2에서는 아직 미지원)

2. 이미지 매핑하기.
  - getImg가 Int를 리턴하는 이유는, 안드로이드는 모든 리소스를 정수형으로 순번을 매겨 관리하기 때문.
  - getImg에서 리소스 번호 확인 -> layout의 page_main.xml에 id="image"인 이미지 뷰에 ImageResource 할당.

# Preview
![](https://github.com/danggai/ViewPager_Example/blob/master/example.gif?raw=true)
