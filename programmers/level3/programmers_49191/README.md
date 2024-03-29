# 순위

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.</p>

<p>선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>선수의 수는 1명 이상 100명 이하입니다.</li>
<li>경기 결과는 1개 이상 4,500개 이하입니다.</li>
<li>results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.</li>
<li>모든 경기 결과에는 모순이 없습니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>results</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>5</td>
<td>[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]</td>
<td>2</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.<br>
5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.</p>

<p><a href="http://contest.usaco.org/JAN08.htm" target="_blank" rel="noopener">출처</a></p>
</div>
    </div>

----

## 메모

플로이드 와샬 알고리즘으로 풀이 작성

플로이드 와샬 알고리즘을 간단하게 정리하자면

모든 정점을 대상으로 거쳐가는 정점기준으로 알고리즘 수행하며

__모든 정점에서 정점간 최단 경로__ 를 구하는데 사용함

```shell
        1    2    3    4    5 
   1    0    1  INF  INF    2 
   2  INF    0  INF  INF    1 
   3  INF    1    0  INF    2 
   4  INF    1    1    0    2 
   5  INF  INF  INF  INF    0
```

테스트 케이스의 단방향 기준으로 각 선수간 연결되는 정보

양방향으로 할시 오류 발생.

양방향으로 할 경우, 두개의 그래프를 지녀야 가능함.

테스트 케이스의 답이 왜 `2`, `5`이냐면

`2` 의 행과 `2` 의 열을 살펴보자면 둘 다 안 거친 정점이 없기(`INF`) 때문에.

마찬가지로 `5`의 경우도 모두 `INF`인 정점이 없기 때문에.

왜 정점간에 정보를 모르면 답이 될 수 없냐면

선수간에 승패를 모르면 해당 선수간에 우위를 알 수 없어 순위를 모른다.

순위를 알려면 자기 자신이 이기는 그룹, 지는 그룹을 알아야 알 수 있다.

따라서 전체 그룹에서 해당 그룹 외에 존재하는 그룹이 존재한다면

현재 자신의 위치를 정확히 알 수 없기 때문에

모든 선수간에 비교 우위를 그래프로 표현하였을 때, 이어지는 정점이 없는 선수는

현재 순위를 정확히 알 수 없는 상태로 판단한다.

사실 예외 케이스를 찾아 보려고 해도 찾을 수가 없어서 여기까지만 메모



----

* [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49191)