# [야근 지수](https://programmers.co.kr/learn/courses/30/lessons/12927)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다. 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다. Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,  퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.</p>

<h5>제한 사항</h5>

<ul>
<li><code>works</code>는 길이 1 이상, 20,000 이하인 배열입니다.</li>
<li><code>works</code>의 원소는 50000 이하인 자연수입니다.</li>
<li><code>n</code>은 1,000,000 이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>works</th>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[4, 3, 3]</td>
<td>4</td>
<td>12</td>
</tr>
<tr>
<td>[2, 1, 2]</td>
<td>1</td>
<td>6</td>
</tr>
<tr>
<td>[1,1]</td>
<td>3</td>
<td>0</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
n=4 일 때, 남은 일의 작업량이 [4, 3, 3] 이라면 야근 지수를 최소화하기 위해 4시간동안 일을 한 결과는 [2, 2, 2]입니다. 이 때 야근 지수는 2<sup>2</sup> + 2<sup>2</sup> + 2<sup>2</sup> = 12 입니다.</p>

<p>입출력 예 #2<br>
n=1일 때, 남은 일의 작업량이 [2,1,2]라면 야근 지수를 최소화하기 위해 1시간동안 일을 한 결과는 [1,1,2]입니다. 야근지수는 1<sup>2</sup> + 1<sup>2</sup> + 2<sup>2</sup> = 6입니다.</p>

<p>입출력 예 #3</p>
</div>
    </div>

---

## 메모

가장 적게 야근 피로도를 만드는 것이 목적으로

입출력 예시를 자세히 살펴보면 알 수 있듯.

입력으로 주어진 업무 내용을 평준화 시키면 된다.

야근 피로도가 제곱으로 이루어지기 때문에

**한마디로 가장 높은 업무량을 하나씩 줄여주면 된다.**