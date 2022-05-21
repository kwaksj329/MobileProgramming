package kr.co.company.animationservice_sol;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.AttributeSet;

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);

        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message message){
            float angle = (Float)message.obj;
            mRenderer.setmAngle(angle);
            requestRender();
        }
    };

    private Messenger mAngleReceiver = new Messenger(mHandler);
    public Messenger getmAngleReceiver() {return mAngleReceiver;}

    //public Messenger getAngleReceiver() { return mAngleReceiver; }

    // 1. define and create a handler instance.
    // 2. create a messenger instance with the handler (mAngleReceiver).

}
