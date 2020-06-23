package com.uatech.MyUnix;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.util.Collections;

public class demo extends AppCompatActivity {

    FetchDocs fetchDocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        requestSignIn();
    }

    private void requestSignIn() {

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestScopes(new Scope(DriveScopes.DRIVE_FILE))
                .build();

        GoogleSignInClient  client = GoogleSignIn.getClient(this,signInOptions);

        startActivityForResult(client.getSignInIntent(), 400);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case 400:
                if (resultCode == RESULT_OK)
                {
                    handleSignInIntent(data);
                }
                break;
        }
    }

    private void handleSignInIntent(Intent data) {

        GoogleSignIn.getSignedInAccountFromIntent(data)
                .addOnSuccessListener(new OnSuccessListener<GoogleSignInAccount>() {
                    @Override
                    public void onSuccess(GoogleSignInAccount googleSignInAccount) {

                        GoogleAccountCredential credential = GoogleAccountCredential
                                .usingOAuth2(demo.this, Collections.singleton(DriveScopes.DRIVE_FILE));
                        credential.setSelectedAccount(googleSignInAccount.getAccount());

                        Drive googleDriveService = new Drive.Builder(
                                AndroidHttp.newCompatibleTransport(),
                                new GsonFactory(),
                                credential).setApplicationName("ABC")
                                .build();
                        fetchDocs = new FetchDocs(googleDriveService);
                        fetchDocs.createFilePDF();

                        /*File fileMetadata = new File();
                        fileMetadata.setName("Invoices");
                        fileMetadata.setMimeType("application/vnd.google-apps.folder");


                        try {
                            File file = googleDriveService.files().create(fileMetadata)
                                    .setFields("id")
                                    .execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } */
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.print("hii");
                    }
                });
    }
}
