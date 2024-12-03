# CustomToast Example

개발자가 커스텀하여 디자인한 Toast를 만들고, RecyclerView의 아이템에 연동해보는 예제.

# 주요 학습 내용

1. Toast 구현 및 CustomToast 연동

  - `val toast = Toast(context)`     // toast 선언
  - `toast.view = mInflater.inflate(R.layout.custom_toast, null)`   // CustomToast 그려내고, 연동.

2. 이미지 리소스 연동

  - `context.getResources().getIdentifier("파일명", "drawable", context.getPackageName())`

3. RecyclerView의 각각 Item에 리스너 구현

  - Adapter의 `onBindViewHolder`에 `holder.itemView.setOnClickListener{}` 구현

4. Adapter로 Activity의 Context 전달하기.

  - Adapter의 생성자로 `Adapter(val context: Context, ...)`
  - Adapter 호출 시 `Adapter(this, ...)`를 통해 context 전달 가능. 

4. Adapter에서 view 구성을 위해 inflater을 사용

  - ` var mInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater` 

# Preview

![](https://github.com/danggai/Kotlin-Android-Examples/blob/master/CustomToastExample/preview.gif?raw=true)
