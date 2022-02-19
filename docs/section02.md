# 3. 변수와 자료,연산자

## 1. 자료형 알아보기

### 코틀린의 자료형은 참조형 자료형을 사용한다

- 기본형 vs 참조형?
    - 기본형(Primitive Data Type) : 가공되지 않은 순수한 자료형을 말하며 프로그래밍 언어에 내장되어 있음
    - 참조형(Reference Type)  : 객체를 생성하고 동적 메모리 영역에 데이터를 둔 다음 이것을 참조함
- 자바와 비교했을 때..
    - **자바**는 int, long, float, double 등 **기본형과** String, date같은 **참조형을 모두 사용**
    - **코틀린**에서는 **참조형만 사용**
        - 참조형으로 선언한 변수는 성능 최적화를 위해 코틀린 컴파일러에서 다시 기본형으로 대체된다.
        - 코틀린에서는 참조형을 기본형으로 고려하는 등의 최적화를 신경쓰지 않아도 됨

### 기본형과 참조형의 동작 원리

e.g jav에서 사용된 기본형과 참조형으로 선언한 변수

```java
int a = 77; // 기본형
Person person = new Person(); // 참조형으로 person 객체를 위해 참조 주소 (A12)를 가진다.
```

- 기본형으로 선언한 변수 a는 임시 메모리인 스택에 저장되며 값이 저장된 메모리의 크기도 고정되어 있음
- 참조형은 스택에 값이 아닌 참조 주소가 있다. (A12)
    - 실제 객체는 동적 메모리인 힙에 저장됨
- 기본형이 참조형보다 수행시간이 더 빠름
    - 코틀린은 겉으로 참조형을 사용하는 것 같지만 컴파일 과정을 거치면 참조형이 기본형으로 바뀜

### 문자열 자료형

문자열 자료형은 여러 문자를 배열하여 저장할 수 있는 자료형이며, 기본형에 속하지 않는 배열 형태로 되어있는 특수한 자료형

![Untitled](https://user-images.githubusercontent.com/58503875/154808018-a473201b-6cb2-47eb-8def-35e0b418e684.png)

코틀린은 힙 영역의 String Pool이라는 공간에 문자열인 ‘Hello’를 저장해 두고 이 값을 str1, str3이 참조하도록 만듦

결과적으로 str3의 참조주소는 str1과 동일하므로 참조 비교를 위해 === 연산자를 사용하면 true가 반환됨

⇒ 문자열 자료형은 String Pool을 이용해 필요한 경우 메모리 공간을 재활용

### 자료형에 별명 붙이기

변수의 자료형이 복잡한 구조를 가지며 자료형에 별명을 붙일 수도 있음

typealias 키워드 사용

```kotlin
typealias Username = String // String을 Username이라는 별명으로 대체
val user : Username = "Kildong" // 이제부터  Username은 String과 같은 표현
```

## 2. 자료형 검사하고 변환하기

- **코틀린은 변수를 사용할 때 반드시 값이 할당되어 있어야 한다는 원칙이 있음**
- 만약 값이 할당되지 않은 변수를 사용하면 코틀린에서 오류가 발생한다.
- 코틀린에서는 null 상태인 변수를 허용하려면 물음표(?) 기호를 사용해 선언해야 함

### null을 허용한 변수 검사하기

프로그램이 실행되는 도중에 값이 null인 변수에 접근하려 하면 **NullPointerException(NPE)** 예외 오류가 발생

- **변수에 null 할당하기**

```kotlin
// var str1 : String = "Hello Kotlin"
// str1 = null // 오류! null을 허용하지 않음
// println("str1:" $str1)

// 변수에 null 할당을 허용하려면 자료형 뒤에 물음표(?) 기호를 명시해야 함
var str1 : String? = "Hello Kotlin"
str1 = null
println("str1: &str1")
```

**변수의 null 허용 여부에 따라 String과 String?이 서로 다른 자료형이라는 것을 이해해야 함**

- **세이프 콜, non-null 단정 기호**
    - **세이프 콜(`?.`)** : null이 할당되어 있을 가능성이 있는 변수를 검사하여 안전하게 호출하도록 도와주는 기법. 세이프 콜을 추가하려면 호출할 변수 이름 뒤에 **`?.`**를 작성하면 됨
    - **non-null 단정 기호**(`!!`) : non-null 단정 기호는 변수에 할당된 값이 null이 아님을 단정하므로 컴파일러가 null 검사 없이 무시함. 따라서 변수에 null이 할당되어 있어도 컴파일은 잘 진행되나 실행 중에 NPE 발생시킴

```kotlin
println("str1: $str1 length: ${str1?.length}") // str1을 세이프 콜로 안전하게 호출
```

- **조건문을 활용해 null을 허용한 변수 검사하기**

```kotlin
str1 = null
val len = if(str1 != null) str1.length else -1
```

- **세이프 콜과 엘비스 연산자를 활용해 null을 허용한 변수 더 안전하게 사용하기**
    - 세이프 콜 `?.`
    - 엘비스 연산자 (`?:`) : 변수가 null인지 아닌지 검사하여 null이 아니라면 왼쪽 식을 그대로 실행, null이라면 오른쪽 식을 실행

```kotlin
var str1 : String? = "Hello Kotlin"
str1 = null
println("str1: &str1 length: ${str1?.length ?: -1}")
// str1?.length -> str1이 null이 아닌 경우 length, null인 경우 null 반환
    // ?; -1  -> null이 아니면 왼쪽 값(str1?.length 을, null인 경우 오른쪽 값(-1) 반환
}
```

### 자료형 비교하고 검사하고 변환하기

- 코틀린의 자료형은 모두 참조형으로 선언한다.
- 하지만 컴파일을 거쳐서 최적화 될 때 **int, long, short와 같은 자료형은 기본형 자료형으로 변환됨**
- 코틀린에서는 자료형이 서로 다른 변수를 비교하거나 연산할 수 없다.
    - int형으로 선언하 변수와 long형으로 선언한 변수를 서로 더하거나 뺄 수 없음
    - 코틀린에서는 자료형이 서로 다른 변수를 같은 자료형으로 만들어야 연산할 수 있다

```kotlin
fun main() {
    // 자료형 변환
    // - 코틀린에서는 자료형이 다르면 변환 함수를 사용해야 함
    // - 자바와 달리 자료형이 다른 변수에 재할당하면 자동 형 변환이 되지 않고 자료형 불일치 오류가 발생
    val a: Int = 1
    // val b: Double = a // 자료형 불일치 오류 발생
    // val c: Int = 1.1 // 자료형 불일치 오류 발생
    val b: Double = a.toDouble() // 변환 메소드 사용
		// Long형 + int형 -> 자료형이 표현할 수 있는 범위가 큰 자료형으로 자동 형 변환 하여 연산됨
    val result = 1L + 3 
}
```

- 기본형과 참조형 자료형의 비교 원리
    - 단순히 값만 비교 : **이중 등호(==)** 사용
    - 참조 주소 비교 : **삼중 등호(===)** 사용

```kotlin
val a: Int = 128 // 기본으로 변환되어 스택에 128이라는 값 자체를 저장
val b: Int? = 128 // 참조형으로 저장되므로 b에는 128이 저장된 힙의 참조 주소가 저장되어 있음
println(a == b) // true
println(a === b) // false
// null을 허용한 변수는 같은 값을 저장해도 이중 등호와 삼중 등호를 사용한 결괏값이 다름
```

```kotlin
fun compare() {
    // 이중 등호 비교와 삼중 등호 비교 사용하기
    val a: Int =128
    val b = a
    println(a===b) // 자료형이 기본형인 int형이 되어 값이 동일하므로 true

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    println(c == d) // 값의 내용만 비교하는 경우 동일하므로 true
    println(c === d) // 값의 내용은 같지만 참조 주소를 비교해 다른 객체(주소 다름)이므로 false
    println(c === e) // 값의 내용도 같고 참조된 객체도 동일(주소 동일)하므로 true
}
```

![Untitled 1](https://user-images.githubusercontent.com/58503875/154808017-e20a55cf-a083-4387-96f4-5efb0fceaaee.png)

- 스마트 캐스트
    - 컴파일러가 자동으로 형 변환을 함
    - Number형 : 숫자를 저장하기 위한 특수한 자료형 객체를 만듦
- 묵시적 변환
    - any형 : 자료형이 특별히 정해지지 않은 경우에 사용
        - 모든 클래스의 뿌리

```kotlin
fun main() {
    checkArg("Hello")
    checkArg(5)
}

fun checkArg(x: Any) {
    if (x is String) {
        println("x is String : $x")
    }

    if (x is Int) {
        println("x is Int: $x")
    }
}
```

## 3. 코틀린 연산자

자바의 삼항 연산자는 코틀린에서 사용하지 않는다.

단항, 이항 등과 같은 연산자 용어와 연산자의 우선순위를 알아 두는 것이 중ㅇ요