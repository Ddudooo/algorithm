package study.problem;

import java.util.PriorityQueue;

public class Solution {

	public String solution(int n, int t, int m, String[] timetable) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (String time : timetable) {
			queue.add(timeStrToInt(time));
		}
		int startTime = timeStrToInt("09:00");
		int last = startTime;
		int busSeat = 0;
		while (n > 0) {
			busSeat = 0;
			while (!queue.isEmpty() && queue.peek() <= startTime && busSeat < m) {
				last = queue.poll();
				busSeat++;
			}
			startTime += t;
			n--;
		}
		if (busSeat < m) {
			int min = Math.max(startTime - t, last);
			return intToTimeStr(min);
		} else {
			return intToTimeStr(last - 1);
		}
	}

	private int timeStrToInt(String time) {
		String[] split = time.split(":");
		int result = 0;
		result += Integer.parseInt(split[0]) * 60;
		result += Integer.parseInt(split[1]);
		return result;
	}

	private String intToTimeStr(int time) {
		int hour = time / 60;
		int min = time % 60;
		return String.format("%02d:%02d", hour, min);
	}
}