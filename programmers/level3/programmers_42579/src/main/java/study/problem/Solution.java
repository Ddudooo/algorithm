package study.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Solution {

	public int[] solution(String[] genres, int[] plays) {
		int songCnt = genres.length;
		Map<String, Integer> genreCounter = new HashMap<>();
		List<Song> songs = new ArrayList<>();
		for (int i = 0; i < songCnt; i++) {
			int idx = i;
			String genre = genres[i];
			int play = plays[i];
			songs.add(new Song(idx, genre, play));
			genreCounter.put(genre, genreCounter.getOrDefault(genre, 0) + play);
		}
		List<Integer> answer = new ArrayList<>();
		while (genreCounter.keySet().size() != 0) {
			String mostPlayGenre = nextMostPlayGenre(genreCounter);
			songs.stream()
				.filter(song -> song.getGenre().equals(mostPlayGenre))
				.sorted((a, b) -> {
					if (a.getPlay() == b.getPlay()) {
						return Integer.compare(a.getIdx(), b.getIdx());
					}
					return -1 * Integer.compare(a.getPlay(), b.getPlay());
				})
				.limit(2)
				.forEach(song -> {
					answer.add(song.getIdx());
				});
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private String nextMostPlayGenre(Map<String, Integer> map) {
		Set<String> strings = map.keySet();
		if (strings.size() == 0) {
			return "";
		}
		int max = Integer.MIN_VALUE;
		String mostPlayedGenre = "";
		for (String genre : strings) {
			if (max < map.get(genre)) {
				mostPlayedGenre = genre;
				max = map.get(genre);
			}
		}
		map.remove(mostPlayedGenre);
		return mostPlayedGenre;
	}
}

class Song {

	private final int idx;
	private final String genre;
	private final int play;

	public Song(int idx, String genre, int play) {
		this.idx = idx;
		this.genre = genre;
		this.play = play;
	}

	public int getIdx() {
		return idx;
	}

	public String getGenre() {
		return genre;
	}

	public int getPlay() {
		return play;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
			.add("idx=" + idx)
			.add("genre='" + genre + "'")
			.add("play=" + play)
			.toString();
	}
}