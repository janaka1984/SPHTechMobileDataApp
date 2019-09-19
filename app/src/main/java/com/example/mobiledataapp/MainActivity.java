package com.example.mobiledataapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.toolbox.Volley;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    List<DbModel> token;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private RecyclerView recyclerView;
    ProgressBar loading_view;
    ArrayList<Repo> mUserDataList = new ArrayList<>();
    private DbHolder dbHolder;
    double count1,count2,count3,count4,count5,count6,count7,count8,count9,count10,count11,count12,count13,count14,count15,count16;
    String year1,year2,year3,year4,year5,year6,year7,year8,year9,year10,year11,year12,year13,year14,year15,year16;
    int quater1,quater2,quater3,quater4,quater5,quater6,quater7,quater8,quater9,quater10,quater11,quater12,quater13,quater14,quater15
    ,quater16;
    String quatervalue1,quatervalue2,quatervalue3,quatervalue4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        loading_view=findViewById(R.id.loading_view);

        dbHolder = new DbHolder(MainActivity.this);
        int counter=dbHolder.counter();
       Boolean result= haveNetworkConnection();
       if (result==false&&counter>0)
       {
           Toast.makeText(MainActivity.this,"No Network Found So conected to local db",Toast.LENGTH_LONG).show();
           token= dbHolder.GetAllData();

       }
       if (result==false&&counter==0)
       {
           Toast.makeText(MainActivity.this,"No Network Found ",Toast.LENGTH_LONG).show();

       }

       if(result == true && counter == 0 ){
           volleyJsonArrayRequest();
       } else
       {

           if(counter > 0){
               token= dbHolder.GetAllData();
               generateDataList(token);
           }

       }



    //    Log.d("Size",String.valueOf(token.size()));




     /*

        for (DbModel cn : token) {

            Log.d("Year",String.valueOf(cn.getYear()));
        }*/

      /*  Repo model=new Repo();
        model.setVolume_of_mobile_data("1");
        model.setQuarter("2");
        model.set_id(3);
        mUserDataList.add(model);
        generateDataList(mUserDataList);*/
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<DbModel> photoList) {

        customRecyclerAdapter = new CustomRecyclerAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customRecyclerAdapter);
    }




    public void volleyJsonArrayRequest(){

        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "https://data.gov.sg/api/action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f";


        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                         loading_view.setVisibility(View.GONE);
                        try {

                            JSONObject object=(response.getJSONObject("result"));
                            JSONArray records=(object.getJSONArray("records"));

                            for (int i=14;i<records.length();i++)
                            {
                                JSONObject jsonObject1 = records.getJSONObject(i);
                                if(i<2)
                                {
                                    //2004
                                    year1=replace(jsonObject1.getString("quarter"));
                                    count1=count1+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater1=4;
                                    if(i==0)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==1)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==1)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count1), String.valueOf(quater1),"","",quatervalue3, quatervalue4));
                                    }

                                }

                                if(i>1&&i<=5)
                                {
                                    //2005

                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count2=count2+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater2=4;
                                    if(i==2)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==3)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==4)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==5)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==5)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count2), String.valueOf(quater2), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>5&&i<=9)
                                {
                                    //2006
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count3=count3+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater3=4;
                                    if(i==6)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==7)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==8)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==9)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==9)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count3), String.valueOf(quater3), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>9&&i<=13)
                                {
                                    //2007
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count4=count4+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater4=4;
                                    if(i==10)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==11)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==12)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==13)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==13)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count4), String.valueOf(quater4), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>13&&i<=17)
                                {
                                    //2008
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count5=count5+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater5=4;
                                    if(i==14)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==15)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==16)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==17)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==17)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count5), String.valueOf(quater5), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>17&&i<=21)
                                {
                                    //2009
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count6=count6+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater6=4;
                                    if(i==18)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==19)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==20)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==21)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==21)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count6), String.valueOf(quater6), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>21&&i<=25)
                                {
                                    //2010
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count7=count7+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater7=4;
                                    if(i==22)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==23)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==24)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==25)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==25)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count7), String.valueOf(quater7), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>25&&i<=29)
                                {
                                    //2011
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count8=count8+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater8=4;
                                    if(i==26)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==27)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==28)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==29)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==29)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count8), String.valueOf(quater8), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>29&&i<=33)
                                {
                                    //2012
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count9=count9+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater9=4;
                                    if(i==30)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==31)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==32)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==33)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==33)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count9), String.valueOf(quater9), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>33&&i<=37)
                                {
                                    //2013
                                    String year1=replace(jsonObject1.getString("quarter"));
                                    count10=count10+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                    quater10=4;
                                    if(i==34)
                                    {
                                        quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                    }
                                    if(i==35)
                                    {
                                        quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==36)
                                    {
                                        quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                    }
                                    if(i==37)
                                    {
                                        quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                    }

                                    if(i==37)
                                    {
                                        dbHolder.AddData(new DbModel(year1, String.valueOf(count10), String.valueOf(quater10), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                    }

                                }
                                if(i>37&&i<=41)
                            {
                                //2014
                                String year1=replace(jsonObject1.getString("quarter"));
                                count11=count11+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                quater11=4;
                                if(i==38)
                                {
                                    quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                }
                                if(i==39)
                                {
                                    quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==40)
                                {
                                    quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==41)
                                {
                                    quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                }

                                if(i==41)
                                {
                                    dbHolder.AddData(new DbModel(year1, String.valueOf(count11), String.valueOf(quater11), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                }

                            }  if(i>41&&i<=45)
                            {
                                Log.d("2015","Year");
                                String year1=replace(jsonObject1.getString("quarter"));
                                count12=count12+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                quater12=4;
                                if(i==42)
                                {
                                    quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                }
                                if(i==43)
                                {
                                    quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==44)
                                {
                                    quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==45)
                                {
                                    quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                }

                                if(i==45)
                                {
                                    dbHolder.AddData(new DbModel(year1, String.valueOf(count12), String.valueOf(quater12), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                }

                            }  if(i>45&&i<=49)
                            {
                                //2016
                                String year1=replace(jsonObject1.getString("quarter"));
                                count13=count13+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                quater13=4;
                                if(i==46)
                                {
                                    quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                }
                                if(i==47)
                                {
                                    quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==48)
                                {
                                    quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==49)
                                {
                                    quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                }

                                if(i==49)
                                {
                                    dbHolder.AddData(new DbModel(year1, String.valueOf(count13), String.valueOf(quater13), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                }

                            }
                                if(i>49&&i<=53)
                            {
                                //2017
                                String year1=replace(jsonObject1.getString("quarter"));
                                count14=count14+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                quater14=4;
                                if(i==50)
                                {
                                    quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                }
                                if(i==51)
                                {
                                    quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==52)
                                {
                                    quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==53)
                                {
                                    quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                }

                                if(i==53)
                                {
                                    dbHolder.AddData(new DbModel(year1, String.valueOf(count14), String.valueOf(quater14), quatervalue1, quatervalue2,quatervalue3,quatervalue4));
                                }

                            }  if(i>53&&i<=57)
                            {
                                //2018
                                String year1=replace(jsonObject1.getString("quarter"));
                                count15=count15+Double.parseDouble(jsonObject1.getString("volume_of_mobile_data"));
                                quater15=4;
                                if(i==54)
                                {
                                    quatervalue1 = jsonObject1.getString("volume_of_mobile_data")+"yes";
                                }
                                if(i==55)
                                {
                                    quatervalue2 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==56)
                                {
                                    quatervalue3 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==57)
                                {
                                    quatervalue4 = jsonObject1.getString("volume_of_mobile_data");
                                }
                                if(i==57)
                                {
                                    dbHolder.AddData(new DbModel(year1, String.valueOf(count15), String.valueOf(quater15), quatervalue1, quatervalue2,quatervalue3,quatervalue4));

                                }
                              /*  if(i==58)
                                {
                                    startfunctio();
                                }*/
                            }

                         /*
                                Repo model=new Repo();
                                model.setVolume_of_mobile_data(jsonObject1.getString("volume_of_mobile_data"));
                                model.setQuarter(jsonObject1.getString("quarter"));
                                model.set_id(Integer.parseInt(jsonObject1.getString("_id")));*/

                            }


                            int counter=dbHolder.counter();

                            if(counter > 0){
                                token= dbHolder.GetAllData();
                                generateDataList(token);
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                        loading_view.setVisibility(View.GONE);
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);


    }


    void startfunctio()
    {
        startActivity(new Intent(MainActivity.this,MainActivity.class));
    }

 public String replace(String value)
 {
     loading_view.setVisibility(View.GONE);
     String year = "";
     if(value.contains("-Q1"))
     {
         year = value.replace("-Q1", " ");

     }
     if(value.contains("-Q2"))
     {
         year =value.replace("-Q2", " ");

     }
     if(value.contains("-Q3"))
     {
         year= value.replace("-Q3", " ");

     }
     if(value.contains("-Q4"))
     {
         year = value.replace("-Q4", " ");

     }


     return  year;
 }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

}
