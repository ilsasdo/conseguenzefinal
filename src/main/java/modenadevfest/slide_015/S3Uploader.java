package modenadevfest.slide_015;

import java.io.File;

public class S3Uploader implements FileUploader {
    public S3Uploader(String s3Bucket) {

    }

    @Override
    public boolean upload(File file, String dest) {
        return false;
    }
}
