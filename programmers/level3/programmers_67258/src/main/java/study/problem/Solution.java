package study.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public int[] solution(String[] gems) {
		Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
		if (gemKinds.size() == 1) {
			return new int[]{1, 1}; // 보석 종류가 하나일 경우엔 모든 보석이 하나만 이루어짐.
		}
		Queue<String> buyList = new LinkedList<>();
		Map<String, Integer> gemCntMap = new HashMap<>();
		int startPoint = 0;
		int start = 0;
		int buySize = Integer.MAX_VALUE;
		for (String gem : gems) { // 보석 마다 순회하면서
			gemCntMap.put(gem, gemCntMap.getOrDefault(gem, 0) + 1); // 보석 개수를 추가한다.
			buyList.add(gem); // 사려는 보석으로 넣어놓고

			while (true) {
				// 사려는 보석 리스트를 맨 앞부터 검사하여
				String firstBuy = buyList.peek();

				if (gemCntMap.get(firstBuy) > 1) {
					// 구매하려는 맨 앞 보석의 보석이 추가된 경우
					// 해당 보석은 제외한다.
					removeGem(buyList, gemCntMap, firstBuy);
					startPoint++;
				} else {
					break; // 그 외에는 전부 구매한다.
				}
			}

			if (gemCntMap.size() == gemKinds.size() //종류별로 하나이상씩 구매리스트에 추가된 경우
				&& buySize > buyList.size()) { // 이전 구매량과 비교하여, 적을 경우
				buySize = buyList.size();    // 구매량을 갱신하고
				start = startPoint;     // 구매 시작점도 갱신한다.
			}
		}
		// 구매 시작점부터 구매량까지.
		// 번호가 1부터 시작되어 1을 시작점에 추가한다.
		return new int[]{start + 1, start + buySize};
	}

	private void removeGem(Queue<String> buyQueue, Map<String, Integer> gemCntMap, String gemName) {
		buyQueue.poll();
		gemCntMap.put(gemName, gemCntMap.get(gemName) - 1);
	}
}