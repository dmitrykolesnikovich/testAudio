package featurea.mario.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import featurea.android.util.ApkFileUtil;
import featurea.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String path = Environment.getExternalStorageDirectory().getPath();
        new File(path + "/temp").mkdirs();
        try {
            JarFile jarFile = ApkFileUtil.getInstance().getFile(getApplication());
            InputStream inputStream = jarFile.getInputStream(jarFile.getEntry("Castle.mp3"));
            FileUtil.copyPaste(inputStream, new File(path + "/temp/Castle.mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
