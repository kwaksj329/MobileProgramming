package kr.co.company.lunarlander;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.AsyncTask;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;


public class LanderAnimator extends AsyncTask<Integer, Integer, Integer> {

    // Define constructor..
    private LunarView mLanderView;
    private int mX, mY;
    private ValueAnimator fireAnim;

    public LanderAnimator(LunarView lander){
        mLanderView = lander;
    }

    protected Integer doInBackground(Integer... integers) {
        // Implement code to update the lander position in a loop
        mX = integers[0];
        mY = integers[1];
        while (true){
            if (!mPaused){
                mX += 5;
                mY += 5;
                if (mX >= mLanderView.getWidth())
                    mX = 0;
                publishProgress(mX, mY);
            }
            try{
                Thread.sleep(100);
            }catch (Exception ex){}
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        // Put code to update the lander position with values.
        mLanderView.setLanderPos(values[0], values[1]);
        mLanderView.invalidate();
    }

    private boolean mPaused = false;
    public void pauseAnimator() {
        mPaused = (!mPaused);
    }
    public void fireAnimator() {
        int startY = mY;
        fireAnim = ValueAnimator.ofFloat(0, mLanderView.getmCanvasHeight() / (float)10);
        fireAnim.setDuration(1000);
        fireAnim.addUpdateListener(valueAnimator -> {
            float height = (float)valueAnimator.getAnimatedValue();
            if(!mPaused){
                mY = startY - (int)height;
                System.out.println(height);
            }
        });
        fireAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        fireAnim.start();
    }
}
