# [거스름돈](https://programmers.co.kr/learn/courses/30/lessons/12907)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>Finn은 편의점에서 야간 아르바이트를 하고 있습니다. 야간에 손님이 너무 없어 심심한 Finn은 손님들께 거스름돈을 n 원을 줄 때 방법의 경우의 수를 구하기로 하였습니다.</p>

<p>예를 들어서 손님께 5원을 거슬러 줘야 하고 1원, 2원, 5원이 있다면 다음과 같이 4가지 방법으로 5원을 거슬러 줄 수 있습니다.</p>

<ul>
<li>1원을 5개 사용해서 거슬러 준다.</li>
<li>1원을 3개 사용하고, 2원을 1개 사용해서 거슬러 준다.</li>
<li>1원을 1개 사용하고, 2원을 2개 사용해서 거슬러 준다.</li>
<li>5원을 1개 사용해서 거슬러 준다.</li>
</ul>

<p>거슬러 줘야 하는 금액 n과 Finn이 현재 보유하고 있는 돈의 종류 money가 매개변수로 주어질 때, Finn이 n 원을 거슬러 줄 방법의 수를 return 하도록 solution 함수를 완성해 주세요.</p>

<h5>제한 사항</h5>

<ul>
<li>n은 100,000 이하의 자연수입니다.</li>
<li>화폐 단위는 100종류 이하입니다.</li>
<li>모든 화폐는 무한하게 있다고 가정합니다.</li>
<li>정답이 커질 수 있으니, 1,000,000,007로 나눈 나머지를 return 해주세요.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>money</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>5</td>
<td>[1,2,5]</td>
<td>4</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
문제의 예시와 같습니다.</p>
</div>
    </div>

---

# 메모

앞서 풀었던 1칸 혹은 2칸 이동했을때 몇가지 방법으로 갈 수 있나와 매우 유사한 문제이다

돈이 `n`이라면 `-n` 금액을 지불하는 방법에서 추가해주면된다

자세히 살펴보자

예시로 문제의 예제 입출력을 좀 더 살펴 보자

`1`만으로 반환했을 경우 가짓수이다.

| money| 0| 1| 2| 3 | 4 | 5 |
|---|---|---|---|---|---|---|
|  1|  1|  1|  1|  1|  1|  1|

추가로 `2`를 포함하여 반환했을 경우 가짓수

| money| 0| 1| 2| 3 | 4 | 5 |
|---|---|---|---|---|---|---|
|  1|  1|  1|  1|  1|  1|  1|
|  2|  1|  1|  2|  2|  3|  3|

추가로 `5`를 포함하여 반환했을 경우 가짓수

| money| 0| 1| 2| 3 | 4 | 5 |
|---|---|---|---|---|---|---|
|  1|  1|  1|  1|  1|  1|  1|
|  2|  1|  1|  2|  2|  3|  3|
|  5|  1|  1|  2|  2|  3|  4|

단순하게 가장 작은 돈부터 가짓수를 정리했을때

돈크기만큼 이전 돈에 필요한 가짓수를 더하면 된다.