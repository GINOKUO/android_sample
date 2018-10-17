package gino.com.leftrightslide2;

/**
 * Created by gino_kuo on 2018/10/3.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;

public class SecondActivity extends Activity implements OnGestureListener{
        //定义手势检测器实例
        GestureDetector detector;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second);
            //初始化手势检测器
            detector=new GestureDetector(this,this);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // TODO Auto-generated method stub
            return detector.onTouchEvent(event);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_flip, menu);
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            // TODO Auto-generated method stub
            //如果向左滑动距离大于50mm
            if (e2.getX()-e1.getX()>50) {
                Intent intent=getIntent();
                setResult(Activity.RESULT_OK, intent);
                this.finish();
                overridePendingTransition(R.anim.left_in, R.anim.right_out);

                //如果向右滑动的距离大于50mm
            } else if(e1.getX()-e2.getX()>50) {
                Intent intent=getIntent();
                setResult(Activity.RESULT_OK, intent);
                this.finish();
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }
}
