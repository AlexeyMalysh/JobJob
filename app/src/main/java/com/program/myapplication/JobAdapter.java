package com.program.myapplication;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JobAdapter extends ArrayAdapter<JobModel> {

    private LayoutInflater inflater;
    private int layout;
    private List<JobModel> states;


    public JobAdapter(Context context, int resource, List<JobModel> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView jobView = view.findViewById(R.id.image_job);
        TextView companyView = view.findViewById(R.id.company);
        TextView vacancyView = view.findViewById(R.id.vacancy);
        TextView infoView = view.findViewById(R.id.info_job);
        TextView timeView = view.findViewById(R.id.job_time);
        TextView saleView = view.findViewById(R.id.job_sale);
        Button seeVacancy = view.findViewById(R.id.watch_vacancy);

       JobModel state = states.get(position);
        seeVacancy.setId(state.getIdVacancy());
        seeVacancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), info_about_job.class);
                intent.putExtra("id", String.valueOf(seeVacancy.getId()));
                getContext().startActivity(intent);
                String js = null;
                try {
                    js = new JSONObject()
                            .put("offer_id", seeVacancy.getId())
                            .put("cv_id", Model.getInstance().getPhoneNumber())
                            .toString();

                    Log.e("ID", String.valueOf(seeVacancy.getId()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                ActivityOkHttp activityOkHttp = new ActivityOkHttp();
                activityOkHttp.postHttpEmployee(js);
            }
        });

        Picasso.get().load(state.getUrlImage()).into(jobView);
        companyView.setText(state.getCompany());
        vacancyView.setText(state.getVacancy());
        infoView.setText(state.getInfo());
        timeView.setText(state.getJobTime());
        saleView.setText(state.getSale());


        return view;
    }
}
