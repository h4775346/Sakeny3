package com.snonosystems.sakeny;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;

import com.theartofdev.edmodo.cropper.CropImage;

import de.hdodenhof.circleimageview.CircleImageView;


public class StartActivity extends AppCompatActivity {

    CircleImageView image_prof ;
    Button btn_finish_reg;
    FirebaseAuth mAuth;
    public static final int IMG_CODE=0;
    Uri image_uri ;
    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn_finish_reg = findViewById(R.id.btn_finish_login);
        mAuth = FirebaseAuth.getInstance();
        image_prof=findViewById(R.id.image_profile_start);
        ((View) image_prof).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,IMG_CODE);



            }
        });


        btn_finish_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mAuth.signOut();
              startActivity(new Intent(getApplicationContext(),LoginActivity.class));
              finish();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode ==IMG_CODE&& resultCode==RESULT_OK&& data.getData()!=null){
            image_uri = data.getData();

            CropImage.activity(image_uri)
                    .setAspectRatio(1, 1)
                    .setMinCropWindowSize(500, 500)
                    .start(this);






        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                image_prof.setImageURI(resultUri);
                Toast.makeText(this, resultUri.toString(), Toast.LENGTH_SHORT).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }



    }
}
