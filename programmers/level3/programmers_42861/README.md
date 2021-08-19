# [섬 연결하기](https://programmers.co.kr/learn/courses/30/lessons/42861)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.</p>

<p>다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.</p>

<p><strong>제한사항</strong></p>

<ul>
<li>섬의 개수 n은 1 이상 100 이하입니다.</li>
<li>costs의 길이는 <code>((n-1) * n) / 2</code>이하입니다.</li>
<li>임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.</li>
<li>같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.</li>
<li>모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.</li>
<li>연결할 수 없는 섬은 주어지지 않습니다.</li>
</ul>

<p><strong>입출력 예</strong></p>
<table class="table">
        <thead><tr>
<th>n</th>
<th>costs</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>4</td>
<td>[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]</td>
<td>4</td>
</tr>
</tbody>
      </table>
<p><strong>입출력 예 설명</strong></p>

<p>costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.</p>

<p><img src="https://grepp-programmers.s3.amazonaws.com/files/production/13e2952057/f2746a8c-527c-4451-9a73-42129911fe17.png" title="" alt="image.png"></p>
</div>
    </div>

---

# 메모

최소 신장 트리를 만들어 해당 트리의 비용을 계산하면 되는 문제

비용이 적은 순으로 최소 신장 트리를 만들어야 하기에

입력으로 들어온 `costs`를 비용을 오름차순으로 정렬 후 처리한다.

자세한 내용은 크루스칼 알고리즘과 최소 신장 트리를 찾아보면서 확인하자.