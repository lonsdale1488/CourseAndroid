package course.pllug.om.murashev;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import course.pllug.om.murashev.R;


public class Profile extends Fragment {
    final String LOG_TAG = "ProfileLogs";
   private View root;
    Paint paint;
    Bitmap bitmap;
    Bitmap scaledBitmap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.profile, container,false);
        Shader shader = createShader();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(shader);

        return root;
    }

    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(300, 400, 100, paint);
    }
    private Shader createShader() {
        bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.drawer_shadow);
        BitmapShader shader = new BitmapShader(bitmap,
                Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        return shader;
    }
}

