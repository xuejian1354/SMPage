package com.ymbl.smpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    ViewGroup _root;
    private int _xDelta;
    private int _yDelta;

    private RoundlProgresWithNum mRoundlProgres1, mRoundlProgres2,
            mRoundlProgres3, mRoundlProgres4, mRoundlProgres5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("环境检测仪");
        setSupportActionBar(toolbar);

        _root = (ViewGroup) findViewById(R.id.root);

        mRoundlProgres1 = (RoundlProgresWithNum) findViewById(R.id.mRoundlProgres1);
        mRoundlProgres1.setProgress(39);
        mRoundlProgres1.setMax(100);
        mRoundlProgres1.setColor(Color.parseColor("#B9D3EE"));
        mRoundlProgres1.setTitle("湿度");
        mRoundlProgres1.setVal("39.1%");

        mRoundlProgres2 = (RoundlProgresWithNum) findViewById(R.id.mRoundlProgres2);
        mRoundlProgres2.setProgress(29);
        mRoundlProgres2.setMax(100);
        mRoundlProgres2.setColor(Color.parseColor("#CD661D"));
        mRoundlProgres2.setTitle("温度");
        mRoundlProgres2.setVal("28.9℃");

        mRoundlProgres3 = (RoundlProgresWithNum) findViewById(R.id.mRoundlProgres3);
        mRoundlProgres3.setProgress(70);
        mRoundlProgres3.setMax(100);
        mRoundlProgres3.setColor(Color.parseColor("#CD5C5C"));
        mRoundlProgres3.setTitle("光照");
        mRoundlProgres3.setVal("正常");

        mRoundlProgres4 = (RoundlProgresWithNum) findViewById(R.id.mRoundlProgres4);
        mRoundlProgres4.setProgress(80);
        mRoundlProgres4.setMax(100);
        mRoundlProgres4.setColor(Color.parseColor("#EE9A00"));
        mRoundlProgres4.setTitle("声音");
        mRoundlProgres4.setVal("正常");

        mRoundlProgres5 = (RoundlProgresWithNum) findViewById(R.id.mRoundlProgres5);
        mRoundlProgres5.setProgress(75);
        mRoundlProgres5.setMax(100);
        mRoundlProgres5.setColor(Color.parseColor("#7CCD7C"));
        mRoundlProgres5.setTitle("空气质量");
        mRoundlProgres5.setVal("良好");

        mRoundlProgres1.setOnTouchListener(this);
        mRoundlProgres2.setOnTouchListener(this);
        mRoundlProgres3.setOnTouchListener(this);
        mRoundlProgres4.setOnTouchListener(this);
        mRoundlProgres5.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int)event.getRawX();
        final int Y = (int)event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            RelativeLayout.LayoutParams lParams =
                    (RelativeLayout.LayoutParams) v.getLayoutParams();
            _xDelta = X - lParams.leftMargin;
            _yDelta = Y - lParams.topMargin;
            break;

        case MotionEvent.ACTION_MOVE:
            RelativeLayout.LayoutParams layoutParams =
                    (RelativeLayout.LayoutParams) v.getLayoutParams();
            layoutParams.leftMargin = X - _xDelta;
            layoutParams.topMargin = Y - _yDelta;
            layoutParams.rightMargin = -250;
            layoutParams.bottomMargin = -250;
            v.setLayoutParams(layoutParams);
            break;
        }
        _root.invalidate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
