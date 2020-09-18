package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.adapters;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SchoolDetailsAdapter extends RecyclerView.Adapter<SchoolDetailsAdapter.SchoolDetailsViewHolder> {

    private Context mContext;
    private ISchoolData mSchoolResult;
    private HashMap<String, Object> mDataMap;
    private final ArrayList<Pair<String, Object>> mPairs = new ArrayList<>();

    private enum FieldType {DESCRIPTION, STAT }

    public SchoolDetailsAdapter(Context context, ISchoolData completeSchoolData) {
        this.mContext = new WeakReference<>(context).get();
        this.mSchoolResult = completeSchoolData;
        Gson gson = new Gson();
        String json = gson.toJson(mSchoolResult);

        // Converting individual fields into a mapped collection of data
        this.mDataMap = gson.fromJson(json, new TypeToken<HashMap<String, String>>(){}.getType());

        // Converting mapped collection into a list of mapped pairs - this is used to get an item by its position
        for (String key : mDataMap.keySet()) {
            mPairs.add(new Pair<>(key, mDataMap.get(key)));
        }
    }

    @NonNull
    @Override
    public SchoolDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutID;
        layoutID = viewType == FieldType.DESCRIPTION.ordinal() ? R.layout.viewholder_school_details_text : R.layout.viewholder_school_details_stat;
        return new SchoolDetailsViewHolder(LayoutInflater.from(mContext).inflate(layoutID, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolDetailsViewHolder holder, int position) {
        Pair<String, Object> pair = mPairs.get(position);
        holder.headerTextView.setText(pair.first);
        holder.contentTextView.setText(getStatString(holder, pair));
    }

    private String getPercentageString(Double value) {
        return value != null ? String.valueOf(Math.floor(value * 100)).concat("%") : "--";
    }

    private String getStatString(@NonNull SchoolDetailsViewHolder holder, Pair<String, Object> pair) {
        String data;
        if (holder.getItemViewType() == FieldType.DESCRIPTION.ordinal()) {
            data = (String) pair.second;
        } else {
            if (pair.second instanceof Double) {
                // More than likely a percentage... If not, this can be refactored later.
                 data = getPercentageString(((Double) pair.second));
            } else if (pair.second instanceof Integer) {
                data = ((Integer) pair.second).toString();
            } else if (pair.second instanceof Boolean) {
                data = ((Boolean) pair.second).toString();
            } else {
                data = (String) pair.second;
            }
        }
        return data;
    }

    @Override
    public int getItemViewType(int position) {
        Pair<String, Object> pair = mPairs.get(position);
        String key = pair.first;
        Object data = mDataMap.get(key);
        if (data instanceof Boolean || data instanceof Number) {
            return FieldType.STAT.ordinal();
        }
        return FieldType.DESCRIPTION.ordinal();
    }

    @Override
    public int getItemCount() {
        return mDataMap.size();
    }

    protected static class SchoolDetailsViewHolder extends RecyclerView.ViewHolder {

        private TextView headerTextView;
        private TextView contentTextView;

        public SchoolDetailsViewHolder(@NonNull View view) {
            super(view);

            headerTextView = view.findViewById(R.id.details_header);
            contentTextView = view.findViewById(R.id.details_content);
        }
    }
}
