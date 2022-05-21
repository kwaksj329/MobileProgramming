package kr.co.company.animationservice_sol;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class AnimationService extends Service {
    public AnimationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Messenger valMessenger = (Messenger)intent.getExtras().get("ValueMessenger");

        Thread animThread = new Thread() {
            public void run() {
                float startAngle = 0;
                float endAngle = 360;
                float angle = startAngle;
                float incAngle = 5;
                while (angle < endAngle) {
                    angle += incAngle;
                    Message msg = Message.obtain();
                    msg.obj = new Float(angle);
                    try {
                        valMessenger.send(msg);
                        Thread.sleep(10);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        animThread.start();

        return super.onStartCommand(intent, flags, startId);
    }
}