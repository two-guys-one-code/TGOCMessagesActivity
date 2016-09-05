package br.com.tgoc.tgocmessage;

/**
 * Created by rodrigocavalcante on 9/5/16.
 */
public interface TGOCMessageActivityTypingInterface {
    boolean isTyping();
    TGOCBubbleInterface typingBubble();
    String typingText();
    TGOCAvatarInterface typingAvatar();
}
