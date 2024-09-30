import java.util.ArrayList;

/**
 * A class to hold details of audio tracks.
 * This version can add, remove, play, stop, and search tracks.
 *
 * @author David J. Barnes
 * @version 2021.07.31
 */
public class MusicOrganizer {
    private final ArrayList<Track> tracks;
    private final MusicPlayer player;
    private int currentTrackIndex;

    public MusicOrganizer() {
        tracks = new ArrayList<>();
        player = new MusicPlayer();
        currentTrackIndex = -1;
    }

    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("Track added: " + track.getDetails());
    }

    public void removeTrack(int index) {
        if (indexValid(index)) {
            Track removedTrack = tracks.remove(index);
            System.out.println("Removed track: " + removedTrack.getDetails());

            if (index == currentTrackIndex) {
                stopPlaying();
            } else if (index < currentTrackIndex) {
                currentTrackIndex--;
            }
        } else {
            System.out.println("Invalid track index.");
        }
    }

    public void startPlayingTrack(int index) {
        if (indexValid(index)) {
            if (currentTrackIndex != -1) {
                stopPlaying();
            }
            currentTrackIndex = index;
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getDetails());
        } else {
            System.out.println("Invalid track index.");
        }
    }

    public void stopPlaying() {
        if (currentTrackIndex != -1) {
            player.stop();
            System.out.println("Stopped playing.");
            currentTrackIndex = -1;
        } else {
            System.out.println("No track is currently playing.");
        }
    }

    public void nextTrack() {
        if (currentTrackIndex != -1 && currentTrackIndex < tracks.size() - 1) {
            startPlayingTrack(currentTrackIndex + 1);
        } else {
            System.out.println("No next track available.");
        }
    }

    public void showCurrentlyPlaying() {
        if (currentTrackIndex != -1) {
            Track track = tracks.get(currentTrackIndex);
            System.out.println("Currently playing: " + track.getDetails());
        } else {
            System.out.println("No track is currently playing.");
        }
    }

    public void listAllTracks() {
        System.out.println("Track listing:");
        if (tracks.isEmpty()) {
            System.out.println("No tracks in the list.");
        } else {
            for (int i = 0; i < tracks.size(); i++) {
                System.out.println(i + ": " + tracks.get(i).getDetails());
            }
        }
    }

    private boolean indexValid(int index) {
        return index >= 0 && index < tracks.size();
    }
}
