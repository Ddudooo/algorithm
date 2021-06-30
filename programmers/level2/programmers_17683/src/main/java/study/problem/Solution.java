package study.problem;

public class Solution {

	public String solution(String m, String[] musicinfos) {
		m = replaceMelody(m);
		MusicInfo answer = MusicInfo.defaultValue();
		for (String musicInfo : musicinfos) {
			String[] infos = musicInfo.split(",");
			infos[3] = replaceMelody(infos[3]);
			MusicInfo music = MusicInfo.of(infos[2], infos[0], infos[1], infos[3]);
			if (matching(m, music) && answer.playTime < music.playTime) {
				answer = music;
			}
		}
		return answer.name;
	}

	private String replaceMelody(String melody) {
		melody = melody.replaceAll("C#", "c");
		melody = melody.replaceAll("D#", "d");
		melody = melody.replaceAll("F#", "f");
		melody = melody.replaceAll("G#", "g");
		melody = melody.replaceAll("A#", "a");
		return melody;
	}

	private boolean matching(String melody, MusicInfo musicInfo) {
		return musicInfo.melody.contains(melody);
	}
}

class MusicInfo implements Comparable<MusicInfo> {

	String name;
	String melody;
	int playTime;

	public MusicInfo() {

	}

	public static MusicInfo defaultValue() {
		MusicInfo musicInfo = new MusicInfo();
		musicInfo.name = "(None)";
		musicInfo.melody = "";
		musicInfo.playTime = 0;
		return musicInfo;
	}

	public static MusicInfo of(String name, String startTime, String endTime, String melody) {
		MusicInfo musicInfo = new MusicInfo();
		musicInfo.name = name;
		int musicTime = musicInfo.calcPlayTime(startTime, endTime);
		musicInfo.playTime = musicTime;
		StringBuilder sb = new StringBuilder();
		int repeatCnt = musicTime / melody.length();
		for (int i = 0; i < repeatCnt; i++) {
			sb.append(melody);
		}
		int cutPoint = musicTime % melody.length();
		sb.append(melody.substring(0, cutPoint));
		musicInfo.melody = sb.toString();
		return musicInfo;
	}

	private int calcPlayTime(String startTime, String endTime) {
		return getTime(endTime) - getTime(startTime);
	}

	private int getTime(String timeStr) {
		String[] split1 = timeStr.split(":");
		return Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);
	}

	@Override
	public int compareTo(MusicInfo o) {
		return this.playTime - o.playTime;
	}
}