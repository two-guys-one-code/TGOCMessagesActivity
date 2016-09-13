# TGOCMessagesActivity

`TGOCMessagesActivity` is a chat UI for your Android application. Based on [JSQMessageViewController][jsq]

![Screenshot][img0] &nbsp;&nbsp; ![Screenshot][img1] &nbsp;&nbsp;

Support:

- [x] Is typing indicator;
- [x] Sites, phones and email link on messages;
- [x] Select messages text;
- [x] Image messages;
- [x] Location messages;
- [X] Video messages;
- [ ] Audio messages;
- [ ] Contact messages;
- [ ] Custom toolbar;

## Installing

Users of this library will need add the jitpack.io repository:

```gradle
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

and:

```gradle
dependencies {
    compile 'com.github.two-guys-one-code:TGOCMessagesActivity:0.2'
}
```

Note: do not add the jitpack.io repository under `buildscript` 

## Getting Started

* Extends `TGOCMessageActivity` in your activity. It will create all UI. On `OnCreate` remove `setContentView(R.layout.YOUR_LAYOUT)` and call `super.init(this)`

```java
public class MainActivity extends TGOCMessageActivity {
 protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         super.init(this);
 }
}
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
    outgoingAvatar = new TGOCAvatar(getResources(), R.drawable.rod);
    incomingAvatar = new TGOCAvatar(getResources(), R.drawable.ed);
}

```

* Implement `TGOCMessageActivityiInterface`

```java
public List<TGOCMessageInterface> messages = new ArrayList<>();
String sender_id = "mySenderId";

@Override
public int numberOfItemsInConversation() {
    return this.messages.size();
}

@Override
public TGOCAvatarInterface avatarAtPosition(int position) {
    final TGOCMessageInterface message = this.messages.get(position);

    if (sender_id.matches(message.getSenderId()))
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
    final TGOCMessageInterface message = this.messages.get(position);

    if (sender_id.matches(message.getSenderId()))
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
* Typing indicator
```java
//setup
this.typingBubble = TGOCBubbleFactory.bubbleWithHexColor(BubbleType.TYPING, "#FAFFFF");
this.typingAvatar = new TGOCAvatar(getResources(), R.drawable.ed); //optional
this.typingText = "Is typing...";
```

```java
//show indicator
this.setShowTypingIndicator(true);
```

* Add your google map v2 api key 

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="YOUR_API_KEY" />
```

* **Message Model**
  * Your message model objects should implement `TGOCMessageInterface`.
  * However, you may use the provided `TGOCMessage` class.

* **Media Item Model**
  * Your media item model objects should implement `TGOCMessageMediaInterface`.
  * However, you may use the provided classes: `TGOCPhotoMediaItem`, `TGOCLocationMediaItem`, `TGOCVideoMediaItem`.
  * Creating your own custom media items is easy! Simply follow the pattern used by the built-in media types.
  * We added a sample example using [Glide][glide] on `TGOCGlidePhotoMediaItem`.
  
* **Avatar Model**
  * Your avatar model objects should implement `TGOCAvatarInterface`.
  * However, you may use the provided `TGOCAvatar` class.
  * Creating your own custom avatar is easy!
  * We added a sample example using [Glide][glide] on `TGOCGlideAvatar`.

* **Message Bubble Model**
  * Your message bubble model objects should implement `TGOCBubbleInterface`.
  * However, you may use the provided `TGOCBubble` class.
  * Also see `TGOCBubbleFactory` for easily generating incoming and outgoing bubbles.
  
## License

`TGOCMessagesActivity` is released under an [MIT License][mit]. See License.md for details.

>**Copyright &copy; 2016 two-guys-one-code.**

[jsq]:http://www.jessesquires.com/JSQMessagesViewController/
[glide]:https://github.com/bumptech/glide
[mit]:http://opensource.org/licenses/MIT
[img0]:https://github.com/two-guys-one-code/TGOCMessagesActivity/blob/master/Screenshots/screenshot0.png
[img1]:https://github.com/two-guys-one-code/TGOCMessagesActivity/blob/master/Screenshots/screenshot1.png
