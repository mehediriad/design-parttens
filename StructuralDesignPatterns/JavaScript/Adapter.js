// Target Interface
class MediaPlayer {
    play(mediaType) {
        throw new Error("This method should be overridden!");
    }
}
// Adaptee
class MediaAdapter {
    constructor(mediaType) {
        if (mediaType === "mp4") {
            this.player = new Mp4Player();
        } else if (mediaType === "vlc") {
            this.player = new VlcPlayer();
        }
    }

    play(mediaType) {
        if (mediaType === "mp4") {
            this.player.playMp4();
        } else if (mediaType === "vlc") {
            this.player.playVlc();
        }
    }
}

// Adaptee Classes
class Mp4Player {
    playMp4() {
        console.log("Playing MP4 file");
    }
}

class VlcPlayer {
    playVlc() {
        console.log("Playing VLC file");
    }
}

// Client
class AudioPlayer extends MediaPlayer {
    constructor() {
        super();
        this.mediaAdapter = null;
    }

    play(mediaType) {
        if (mediaType === "mp3") {
            console.log("Playing MP3 file");
        } else {
            this.mediaAdapter = new MediaAdapter(mediaType);
            this.mediaAdapter.play(mediaType);
        }
    }
}

// Client Code
const audioPlayer = new AudioPlayer();

audioPlayer.play("mp3"); // Output: Playing MP3 file
audioPlayer.play("mp4"); // Output: Playing MP4 file
audioPlayer.play("vlc"); // Output: Playing VLC file
