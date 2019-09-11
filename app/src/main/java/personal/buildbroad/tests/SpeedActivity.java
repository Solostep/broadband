package personal.buildbroad.tests;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import personal.buildbroad.R;

/**
 * Created by liyn18 on 18-4-26.
 */

public class SpeedActivity extends Activity {
    private TextView fileLength;
    private TextView speed;
    private TextView hasDown;
    private TextView percent;
    private Button button;

    private ImageView imageView = null;
    byte[] imageData = null;
    NetWorkSpeedInfo netWorkSpeedInfo = null;
    String url = "http://a.hiphotos.baidu.com/image/h%3D300/sign=ca7649497e8b4710d12ffbccf3cfc3b2/b64543a98226cffc6ec00edab5014a90f703eaf4.jpg";
    private final int UPDATE_SPEED = 1;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tests );

        hasDown = ( TextView ) findViewById( R.id.hasDown );
        fileLength = ( TextView ) findViewById( R.id.fileLength );
        speed = ( TextView ) findViewById( R.id.speed );
        percent = ( TextView ) findViewById( R.id.percent );
        imageView = ( ImageView ) findViewById( R.id.ImageView01 );
        button = ( Button ) findViewById( R.id.Button01 );
        netWorkSpeedInfo = new NetWorkSpeedInfo();
    }

    public void testSpeed(View view){
        button.setEnabled(false);
        //down load the file thread
        new Thread()
        {
            @Override
            public void run()
            {
                imageData = ReadFile.getFileFromUrl( url,
                        netWorkSpeedInfo );
                //stop();
                return;
            }
        }.start();

        //get the speed , down load bytes ,update the view thread
        new Thread()
        {
            @Override
            public void run()
            {

                while ( netWorkSpeedInfo.hadFinishedBytes < netWorkSpeedInfo.totalBytes )
                {
                    netWorkSpeedInfo.downloadPercent = ( int ) (( ( double ) netWorkSpeedInfo.hadFinishedBytes /
                            ( double ) netWorkSpeedInfo.totalBytes ) * 100);
                    try
                    {
                        sleep( 1000 );
                    }
                    catch ( InterruptedException e )
                    {
                        e.printStackTrace();
                    }

                    Log.e( "update", "update,send the message to update" );
                    //update view
                    handler.sendEmptyMessage( UPDATE_SPEED );
                }

                //finished
                if( netWorkSpeedInfo.hadFinishedBytes == netWorkSpeedInfo.totalBytes )
                {

                    netWorkSpeedInfo.downloadPercent = ( int ) (( ( double ) netWorkSpeedInfo.hadFinishedBytes /
                            ( double ) netWorkSpeedInfo.totalBytes ) * 100);
                    handler.sendEmptyMessage( UPDATE_SPEED );
                    Log.e( "update",
                            ",send the message to update and stop" );
                    // stop();
                    return;
                }
                handler.sendEmptyMessage(0 );
            }
        }.start();

    }


    /**
     * Handler for post message into OS
     */
    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage( Message msg )
        {
            button.setEnabled(true);
            int value = msg.what;
            switch ( value )
            {
                case UPDATE_SPEED:
                    updateView();
                    break;
                case 0:
                    break;
            }
        }
    };

    /**
     * Update the view method
     */
    private void updateView()
    {
        /*speed.setText(netWorkSpeedInfo.speed/1024 + "bytes/s" );
        hasDown.setText( netWorkSpeedInfo.hadFinishedBytes/1024 + "bytes" );
        fileLength.setText(netWorkSpeedInfo.totalBytes/1024 + "" );*/

        Log.d("tag","---------"+String.valueOf(netWorkSpeedInfo.totalBytes));
        DecimalFormat df=new DecimalFormat("0.00");
        if (netWorkSpeedInfo.speed<1024){//bytes
            speed.setText(netWorkSpeedInfo.speed/1024 + "bytes/s" );
        }else if (netWorkSpeedInfo.speed<1024*1024){//KB
            speed.setText(df.format(netWorkSpeedInfo.speed/(float)1024) + "kb/s" );
        }else{//M
            speed.setText(df.format(netWorkSpeedInfo.speed/(float)(1024*1024)) + "M/s" );
        }

        if (netWorkSpeedInfo.hadFinishedBytes<1024){//bytes
            hasDown.setText(netWorkSpeedInfo.hadFinishedBytes/1024 + "bytes" );
        }else if (netWorkSpeedInfo.hadFinishedBytes<1024*1024){//KB
            hasDown.setText(df.format(netWorkSpeedInfo.hadFinishedBytes/(float)1024) + "kb" );
        }else if(netWorkSpeedInfo.hadFinishedBytes<1024*1024*1024){//M
            hasDown.setText(df.format(netWorkSpeedInfo.hadFinishedBytes/(float)(1024*1024)) + "M" );
        }else{//G
            hasDown.setText(df.format(netWorkSpeedInfo.hadFinishedBytes/(float)(1024*1024*1024)) + "G" );
        }

        if (netWorkSpeedInfo.totalBytes<1024){//bytes
            fileLength.setText(netWorkSpeedInfo.totalBytes/1024 + "bytes/s" );
        }else if (netWorkSpeedInfo.totalBytes<1024*1024){//kb
            fileLength.setText(df.format(netWorkSpeedInfo.totalBytes/(float)1024) + "kb" );
        }else if (netWorkSpeedInfo.totalBytes<1024*1024*1024){//M
            fileLength.setText(df.format(netWorkSpeedInfo.totalBytes/(float)(1024*1024)) + "M" );
        }else{//G
            fileLength.setText(df.format(netWorkSpeedInfo.totalBytes/(float)(1024*1024*1024)) + "M" );
        }

        percent.setText( netWorkSpeedInfo.downloadPercent+"%" );

        if( imageData != null )
        {
            Bitmap b = BitmapFactory.decodeByteArray( imageData, 0,
                    imageData.length );
            imageView.setImageBitmap( b );
        }
    }
}
