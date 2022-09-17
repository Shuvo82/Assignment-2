package com.example.Offline_2;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.Objects;

public class ThirdFragment extends Fragment {
    private SwitchMaterial dark_mode;
    private Button save_button,check;
    private RadioGroup radioGroup;
    private RadioButton currency, weight, distance;
    private Spinner spinner_from, spinner_to;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }


    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.third_fragment, container, false);

        save_button = view.findViewById(R.id.save_values_button);
        dark_mode = view.findViewById(R.id.dark_mode_switch);
        radioGroup = view.findViewById(R.id.converter_RadioGroup);
        spinner_from = view.findViewById(R.id.spinner_convert_from);
        spinner_to = view.findViewById(R.id.spinner_convert_to);
        currency = view.findViewById(R.id.currency_radioButton);
        weight = view.findViewById(R.id.weight_radioButton);
        distance = view.findViewById(R.id.distance_radioButton);
        check = view.findViewById(R.id.check);





        SharedPreferences demoApp_shared_pref = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);
        boolean savedData = demoApp_shared_pref.getBoolean("dark_mode",false);

        if(savedData){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            dark_mode.setChecked(true);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            dark_mode.setChecked(false);
        }
        dark_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dark_mode.isChecked()) {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("dark_mode", true);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("dark_mode", false);
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


        String ttt= demoApp_shared_pref.getString("default_converter", "weight");
        if(Objects.equals(ttt, "currency")){
            //Toast.makeText(getActivity(), "currency selected", Toast.LENGTH_SHORT).show();
            radioGroup.check(currency.getId());
        }else if(Objects.equals(ttt, "weight")){
            radioGroup.check(weight.getId());
            //Toast.makeText(getActivity(), "weight selected", Toast.LENGTH_SHORT).show();
        }
        else if(Objects.equals(ttt, "distance")){
            radioGroup.check(distance.getId());
            //Toast.makeText(getActivity(), "distance selected", Toast.LENGTH_SHORT).show();
        }




        if (radioGroup.getCheckedRadioButtonId() == currency.getId()) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("doller");
            arrayList.add("euro");
            arrayList.add("ruppee");
            arrayList.add("dirham");
            arrayList.add("yen");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            spinner_from.setAdapter(arrayAdapter);
            spinner_to.setAdapter(arrayAdapter);

            SharedPreferences curr= getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
            spinner_from.setSelection(curr.getInt("default_from",0));
            spinner_to.setSelection(curr.getInt("default_to",0));
        }
        else if (radioGroup.getCheckedRadioButtonId() == distance.getId()) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("meter");
            arrayList.add("kilometer");
            arrayList.add("centimeter");
            arrayList.add("millimeter");
            arrayList.add("micrometer");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            spinner_from.setAdapter(arrayAdapter);
            spinner_to.setAdapter(arrayAdapter);

            SharedPreferences dis= getActivity().getSharedPreferences("distance", getActivity().MODE_PRIVATE);
            spinner_from.setSelection(dis.getInt("default_from",0));
            spinner_to.setSelection(dis.getInt("default_to",0));

            //spinner_from.setSelection(1);

        }
        else if (radioGroup.getCheckedRadioButtonId() == weight.getId()) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("kilogram");
            arrayList.add("gram");
            arrayList.add("milligram");
            arrayList.add("microgram");
            arrayList.add("tonne");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            spinner_from.setAdapter(arrayAdapter);
            spinner_to.setAdapter(arrayAdapter);

            SharedPreferences weight= getActivity().getSharedPreferences("weight", getActivity().MODE_PRIVATE);
            spinner_from.setSelection(weight.getInt("default_from",0));
            spinner_to.setSelection(weight.getInt("default_to",0));

        }

        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("doller");
                arrayList.add("euro");
                arrayList.add("ruppee");
                arrayList.add("dirham");
                arrayList.add("yen");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
                spinner_from.setAdapter(arrayAdapter);
                spinner_to.setAdapter(arrayAdapter);
                SharedPreferences curr= getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
                spinner_from.setSelection(curr.getInt("default_from",0));
                spinner_to.setSelection(curr.getInt("default_to",0));
            }
        });
        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("meter");
                arrayList.add("kilometer");
                arrayList.add("centimeter");
                arrayList.add("millimeter");
                arrayList.add("micrometer");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
                spinner_from.setAdapter(arrayAdapter);
                spinner_to.setAdapter(arrayAdapter);

                SharedPreferences dis= getActivity().getSharedPreferences("distance", getActivity().MODE_PRIVATE);
                spinner_from.setSelection(dis.getInt("default_from",0));
                spinner_to.setSelection(dis.getInt("default_to",0));
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("kilogram");
                arrayList.add("gram");
                arrayList.add("milligram");
                arrayList.add("microgram");
                arrayList.add("tonne");
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
                spinner_from.setAdapter(arrayAdapter);
                spinner_to.setAdapter(arrayAdapter);

                SharedPreferences weight= getActivity().getSharedPreferences("weight", getActivity().MODE_PRIVATE);
                spinner_from.setSelection(weight.getInt("default_from",0));
                spinner_to.setSelection(weight.getInt("default_to",0));
            }
        });


//        String t = demoApp_shared_pref.getString("default_converter", "currency");
//        if(t=="currency"){
//            currency.setChecked(true);
//            SharedPreferences curr= getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
//
//            spinner_from.setSelection(curr.getInt("default_from",0));
//            spinner_to.setSelection(curr.getInt("default_to",0));
//        }
//        else if(t=="weight"){
//            weight.setChecked(true);
//        }
//        else if(t=="distance"){
//            distance.setChecked(true);
//        }

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();



                if (radioGroup.getCheckedRadioButtonId() == R.id.currency_radioButton) {
                    Toast.makeText(getActivity(), "currency", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    ed.putString("default_converter", "currency");

                    editor.putInt("default_from", spinner_from.getSelectedItemPosition());
                    editor.putInt("default_to", spinner_to.getSelectedItemPosition());

                    editor.apply();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.distance_radioButton) {
                    Toast.makeText(getActivity(), "distance", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("distance", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    ed.putString("default_converter", "distance");
                    ed.putString("default_converter", "distance");

                    editor.putInt("default_from", spinner_from.getSelectedItemPosition());
                    editor.putInt("default_to", spinner_to.getSelectedItemPosition());


                    editor.apply();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.weight_radioButton) {
                    Toast.makeText(getActivity(), "weight", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("weight", getActivity().MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    ed.putString("default_converter", "weight");

                    editor.putInt("default_from", spinner_from.getSelectedItemPosition());
                    editor.putInt("default_to", spinner_to.getSelectedItemPosition());
                    editor.apply();
                }
                ed.apply();
            }
        });


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), ttt, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}