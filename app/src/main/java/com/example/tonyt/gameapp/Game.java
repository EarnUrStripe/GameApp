package com.example.tonyt.gameapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import javax.microedition.khronos.egl.EGLDisplay;


public class Game extends ActionBarActivity {
    //private  SharedPreferences hiscore2;
    //private SharedPreferences.Editor hiscore = hiscore2.edit();
    int questionNum = 0;
    int newScore;
    Intent intent;
    int ans;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        newScore =0;
        System.out.println("New Score  = "+newScore);
        intent = getIntent();
        int finalans2 = 0;
        TextView test = (TextView)findViewById(R.id.firstNum);
        test.setText("-50+50 = ");
        TextView Score = (TextView) findViewById(R.id.score);
        Score.setText("Test Question" + "/20");
        newScore--;

        final Button submitAns = (Button) findViewById(R.id.submit);
        submitAns.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText userAns = (EditText) findViewById(R.id.ans);
                TextView Score = (TextView) findViewById(R.id.score);
                System.out.println("userans  = " + Integer.parseInt(userAns.getText().toString()));
                TextView int1 = (TextView) findViewById(R.id.firstNum);

                int temp = ans;
                System.out.println("New Score 2  = " + newScore);
                System.out.print("real ans = "+temp);



                //System.out.println("real ans = "+temp);
                if (Integer.parseInt(userAns.getText().toString()) == temp) {
                    System.out.println("userans  = " + Integer.parseInt(userAns.getText().toString()));
                    newScore++;
                }

                Score.setText(newScore + "" + "/20");
                if (questionNum == 20) {
                    setContentView(R.layout.endgame);
                    TextView endscore = (TextView) findViewById(R.id.endGame);
                    Button retry = (Button) findViewById(R.id.retryGame);
                    endscore.setText("Your score is " + (newScore + ""));
                    if(newScore>15){
                        //hiscore.putInt("High Score :", newScore);
                        //hiscore.commit();

                    }
                    retry.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(intent);
                        }
                    });

                }
                else {
                    GenerateQuestion();
                    System.out.print("real ans new = "+temp);
                }

            }
        });



    }
    public void GenerateQuestion(){

        int firstNum = (int) (Math.random() * 100) - 50;
        int secondNum = (int) (Math.random() * 1000) - 500;
        double op = Math.random();
        String s = "";
        int answer = -1;

        TextView int1 = (TextView) findViewById(R.id.firstNum);
        if (op <= 0.5) {
            s = "+";

            int1.setText((firstNum + "") + " + " + (secondNum + ""));
            answer = firstNum + secondNum;
        } else {
            s = "-";
            int1.setText((firstNum + "") + " - " + (secondNum + ""));
            answer = firstNum - secondNum;
        }
        ans = answer;

        questionNum++;
        return ;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
