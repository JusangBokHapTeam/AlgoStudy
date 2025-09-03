import java.util.*;
import java.util.stream.Collectors;

class Play implements Comparable<Play> {
    
    private int playCount;
    private int number;
    
    public Play(int playCount, int number) {
        this.playCount = playCount;
        this.number = number;
    }
    
    @Override
    public int compareTo(Play o) {
        if (this.playCount == o.playCount) {
            return this.number - o.number;
        }
        return o.playCount - this.playCount;
    }
    
    public int getNumber() {
        return this.number;
    }
}

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList();
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Play>> playsMapByGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            
            String genre = genres[i];
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
            
            List<Play> playlist = playsMapByGenre.getOrDefault(genre, new ArrayList<>());
            playlist.add(new Play(plays[i], i));
            playsMapByGenre.put(genre, playlist);
        }
        
        List<String> sortedGenres = genreMap.entrySet()
                                            .stream()
                                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                            .map(Map.Entry::getKey)
                                            .collect(Collectors.toList());
        
        for (String genre : sortedGenres) {
            
            List<Play> playlist = playsMapByGenre.get(genre);
            Collections.sort(playlist);
            for (Play play : playlist.subList(0, Math.min(2, playlist.size()))) {
                answer.add(play.getNumber());
            }
        }
       
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    
}
