package com.core.csgo_damage_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private String damage_text = "Current damage:\t";
    private String kills_text = "Current kills:\t";

    int green = 0;
    int purple = 1;
    int orange = 2;
    int yellow = 3;
    int blue = 4;

    private Button green_switch;
    private Button purple_switch;
    private Button orange_switch;
    private Button yellow_switch;
    private Button blue_switch;

    private Button green_damage_button;
    private Button purple_damage_button;
    private Button orange_damage_button;
    private Button yellow_damage_button;
    private Button blue_damage_button;

    MutableLiveData<Integer> green_damage_value = new MutableLiveData<>();;
    MutableLiveData<Integer> purple_damage_value = new MutableLiveData<>();;
    MutableLiveData<Integer> orange_damage_value = new MutableLiveData<>();;
    MutableLiveData<Integer> yellow_damage_value = new MutableLiveData<>();;
    MutableLiveData<Integer> blue_damage_value = new MutableLiveData<>();;

    private Button green_kills_button;
    private Button purple_kills_button;
    private Button orange_kills_button;
    private Button yellow_kills_button;
    private Button blue_kills_button;

    private int green_kills_value=0;
    private int purple_kills_value=0;
    private int orange_kills_value=0;
    private int yellow_kills_value=0;
    private int blue_kills_value=0;

    private boolean green_enabled = true;
    private boolean purple_enabled = true;
    private boolean orange_enabled = true;
    private boolean yellow_enabled = true;
    private boolean blue_enabled = true;

    private Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        green_damage_value.setValue(0);
        purple_damage_value.setValue(0);
        orange_damage_value.setValue(0);
        yellow_damage_value.setValue(0);
        blue_damage_value.setValue(0);

        buttonDeclaration();
        buttonSwitchSetup();
        buttonColorFix();
        listeners();
        buttonKillSetup();
        buttonDamageSetup();

    }

    private void reset() {
        green_enabled = true;
        purple_enabled = true;
        orange_enabled = true;
        yellow_enabled = true;
        blue_enabled = true;

        green_kills_button.setEnabled(true);
        purple_kills_button.setEnabled(true);
        orange_kills_button.setEnabled(true);
        yellow_kills_button.setEnabled(true);
        blue_kills_button.setEnabled(true);

        green_damage_button.setEnabled(true);
        purple_damage_button.setEnabled(true);
        orange_damage_button.setEnabled(true);
        yellow_damage_button.setEnabled(true);
        blue_damage_button.setEnabled(true);

        green_damage_value.setValue(0);
        purple_damage_value.setValue(0);
        orange_damage_value.setValue(0);
        yellow_damage_value.setValue(0);
        blue_damage_value.setValue(0);

        green_kills_value = 0;
        purple_kills_value = 0;
        orange_kills_value = 0;
        yellow_kills_value = 0;
        blue_kills_value = 0;

        green_kills_button.setText(kills_text+0);
        purple_kills_button.setText(kills_text+0);
        orange_kills_button.setText(kills_text+0);
        yellow_kills_button.setText(kills_text+0);
        blue_kills_button.setText(kills_text+0);

        green_damage_button.setText(damage_text+green_damage_value.getValue());
        purple_damage_button.setText(damage_text+purple_damage_value.getValue());
        orange_damage_button.setText(damage_text+orange_damage_value.getValue());
        yellow_damage_button.setText(damage_text+yellow_damage_value.getValue());
        blue_damage_button.setText(damage_text+blue_damage_value.getValue());

        buttonColorFix();
    }

    private void listeners() {
        green_damage_value.observe(MainActivity.this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                green_damage_button.setText(damage_text+green_damage_value.getValue());
            }
        });

        purple_damage_value.observe(MainActivity.this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                purple_damage_button.setText(damage_text+purple_damage_value.getValue());
            }
        });

        orange_damage_value.observe(MainActivity.this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                orange_damage_button.setText(damage_text+orange_damage_value.getValue());
            }
        });

        yellow_damage_value.observe(MainActivity.this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                yellow_damage_button.setText(damage_text+yellow_damage_value.getValue());
            }
        });

        blue_damage_value.observe(MainActivity.this,new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                blue_damage_button.setText(damage_text+blue_damage_value.getValue());
            }
        });
    }

    private void buttonDeclaration(){
        green_switch = findViewById(R.id.button_green);
        blue_switch = findViewById(R.id.button_blue);
        purple_switch = findViewById(R.id.button_purple);
        yellow_switch = findViewById(R.id.button_yellow);
        orange_switch = findViewById(R.id.button_orange);

        green_damage_button = findViewById(R.id.button_green_damage);
        blue_damage_button = findViewById(R.id.button_blue_damage);
        purple_damage_button = findViewById(R.id.button_purple_damage);
        yellow_damage_button = findViewById(R.id.button_yellow_damage);
        orange_damage_button = findViewById(R.id.button_orange_damage);

        green_kills_button = findViewById(R.id.button_green_kills);
        blue_kills_button = findViewById(R.id.button_blue_kills);
        purple_kills_button = findViewById(R.id.button_purple_kills);
        yellow_kills_button = findViewById(R.id.button_yellow_kills);
        orange_kills_button = findViewById(R.id.button_orange_kills);

        reset_button = findViewById(R.id.reset);

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    private void buttonColorFix() {
        green_kills_button.setBackgroundColor(
                green_enabled ? getResources().getColor(R.color.green) :
                        getResources().getColor(R.color.green_dim));
        green_damage_button.setBackgroundColor(
                green_enabled ? getResources().getColor(R.color.green) :
                        getResources().getColor(R.color.green_dim));

        purple_kills_button.setBackgroundColor(
                purple_enabled ? getResources().getColor(R.color.purple) :
                        getResources().getColor(R.color.purple_dim));
        purple_damage_button.setBackgroundColor(
                purple_enabled ? getResources().getColor(R.color.purple) :
                        getResources().getColor(R.color.purple_dim));

        orange_kills_button.setBackgroundColor(orange_enabled ? getResources().getColor(R.color.orange) :
                getResources().getColor(R.color.orange_dim));
        orange_damage_button.setBackgroundColor(
                orange_enabled ? getResources().getColor(R.color.orange) :
                        getResources().getColor(R.color.orange_dim));

        yellow_kills_button.setBackgroundColor(
                yellow_enabled ? getResources().getColor(R.color.yellow) :
                        getResources().getColor(R.color.yellow_dim));
        yellow_damage_button.setBackgroundColor(
                yellow_enabled ? getResources().getColor(R.color.yellow) :
                        getResources().getColor(R.color.yellow_dim));

        blue_kills_button.setBackgroundColor(
                blue_enabled ? getResources().getColor(R.color.blue) :
                        getResources().getColor(R.color.blue_dim));
        blue_damage_button.setBackgroundColor(
                blue_enabled ? getResources().getColor(R.color.blue) :
                        getResources().getColor(R.color.blue_dim));
    }

    private void buttonSwitchSetup(){
        green_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                green_enabled = !green_enabled;
                green_kills_button.setEnabled(green_enabled);
                green_damage_button.setEnabled(green_enabled);
                green_kills_button.setBackgroundColor(
                        green_enabled ? getResources().getColor(R.color.green) :
                                getResources().getColor(R.color.green_dim));
                green_damage_button.setBackgroundColor(
                        green_enabled ? getResources().getColor(R.color.green) :
                                getResources().getColor(R.color.green_dim));
            }
        });
        purple_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                purple_enabled = !purple_enabled;
                purple_kills_button.setEnabled(purple_enabled);
                purple_damage_button.setEnabled(purple_enabled);
                purple_kills_button.setBackgroundColor(
                        purple_enabled ? getResources().getColor(R.color.purple) :
                                getResources().getColor(R.color.purple_dim));
                purple_damage_button.setBackgroundColor(
                        purple_enabled ? getResources().getColor(R.color.purple) :
                                getResources().getColor(R.color.purple_dim));
            }
        });
        orange_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                orange_enabled = !orange_enabled;
                orange_kills_button.setEnabled(orange_enabled);
                orange_damage_button.setEnabled(orange_enabled);
                orange_kills_button.setBackgroundColor(orange_enabled ? getResources().getColor(R.color.orange) :
                                getResources().getColor(R.color.orange_dim));
                orange_damage_button.setBackgroundColor(
                        orange_enabled ? getResources().getColor(R.color.orange) :
                                getResources().getColor(R.color.orange_dim));
            }
        });
        yellow_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                yellow_enabled = !yellow_enabled;
                yellow_kills_button.setEnabled(yellow_enabled);
                yellow_damage_button.setEnabled(yellow_enabled);
                yellow_kills_button.setBackgroundColor(
                        yellow_enabled ? getResources().getColor(R.color.yellow) :
                                getResources().getColor(R.color.yellow_dim));
                yellow_damage_button.setBackgroundColor(
                        yellow_enabled ? getResources().getColor(R.color.yellow) :
                                getResources().getColor(R.color.yellow_dim));
            }
        });
        blue_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                blue_enabled = !blue_enabled;
                blue_kills_button.setEnabled(blue_enabled);
                blue_damage_button.setEnabled(blue_enabled);
                blue_kills_button.setBackgroundColor(
                        blue_enabled ? getResources().getColor(R.color.blue) :
                                getResources().getColor(R.color.blue_dim));
                blue_damage_button.setBackgroundColor(
                        blue_enabled ? getResources().getColor(R.color.blue) :
                                getResources().getColor(R.color.blue_dim));
            }
        });
    }

    private void buttonKillSetup() {
        green_kills_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (green_kills_value < 3) {
                    green_kills_value ++;
                    green_kills_button.setText(kills_text+green_kills_value);
                }
                if (green_kills_value == 3) {
                    green_enabled = false;
                    green_kills_button.setEnabled(false);
                    green_damage_button.setEnabled(false);
                    buttonColorFix();
                }
            }
        });
        purple_kills_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (purple_kills_value < 3) {
                    purple_kills_value ++;
                    purple_kills_button.setText(kills_text+purple_kills_value);
                }
                if (purple_kills_value == 3) {
                    purple_enabled = false;
                    purple_kills_button.setEnabled(false);
                    purple_damage_button.setEnabled(false);
                    buttonColorFix();
                }
            }
        });
        orange_kills_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (orange_kills_value < 3) {
                    orange_kills_value ++;
                    orange_kills_button.setText(kills_text+orange_kills_value);
                }
                if (orange_kills_value == 3) {
                    orange_enabled = false;
                    orange_kills_button.setEnabled(false);
                    orange_damage_button.setEnabled(false);
                    buttonColorFix();
                }
            }
        });
        yellow_kills_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (yellow_kills_value < 3) {
                    yellow_kills_value ++;
                    yellow_kills_button.setText(kills_text+yellow_kills_value);
                }
                if (yellow_kills_value == 3) {
                    yellow_enabled = false;
                    yellow_kills_button.setEnabled(false);
                    yellow_damage_button.setEnabled(false);
                    buttonColorFix();
                }
            }
        });
        blue_kills_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (blue_kills_value < 3) {
                    blue_kills_value ++;
                    blue_kills_button.setText(kills_text+blue_kills_value);
                }
                if (blue_kills_value == 3) {
                    blue_enabled = false;
                    blue_kills_button.setEnabled(false);
                    blue_damage_button.setEnabled(false);
                    buttonColorFix();
                }
            }
        });
    }

    private void buttonDamageSetup() {
        green_damage_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogInput(green);
            }
        });

        purple_damage_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogInput(purple);
            }
        });

        orange_damage_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogInput(orange);
            }
        });

        yellow_damage_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogInput(yellow);
            }
        });

        blue_damage_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialogInput(blue);
            }
        });
    }

    private void dialogInput(int color) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Damage");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int value = Integer.valueOf(input.getText().toString());
                if (value > 0 && value < 101) {
                    switch (color) {
                        case 0:
                            green_damage_value.setValue(green_damage_value.getValue() + value);
                            break;
                        case 1:
                            purple_damage_value.setValue(purple_damage_value.getValue() + value);
                            break;
                        case 2:
                            orange_damage_value.setValue(orange_damage_value.getValue() + value);
                            break;
                        case 3:
                            yellow_damage_value.setValue(yellow_damage_value.getValue() + value);
                            break;
                        case 4:
                            blue_damage_value.setValue(blue_damage_value.getValue() + value);
                            break;
                    }
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}