package in.bitcode.notificationdemo;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class BRRemoteInput extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = RemoteInput.getResultsFromIntent( intent );
        String message = bundle.getString("key_text");
        Toast.makeText( context, message, Toast.LENGTH_LONG).show();

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder( context, "bitcode");
        builder.setContentTitle("Message " + message + "\n has been sent!" );

        NotificationManagerCompat.from( context ).cancel(1);
        NotificationManagerCompat.from( context )
                .notify( 1, builder.build() );

    }
}
