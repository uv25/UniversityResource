package com.uatech.MyUnix;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FetchDocs {

    private final Executor mExecutor = Executors.newSingleThreadExecutor();
    private Drive mDriveService;

    public FetchDocs(Drive mDriveService)
    {
        this.mDriveService = mDriveService;
    }

    public Task<String> createFilePDF()
    {
        return Tasks.call(mExecutor, () -> {
            File fileMetadata = new File();
            fileMetadata.setName("Invoices");
            fileMetadata.setMimeType("application/vnd.google-apps.folder");

            try {
                File file = mDriveService.files().create(fileMetadata)
                        .setFields("id")
                        .execute();
                System.out.println("Folder ID: " + file.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return fileMetadata.getId();
        });
    }
}
