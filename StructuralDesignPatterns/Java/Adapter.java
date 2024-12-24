// Target Interface
interface MediaPlayer {
    void play(String mediaType);
}

// Adaptee
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String mediaType) {
        if (mediaType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        } else if (mediaType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        }
    }

    @Override
    public void play(String mediaType) {
        if (mediaType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4();
        } else if (mediaType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc();
        }
    }
}

// Adaptee Classes
interface AdvancedMediaPlayer {
    void playVlc();
    void playMp4();
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc() {
        // Do nothing
    }

    @Override
    public void playMp4() {
        System.out.println("Playing MP4 file");
    }
}

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc() {
        System.out.println("Playing VLC file");
    }

    @Override
    public void playMp4() {
        // Do nothing
    }
}

// Client Code
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String mediaType) {
        if (mediaType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file");
        } else {
            mediaAdapter = new MediaAdapter(mediaType);
            mediaAdapter.play(mediaType);
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        
        audioPlayer.play("mp3"); // Output: Playing MP3 file
        audioPlayer.play("mp4"); // Output: Playing MP4 file
        audioPlayer.play("vlc"); // Output: Playing VLC file
    }
}
