package kr.co.company.animationservice_hw;

import android.animation.ValueAnimator;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.animation.OvershootInterpolator;

public class AnimationService extends Service {
    public static final boolean START = true;
    public static final boolean STOP = false;

    ValueAnimator valueAnimator;
    Messenger valMessenger;
    public AnimationService() {
        valueAnimator = ValueAnimator.ofFloat(0, 360);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(valueAnimator1 -> {
            float angle = (float)valueAnimator1.getAnimatedValue();
            Message msg = Message.obtain();
            msg.obj = angle;
            try {
                valMessenger.send(msg);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        valMessenger = (Messenger)intent.getExtras().get("ValueMessenger");
        boolean order = (boolean)intent.getExtras().get("Order");
        if(order == START){
            float tension = (float)intent.getExtras().get("Tension");
            valueAnimator.setInterpolator(new OvershootInterpolator(tension));
            valueAnimator.start();
        }
        else if (order == STOP){
            valueAnimator.cancel();
            Message msg = Message.obtain();
            msg.obj = (float)0;
            try {
                valMessenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }
}