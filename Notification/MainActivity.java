package com.example.notificationapplication;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    // Notification ID to identify each notification
    private static final int NOTIFICATION_ID = 101;
    // Channel ID is ignored on API 24, but required by NotificationCompat.Builder
    private static final String CHANNEL_ID = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons in the layout
        Button btnBasic = findViewById(R.id.btn_send_basic);
        Button btnBigText = findViewById(R.id.btn_send_big_text);
        Button btnHeadsUp = findViewById(R.id.btn_send_heads_up);
        Button btnCancel = findViewById(R.id.btn_cancel);

        // Set Click Listeners using Lambdas
        btnBasic.setOnClickListener(v -> sendBasicNotification());
        btnBigText.setOnClickListener(v -> sendBigTextNotification());
        btnHeadsUp.setOnClickListener(v -> sendHeadsUpNotification());
        btnCancel.setOnClickListener(v -> cancelNotification());
    }

    /**
     * Builds and sends a simple notification.
     */
    @SuppressLint("MissingPermission")
    private void sendBasicNotification() {
        // Create an Intent to open MainActivity when the notification is tapped
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info) // Generic system icon
                .setContentTitle("Basic Notification")
                .setContentText("This is a simple notification demonstration.")
                .setPriority(NotificationCompat.PRIORITY_HIGH) // Shows in status bar / tray
                .setAutoCancel(true) // Dismiss when tapped
                .setContentIntent(pendingIntent); // Set the intent

        // Send the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    /**
     * Builds and sends a notification with BigTextStyle for expanded content.
     */
    @SuppressLint("MissingPermission")
    private void sendBigTextNotification() {
        String longMessage = "This is a demonstration of the BigTextStyle notification. " +
                "It allows you to show a long piece of text that can be expanded by the user " +
                "to read the full content within the notification tray. This is very useful " +
                "for emails or long messages.";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Big Text Style")
                .setContentText("Expand to read more...")
                .setStyle(new NotificationCompat.BigTextStyle().bigText(longMessage))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    /**
     * Builds and sends a Heads-Up notification using PRIORITY_MAX.
     */
    @SuppressLint("MissingPermission")
    private void sendHeadsUpNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Heads-Up Alert")
                .setContentText("This is a priority notification that pops up!")
                .setPriority(NotificationCompat.PRIORITY_MAX) // Required for heads-up
                .setDefaults(NotificationCompat.DEFAULT_ALL) // Sound, vibration, lights
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    /**
     * Cancels the active notification by its ID.
     */
    private void cancelNotification() {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.cancel(NOTIFICATION_ID);
    }
}