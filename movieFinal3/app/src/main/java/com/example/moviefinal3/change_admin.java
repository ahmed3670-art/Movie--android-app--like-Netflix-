package com.example.moviefinal3;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class change_admin extends AppCompatActivity {

    Button add,remove,uploadimage,Choose,back;
    TextView title ,description,names,dirctor;
    movie mov ;
    DatabaseReference reff ;
    static  int cout=0 ;
     private StorageTask uploadTask ;
    public  Uri imguri ;
    StorageReference mStorageRef ;
    ImageView img ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_admin);
        mStorageRef= FirebaseStorage.getInstance().getReference("Images");

        //fif.key
        back=findViewById(R.id.back1);
        title = findViewById(R.id.title_movie);
        description = findViewById(R.id.description);
        names = findViewById(R.id.names);
        dirctor = findViewById(R.id.dirctor);
        add = findViewById(R.id.change);
        remove = findViewById(R.id.remove);
        uploadimage = findViewById(R.id.upload);
        Choose=findViewById(R.id.choose);

         //dfi va.





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                cout++;
                String name = names.getText().toString();
                String tit = title.getText().toString();
                String dir = dirctor.getText().toString();
                String decrip = description.getText().toString();
                mov = new movie(tit,decrip, name, dir);
                reff = FirebaseDatabase.getInstance().getReference("movies").child("movieAdmin");
                reff.child("movie"+ cout).setValue(mov);
                Toast.makeText(change_admin.this , "data is inserted" ,Toast.LENGTH_LONG).show();

            }
        });
       remove.setOnClickListener(new View.OnClickListener() {
            String tit = title.getText().toString();
            @Override
            public void onClick(View v2) {
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference("movies").child("movieAdmin").child(tit);
                dR.removeValue();

            }
        });
        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                if (uploadTask !=null && uploadTask.isInProgress()){
                    Toast.makeText(change_admin.this , "UPLOAD IN PROGRESS",Toast.LENGTH_LONG).show();
                }else {
                    fileuploader();
                }

            }
        });

   Choose.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           filechooser();
       }
   });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(change_admin.this , "Back>>>" ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(change_admin.this , Admin.class);
                startActivity(intent);
                finish();
            }
        });

    }





    private void filechooser(){
        Intent intent =new Intent();
        intent.setType("image/'");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent , 1);

    }
    private String getextension(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void fileuploader(){
        StorageReference Ref = mStorageRef.child(System.currentTimeMillis()+"."+ getextension(imguri));
        uploadTask= Ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    public void onSuccess (UploadTask.TaskSnapshot taskSnapshot){
                        //Uri download = taskSnapshot.getDownloadUrl();
                        Toast.makeText(change_admin.this , "image Uploaded successfully" , Toast.LENGTH_LONG).show();
                    }
                })
    .addOnFailureListener ( new OnFailureListener(){
        public void onFailure ( Exception exception){

        }
    });
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!= null && data.getData()!=null){
            imguri=data.getData();
            img.setImageURI(imguri);
        }
    }


}



