package gino.com.firebase_fcm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by gino_kuo on 2018/10/1.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("FCM", "onMessageReceived:"+remoteMessage.getFrom());
    }

}
