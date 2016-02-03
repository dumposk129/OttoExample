package com.f0hzz52.ottoexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Fragment1 extends Fragment {
    @Bind(R.id.tvTest)
    TextView tvTest;
    @Bind(R.id.txtMessage)
    EditText txtMessage;
    @Bind(R.id.btnSendMessage)
    Button btnSendMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnSendMessage)
    public void btnSendMessageClicked() {
        // Publish Event
        BusStation.getBus().post(new Message(txtMessage.getText().toString()));
    }

    @Override
    public void onResume() {
        super.onResume();
        // Register with bus
        BusStation.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Unregister with bus
        BusStation.getBus().unregister(this);
    }

    // Listener Event
    @Subscribe
    public void recievedMesage(Message message) {
        tvTest.setText(message.getMsg());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}