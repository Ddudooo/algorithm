package study.programmers30_42579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		List<Integer> collection = new ArrayList<>();
		Map<String, Integer> genresCntMap = new HashMap<>();
		List<Song> songList = new ArrayList<>();
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			if (genresCntMap.containsKey(genre)) {
				int value = genresCntMap.get(genre) + 1;
				genresCntMap.put(genre, value);
			} else {
				genresCntMap.put(genre, 1);
			}
			songList.add(new Song(i, plays[i], genre));
		}
		List<String> genreRankList = new LinkedList<>();
		songList.sort(Song::compareTo);
		for (Song song : songList) {
			if (!genreRankList.contains(song.genre)) {
				genreRankList.add(song.genre);
			}
		}
		for (String genre : genreRankList) {
			List<Integer> songIdx =
				songList.stream()
					.filter(song -> song.genre.equals(genre))
					.sorted()
					.limit(2)
					.map(song -> song.idx)
					.collect(Collectors.toList());
			collection.addAll(songIdx);
		}
		answer = new int[collection.size()];
		int size = 0;
		for (int idx : collection) {
			answer[size++] = idx;
		}
		return answer;
	}

	class Song implements Comparable<Song> {

		int idx;
		int play;
		String genre;

		public Song(int idx, int play, String genre) {
			this.idx = idx;
			this.play = play;
			this.genre = genre;
		}

		@Override
		public int compareTo(Song o) {
			if (this.play < o.play) {
				return 1;
			} else if (this.play > o.play) {
				return -1;
			}
			return this.idx < o.idx ? -1 : 1;
		}
	}
}