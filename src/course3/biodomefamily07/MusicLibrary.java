package course3.biodomefamily07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicLibrary {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        for (int i = 0; i < songs.size(); i++) {
            if (song.getTitle().equals(songs.get(i).getTitle())) {
                throw new IllegalArgumentException("이미 등록한 노래입니다.");
            }
        }
        songs.add(song);
        System.out.println("새로운 노래 \"" + song.toString() + "\" 추가되었습니다.");
    }

    public void removeSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                System.out.println("노래 \"" + songs.get(i).toString() + "\" 삭제되었습니다.");
                songs.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("해당 노래가 없습니다.");
    }

    public List<Song> getHumanSongs() {
        List<Song> humanSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof ManagerSong) {
                humanSongs.add(song);
            }
        }
        if (humanSongs.isEmpty()) {
            throw new IllegalArgumentException("조회할 수 있는 사람용 노래가 없습니다.");
        }
        return humanSongs;
    }
    public List<Song> getAnimalSongs() {
        List<Song> animalSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof AnimalSong) {
                animalSongs.add(song);
            }
        }
        if (animalSongs.isEmpty()) {
            throw new IllegalArgumentException("조회할 수 있는 동물용 노래가 없습니다.");
        }
        return animalSongs;
    }

    public List<Song> searchByAnimal(String animal) {
        List<Song> animalSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof AnimalSong) {
                if (((AnimalSong) song).getTargetAnimal().equals(animal)) {
                    animalSongs.add(song);
                }
            }
        }
        if (animalSongs.isEmpty()) {
            throw new IllegalArgumentException("찾을 수 없습니다.");
        }

        return animalSongs;
    }

    public List<Song> searchByGenre(String genre) {
        List<Song> genreSonogs = new ArrayList<>();
        for (Song song : songs) {
            if (song instanceof ManagerSong) {
                if (((ManagerSong) song).getGenre().equals(genre)) {
                    genreSonogs.add(song);
                }
            }
        }
        if (genreSonogs.isEmpty()) {
            throw new IllegalArgumentException("찾을 수 없습니다.");
        }

        return genreSonogs;
    }

    public void  shuffle() {
        Collections.shuffle(songs);
    }
}
