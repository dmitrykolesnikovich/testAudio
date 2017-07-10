package featurea.mario.android;

import android.app.Activity;
import android.os.Bundle;
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
        try {
            JarFile jarFile = ApkFileUtil.getInstance().getFile(getApplication());
            InputStream inputStream = jarFile.getInputStream(jarFile.getEntry("Castle.mp3"));
            FileUtil.copyPaste(inputStream, new File("temp/Castle.mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
