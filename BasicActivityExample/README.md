# Basic Activity Example

기본적인 액티비티 생성, 종료, 흐름 등 실습을 통해 이해하기

# 주요 학습 내용

1. startActivity(Intent( .... ))
    - 액티비티 새로 실행하기.
    - 기존 액티비티는 onPause() 호출 후, Back Stack에 누적됨. 

2. startActivityForResult(...)
    - 해당 함수로 발생 한 activity가 Finish될 때 onActivityResult(...) 를 발생시킴.
    - requestCode, resultCode로 액티비티의 호출 내용, 결과에 대한 정보를 전달 가능.

3. finish()
    - 액티비티 종료 및 스택 최상위 액티비티 onResume() 실행.

4. intent에 putExtra(...)를 통해 데이터를 액티비티 간 전달 가능.
    - 여러 변수형에 대해 overwrite된 함수들이 존재한다.


# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/BasicActivityExample/preview.gif?raw=true)
