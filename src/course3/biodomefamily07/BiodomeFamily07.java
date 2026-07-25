package course3.biodomefamily07;

import java.util.List;

public class BiodomeFamily07 {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();
        Player player = new Player();

        try {
            // 1. 라이브러리에 노래 5곡 추가
            library.addSong(new AnimalSong("초원을 그리며", 2, "레이나", "사슴"));
            library.addSong(new AnimalSong("영웅 호테", 1, "돈키", "당나귀"));
            library.addSong(new AnimalSong("과자를 줄게", 3, "제롬", "코끼리"));
            library.addSong(new ManagerSong("화양연화", 2, "장양림", "재즈"));
            library.addSong(new ManagerSong("시간의 수평선", 4, "하윤", "팝"));
            System.out.println();

            // 2. 사람을 위한 음악을 검색하고 첫번째 곡을 플레이어로 재생
            List<Song> humanSongs = library.getHumanSongs();
            Song firstHumanSong = humanSongs.get(0);
            player.setCurrentSong(firstHumanSong);
            player.play();

            // 3. 볼륨을 30으로 설정
            player.setVolume(30);

            // 4. '당나귀'를 위한 음악을 검색하고 플레이어로 재생
            List<Song> donkeySongs = library.searchByAnimal("당나귀");
            Song donkeySong = donkeySongs.get(0);
            player.setCurrentSong(donkeySong);
            player.play();
            System.out.println();

            // 5. 노래 제목으로 노래 1곡 삭제
            library.removeSong("시간의 수평선");

        } catch (Exception e) {
            System.out.println("[예외 안내] " + e.getMessage());
        }
    }
}
