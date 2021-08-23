package study.problem;

public class Solution {

	public String solution(String play_time, String adv_time, String[] logs) {
		int playTime = timestampToSecond(play_time);
		int advTime = timestampToSecond(adv_time);
		int[] play = new int[playTime + 1];
		for (String log : logs) {
			String[] split = log.split("-");
			addPlayCnt(play, split[0], split[1]);
		}
		long temp = 0;
		for (int i = 0; i <= advTime; i++) {
			temp += play[i];
		}
		long max = temp;
		int idx = 0;
		for (int i = 1; i + advTime <= playTime; i++) {
			temp = temp - play[i - 1] + play[i + advTime - 1];

			if (temp > max) {
				max = temp;
				idx = i;
			}
		}
		return secondToTimestamp(idx);
	}

	private void addPlayCnt(int[] play, String start, String end) {
		int startTime = timestampToSecond(start);
		int endTime = timestampToSecond(end);
		for (int i = startTime; i < endTime; i++) {
			play[i]++;
		}
	}

	private int timestampToSecond(String timestamp) {
		String[] split = timestamp.split(":");
		int hour = Integer.parseInt(split[0]) * 60 * 60;
		int min = Integer.parseInt(split[1]) * 60;
		int sec = Integer.parseInt(split[2]);
		return hour + min + sec;
	}

	private String secondToTimestamp(int second) {
		int hour = second / 3600;
		second = second % 3600;
		int min = second / 60;
		int sec = second % 60;
		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
}