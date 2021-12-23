package com.guiathayde.learnenglish.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.guiathayde.learnenglish.R;

public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonDog, buttonCat, buttonLion, buttonMonkey, buttonSheep, buttonCow;
    private MediaPlayer mediaPlayer;

    public AnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        buttonDog = view.findViewById(R.id.buttonDog);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonLion = view.findViewById(R.id.buttonLion);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonCow = view.findViewById(R.id.buttonCow);

        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonLion.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);
        buttonCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonDog:
                playSound(R.raw.dog);
                break;
            case R.id.buttonCat:
                playSound(R.raw.cat);
                break;
            case R.id.buttonLion:
                playSound(R.raw.lion);
                break;
            case R.id.buttonMonkey:
                playSound(R.raw.monkey);
                break;
            case R.id.buttonSheep:
                playSound(R.raw.sheep);
                break;
            case R.id.buttonCow:
                playSound(R.raw.cow);
                break;
            default:
                break;
        }
    }

    private void playSound(int soundId) {
        mediaPlayer = MediaPlayer.create(getActivity(), soundId);

        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}