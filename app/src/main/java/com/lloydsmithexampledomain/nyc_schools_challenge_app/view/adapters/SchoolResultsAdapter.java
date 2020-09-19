package com.lloydsmithexampledomain.nyc_schools_challenge_app.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lloydsmithexampledomain.nyc_schools_challenge_app.R;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.presenter.interfaces.contracts.ISchoolData;
import com.lloydsmithexampledomain.nyc_schools_challenge_app.view.interfaces.contracts.ISchoolResultsAdapter;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

public class SchoolResultsAdapter extends RecyclerView.Adapter<SchoolResultsAdapter.SchoolResultsViewHolder> implements ISchoolResultsAdapter {

    private Context mContext;
    private List<ISchoolData> mSchoolResults;
    private OnItemClickListener mListener;

    public SchoolResultsAdapter(Context context, List<ISchoolData> schoolResults) {
        this.mContext = new WeakReference<>(context).get();
        this.mSchoolResults = schoolResults;
    }

    private String getPercentageString(Double value) {
        return value != null ? String.valueOf(Math.floor(value * 100)).concat("%") : "--";
    }

    @NonNull
    @Override
    public SchoolResultsAdapter.SchoolResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolResultsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.viewholder_school_result, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolResultsAdapter.SchoolResultsViewHolder holder, int position) {
        final ISchoolData result = mSchoolResults.get(position);
        holder.schoolNameTextView.setText(result.getSchoolName());
        holder.statsRatingTextView.setText(String.format("GR: %s\nSR: %s", getPercentageString(result.getGraduationRatePercentage()), getPercentageString(result.getStudentSafetyPercentage())));
        holder.locationTextView.setText(String.format(Locale.getDefault(), "%s, %s %s", result.getCity(), result.getStateCode(), result.getPostcode()));
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClicked(result);
            }
        });
    }

    @Override
    public void setItemClickListener(ISchoolResultsAdapter.OnItemClickListener clickListener) {
        this.mListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mSchoolResults.size();
    }

    protected static class SchoolResultsViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private TextView schoolNameTextView;
        private TextView statsRatingTextView;
        private TextView locationTextView;

        public SchoolResultsViewHolder(@NonNull View view) {
            super(view);

            itemView = view;
            schoolNameTextView = view.findViewById(R.id.results_viewholder_school_name);
            statsRatingTextView = view.findViewById(R.id.results_viewholder_stats_rating);
            locationTextView = view.findViewById(R.id.results_viewholder_location);
        }
    }
}
