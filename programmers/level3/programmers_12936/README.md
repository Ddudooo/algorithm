# [줄 서는 방법](https://programmers.co.kr/learn/courses/30/lessons/12936)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>n명의 사람이 일렬로 줄을 서고 있습니다.  n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.</p>

<ul>
<li>[1, 2, 3]</li>
<li>[1, 3, 2]</li>
<li>[2, 1, 3]</li>
<li>[2, 3, 1]</li>
<li>[3, 1, 2]</li>
<li>[3, 2, 1]</li>
</ul>

<p>사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return하는 solution 함수를 완성해주세요.</p>

<h6>제한사항</h6>

<ul>
<li>n은 20이하의 자연수 입니다.</li>
<li>k는 n! 이하의 자연수 입니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>k</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>3</td>
<td>5</td>
<td>[3,1,2]</td>
</tr>
</tbody>
      </table>
<h5>입출력 예시 설명</h5>

<p>입출력 예 #1<br>
문제의 예시와 같습니다.</p>
</div>
    </div>

---

# 메모

처음에는 모든 순서를 구해서 처리하려고 하였으나

숫자 크기에 따라 기하급수적으로 증가하여 규칙에 따른 순서 입력으로 바꾸었다.

규칙은 아래와 같은데

첫 순서는

들어갈 수 있는 숫자들을 오름차순으로 정렬했을때

`k` 를 `(n - 1)!` 로 나눈 값과 같다.

다음 순서를 입력하기 위해서는

이미 입력된 숫자와 그에 따른 변경사항을 고려해서 처리해야 하는데

뒷 부분은 검색을 통해 알아보았다...

문제 본문을 예시로 들었을 경우

`n` 이 3, `k` 가 5인데 순서는 대략 다음과 같이 6가지다

* `[1, 2, 3]`
* `[1, 3, 2]`
* `[2, 1, 3]`
* `[2, 3, 1]`
* `[3, 1, 2]`
* `[3, 2, 1]`

첫 순서는 위에서 알아보았고

두번째부터 변경사항 반영은

숫자로 들어올 수 있는 `[1,2]` 변경에 따른 반영이다

* `[1, 2]`
* `[2, 1]`

가 올 수 있는데, 결과 값이 `[3, 1, 2]`이기에

이는 `n` 이 2, 이고 `k`가 1일때가 필요하다는 결론이 나온다.

따라서 `n` 을 1 차감하고

`k` 는 `(n-1)!`에서 `k`로 나눈 나머지 값이 된다.

효율성 테스트 통과를 위해 검색을 통해 풀었는데

팩토리얼 계산을 여러번할 필요 없이 첫 계산이후 계속 해당 값을 나누어

순서에 맞는 팩토리얼 값을 계산할 수 있다.

멍청하게 풀어서 오래걸렸다.