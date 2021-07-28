package study.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Solution {

	public int solution(String[] lines) {
		List<RequestLog> logs = new ArrayList<>();
		for (String line : lines) {
			logs.add(parsingLog(line));
		}
		int answer = 0;
		int size = logs.size();
		if (size == 1) {
			return 1;
		}
		for (int i = 0; i < size; i++) {
			int cnt = 0;
			RequestLog currentLog = logs.get(i);
			for (int j = i; j < size; j++) {
				RequestLog nextLog = logs.get(j);
				if (currentLog.getEnd() + 1000 > nextLog.getStart()) {
					cnt++;
				}
			}
			answer = Math.max(cnt, answer);
		}
		return answer;
	}

	private RequestLog parsingLog(String line) {
		String[] s = line.split(" ");
		String[] timeStr = s[1].split(":");
		long doneTime = 0;
		long hour = Long.parseLong(timeStr[0]);
		long min = Long.parseLong(timeStr[1]);
		doneTime += hour * 60 * 60 * 1000;
		doneTime += min * 60 * 1000;
		String[] secStr = timeStr[2].split("\\.");
		long sec = Long.parseLong(secStr[0]);
		doneTime += sec * 1000;
		long milleSec = Long.parseLong(secStr[1]);
		doneTime += milleSec;
		long duringTime = parsingStrToNanoSecond(s[2]);
		return RequestLog.of(line, doneTime, duringTime);
	}

	private long parsingStrToNanoSecond(String str) {
		str = str.replaceAll("\\D", "");
		str = String.format("%-4s", str);
		str = str.replaceAll(" ", "0");
		return Long.parseLong(str);
	}
}

class RequestLog {

	private final String origin;
	private final long start;
	private final long end;

	private RequestLog(String origin, long start, long end) {
		this.origin = origin;
		this.start = start;
		this.end = end;
	}

	public static RequestLog of(String origin, long endTime, long durationTime) {
		long start = endTime - durationTime + 1;
		return new RequestLog(origin, start, endTime);
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return new StringJoiner("\n")
			.add(RequestLog.class.getSimpleName())
			.add("origin = " + origin)
			.add("start = " + start)
			.add("end = " + end)
			.toString();
	}
}