package course3.biodomefamily07;

public class Player {
    private Song currentSong;
    private int volume;

    public Player() {
        this.currentSong = null;
        this.volume = 1; // 기본 볼륨 1
    }

    public Player(Song currentSong, int volume) {
        this.currentSong = currentSong;
        this.volume = volume;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        // 1. 현재 곡의 타입에 따라 max Limit 결정
        int maxLimit = (currentSong instanceof AnimalSong) ? 5 : 50;
        // 2. 범위 검사 및 예외 던지기
        if (volume < 0 || volume > maxLimit) {
            throw new IllegalArgumentException("볼륨 조절 범위를 초과했습니다. (허용 범위: 0 ~ " + maxLimit + ")");
        }
        // 3. 정상 변경 및 출력
        this.volume = volume;
        String postposition = (volume == 30 || volume == 10 || volume == 0) ? "으로" : "로";
        System.out.println("볼륨을 " + this.volume + postposition + " 설정합니다.");
    }

    public void play() {
        if (currentSong == null) {
            throw new IllegalStateException("재생할 음악이 없습니다.");
        }
        // 재생 전 동물 노래 자동 볼륨 조절
        if (currentSong instanceof AnimalSong && this.volume >= 5) {
            this.volume = 5;
            System.out.println("볼륨을 5로 설정합니다.");
        }
        System.out.println("\"" + currentSong + "\" 재생합니다.");
    }
}
