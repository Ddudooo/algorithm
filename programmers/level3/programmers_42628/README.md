# 이중우선순위 큐

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.</p>
<table class="table">
        <thead><tr>
<th>명령어</th>
<th>수신 탑(높이)</th>
</tr>
</thead>
        <tbody><tr>
<td>I 숫자</td>
<td>큐에 주어진 숫자를 삽입합니다.</td>
</tr>
<tr>
<td>D 1</td>
<td>큐에서 최댓값을 삭제합니다.</td>
</tr>
<tr>
<td>D -1</td>
<td>큐에서 최솟값을 삭제합니다.</td>
</tr>
</tbody>
      </table>
<p>이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.</li>
<li>operations의 원소는 큐가 수행할 연산을 나타냅니다.

<ul>
<li>원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.</li>
</ul></li>
<li>빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>operations</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>["I 16","D 1"]</td>
<td>[0,0]</td>
</tr>
<tr>
<td>["I 7","I 5","I -5","D -1"]</td>
<td>[7,5]</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.<br>
7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.</p>

<p><a href="http://icpckorea.org/problems/2013/onlineset.pdf" target="_blank" rel="noopener">출처</a></p>
</div>
    </div>

---

## 메모

큐를 이용하여 입출력에 따른 큐 변경을 해야 하는 문제

`Deque` 와 `PriorityQueue` 의 기능을 섞어서 구현하면 된다.

테스트 케이스가 부족한듯...

날로 써도 그냥 통과됨

---

* [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42628)