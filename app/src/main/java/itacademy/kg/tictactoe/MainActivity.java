package itacademy.kg.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    int player = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
             int counter = 0;
             public void playerTap(View view) {
             ImageView img = (ImageView) view;
             int tappedImage = Integer.parseInt(img.getTag().toString());
              if (!gameActive){
               gameReset(view);
        }if (gameState[tappedImage]==2) {
            counter++;
            if (counter == 9) {
                gameActive = false;
            }
            gameState[tappedImage] = player;
            img.setTranslationY(-1000f);
            if (player == 0) {
                img.setImageResource(R.drawable.xx);
                player = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O'igrok - Нажмите, чтобы играть");
            } else {
                img.setImageResource(R.drawable.ooo);
                player = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X'igrok - нажмите, чтобы играть");
            }img.animate().translationYBy(1000f).setDuration(300);
        }int flag = 0;
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;
                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = "X has won";
                } else {
                    winnerStr = "O has won";
                }TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }if (counter == 9 && flag == 0) {
            TextView status = findViewById(R.id.status);
            status.setText("Match Draw");
        }
    }
    public void gameReset(View view) {
        gameActive = true;
        player = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    }
