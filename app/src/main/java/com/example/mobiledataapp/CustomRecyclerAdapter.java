package com.example.mobiledataapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivity mFragment;
    private List<DbModel> mListing;
    public CustomRecyclerAdapter(MainActivity fragment, List<DbModel> listing)
    {
        super();
        this.mFragment = fragment;
        this.mListing = listing;
    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        return mListing.size();
    }
    private DbModel getItem(int position) {
        return mListing.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repo_list_item,
                parent, false);
        return new CustomRecyclerAdapter.ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof CustomRecyclerAdapter.ItemViewHolder) {
            ((CustomRecyclerAdapter.ItemViewHolder) viewHolder).setListeners(getItem(position),position);
            settingViewsAndListeners((CustomRecyclerAdapter.ItemViewHolder) viewHolder, position);
        }
    }

    private void settingViewsAndListeners(final CustomRecyclerAdapter.ItemViewHolder itemViewHolder, final int position) {

        final DbModel data = getItem(position);

        if (data == null) {
       //     CommonUtilities.log_e(TAG, "Object is null");
            return;
        }




            itemViewHolder.datausage.setText(data.getYear());
            itemViewHolder.count.setText(data.getTotal());


        itemViewHolder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.getQuaterCount().contains("1")&&itemViewHolder.quatercover1.getVisibility()==View.GONE)
                {
                    itemViewHolder.quatercover1.setVisibility(View.VISIBLE);
                    itemViewHolder.quater_name1.setText("Q-1");
                    if(data.getQuater1().contains("yes"))
                    {
                        String value  = data.getQuater1().replace("yes", " ");
                        itemViewHolder.quater_type1.setText(value);
                        itemViewHolder.quater1_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type1.setText(data.getQuater1());
                    }

                }
                else
                {
                    itemViewHolder.quatercover1.setVisibility(View.GONE);
                }
                if(data.getQuaterCount().contains("2")&&itemViewHolder.quatercover1.getVisibility()==View.GONE&&itemViewHolder.quatercover2.getVisibility()==View.GONE)
                {
                    itemViewHolder.quatercover1.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover2.setVisibility(View.VISIBLE);

                    itemViewHolder.quater_name1.setText("Q-1");
                    if(data.getQuater1().contains("yes"))
                    {
                        String value  = data.getQuater1().replace("yes", " ");
                        itemViewHolder.quater_type1.setText(value);
                        itemViewHolder.quater1_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type1.setText(data.getQuater1());
                    }
                    itemViewHolder.quater_name2.setText("Q-2");
                    if(data.getQuater2().contains("yes"))
                    {
                        String value  = data.getQuater2().replace("yes", " ");
                        itemViewHolder.quater_type2.setText(value);
                        itemViewHolder.quater2_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type2.setText(data.getQuater2());
                    }
                }
                else
                {
                    itemViewHolder.quatercover1.setVisibility(View.GONE);
                    itemViewHolder.quatercover2.setVisibility(View.GONE);
                }
                if(data.getQuaterCount().contains("3"))
                {
                    itemViewHolder.quatercover1.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover2.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover3.setVisibility(View.VISIBLE);

                    itemViewHolder.quater_name1.setText("Q-1");
                    itemViewHolder.quater_name1.setText("Q-1");
                    if(data.getQuater1().contains("yes"))
                    {
                        String value  = data.getQuater1().replace("yes", " ");
                        itemViewHolder.quater_type1.setText(value);
                        itemViewHolder.quater1_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type1.setText(data.getQuater1());
                    }
                    itemViewHolder.quater_name2.setText("Q-2");
                    itemViewHolder.quater_name2.setText("Q-2");
                    if(data.getQuater2().contains("yes"))
                    {
                        String value  = data.getQuater2().replace("yes", " ");
                        itemViewHolder.quater_type2.setText(value);
                        itemViewHolder.quater2_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type2.setText(data.getQuater2());
                    }
                    itemViewHolder.quater_name3.setText("Q-3");


                    if(data.getQuater3().contains("yes"))
                    {
                        String value  = data.getQuater3().replace("yes", " ");
                        itemViewHolder.quater_type3.setText(value);
                        itemViewHolder.quater3_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type3.setText(data.getQuater3());
                    }
                }
                if(data.getQuaterCount().contains("4")&&itemViewHolder.quatercover1.getVisibility()==View.GONE&&itemViewHolder.quatercover2.getVisibility()==View.GONE
                        &&itemViewHolder.quatercover3.getVisibility()==View.GONE&&itemViewHolder.quatercover4.getVisibility()==View.GONE)
                {
                    itemViewHolder.quatercover1.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover2.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover3.setVisibility(View.VISIBLE);
                    itemViewHolder.quatercover4.setVisibility(View.VISIBLE);

                    itemViewHolder.quater_name1.setText("Q-1");
                    itemViewHolder.quater_name1.setText("Q-1");
                    if(data.getQuater1().contains("yes"))
                    {
                        if(data.getQuater1().length()<1)
                        {
                            itemViewHolder.quatercover1.setVisibility(View.GONE);
                        }
                        else
                        {
                            String value = data.getQuater1().replace("yes", " ");
                            itemViewHolder.quater_type1.setText(value);
                            itemViewHolder.quater1_img.setVisibility(View.VISIBLE);
                        }
                    }
                    else {
                        if (data.getQuater1().length() < 1) {
                            itemViewHolder.quatercover1.setVisibility(View.GONE);
                        } else {
                            itemViewHolder.quater_type1.setText(data.getQuater1());
                        }
                    }
                    itemViewHolder.quater_name2.setText("Q-2");
                    itemViewHolder.quater_name2.setText("Q-2");
                    if(data.getQuater2().contains("yes"))
                    {
                        if(data.getQuater2().length()<1)
                        {
                            itemViewHolder.quatercover2.setVisibility(View.GONE);
                        }
                        else {
                            if (data.getQuater2().length() < 1)
                            {
                                itemViewHolder.quatercover2.setVisibility(View.GONE);
                            }
                            else
                                {

                                String value = data.getQuater2().replace("yes", " ");
                                itemViewHolder.quater_type2.setText(value);
                                itemViewHolder.quater2_img.setVisibility(View.VISIBLE);
                            }
                        }
                     }
                    else
                        {
                        if (data.getQuater2().length() < 1)
                        {
                            itemViewHolder.quatercover2.setVisibility(View.GONE);
                        } else {
                            itemViewHolder.quater_type2.setText(data.getQuater2());

                        }
                    }
                    itemViewHolder.quater_name3.setText("Q-3");
                    if(data.getQuater3().contains("yes"))
                    {
                        String value  = data.getQuater3().replace("yes", " ");
                        itemViewHolder.quater_type3.setText(value);
                        itemViewHolder.quater3_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type3.setText(data.getQuater3());
                    }
                    itemViewHolder.quater_name4.setText("Q-4");
                    if(data.getQuater4().contains("yes"))
                    {
                        String value  = data.getQuater4().replace("yes", " ");
                        itemViewHolder.quater_type4.setText(value);
                        itemViewHolder.quater4_img.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        itemViewHolder.quater_type4.setText(data.getQuater4());
                    }
                }
                else
                {
                    itemViewHolder.quatercover1.setVisibility(View.GONE);
                    itemViewHolder.quatercover2.setVisibility(View.GONE);
                    itemViewHolder.quatercover3.setVisibility(View.GONE);
                    itemViewHolder.quatercover4.setVisibility(View.GONE);
                }
            }
        });


    }

    /*
     * View Holder
     */
    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView datausage, count, quater_name1, quater_type1, quater_name2, quater_type2
                , quater_name3, quater_type3, quater_name4, quater_type4;
        LinearLayout upper_cover,Lower_cover,quatercover1,quatercover2,quatercover3,quatercover4;
        ImageView down,quater1_img,quater2_img,quater3_img,quater4_img;

        View view;

        private ItemViewHolder(View itemView, int type) {
            super(itemView);

            init(itemView, type);
        }

        void init(View itemView, int type) {

            this.view = itemView;

            datausage=(TextView) view.findViewById(R.id.datausage);
            down=(ImageView) view.findViewById(R.id.down);
            count=(TextView) view.findViewById(R.id.count);
            quater_name1=(TextView) view.findViewById(R.id.quater_name1);
            quater_type1=(TextView) view.findViewById(R.id.quater_type1);
            quater_name2=(TextView) view.findViewById(R.id.quater_name2);
            quater_type2=(TextView) view.findViewById(R.id.quater_type2);
            quater_name3=(TextView) view.findViewById(R.id.quater_name3);
            quater_type3=(TextView) view.findViewById(R.id.quater_type3);
            quater_name4=(TextView) view.findViewById(R.id.quater_name4);
            quater_type4=(TextView) view.findViewById(R.id.quater_type4);
            upper_cover=(LinearLayout) view.findViewById(R.id.upper_cover);
            quater1_img=(ImageView) view.findViewById(R.id.quater1_image1);
            quater2_img=(ImageView) view.findViewById(R.id.quater1_image2);
            quater3_img=(ImageView) view.findViewById(R.id.quater1_image3);
            quater4_img=(ImageView) view.findViewById(R.id.quater1_image4);


            quatercover1=(LinearLayout) view.findViewById(R.id.quater_cover1);
            quatercover2=(LinearLayout) view.findViewById(R.id.quater_cover2);
            quatercover3=(LinearLayout) view.findViewById(R.id.quater_cover3);
            quatercover4=(LinearLayout) view.findViewById(R.id.quater_cover4);

        }


        void setListeners(final DbModel itemListing, final int position) {



        }
    }

}
