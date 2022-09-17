package com.example.Offline_2;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class FirstFragment extends Fragment {
    private TextView result_view, math_info_view, temp_math;
    private SwitchCompat switch1;
    boolean equal_pressed = false;

    private Button one, two, three, four, five, six, seven, eight, nine, zero, div, multi, sub, plus, dot, equals, clear, del, exp, modulo;
    String operator;
    float number1, number2, result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);

        boolean savedData = sharedPreferences.getBoolean("dark_mode",false);
        if(savedData){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            //dark_mode.setChecked(true);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            //dark_mode.setChecked(false);
        }


        one = view.findViewById(R.id.one);
        two = view.findViewById(R.id.two);
        three = view.findViewById(R.id.three);
        four = view.findViewById(R.id.four);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);
        zero = view.findViewById(R.id.zero);

        dot = view.findViewById(R.id.dot);
        equals = view.findViewById(R.id.equal);

        div = view.findViewById(R.id.div);
        multi = view.findViewById(R.id.multiply);
        sub = view.findViewById(R.id.sub);
        plus = view.findViewById(R.id.plus);

        clear = view.findViewById(R.id.ac);
        del = view.findViewById(R.id.del);
        exp = view.findViewById(R.id.exp);
        modulo = view.findViewById(R.id.modulo);

        result_view = view.findViewById(R.id.result);
        math_info_view = view.findViewById(R.id.math_info);
        temp_math = view.findViewById(R.id.temp_math);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("1");
                    math_info_view.setText("1");
                } else {
                    temp_math.setText(temp_math.getText() + "1");
                    math_info_view.setText(math_info_view.getText() + "1");
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("2");
                    math_info_view.setText("2");
                } else {
                    temp_math.setText(temp_math.getText() + "2");
                    math_info_view.setText(math_info_view.getText() + "2");
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("3");
                    math_info_view.setText("3");
                } else {
                    temp_math.setText(temp_math.getText() + "3");
                    math_info_view.setText(math_info_view.getText() + "3");
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("4");
                    math_info_view.setText("4");
                } else {
                    temp_math.setText(temp_math.getText() + "4");
                    math_info_view.setText(math_info_view.getText() + "4");
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("5");
                    math_info_view.setText("5");
                } else {
                    temp_math.setText(temp_math.getText() + "5");
                    math_info_view.setText(math_info_view.getText() + "5");
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("6");
                    math_info_view.setText("6");
                } else {
                    temp_math.setText(temp_math.getText() + "6");
                    math_info_view.setText(math_info_view.getText() + "6");
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("7");
                    math_info_view.setText("7");
                } else {
                    temp_math.setText(temp_math.getText() + "7");
                    math_info_view.setText(math_info_view.getText() + "7");
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("8");
                    math_info_view.setText("8");
                } else {
                    temp_math.setText(temp_math.getText() + "8");
                    math_info_view.setText(math_info_view.getText() + "8");
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("9");
                    math_info_view.setText("9");
                } else {
                    temp_math.setText(temp_math.getText() + "9");
                    math_info_view.setText(math_info_view.getText() + "9");
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("0");
                    math_info_view.setText("0");
                } else {
                    temp_math.setText(temp_math.getText() + "0");
                    math_info_view.setText(math_info_view.getText() + "0");
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                if (math_info_view.getText().equals("")) {
                    temp_math.setText("0.");
                    math_info_view.setText("0.");
                } else {
                    temp_math.setText(temp_math.getText() + ".");
                    math_info_view.setText(math_info_view.getText() + ".");
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                operator = "+";
                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("+");
                    temp_math.setText("@");
                } else {
                    math_info_view.setText(math_info_view.getText() + "+");
                    temp_math.setText(temp_math.getText() + "@");
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }


                operator = "-";

                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("-");
                    temp_math.setText("-");
                } else {
                    math_info_view.setText(math_info_view.getText() + "-");
                    temp_math.setText(temp_math.getText() + "-");
                }
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }

                operator = "*";


                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("*");
                    temp_math.setText(",");
                } else {
                    math_info_view.setText(math_info_view.getText() + "*");
                    temp_math.setText(temp_math.getText() + ",");
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }
                operator = "/";
                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("/");
                    temp_math.setText("/");
                } else {
                    math_info_view.setText(math_info_view.getText() + "/");
                    temp_math.setText(temp_math.getText() + "/");
                }
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }


                operator = "exp";


                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("^");
                    temp_math.setText("#");
                } else {
                    math_info_view.setText(math_info_view.getText() + "^");
                    temp_math.setText(temp_math.getText() + "#");
                }
            }
        });
        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equal_pressed) {
                    result_view.setText("");
                    math_info_view.setText("");
                    equal_pressed = false;
                }


                operator = "modulo";


                if (math_info_view.getText().equals("")) {
                    math_info_view.setText("%");
                    temp_math.setText("%");
                } else {
                    math_info_view.setText(math_info_view.getText() + "%");
                    temp_math.setText(temp_math.getText() + "%");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_view.setText("");
                math_info_view.setText("");
                temp_math.setText("");
                equal_pressed = false;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!math_info_view.getText().equals("")) {
                    String s = math_info_view.getText().toString();
                    String s1 = temp_math.getText().toString();
                    if (s.length() > 0) {
                        temp_math.setText(s1.substring(0, s1.length() - 1));
                        math_info_view.setText(s.substring(0, s.length() - 1));
                    } else {

                        // Toast.makeText(MainActivity.this, "No more characters to delete", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Toast.makeText(this, "nothing to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equal_pressed = true;
                if (operator == "+") {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split("@", 5);
                    float re = Float.parseFloat(arrOfStr[0]) + Float.parseFloat(arrOfStr[1]);
                    result_view.setText(String.valueOf(re));
                } else if (Objects.equals(operator, "-")) {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split("-", 5);
                    float re = Float.parseFloat(arrOfStr[0]) - Float.parseFloat(arrOfStr[1]);
                    result_view.setText(String.valueOf(re));
                } else if (Objects.equals(operator, "*")) {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split(",", 5);
                    float re = Float.parseFloat(arrOfStr[0]) * Float.parseFloat(arrOfStr[1]);
                    result_view.setText(String.valueOf(re));
                } else if (Objects.equals(operator, "/")) {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split("/", 5);
                    float re = Float.parseFloat(arrOfStr[0]) / Float.parseFloat(arrOfStr[1]);
                    result_view.setText(String.valueOf(re));
                } else if (Objects.equals(operator, "exp")) {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split("#", 5);
                    float re = (float) Math.pow(Float.parseFloat(arrOfStr[0]), Float.parseFloat(arrOfStr[1]));
                    result_view.setText(String.valueOf(re));
                } else if (Objects.equals(operator, "modulo")) {
                    String str = temp_math.getText().toString();
                    String[] arrOfStr = str.split("%", 5);
                    float re = Float.parseFloat(arrOfStr[0]) % Float.parseFloat(arrOfStr[1]);
                    result_view.setText(String.valueOf(re));
                }
            }
        });
        return view;
    }


}