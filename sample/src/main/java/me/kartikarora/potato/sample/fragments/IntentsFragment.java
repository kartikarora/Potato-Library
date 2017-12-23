package me.kartikarora.potato.sample.fragments;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import me.kartikarora.potato.Potato;
import me.kartikarora.potato.sample.R;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;


public class IntentsFragment extends Fragment {

    private Button mCallIntent, mSMSIntent;

    public IntentsFragment() {
        // Required empty public constructor
    }

    public static IntentsFragment newInstance() {
        IntentsFragment fragment = new IntentsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intents, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.fire_email_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                EditText toEditText = view.findViewById(R.id.to_edit_text);
                EditText subjectEditText = view.findViewById(R.id.subject_edit_text);
                EditText messageEditText = view.findViewById(R.id.message_edit_text);

                String to = toEditText.getText().toString();
                if (TextUtils.isEmpty(to)) {
                    to = toEditText.getHint().toString();
                }
                String subject = subjectEditText.getText().toString();
                if (TextUtils.isEmpty(subject)) {
                    subject = subjectEditText.getHint().toString();
                }
                String message = messageEditText.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    message = messageEditText.getHint().toString();
                }

                Potato.potate(getActivity().getApplicationContext())
                        .Intents().emailIntent(to, subject, message);
            }
        });

        view.findViewById(R.id.fire_url_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                EditText urlEditText = view.findViewById(R.id.url_edit_text);
                String url = urlEditText.getText().toString();
                if (TextUtils.isEmpty(url)) {
                    url = urlEditText.getHint().toString();
                }
                Potato.potate(getActivity().getApplicationContext())
                        .Intents().browserIntent(url);
            }
        });

        mCallIntent = view.findViewById(R.id.fire_calling_intent);
        mCallIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                EditText numberEditText = view.findViewById(R.id.number_edit_text);
                String number = numberEditText.getText().toString();
                if (TextUtils.isEmpty(number)) {
                    number = numberEditText.getHint().toString();
                }
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PERMISSION_GRANTED) {
                    Potato.potate(getActivity().getApplicationContext())
                            .Intents().callIntent(number);
                } else {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
            }
        });

        mSMSIntent = view.findViewById(R.id.fire_sms_intent);
        mSMSIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                EditText numberEditText = view.findViewById(R.id.number_sms_edit_text);
                String number = numberEditText.getText().toString();
                if (TextUtils.isEmpty(number)) {
                    number = numberEditText.getHint().toString();
                }
                EditText messageEditText = view.findViewById(R.id.sms_edit_text);
                String message = messageEditText.getText().toString();
                if (TextUtils.isEmpty(message)) {
                    message = messageEditText.getHint().toString();
                }

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) == PERMISSION_GRANTED) {
                    Potato.potate(getActivity().getApplicationContext())
                            .Intents().smsIntent(number, message);
                } else {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 2);
                }

            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1 && grantResults[0] == PERMISSION_GRANTED) {
            mCallIntent.performClick();
        } else if (requestCode == 2 && grantResults[0] == PERMISSION_GRANTED) {
            mSMSIntent.performClick();
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
