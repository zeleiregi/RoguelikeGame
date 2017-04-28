package com.example.szakkr.roguelikegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.nfc.Tag;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.szakkr.roguelikegame.Entities.Player;

import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.WHITE;
import static com.example.szakkr.roguelikegame.GameView.chr;

/**
 * Created by Szakkör on 2017. 04. 28..
 */

public class Game extends Thread {
    public static Game instance;
    public int width;
    public int height;
    Player player;
    Context context;
    GameView gameView;
    Map map;
    Paint paint = new Paint();

    Random random = new Random();

    SurfaceHolder surfaceHolder;

    public Game(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        instance = this;

        createMap();
    }

    int[][] tiles = new int[100][100];

    public void createMap() {
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                //if (row > 2 && col > 2) {
                  //  if (tiles[row - 2][col] == 1 && tiles[row - 1][col - 1] == 1 && tiles[row - 1][col + 1] == 1) {
                    //    tiles[row][col] = 1;
                   // /}
                    tiles[row][col] = random.nextInt(2);
                //}
            }
        }

    }

    public void drawMap(Canvas canvas) {
        int numX = width / 100;
        int numY = height / 100;

        for (int i = 0; i < 100; i++) {
            for (int e = 0; e < 100; e++) {
                if (tiles[i][e] == 0) {
                    paint.setColor(BLACK);
                } else {
                    paint.setColor(BLUE);
                }
                canvas.drawRect(32 * i, 32 * e, 32 * (i + 1), 32 * (e + 1), paint);
            }
        }
    }

    public static Game getInstance() {
        return instance;
    }

    public void run() {
        super.run();

        while (true) {

            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                //canvas.drawBitmap(GameView.map, 0, 0, null);
                canvas.drawColor(Color.BLUE);
                update();
                render(canvas);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            try {
                sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void render(Canvas canvas) {

        drawMap(canvas);
    }

    public void update() {

    }

    public boolean onTouch(MotionEvent event) {
        Log.v(TAG, event.toString());

        if (event.getAction() == MotionEvent.ACTION_MOVE ||
                event.getAction() == MotionEvent.ACTION_DOWN ||
                event.getAction() == MotionEvent.ACTION_POINTER_DOWN) {


            return true;
        }
        return false;
    }
}
