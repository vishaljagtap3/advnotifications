package in.bitcode.notificationdemo;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnBigTextStyle, mBtnSimpleNotification, mBtnBigPicStyle, mBtnInboxStyle, mBtnActionButton, mBtnReply;
    private Button mBtnSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnSimpleNotification = findViewById(R.id.btnSimple);
        mBtnBigTextStyle = findViewById(R.id.btnBigTextStyle);
        mBtnBigPicStyle = findViewById(R.id.btnBigPicStyle);
        mBtnInboxStyle = findViewById(R.id.btnInboxStyle);
        mBtnActionButton = findViewById(R.id.btnAddAction);
        mBtnReply = findViewById(R.id.btnReply);
        mBtnSnackBar = findViewById(R.id.btnSnackBar);

        mBtnSnackBar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Snackbar snackbar = Snackbar.make(
                                mBtnActionButton,
                                "Message has been Sent!",
                                Snackbar.LENGTH_LONG
                        );

                        snackbar.setAction(
                                "Refresh",
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(MainActivity.this, "this is some action!", Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                        snackbar.setActionTextColor(Color.WHITE);
                        snackbar.show();


                    }
                }
        );


        mBtnSimpleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                MainActivity.this,
                                "bitcode"
                        );


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon =
                        BitmapFactory.decodeResource(
                                getResources(),
                                R.drawable.in_flag
                        );

                builder.setLargeIcon(largeIcon);
                builder.setCategory(NotificationCompat.CATEGORY_EVENT);
                builder.setLights(Color.RED, 400, 300);

                builder.setVibrate(
                        new long[]{500, 200, 500, 300, 500, 400}
                );
                //builder.setOngoing( true );

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                new Intent(MainActivity.this, ActDetails.class),
                                0);
                builder.setContentIntent(contentIntent);

                builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

                Notification notification = builder.build();

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(1, notification);

                //notificationManagerCompat.cancelAll();

               /* ((NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE))
                        .notify( 1, notification );*/
            }
        });


        mBtnBigTextStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                MainActivity.this,
                                "bitcode"
                        );


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.in_flag);
                builder.setLargeIcon(largeIcon);

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                new Intent(MainActivity.this, ActDetails.class),
                                0);
                builder.setContentIntent(contentIntent);

                //big text style
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.bigText("This is big text! This is big text! This is big text! This is big text! This is big text! This is big text! This is big text! This is big text! This is big text!");
                bigTextStyle.setBigContentTitle("Big Content Title");
                bigTextStyle.setSummaryText("this is summary text");

                builder.setStyle(bigTextStyle);


                Notification notification = builder.build();

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(2, notification);

            }
        });


        //big pic style
        mBtnBigPicStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                MainActivity.this,
                                "bitcode"
                        );


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.in_flag);
                builder.setLargeIcon(largeIcon);

                Intent intent = new Intent(MainActivity.this, ActDetails.class);
                intent.putExtra("data", "some data");

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                intent,
                                0);
                builder.setContentIntent(contentIntent);

                //big pic style
                NotificationCompat.BigPictureStyle bigPictureStyle =
                        new NotificationCompat.BigPictureStyle();
                bigPictureStyle
                        .setBigContentTitle("This is Big...!")
                        .bigPicture(largeIcon);
                //.bigLargeIcon( largeIcon );

                builder.setStyle(bigPictureStyle);

                Notification notification = builder.build();

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(1, notification);
                //((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify( 1, notification );
            }
        });

        //inbox style
        mBtnInboxStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, "bitcode");


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.in_flag);
                builder.setLargeIcon(largeIcon);

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                new Intent(MainActivity.this, ActDetails.class),
                                0);
                builder.setContentIntent(contentIntent);

                //inbox style

                NotificationCompat.InboxStyle inboxStyle =
                        new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("You got calls from...");
                inboxStyle.addLine("Google for CEO")
                        .addLine("Facebook as CTO")
                        .addLine("BitCode as CEO")
                        .addLine("Infosys as Mentor");
                inboxStyle.setSummaryText("Are you serious?");
                builder.setStyle(inboxStyle);

                Notification notification = builder.build();

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(1, notification);
                //((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify( 1, notification );
            }
        });


        //action button
        mBtnActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, "bitcode");


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.in_flag);
                builder.setLargeIcon(largeIcon);

                Intent intent = new Intent(MainActivity.this, ActDetails.class);
                intent.putExtra("notification_id", 1);

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                intent,
                                0);
                builder.setContentIntent(contentIntent);

                //add action button
                Intent actionIntent = new Intent(MainActivity.this, ActDetails.class);
                builder.addAction(
                        R.mipmap.ic_launcher,
                        "Some Action",
                        PendingIntent.getActivity(MainActivity.this, 0, actionIntent, 0)
                );

                builder.addAction(
                        R.mipmap.ic_launcher,
                        "Action",
                        PendingIntent.getActivity(MainActivity.this, 0, actionIntent, 0)
                );

                builder.addAction(
                        R.mipmap.ic_launcher,
                        "Action1",
                        PendingIntent.getActivity(MainActivity.this, 0, actionIntent, 0)
                );

                Notification notification = builder.build();
                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(1, notification);
                //((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify( 1, notification );
            }
        });

        //button reply
        mBtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, "bitcode");


                builder.setAutoCancel(true);
                builder.setContentTitle("BitCode has got something for you!");
                builder.setContentText("You have been selected by Google as CEO! We are kidding!");
                builder.setColor(Color.RED);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.in_flag);
                builder.setLargeIcon(largeIcon);

                Intent intent = new Intent(MainActivity.this, ActDetails.class);
                intent.putExtra("notification_id", 1);

                PendingIntent contentIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                0,
                                intent,
                                0);
                builder.setContentIntent(contentIntent);

                //reply

                String key = "key_text";
                RemoteInput.Builder builderRInput =
                        new RemoteInput.Builder(key);
                builderRInput.setLabel("Write something here...");
                RemoteInput remoteInput = builderRInput.build();


                PendingIntent replyPendingIntent =
                        PendingIntent.getActivity(
                                MainActivity.this,
                                101,
                                new Intent(MainActivity.this, ActDetails.class),
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );


                NotificationCompat.Action.Builder builderAction =
                        new NotificationCompat.Action.Builder(
                                R.mipmap.ic_launcher,
                                "reply",
                                replyPendingIntent
                        );
                builderAction.addRemoteInput(remoteInput);
                NotificationCompat.Action action = builderAction.build();

                builder.addAction(action);


                Notification notification = builder.build();
                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(1, notification);
                //((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify( 1, notification );
            }
        });


    }

    @SuppressLint("NewApi")
    private NotificationChannel getNotificationChannel() {

        @SuppressLint({"NewApi", "LocalSuppress"})

        NotificationChannel notificationChannel = new NotificationChannel(
                "bitcode",
                "bitcode notifications",
                NotificationManager.IMPORTANCE_DEFAULT
        );
        notificationChannel.setDescription("Some description");


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);

        return notificationChannel;
    }
}
