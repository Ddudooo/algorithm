# 타겟 넘버

[문제 주소](https://programmers.co.kr/learn/courses/30/lessons/43165)

문제 설명 n개의 음이 아닌 정수가 있습니다.  
이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.    
예를 들어 `[1, 1, 1, 1, 1]`로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

```html
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

사용할 수 있는 숫자가 담긴 배열 `numbers`, 타겟 넘버 `target`이 매개변수로 주어질 때

숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 `return` 하도록 `solution` 함수를 작성해주세요.

---
제한사항

주어지는 숫자의 개수는 2개 이상 20개 이하입니다.

각 숫자는 1 이상 50 이하인 자연수입니다.

타겟 넘버는 1 이상 1000 이하인 자연수입니다.

---

### 메모

코틀린 풀이 기가 막혀서 추가함

완전 짧아짐.

```kotlin
class Solution {
    fun solution(numbers: IntArray, target: Int): Int = dfs(numbers, target)

    private fun dfs(numbers: IntArray, target: Int): Int =
        numbers.fold(listOf(0)) { list, number ->
            list.run {
                map { it + number } + map { it - number }
            }
        }.count { it == target }
}
```

`fold` 메소드를 이용해 기본적으로 `list` 선언 후 모든 경우의 수를 `list` 내에 추가
`count` 메소드를 통해 원하는 값이 나온 경우만 카운팅.

기가 막힘...