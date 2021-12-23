package com.guiathayde.learnenglish.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.guiathayde.learnenglish.R;

public class NumbersFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        buttonOne = view.findViewById(R.id.buttonOne);
        buttonTwo = view.findViewById(R.id.buttonTwo);
        buttonThree = view.findViewById(R.id.buttonThree);
        buttonFour = view.findViewById(R.id.buttonFour);
        buttonFive = view.findViewById(R.id.buttonFive);
        buttonSix = view.findViewById(R.id.buttonSix);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonOne:
                playSound(R.raw.one);
                break;
            case R.id.buttonTwo:
                playSound(R.raw.two);
                break;
            case R.id.buttonThree:
                playSound(R.raw.three);
                break;
            case R.id.buttonFour:
                playSound(R.raw.four);
                break;
            case R.id.buttonFive:
                playSound(R.raw.five);
                break;
            case R.id.buttonSix:
                playSound(R.raw.six);
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