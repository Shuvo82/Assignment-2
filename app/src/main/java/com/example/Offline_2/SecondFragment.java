package com.example.Offline_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

public class SecondFragment extends Fragment {
    private EditText input;
    private TextView output;
    private Button Convert;
    private RadioGroup radioGroup;
    private RadioButton currency, distance, weight;

    private Spinner convert_to_spinner, convert_from_spinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        Convert = view.findViewById(R.id.Convert);
        input = view.findViewById(R.id.input);
        output = view.findViewById(R.id.output_text_view);
        radioGroup = view.findViewById(R.id.converter_radioGroups);
        currency = view.findViewById(R.id.currency);
        distance = view.findViewById(R.id.distance);
        weight = view.findViewById(R.id.weight);
        convert_from_spinner = view.findViewById(R.id.convert_from_spinner);
        convert_to_spinner = view.findViewById(R.id.convert_to_spinner);

        SharedPreferences demoApp_shared_pref = getActivity().getSharedPreferences("demoApp", getActivity().MODE_PRIVATE);

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

        if (radioGroup.getCheckedRadioButtonId() == R.id.currency) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("doller");
            arrayList.add("euro");
            arrayList.add("ruppee");
            arrayList.add("dirham");
            arrayList.add("yen");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            convert_from_spinner.setAdapter(arrayAdapter);
            convert_to_spinner.setAdapter(arrayAdapter);
            SharedPreferences curr= getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
            convert_from_spinner.setSelection(curr.getInt("default_from",0));
            convert_to_spinner.setSelection(curr.getInt("default_to",0));
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.distance) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("meter");
            arrayList.add("kilometer");
            arrayList.add("centimeter");
            arrayList.add("millimeter");
            arrayList.add("micrometer");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            convert_from_spinner.setAdapter(arrayAdapter);
            convert_to_spinner.setAdapter(arrayAdapter);

            SharedPreferences dis= getActivity().getSharedPreferences("distance", getActivity().MODE_PRIVATE);
            convert_from_spinner.setSelection(dis.getInt("default_from",0));
            convert_to_spinner.setSelection(dis.getInt("default_to",0));
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.weight) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("kilogram");
            arrayList.add("gram");
            arrayList.add("milligram");
            arrayList.add("microgram");
            arrayList.add("tonne");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
            convert_from_spinner.setAdapter(arrayAdapter);
            convert_to_spinner.setAdapter(arrayAdapter);

            SharedPreferences weight= getActivity().getSharedPreferences("weight", getActivity().MODE_PRIVATE);
            convert_from_spinner.setSelection(weight.getInt("default_from",0));
            convert_to_spinner.setSelection(weight.getInt("default_to",0));
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
                convert_from_spinner.setAdapter(arrayAdapter);
                convert_to_spinner.setAdapter(arrayAdapter);

                SharedPreferences curr= getActivity().getSharedPreferences("currency", getActivity().MODE_PRIVATE);
                convert_from_spinner.setSelection(curr.getInt("default_from",0));
                convert_to_spinner.setSelection(curr.getInt("default_to",0));
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
                convert_from_spinner.setAdapter(arrayAdapter);
                convert_to_spinner.setAdapter(arrayAdapter);

                SharedPreferences dis= getActivity().getSharedPreferences("distance", getActivity().MODE_PRIVATE);
                convert_from_spinner.setSelection(dis.getInt("default_from",0));
                convert_to_spinner.setSelection(dis.getInt("default_to",0));
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
                convert_from_spinner.setAdapter(arrayAdapter);
                convert_to_spinner.setAdapter(arrayAdapter);

                SharedPreferences weight= getActivity().getSharedPreferences("weight", getActivity().MODE_PRIVATE);
                convert_from_spinner.setSelection(weight.getInt("default_from",0));
                convert_to_spinner.setSelection(weight.getInt("default_to",0));
            }
        });
        //int t=radioGroup.getCheckedRadioButtonId();

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter a value", Toast.LENGTH_SHORT).show();
                } else {
                    double inputValue = Double.parseDouble(inputText);
                    //output.setText(String.valueOf(inputValue));
                    if (radioGroup.getCheckedRadioButtonId() == weight.getId()) {
                        String selectedTo = convert_to_spinner.getSelectedItem().toString();
                        String selectedFrom = convert_from_spinner.getSelectedItem().toString();
                        //output.setText("in weight");
                        //output.setText(selectedFrom);
                        if (selectedFrom.equals("kilogram")) {
                            //output.setText(selectedFrom);
                            if (selectedTo.equals("kilogram")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("gram")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            } else if (selectedTo.equals("milligram")) {
                                output.setText(String.valueOf(inputValue * 1000000));
                            } else if (selectedTo.equals("microgram")) {
                                output.setText(String.valueOf(inputValue * 1000000000));
                            } else if (selectedTo.equals("tonne")) {
                                output.setText(String.valueOf(inputValue / 907.185));
                            }

                        } else if (selectedFrom.equals("gram")) {
                            if (selectedTo.equals("kilogram")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            } else if (selectedTo.equals("gram")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("milligram")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            } else if (selectedTo.equals("microgram")) {
                                output.setText(String.valueOf(inputValue * 1000000));
                            } else if (selectedTo.equals("tonne")) {
                                output.setText(String.valueOf(inputValue / 907185));
                            }
                        } else if (selectedFrom.equals("milligram")) {
                            if (selectedTo.equals("kilogram")) {
                                output.setText(String.valueOf(inputValue / 1000000));
                            } else if (selectedTo.equals("gram")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            } else if (selectedTo.equals("milligram")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("microgram")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            } else if (selectedTo.equals("tonne")) {
                                output.setText(String.valueOf(inputValue / 907185000));
                            }
                        } else if (selectedFrom.equals("microgram")) {
                            if (selectedTo.equals("kilogram")) {
                                output.setText(String.valueOf(inputValue / 1000000000));
                            } else if (selectedTo.equals("gram")) {
                                output.setText(String.valueOf(inputValue / 1000000));
                            } else if (selectedTo.equals("milligram")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            } else if (selectedTo.equals("microgram")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("tonne")) {
                                output.setText(String.valueOf(inputValue / 907185000));
                            }
                        } else if (selectedFrom.equals("tonne")) {
                            if (selectedTo.equals("kilogram")) {
                                output.setText(String.valueOf(inputValue * 907.185));
                            } else if (selectedTo.equals("gram")) {
                                output.setText(String.valueOf(inputValue * 907185));
                            } else if (selectedTo.equals("milligram")) {
                                output.setText(String.valueOf(inputValue * 907185000));
                            } else if (selectedTo.equals("microgram")) {
                                output.setText(String.valueOf(inputValue * 907185000));
                            } else if (selectedTo.equals("tonne")) {
                                output.setText(String.valueOf(inputValue));
                            }
                        }
                    }//done
                    else if (radioGroup.getCheckedRadioButtonId() == distance.getId()) {
                        String selectedTo = convert_to_spinner.getSelectedItem().toString();
                        String selectedFrom = convert_from_spinner.getSelectedItem().toString();

                        if (selectedFrom.equals("meter")) {
                            if (selectedTo.equals("meter")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("kilometer")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            } else if (selectedTo.equals("centimeter")) {
                                output.setText(String.valueOf(inputValue * 100));
                            } else if (selectedTo.equals("millimeter")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            } else if (selectedTo.equals("micrometer")) {
                                output.setText(String.valueOf(inputValue * 1000000));
                            }

                        } else if (selectedFrom.equals("kilometer")) {
                            if (selectedTo.equals("meter")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            } else if (selectedTo.equals("kilometer")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("centimeter")) {
                                output.setText(String.valueOf(inputValue * 100000));
                            } else if (selectedTo.equals("millimeter")) {
                                output.setText(String.valueOf(inputValue * 1000000));
                            } else if (selectedTo.equals("micrometer")) {
                                output.setText(String.valueOf(inputValue * 1000000000));
                            }
                        } else if (selectedFrom.equals("centimeter")) {
                            if (selectedTo.equals("meter")) {
                                output.setText(String.valueOf(inputValue / 100));
                            } else if (selectedTo.equals("kilometer")) {
                                output.setText(String.valueOf(inputValue / 100000));
                            } else if (selectedTo.equals("centimeter")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("millimeter")) {
                                output.setText(String.valueOf(inputValue * 10));
                            } else if (selectedTo.equals("micrometer")) {
                                output.setText(String.valueOf(inputValue * 10000));
                            }
                        } else if (selectedFrom.equals("millimeter")) {
                            if (selectedTo.equals("meter")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            } else if (selectedTo.equals("kilometer")) {
                                output.setText(String.valueOf(inputValue / 1000000));
                            } else if (selectedTo.equals("centimeter")) {
                                output.setText(String.valueOf(inputValue / 10));
                            } else if (selectedTo.equals("millimeter")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("micrometer")) {
                                output.setText(String.valueOf(inputValue * 1000));
                            }
                        } else if (selectedFrom.equals("micrometer")) {
                            if (selectedTo.equals("meter")) {
                                output.setText(String.valueOf(inputValue / 1000000));
                            } else if (selectedTo.equals("kilometer")) {
                                output.setText(String.valueOf(inputValue / 1000000000));
                            } else if (selectedTo.equals("centimeter")) {
                                output.setText(String.valueOf(inputValue / 10000));
                            } else if (selectedTo.equals("millimeter")) {
                                output.setText(String.valueOf(inputValue / 1000));
                            }
                        }
                    }//done
                    else if (radioGroup.getCheckedRadioButtonId() == currency.getId()) {
                        String selectedTo = convert_to_spinner.getSelectedItem().toString();
                        String selectedFrom = convert_from_spinner.getSelectedItem().toString();
                        if (selectedFrom.equals("doller")) {
                            if (selectedTo.equals("doller")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("euro")) {
                                output.setText(String.valueOf(inputValue * 0.85));
                            } else if (selectedTo.equals("pound")) {
                                output.setText(String.valueOf(inputValue * 0.75));
                            } else if (selectedTo.equals("ruppee")) {
                                output.setText(String.valueOf(inputValue * 74.5));
                            } else if (selectedTo.equals("yen")) {
                                output.setText(String.valueOf(inputValue * 110.5));
                            }
                        } else if (selectedFrom.equals("euro")) {
                            if (selectedTo.equals("doller")) {
                                output.setText(String.valueOf(inputValue * 1.18));
                            } else if (selectedTo.equals("euro")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("pound")) {
                                output.setText(String.valueOf(inputValue * 0.88));
                            } else if (selectedTo.equals("ruppee")) {
                                output.setText(String.valueOf(inputValue * 88.5));
                            } else if (selectedTo.equals("yen")) {
                                output.setText(String.valueOf(inputValue * 130.5));
                            }
                        } else if (selectedFrom.equals("pound")) {
                            if (selectedTo.equals("doller")) {
                                output.setText(String.valueOf(inputValue * 1.33));
                            } else if (selectedTo.equals("euro")) {
                                output.setText(String.valueOf(inputValue * 1.13));
                            } else if (selectedTo.equals("pound")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("ruppee")) {
                                output.setText(String.valueOf(inputValue * 99.5));
                            } else if (selectedTo.equals("yen")) {
                                output.setText(String.valueOf(inputValue * 147.5));
                            }
                        } else if (selectedFrom.equals("ruppee")) {
                            if (selectedTo.equals("doller")) {
                                output.setText(String.valueOf(inputValue * 0.013));
                            } else if (selectedTo.equals("euro")) {
                                output.setText(String.valueOf(inputValue * 0.011));
                            } else if (selectedTo.equals("pound")) {
                                output.setText(String.valueOf(inputValue * 0.010));
                            } else if (selectedTo.equals("ruppee")) {
                                output.setText(String.valueOf(inputValue));
                            } else if (selectedTo.equals("yen")) {
                                output.setText(String.valueOf(inputValue * 1.47));
                            }
                        } else if (selectedFrom.equals("yen")) {
                            if (selectedTo.equals("doller")) {
                                output.setText(String.valueOf(inputValue * 0.009));
                            } else if (selectedTo.equals("euro")) {
                                output.setText(String.valueOf(inputValue * 0.0077));
                            } else if (selectedTo.equals("pound")) {
                                output.setText(String.valueOf(inputValue * 0.0068));
                            } else if (selectedTo.equals("ruppee")) {
                                output.setText(String.valueOf(inputValue * 0.68));
                            } else if (selectedTo.equals("yen")) {
                                output.setText(String.valueOf(inputValue));
                            }
                        }
                    }
                }
            }
        });


        return view;
    }
}