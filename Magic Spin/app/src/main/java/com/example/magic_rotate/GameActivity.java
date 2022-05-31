package com.example.magic_rotate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.magic_rotate.data_local.DataLocalManager;
import com.example.magic_rotate.data_local.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.net.ssl.SSLHandshakeException;

public class GameActivity extends AppCompatActivity {
    Dialog dialog;
    List<String> usedCharacter;
    ImageView chiecnon;
    Button btn_play, btn_guess, btn_guessall, btn_guestAll_Cancel, btn_guestAll_ans, btn_play_again, btn_home, btn_save;
    TextView ketqua, tv_point, tv_guess, tv_question, tv_life, tv_lose;
    EditText edt_guess, edt_guessAll, edt_savename;
    Random r = new Random();
    android.support.constraint.ConstraintLayout layout;
    LinearLayout ans_layout;
    String kq, result;
    int questionID, position, characterCount, life;
    List<String> guestList;
    List<Question> questionList;
    List<User> userList;
    boolean spinflag = true, guessflag = false, restart_Flag;
    int point = 0;
    int from = 0;
    int phanthuong[] = {2000, 100, 500, 1, 200, 700, 1000, 400, 2, 900, 3, 300, 800, 4, 100, 400, 600, 300, 5, 200, 900, 700, 6, 300};
    int vong[] = {360, 720, 1080, 1440};
    int vitri[] = {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180, 195, 210, 225, 240, 255, 270, 285, 300, 315, 330, 345};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        init();
    }

    public void init() {
        chiecnon = findViewById(R.id.chiecnon);
        btn_play = findViewById(R.id.btn_play);
        btn_guess = findViewById(R.id.btn_guess);
        btn_guessall = findViewById(R.id.btn_guess_all);
        edt_guess = findViewById(R.id.edt_guess);

        ketqua = findViewById(R.id.result);
        layout = findViewById(R.id.layout);
        tv_point = findViewById(R.id.point);
        tv_life = findViewById(R.id.tv_lifecount);
        tv_guess = findViewById(R.id.btn_guess);
        tv_question = findViewById(R.id.question);
        ans_layout = findViewById(R.id.answer_layout);

        //userList=DataLocalManager.getListUser();

        guestList = new ArrayList<>();
        questionList = new ArrayList<>();
        questionList.addAll(new LoadQuestion().loadQuestion());
        restart_Flag = true;
        showQuestion();
        life = 3;
        life_count();

        btn_guessall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guestAllCharacter();
            }
        });
        btn_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!spinflag) {
                    String guess_charater = edt_guess.getText().toString();
                    if (guess_charater.isEmpty()) {
                        Toast.makeText(GameActivity.this, "Vui long nhap ki tu muon doan", Toast.LENGTH_SHORT).show();
                    } else {
                            guestCharacter(edt_guess.getText().toString().trim());
                            edt_guess.setText("");
                            life_count();
                    }
                } else
                    Toast.makeText(GameActivity.this, "Vui long xoay truoc", Toast.LENGTH_SHORT).show();
            }
        });
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restart_Flag) {
                    btn_play.setText("Quay");
                    showQuestion();
                } else if (spinflag) {
                    process();
                    spinflag = false;
                   // guessflag = true;
                } else {
                    Toast.makeText(GameActivity.this, "Vui long doan chu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void process() {
        position = r.nextInt(vitri.length);

        int to = vitri[position] + vong[r.nextInt(vong.length)];
        RotateAnimation anim = new RotateAnimation(from, to, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        anim.setDuration(5000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (phanthuong[position]) {
                    case 1:
                        kq = "ban duoc nhan doi so diem";

                        break;
                    case 2:
                        kq = "Ban bi mat luot";
                        life-=1;
                        life_count();
                        break;
                    case 3:
                        kq = "Ban duoc tang 1000 diem";
                        point+=1000;
                        spinflag=true;
                        break;
                    case 4:
                        kq = "Ban bi mat diem";
                        point = 0;
                        break;
                    case 5:
                        kq = "Ban bi mat luot";
                        life-=1;
                        life_count();
                        break;
                    case 6:
                        kq = "Ban bi chia doi so diem";
                        point = point / 2;
                        break;
                    default:
                        kq = "Điểm:" + phanthuong[position];
                        break;
                }
                ketqua.setText(kq);
                tv_point.setText("Điểm của bạn: " + String.valueOf(point));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        chiecnon.startAnimation(anim);
        from = vitri[position];
    }

    public void showQuestion() {
        ketqua.setText("Game moi");
        usedCharacter = new ArrayList<>();
        Random random = new Random();
        ans_layout.removeAllViewsInLayout();
        questionID = random.nextInt(questionList.size());
        tv_question.setText(questionList.get(questionID).getQuestion().toString());
        result = questionList.get(questionID).getResult().toString();
        char[] charArray = result.toCharArray();
        for (int i = 0; i < result.length(); i++) {
            TextView a = new TextView(GameActivity.this);
            a.setBackground(getDrawable(R.drawable.card));
            a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            a.setTag("key" + charArray[i] + i);
            ans_layout.addView(a);
        }

        restart_Flag = false;
    }

    public void guestCharacter(String c) {
        int count = 0;
        for (String a : usedCharacter) {
            if (c.toUpperCase().equals(a.toUpperCase())) {
                Toast.makeText(GameActivity.this, "Bạn đã nhập chữ này rồi", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        usedCharacter.add(c);
        char[] charArray = result.toCharArray();
        for (int i = 0; i < result.length(); i++) {
            Log.d("run to here", String.valueOf(charArray[i]));
            if (c.equals(String.valueOf(charArray[i]))) {
                count++;
                characterCount++;
                TextView a = ans_layout.findViewWithTag("key" + charArray[i] + i);
                a.setText(String.valueOf(charArray[i]));
                a.setTextColor(Color.WHITE);
                a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                a.setBackground(getDrawable(R.drawable.cardreveal));
            }
        }
        if (count > 0) {
            Toast.makeText(GameActivity.this, "Co " + count + " chu " + c, Toast.LENGTH_SHORT).show();
            if(phanthuong[position]==1){
                point*=2;
            }else if(phanthuong[position]==4|phanthuong[position]==6){

            }else{
                point += phanthuong[position] * count;
                tv_point.setText("Điểm của bạn: " + String.valueOf(point));
            }



        } else {
            Toast.makeText(GameActivity.this, "Ban da doan sai", Toast.LENGTH_SHORT).show();
            life -= 1;
        }
        if (characterCount == result.length()) {
            finishGuess();
        }
        spinflag = true;
      //  guessflag = false;

    }

    public void guestAllCharacter() {
        AlertDialog.Builder dialogBuider = new AlertDialog.Builder(this);
        final View guessAllView = getLayoutInflater().inflate(R.layout.guessall, null);
        edt_guessAll = (EditText) guessAllView.findViewById(R.id.edt_ans_all);
        btn_guestAll_ans = (Button) guessAllView.findViewById(R.id.btn_play_again);
        btn_guestAll_Cancel = (Button) guessAllView.findViewById(R.id.btn_home);

        dialogBuider.setView(guessAllView);
        dialog = dialogBuider.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        btn_guestAll_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (result.equals(edt_guessAll.getText().toString().toUpperCase())) {
                    point += 5000;
                    tv_point.setText("Điểm của bạn: " + String.valueOf(point));
                    finishGuess();
                } else {
                    life -= 1;
                    life_count();
                    Toast.makeText(GameActivity.this, "Bạn đã đoán sai", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btn_guestAll_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void life_count() {
        tv_life.setText("Số mạng còn lại: " + life);
        if (life == 0) lose();

    }

    public void lose() {
        userList = DataLocalManager.getListUser(GameActivity.this);
        Log.d("So nguoi",""+String.valueOf(userList.size()));
        AlertDialog.Builder dialogBuider = new AlertDialog.Builder(this);
        final View loseView = getLayoutInflater().inflate(R.layout.lose_layout, null);
        tv_lose = (TextView) loseView.findViewById(R.id.tv_showpoint);
        btn_home = (Button) loseView.findViewById(R.id.btn_home);
        btn_play_again = (Button) loseView.findViewById(R.id.btn_play_again);
       //save record
        btn_save = loseView.findViewById(R.id.btn_save);
        edt_savename = loseView.findViewById(R.id.edt_lose_name);

        dialogBuider.setView(loseView);


        dialog = dialogBuider.create();
        dialog.show();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        tv_lose.setText("Số điểm của bạn là: " + point);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_savename.getText().length() == 0) {
                    Toast.makeText(GameActivity.this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(edt_savename.getText().toString(), point);
                    userList.add(user);
                    Log.d("Save User",""+edt_savename.getText()+point);
                    Toast.makeText(GameActivity.this, "da luu", Toast.LENGTH_SHORT).show();
                    Log.d("So nguoi da them",""+String.valueOf(userList.size()));


                    DataLocalManager.setListUser(userList,GameActivity.this);
                }
            }
        });
        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuestion();
                life = 3;
                life_count();
                dialog.dismiss();

            }
        });
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, HomeActivity.class));
            }
        });

    }

    public void finishGuess() {
        Toast.makeText(GameActivity.this, "Ban da doan xong", Toast.LENGTH_SHORT).show();
        char[] charArray = result.toCharArray();
        for (int i = 0; i < result.length(); i++) {
            Log.d("run to here", String.valueOf(charArray[i]));
            TextView a = ans_layout.findViewWithTag("key" + charArray[i] + i);
            a.setText(String.valueOf(charArray[i]));
            a.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            a.setTextColor(Color.WHITE);
            a.setBackground(getDrawable(R.drawable.cardreveal));
        }
        btn_play.setText("Tiếp tục");
        restart_Flag = true;
        tv_question.setText("Bạn đã thành công");
    }
}