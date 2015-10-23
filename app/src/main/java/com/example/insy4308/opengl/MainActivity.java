package com.example.insy4308.opengl;

import android.app.Activity;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends Activity implements  GLSurfaceView.Renderer {


    float animation = 0.0f;
    Sprite sprite = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        GLSurfaceView glView = new GLSurfaceView(this);
        glView.setEGLContextClientVersion(2);
        glView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        glView.setRenderer(this);
        setContentView(glView);


        sprite = new Sprite();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        GLES20.glClearColor(0.0f, 0.3921568627450980f, 0.6941176470588235f, 0.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        int dimension = Math.min(width, height) * 2;
        GLES20.glViewport((width - dimension) / 2, (height - dimension) / 2, dimension, dimension);
    }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        animation += 0.01f;

        sprite.setRotation(animation*100);
        sprite.setHeight(0.2f);
        sprite.setWidth(0.2f);

        sprite.draw();
    }



}
