# [불량 사용자](https://programmers.co.kr/learn/courses/30/lessons/64064)

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>개발팀 내에서 이벤트 개발을 담당하고 있는 "무지"는 최근 진행된 카카오이모티콘 이벤트에 비정상적인 방법으로 당첨을 시도한 응모자들을 발견하였습니다. 이런 응모자들을 따로 모아 <code>불량 사용자</code>라는 이름으로 목록을 만들어서 당첨 처리 시 제외하도록 이벤트 당첨자 담당자인 "프로도" 에게 전달하려고 합니다. 이 때 개인정보 보호을 위해 사용자 아이디 중 일부 문자를 '*' 문자로 가려서 전달했습니다. 가리고자 하는 문자 하나에 '*' 문자 하나를 사용하였고 아이디 당 최소 하나 이상의 '*' 문자를 사용하였습니다.<br>
"무지"와 "프로도"는 불량 사용자 목록에 매핑된 응모자 아이디를 <code>제재 아이디</code> 라고 부르기로 하였습니다.</p>

<p>예를 들어, 이벤트에 응모한 전체 사용자 아이디 목록이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th>응모자 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>frodo</td>
</tr>
<tr>
<td>fradi</td>
</tr>
<tr>
<td>crodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
<tr>
<td>frodoc</td>
</tr>
</tbody>
      </table>
<p>다음과 같이 불량 사용자 아이디 목록이 전달된 경우,</p>
<table class="table">
        <thead><tr>
<th>불량 사용자</th>
</tr>
</thead>
        <tbody><tr>
<td>fr*d*</td>
</tr>
<tr>
<td>abc1**</td>
</tr>
</tbody>
      </table>
<p>불량 사용자에 매핑되어 당첨에서 제외되어야 야 할 제재 아이디 목록은 다음과 같이 두 가지 경우가 있을 수 있습니다.</p>
<table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>frodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>fradi</td>
</tr>
<tr>
<td>abc123</td>
</tr>
</tbody>
      </table>
<p>이벤트 응모자 아이디 목록이 담긴 배열 user_id와 불량 사용자 아이디 목록이 담긴 배열 banned_id가 매개변수로 주어질 때, 당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능한 지 return 하도록 solution 함수를 완성해주세요.</p>

<h4><strong>[제한사항]</strong></h4>

<ul>
<li>user_id 배열의 크기는 1 이상 8 이하입니다.</li>
<li>user_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.

<ul>
<li>응모한 사용자 아이디들은 서로 중복되지 않습니다.</li>
<li>응모한 사용자 아이디는 알파벳 소문자와 숫자로만으로 구성되어 있습니다.</li>
</ul></li>
<li>banned_id 배열의 크기는 1 이상 user_id 배열의 크기 이하입니다.</li>
<li>banned_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.

<ul>
<li>불량 사용자 아이디는 알파벳 소문자와 숫자, 가리기 위한 문자 '*' 로만 이루어져 있습니다.</li>
<li>불량 사용자 아이디는 '*' 문자를 하나 이상 포함하고 있습니다.</li>
<li>불량 사용자 아이디 하나는 응모자 아이디 중 하나에 해당하고 같은 응모자 아이디가 중복해서 제재 아이디 목록에 들어가는 경우는 없습니다.</li>
</ul></li>
<li>제재 아이디 목록들을 구했을 때 아이디들이 나열된 순서와 관계없이 아이디 목록의 내용이 동일하다면 같은 것으로 처리하여 하나로 세면 됩니다.</li>
</ul>

<hr>

<h5><strong>[입출력 예]</strong></h5>
<table class="table">
        <thead><tr>
<th>user_id</th>
<th>banned_id</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>["frodo", "fradi", "crodo", "abc123", "frodoc"]</code></td>
<td><code>["fr*d*", "abc1**"]</code></td>
<td>2</td>
</tr>
<tr>
<td><code>["frodo", "fradi", "crodo", "abc123", "frodoc"]</code></td>
<td><code>["*rodo", "*rodo", "******"]</code></td>
<td>2</td>
</tr>
<tr>
<td><code>["frodo", "fradi", "crodo", "abc123", "frodoc"]</code></td>
<td><code>["fr*d*", "*rodo", "******", "******"]</code></td>
<td>3</td>
</tr>
</tbody>
      </table>
<h5><strong>입출력 예에 대한 설명</strong></h5>

<h5><strong>입출력 예 #1</strong></h5>

<p>문제 설명과 같습니다.</p>

<h5><strong>입출력 예 #2</strong></h5>

<p>다음과 같이 두 가지 경우가 있습니다.</p>
<table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>frodo</td>
</tr>
<tr>
<td>crodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>frodo</td>
</tr>
<tr>
<td>crodo</td>
</tr>
<tr>
<td>frodoc</td>
</tr>
</tbody>
      </table>
<h5><strong>입출력 예 #3</strong></h5>

<p>다음과 같이 세 가지 경우가 있습니다.</p>
<table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>frodo</td>
</tr>
<tr>
<td>crodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
<tr>
<td>frodoc</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>fradi</td>
</tr>
<tr>
<td>crodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
<tr>
<td>frodoc</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>제재 아이디</th>
</tr>
</thead>
        <tbody><tr>
<td>fradi</td>
</tr>
<tr>
<td>frodo</td>
</tr>
<tr>
<td>abc123</td>
</tr>
<tr>
<td>frodoc</td>
</tr>
</tbody>
      </table></div>
    </div>

---

## 메모

완전히 동일한 제재아이디 리스트가 나왔을때 처리를 안해줘서

오래걸렸다...

크게 세가지 동작으로 결과값을 도출한다.

1. `banned_id`를 순회한다.
2. 순회중인 `banned_id` 와 매칭되는 `user_id`, 제재 아이디들을 해당 순번에 맞게 저장한다.
3. 도출된 `banned_id`별 제대아이디들을 dfs 방식으로 순회하면서 제재 리스트를 생성한다.

결과는 도출된 제재 리스트의 크기다.

