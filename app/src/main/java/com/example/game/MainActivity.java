package com.example.game;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnRestart;
    Button btnUndo;
    Button btnRedo;

    TextView[] txt = new TextView[9];
    int cnt = 0;

    String P1 = "X";
    String P2 = "O";
    boolean gameend;

    ArrayList<HashMap> undolist = new ArrayList<>();
    ArrayList<HashMap> redolist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRestart = findViewById(R.id.btnRestart);
        btnUndo = findViewById(R.id.btnUndo);
        btnRedo = findViewById(R.id.btnRedo);

        for(int i = 0; i < 9; i++){
            int id = getResources().getIdentifier("txt"+i,"id",getPackageName());
            txt[i] = findViewById(id);

            int j = i;
            txt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(txt[j].getText().toString().isEmpty()  && !gameend){
                       if(cnt % 2 == 0){
                           txt[j].setText(P1);
                       }else {
                           txt[j].setText(P2);
                       }
                       cnt++;
                       win();

                       String player = txt[j].getText().toString();
                       HashMap hashMap = new HashMap();
                       hashMap.put("pos",j);
                       hashMap.put("player",player);

                       undolist.add(hashMap);
                   }
                }
            });
        }

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(undolist.size() > 0){
                  int undopos = undolist.size()-1;
                  HashMap hashMap = undolist.get(undopos);

                  int pos = (int) hashMap.get("pos");

                  txt[pos].setText("");
                  undolist.remove(undopos);
                  cnt--;
                  win();
                  redolist.add(hashMap);
                }

            }
        });

        btnRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(redolist.size() > 0){
                    int redopos = redolist.size()-1;
                    HashMap hashMap = redolist.get(redopos);

                    int pos = (int) hashMap.get("pos");
                    String player = (String) hashMap.get("player");

                    txt[pos].setText(player);
                    redolist.remove(redopos);
                    cnt++;
                    win();
                    undolist.add(hashMap);

                }

            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameend = false;
                newgame();
            }
        });
    }

    void win(){
        gameend = false;
        //P1 = X
        if (txt[0].getText().toString().equals(P1) && txt[1].getText().toString().equals(P1) && txt[2].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[3].getText().toString().equals(P1) && txt[4].getText().toString().equals(P1) && txt[5].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[6].getText().toString().equals(P1) && txt[7].getText().toString().equals(P1) && txt[8].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[0].getText().toString().equals(P1) && txt[4].getText().toString().equals(P1) && txt[8].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[2].getText().toString().equals(P1) && txt[4].getText().toString().equals(P1) && txt[6].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[0].getText().toString().equals(P1) && txt[3].getText().toString().equals(P1) && txt[6].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[1].getText().toString().equals(P1) && txt[4].getText().toString().equals(P1) && txt[7].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is "+P1, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[2].getText().toString().equals(P1) && txt[5].getText().toString().equals(P1) && txt[8].getText().toString().equals(P1)) {

            Toast.makeText(this, "Winner is " + P1, Toast.LENGTH_SHORT).show();
            gameend = true;
        //P2 = O
        } else if (txt[0].getText().toString().equals(P2) && txt[1].getText().toString().equals(P2) && txt[2].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[3].getText().toString().equals(P2) && txt[4].getText().toString().equals(P2) && txt[5].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[6].getText().toString().equals(P2) && txt[7].getText().toString().equals(P2) && txt[8].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[0].getText().toString().equals(P2) && txt[4].getText().toString().equals(P2) && txt[8].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[2].getText().toString().equals(P2) && txt[4].getText().toString().equals(P2) && txt[6].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[0].getText().toString().equals(P2) && txt[3].getText().toString().equals(P2) && txt[6].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[1].getText().toString().equals(P2) && txt[4].getText().toString().equals(P2) && txt[7].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;

        } else if (txt[2].getText().toString().equals(P2) && txt[5].getText().toString().equals(P2) && txt[8].getText().toString().equals(P2)) {

            Toast.makeText(this, "Winner is "+P2, Toast.LENGTH_SHORT).show();
            gameend = true;
        //Draw Game
        } else if (cnt == 9) {

            Toast.makeText(this, "Draw Game", Toast.LENGTH_SHORT).show();
        }
    }

    void newgame(){
        for (int j = 0; j < 9; j++){
            txt[j].setText("");
        }
        undolist.clear();
        redolist.clear();
        cnt = 0;
    }

}