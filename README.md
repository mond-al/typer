# typer
안드로이드 TextView에 텍스트를 타이핑하는 것처럼 순차적으로 첫가끝(자음모음)입력을 지원합니다.
한글을 [첫가끝](https://pat.im/1176)으로 분해하여 타이핑하는 것처럼 입력합니다. 아직은 두벌식을 사용할때 처럼 [도깨비불현상](https://namu.wiki/w/%EB%8F%84%EA%B9%A8%EB%B9%84%EB%B6%88%20%ED%98%84%EC%83%81)을 구현하지는 못했습니다.

### typer로 할 수 있는 동작들
예제1. 커서없이_쓰기:  
![예제1_커서없이_쓰기](https://github.com/mond-al/typer/blob/main/demo1.gif?raw=true)

예제2. 커서보이게_쓰기  
![예제2_커서보이게_쓰기](https://github.com/mond-al/typer/blob/main/demo2.gif?raw=true)

예제3. 커서보이게_지우기  
![예제3_커서보이게_지우기](https://github.com/mond-al/typer/blob/main/demo3.gif?raw=true)


```kotlin
Typer.typing(textView, "타이핑할 문자열", useCursor){
    Toast.makeText(this, "타이핑 끝", Toast.LENGTH_SHORT).show()
}
```

첫 배포. 아직은 아주 간단한 수준의 타이핑 효과를 줄수 있습니다.   

### Todo : 
1. 데이터 최적화
2. 도깨비불현상구현
3. 구간 지우고 다시 쓰기 

# DEMO
<img src="https://github.com/mond-al/typer/blob/main/demo.gif?raw=true" width="50%">


[![](https://jitpack.io/v/mond-al/typer.svg)](https://jitpack.io/#mond-al/typer)

Step 1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.mond-al:typer:Tag'
	}
```

Step3. Just Use it!

```kotlin
Typer.typing(textView, "타이핑할 문자열", useCursor){
    Toast.makeText(this, "타이핑 끝", Toast.LENGTH_SHORT).show()
}
```
