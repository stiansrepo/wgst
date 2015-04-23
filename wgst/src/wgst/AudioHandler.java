package wgst;

import java.applet.Applet;
import java.applet.AudioClip;
/**
 * @author DesktopStian
 */
public class AudioHandler {
        public static final AudioClip BALL = Applet.newAudioClip(AudioHandler.class.getResource("/ball.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(AudioHandler.class.getResource("/gameover.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(AudioHandler.class.getResource("/back.wav"));
        public static final AudioClip EXPLODE = Applet.newAudioClip(AudioHandler.class.getResource("/explode.wav"));
}
