# Fragment Example

Fragment를 직접 Activity안에 구현해보고, 원리 이해해보기.

# 주요 학습 내용

1. Fragment를 이용하여, View를 더 효율적으로 구성할 수 있음.
    - FragmentManager을 이용하여 컨트롤 가능.
    - .commit()를 통해 반드시 commit를 해야지만 수정사항이 반영됨.
    - 별도의 작업이 없을 시, BackButton을 누르면 현재 Activity가 종료됨.
        - AddToBackStack() 매소드를 통해 백버튼으로 제거 가능함.

2. 구글은 Activity의 구성에 Fragment를 적극 활용할 것을 권장함.

# preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/FragmentExample/preview.gif?raw=true)

 