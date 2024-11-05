package com.robinbd.exam.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.robinbd.exam.R;


public class ProfileFragment extends androidx.fragment.app.Fragment {
    Button data,datareg;
    TextView tvdata,tvtex;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     View myview =   inflater.inflate(R.layout.fragment_profile, container, false);
        data =myview.findViewById(R.id.data);
        tvdata =myview.findViewById(R.id.tvdata);
        tvtex =myview.findViewById(R.id.tvtex);
        datareg =myview.findViewById(R.id.datareg);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userdettres", Context.MODE_PRIVATE);
                String getusername = sharedPreferences.getString("emailkey","no data avallable");
                String getpassword = sharedPreferences.getString("passwordkey","no data");
                tvdata.append("email is "+getusername+"\n");
                tvdata.append("password is "+getpassword);

            }

        });
        datareg.setOnClickListener(v -> {
            SharedPreferences sharedPreferences =getActivity().getSharedPreferences("userdata",Context.MODE_PRIVATE);
            String getusernamee = sharedPreferences.getString("pastnamekey","no data avallable");
            String getlastname = sharedPreferences.getString("lastnamekey","no data avallable");
            String getemail = sharedPreferences.getString("emailkey","no data avallable");
            String getphone = sharedPreferences.getString("phonekey","no data avallable");
            String getpassword= sharedPreferences.getString("passwordkey","no data avallable");
            String getspinner= sharedPreferences.getString("spinnerkey","no data avallable");
          /*  String getselet = sharedPreferences.getString("seletkey","no data avallable");*/
            SharedPreferences sharedPreferences1 =getActivity().getSharedPreferences("radiodata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences1.edit();
            String getselet = sharedPreferences.getString("seletkey","no data avallable");


            tvtex.append("fast name : " + getusernamee + "\n");
            tvtex.append("last name : " + getlastname + "\n");
            tvtex.append("email : " + getemail + "\n");
            tvtex.append("number : " + getphone + "\n");
            tvtex.append("pasword : " + getpassword + "\n");
            tvtex.append("this county : " + getspinner + "\n");
            tvtex.append("Gender : " + getselet + "\n");


        });





        return myview;
    }
}