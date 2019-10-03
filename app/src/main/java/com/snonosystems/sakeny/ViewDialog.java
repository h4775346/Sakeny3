package com.snonosystems.sakeny;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ViewDialog {



    public void showDialog(Activity activity,String message){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.wrong_input_message);

        Button finish =  dialog.findViewById(R.id.btn_finish);
        TextView txt_wrong = dialog.findViewById(R.id.txt_wrong_input);

        txt_wrong.setText(message);





        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
