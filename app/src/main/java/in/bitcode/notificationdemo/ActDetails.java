package in.bitcode.notificationdemo;

import android.app.RemoteInput;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ActDetails extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if( getIntent().hasExtra("notification_id") ) {
            Toast.makeText( this, "Cancelling Notification", Toast.LENGTH_LONG).show();

            NotificationManagerCompat.from( this )
                    .cancel( getIntent().getIntExtra("notification_id", -1 ));
        }*/



        Bundle bundle = RemoteInput.getResultsFromIntent(getIntent());
        String message = bundle.getString("key_text");

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        /*NotificationManagerCompat.from(this)
                .cancel(1);
                */



        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "bitcode");

        builder.setContentTitle("Message " + message + "\n has been sent!");
        builder.setContentText("Confirmation");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManagerCompat.from(this)
                .notify(1, builder.build());


        new AsyncTask<Object, Object, Object>() {
            @Override
            protected Object doInBackground(Object... objects) {
                try {
                    Thread.sleep( 10 * 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                NotificationManagerCompat.from(ActDetails.this).cancel(1);
            }
        }
        .execute((Object) null);


    }
}
