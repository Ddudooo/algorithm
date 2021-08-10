# [상호 평가](https://programmers.co.kr/learn/courses/30/lessons/83201)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>대학 교수인 당신은, 상호평가를 통하여 학생들이 제출한 과제물에 학점을 부여하려고 합니다. 아래는 0번부터 4번까지 번호가 매겨진 5명의 학생들이 자신과 다른 학생의 과제를 평가한 점수표입니다.</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td><strong>0</strong></td>
<td><strong>1</strong></td>
<td><strong>2</strong></td>
<td><strong>3</strong></td>
<td><strong>4</strong></td>
</tr>
<tr>
<td><strong>0</strong></td>
<td><del><strong>100</strong></del></td>
<td>90</td>
<td>98</td>
<td>88</td>
<td>65</td>
</tr>
<tr>
<td><strong>1</strong></td>
<td>50</td>
<td><del><strong>45</strong></del></td>
<td>99</td>
<td>85</td>
<td>77</td>
</tr>
<tr>
<td><strong>2</strong></td>
<td>47</td>
<td>88</td>
<td><strong>95</strong></td>
<td>80</td>
<td>67</td>
</tr>
<tr>
<td><strong>3</strong></td>
<td>61</td>
<td>57</td>
<td>100</td>
<td><strong>80</strong></td>
<td>65</td>
</tr>
<tr>
<td><strong>4</strong></td>
<td>24</td>
<td>90</td>
<td>94</td>
<td>75</td>
<td><strong>65</strong></td>
</tr>
<tr>
<td><strong>평균</strong></td>
<td>45.5</td>
<td>81.25</td>
<td>97.2</td>
<td>81.6</td>
<td>67.8</td>
</tr>
<tr>
<td><strong>학점</strong></td>
<td>F</td>
<td>B</td>
<td>A</td>
<td>B</td>
<td>D</td>
</tr>
</tbody>
      </table>
<p>위의 점수표에서, i행 j열의 값은 i번 학생이 평가한 j번 학생의 과제 점수입니다.</p>

<ul>
<li>0번 학생이 평가한 점수는 0번 <code>행</code>에담긴 [<strong>100</strong>, 90, 98, 88, 65]입니다.

<ul>
<li>0번 학생은 자기 자신에게 100점, 1번 학생에게 90점, 2번 학생에게 98점, 3번 학생에게 88점, 4번 학생에게 65점을 부여했습니다.</li>
</ul></li>
<li>2번 학생이 평가한 점수는 2번 <code>행</code>에담긴 [47, 88, <strong>95</strong>, 80, 67]입니다.

<ul>
<li>2번 학생은 0번 학생에게 47점, 1번 학생에게 88점, 자기 자신에게 95점, 3번 학생에게 80점, 4번 학생에게 67점을 부여했습니다.<br></li>
</ul></li>
</ul>

<p>당신은 각 학생들이 받은 점수의 평균을 구하여, 기준에 따라 학점을 부여하려고 합니다.<br>
만약, 학생들이 자기 자신을 평가한 점수가 <strong>유일한 최고점</strong> 또는 <strong>유일한 최저점</strong>이라면 그 점수는 제외하고 평균을 구합니다.</p>

<ul>
<li>0번 학생이 받은 점수는 0번 <code>열</code>에 담긴 [<code>100</code>, 50, 47, 61, 24]입니다. 자기 자신을 평가한 100점은 자신이 받은 점수 중에서 유일한 최고점이므로, 평균을 구할 때 제외합니다. 

<ul>
<li>0번 학생의 평균 점수는 (50+47+61+24) / 4 = 45.5입니다.</li>
</ul></li>
<li>4번 학생이 받은 점수는 4번 <code>열</code>에 담긴 [65, 77, 67, 65, <code>65</code>]입니다. 자기 자신을 평가한 65점은 자신이 받은 점수 중에서 최저점이지만 같은 점수가 2개 더 있으므로, 유일한 최저점이 아닙니다. 따라서, 평균을 구할 때 제외하지 않습니다.

<ul>
<li>4번 학생의 평균 점수는 (65+77+67+65+65) / 5 = 67.8입니다. </li>
</ul></li>
</ul>

<p>제외할 점수는 제외하고 평균을 구한 후, 아래 기준에 따라 학점을 부여합니다.</p>
<table class="table">
        <thead><tr>
<th>평균</th>
<th>학점</th>
</tr>
</thead>
        <tbody><tr>
<td>90점 이상</td>
<td>A</td>
</tr>
<tr>
<td>80점 이상 90점 미만</td>
<td>B</td>
</tr>
<tr>
<td>70점 이상 80점 미만</td>
<td>C</td>
</tr>
<tr>
<td>50점 이상 70점 미만</td>
<td>D</td>
</tr>
<tr>
<td>50점 미만</td>
<td>F</td>
</tr>
</tbody>
      </table>
<p>학생들의 점수가 담긴 정수형 2차원 배열 scores가 매개변수로 주어집니다. 이때, 학생들의 학점을 구하여 하나의 문자열로 만들어서 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>scores</code>의 행의 길이(학생 수) ≤ 10</li>
<li><code>scores</code>의 열의 길이 = <code>scores</code>의 행의 길이

<ul>
<li>즉, <code>scores</code>는 행과 열의 길이가 같은 2차원 배열입니다.<br></li>
</ul></li>
<li>0 ≤ <code>scores</code>의 원소 ≤ 100 </li>
<li>return 값 형식

<ul>
<li>0번 학생의 학점부터 차례대로 이어 붙인 하나의 문자열을 return 합니다.<br></li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>scores</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]</td>
<td><code>"FBABD"</code></td>
</tr>
<tr>
<td>[[50,90],[50,87]]</td>
<td><code>"DA"</code></td>
</tr>
<tr>
<td>[[70,49,90],[68,50,38],[73,31,100]]</td>
<td><code>"CFD"</code></td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td><strong>0</strong></td>
<td><strong>1</strong></td>
</tr>
<tr>
<td><strong>0</strong></td>
<td><strong>50</strong></td>
<td>90</td>
</tr>
<tr>
<td><strong>1</strong></td>
<td>50</td>
<td><del><strong>87</strong></del></td>
</tr>
<tr>
<td><strong>평균</strong></td>
<td>50</td>
<td>90</td>
</tr>
<tr>
<td><strong>학점</strong></td>
<td>D</td>
<td>A</td>
</tr>
</tbody>
      </table>
<ul>
<li>1번 학생이 자기 자신을 평가한 87점은 [90, 87]에서 유일한 최저점이므로, 평균을 구할 때 제외합니다.</li>
</ul>

<p><strong>입출력 예 #3</strong></p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td><strong>0</strong></td>
<td><strong>1</strong></td>
<td><strong>2</strong></td>
</tr>
<tr>
<td><strong>0</strong></td>
<td><strong>70</strong></td>
<td>49</td>
<td>90</td>
</tr>
<tr>
<td><strong>1</strong></td>
<td>68</td>
<td><del><strong>50</strong></del></td>
<td>38</td>
</tr>
<tr>
<td><strong>2</strong></td>
<td>73</td>
<td>31</td>
<td><del><strong>100</strong></del></td>
</tr>
<tr>
<td><strong>평균</strong></td>
<td>70.33…</td>
<td>40</td>
<td>64</td>
</tr>
<tr>
<td><strong>학점</strong></td>
<td>C</td>
<td>F</td>
<td>D</td>
</tr>
</tbody>
      </table>
<ul>
<li>1번 학생이 자기 자신을 평가한 50점은 [49, 50, 31]에서 유일한 최고점이므로, 평균을 구할 때 제외합니다.</li>
<li>2번 학생이 자기 자신을 평가한 100점은 [90, 38, 100]에서 유일한 최고점이므로, 평균을 구할 때 제외합니다.</li>
</ul>
</div>
    </div>

---

