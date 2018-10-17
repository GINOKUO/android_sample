package gino.com.leftrightslide2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity implements OnGestureListener{
        //定义手势检测器实例
        GestureDetector detector;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //初始化手势检测器
            detector=new GestureDetector(this, this);
        }

        //可省略
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_flip, menu);
            return true;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // TODO Auto-generated method stub
            //将触碰事件交给GestureDetector处理
            return detector.onTouchEvent(event);
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
            //如果向右滑动的距离大于50mm
            if (e1.getX()-e2.getX()>50) {
                Intent intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                //设置切换动画，从右边进入，左边退出
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            } else if(e2.getX()-e1.getX()>50) {
                Intent intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                //设置切换动画，从左边进入，右边退出
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
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
