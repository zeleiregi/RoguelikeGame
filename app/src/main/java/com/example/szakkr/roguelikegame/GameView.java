package com.example.szakkr.roguelikegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import static android.R.attr.width;
import static com.example.szakkr.roguelikegame.Game.instance;
import static com.example.szakkr.roguelikegame.R.attr.height;

/**
 * Created by Szakkör on 2017. 04. 28..
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    public static Bitmap chr;
    public static Bitmap portal;
    public static Bitmap map;
    public static Bitmap monster;

    private final SurfaceHolder surfaceHolder;


    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /*chr = BitmapFactory.decodeResource(context.getResources(), R.drawable.chr);
        portal = BitmapFactory.decodeResource(context.getResources(), R.drawable.portal);
        map = BitmapFactory.decodeResource(context.getResources(), R.drawable.map);
        monster= BitmapFactory.decodeResource(context.getResources(), R.drawable.monsters);*/

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        setFocusable(true);
        setOnTouchListener(this);

        instance = new Game(context,surfaceHolder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        instance.width = width;
        instance.height = height;


    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        instance.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return instance.onTouch(motionEvent);
    }
}
