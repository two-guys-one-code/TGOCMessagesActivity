# TGOCMessagesActivity

TGOCMessagesActivity is a chat UI for your Android application. Based on [JSQMessageViewController](http://www.jessesquires.com/JSQMessagesViewController/)

![Screenshot][img0] &nbsp;&nbsp; ![Screenshot][img1] &nbsp;&nbsp;

# Getting Started

* Extends TGOCMessageActivity in your activity. It will create all UI

```java
public class MainActivity extends TGOCMessageActivity
```

* Create Bubbles and Avatars

```java
TGOCBubble outgoingBubble;
TGOCBubble incomingBubble;
TGOCAvatar outgoingAvatar;
TGOCAvatar incomingAvatar;

//you can use TGOCBubbleFactory to create an incoming and outgoing bubble
public void initBubbleMessages() {
    outgoingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.OUTGOING, "#C7D6DA");
    incomingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.INCOMING, "#FAFFFF");
    outgoingAvatar = new TGOCAvatar(BitmapFactory.decodeResource(getResources(),R.drawable.rod));
    incomingAvatar = new TGOCAvatar(BitmapFactory.decodeResource(getResources(),R.drawable.ed));
}

```

* Implement TGOCMessageActivityiInterface

```java
@Override
public int numberOfItemsInConversation() {
    return this.messages.size();
}

@Override
public TGOCAvatarInterface avatarAtPosition(int position) {
    final TGOCMessage message = this.messages.get(position);

    if (sender_id == message.getSenderId())
        return null; //return null if you don't want avatar on your messages
    else
        return incomingAvatar;
}

@Override
public TGOCMessageInterface messageDataAtPosition(int position) {
    return this.messages.get(position);
}

@Override
public void bindViewHolderAtPosition(TGOCMessageBubbleViewHolderInterface view, int position) {
    view.getSenderTextView().setTextColor(Color.parseColor("#29353A"));
    view.getTextView().setTextColor(Color.parseColor("#29353A"));
}

@Override
public void didSelectMessage(TGOCMessageInterface messageInterface) {
    System.out.println(messageInterface.getSenderDisplayName()+": "+messageInterface.toString()); //called when user click on media messages
}

@Override
public TGOCBubbleInterface messageBubbleAtPosition(int position) {
    final TGOCMessage message = this.messages.get(position);

    if (sender_id == message.getSenderId())
        return outgoingBubble;
    else
        return incomingBubble;
}

@Override
public void didPressSendButton(View view) {
    this.messages.add(new TGOCMessage(0, this.tgocEditText.getText().toString(), "Rodrigo"));
    this.finishSendingMessage();
}
```
* Add your google map v2 api key 

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY" />
```

* **Message Model**
  * Your message model objects should implement TGOCMessageInterface.
  * However, you may use the provided TGOCMessage class.

* **Media Item Model**
  * Your media item model objects should implement TGOCMessageMediaInterface.
  * However, you may use the provided classes: TGOCPhotoMediaItem, TGOCLocationMediaItem.
  * Creating your own custom media items is easy! Simply follow the pattern used by the built-in media types.
  * We added a sample example using Glide on TGOCGlidePhotoMediaItem.

* **Message Bubble Model**
  * Your message bubble model objects should implement TGOCBubbleInterface.
  * However, you may use the provided TGOCBubble class.
  * Also see TGOCBubbleFactory for easily generating incoming and outgoing bubbles.

[img0]:https://github.com/two-guys-one-code/TGOCMessagesActivity/blob/master/Screenshots/screenshot0.png
[img1]:https://github.com/two-guys-one-code/TGOCMessagesActivity/blob/master/Screenshots/screenshot1.png
