package study.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public String[] solution(String[] record) {
		List<Record> records = new ArrayList<>();
		Map<String, String> names = new HashMap<>();
		for (String input : record) {
			StringTokenizer st = new StringTokenizer(input);
			String event = st.nextToken();
			String id = st.nextToken();
			if (st.hasMoreTokens()) {
				String name = st.nextToken();
				names.put(id, name);
			}
			records.add(Record.of(event, id));
		}

		return records.stream()
			.filter(r -> !r.getEvent().equals(Event.CHANGE))
			.map(r -> String.format("%s님이 %s", names.get(r.getId()), r.getEvent()))
			.toArray(String[]::new);
	}
}

class Record {

	private final String id;
	private final Event event;

	public Record(String id, Event event) {
		this.id = id;
		this.event = event;
	}

	public static Record of(String event, String id) {
		return new Record(id, Event.getEvent(event));
	}

	public String getId() {
		return id;
	}

	public Event getEvent() {
		return this.event;
	}
}

enum Event {
	ENTER,
	LEAVE,
	CHANGE;

	public static Event getEvent(String event) {
		for (Event e : Event.values()) {
			if (e.name().equalsIgnoreCase(event)) {
				return e;
			}
		}
		throw new IllegalArgumentException("not matching event");
	}

	@Override
	public String toString() {
		switch (this) {
			case ENTER:
				return "들어왔습니다.";
			case LEAVE:
				return "나갔습니다.";
			default:
				return "";
		}
	}
}