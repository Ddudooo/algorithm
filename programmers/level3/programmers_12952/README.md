# [N-Queen](https://programmers.co.kr/learn/courses/30/lessons/12952)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.</p>

<p>예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.</p>

<p><img src="https://i.imgur.com/lt2zdK6.png" title="" alt="Imgur"><br>
<img src="https://i.imgur.com/5c5EUrq.png" title="" alt="Imgur"></p>

<p>체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.</li>
<li>n은 12이하의 자연수 입니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>4</td>
<td>2</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
문제의 예시와 같습니다.</p>
</div>
    </div>

---

## 메모

1<= n <= 12 이나

n이 커질수록 이차원 배열이 기하급수적으로 커져

퀸의 위치만 저장하기 위해 일차원 배열을 사용하여 처리.

첫 행에 하나씩 퀸을 놓으면서 처리 가능한 경우 카운트를 올려가면서 처리

일차원 배열로 처리 하였기에 좌표 계산시 주의해야함
