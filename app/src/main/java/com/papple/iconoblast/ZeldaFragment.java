package com.papple.iconoblast;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jaeger.library.StatusBarUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ZeldaFragment extends Fragment implements Zelda_Adapter.OnItemClickListener, Zelda_Adapter_List.OnItemClickListener {
    private MediaPlayer jaimeLesPlayer;
    RecyclerView mRecyclerView;
    Zelda_Adapter_List aAdapter;
    Zelda_Adapter aAdapter2;
    RecyclerView.LayoutManager mLayoutManager;
    public RelativeLayout relativeLayout;
    ArrayList<Zelda_Item_List_ListVersion> zeldaList;
    ArrayList<Zelda_Item_List> zeldaList2;
    Picasso.Builder builder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_zelda, container, false);

        if (getActivity() == null) {
            return view;
        }

        SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);
        SharedPreferences.Editor editor = settings.edit();

        // Remember choice
        editor.putBoolean("aFrag",false);
        editor.putBoolean("sFrag", false);
        editor.putBoolean("dFrag", false);
        editor.putBoolean("mFrag", false);
        editor.putBoolean("zFrag", true);
        editor.putBoolean("asFrag", false);
        editor.putBoolean("deltaFrag", false);

        editor.apply();

        CoordinatorLayout cLayout = getActivity().findViewById(R.id.coordinationLayout);

        boolean answerA = settings.getBoolean("questionA", false);
        boolean answerB = settings.getBoolean("questionB", false);
        boolean answerC = settings.getBoolean("questionC", false);
        boolean answerD = settings.getBoolean("questionD", false);

        if (Build.VERSION.SDK_INT >= 21) {
            if (answerA) {
                getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));
                StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.zelda));
            } else if (answerB) {
                getActivity().setTheme(R.style.DarkTheme2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.dzelda));
                StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.dzelda));
            } else {
                getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));
                StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.zelda));
            }
        } else {
            if (answerA) {
                getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));
            } else if (answerB) {
                getActivity().setTheme(R.style.DarkTheme2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.dzelda));
            } else {
                getActivity().setTheme(R.style.AppTheme_NoActionBar2);
                cLayout.setBackgroundColor(getResources().getColor(R.color.zelda));
            }
        }

        if (answerC) {
            zeldaList = new ArrayList<>();
            zeldaList.add(new Zelda_Item_List_ListVersion("ZELDA !!! (Ico)"));
            zeldaList.add(new Zelda_Item_List_ListVersion("Chanson Ico et Étagère"));

            mRecyclerView = view.findViewById(R.id.zeldaRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter = new Zelda_Adapter_List(zeldaList);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(aAdapter);
            aAdapter.setOnItemClickListener(this);
        } else if (answerD) {
            zeldaList2 = new ArrayList<>();
            zeldaList2.add(new Zelda_Item_List(R.drawable.zelda_image, "ZELDA !!! (Ico)"));
            zeldaList2.add(new Zelda_Item_List(R.drawable.chanson_zelda_image, "Chanson Ico et Étagère"));

            mRecyclerView = view.findViewById(R.id.zeldaRecyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            aAdapter2 = new Zelda_Adapter(zeldaList2);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(aAdapter2);
            aAdapter2.setOnItemClickListener(this);

            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        return view;
    }

    private void playSound(int redId) {
        if (jaimeLesPlayer != null) {
            jaimeLesPlayer.stop();
            jaimeLesPlayer.release();
        }
        jaimeLesPlayer = MediaPlayer.create(getContext(), redId);
        jaimeLesPlayer.start();
    }

    @Override
    public void onItemClick(View v, int position) {

        if (getActivity() != null) {
            SharedPreferences settings = getActivity().getSharedPreferences("Answers", 0);

            boolean answerC = settings.getBoolean("questionC", false);
            boolean answerD = settings.getBoolean("questionD", false);

            if (answerC) {
                Zelda_Item_List_ListVersion currentItem = zeldaList.get(position);
                switch (currentItem.getText()) {
                    case "ZELDA !!! (Ico)":
                        playSound(R.raw.zelda_sound);
                        break;
                    case "Chanson Ico et Étagère":
                        playSound(R.raw.chanson_zelda_sound);
                        break;
                }
            } else if (answerD) {
                Zelda_Item_List currentItem = zeldaList2.get(position);
                switch (currentItem.getZeldaText()) {
                    case "ZELDA !!! (Ico)":
                        playSound(R.raw.zelda_sound);
                        break;
                    case "Chanson Ico et Étagère":
                        playSound(R.raw.chanson_zelda_sound);
                        break;
                }
            }
        }
    }
}
