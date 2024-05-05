
package com.example.ezgodotaddon.host;


import android.widget.Toast;

import androidx.annotation.NonNull;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.UsedByGodot;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

public class HelloWorld extends GodotPlugin{


    // Declare a MethodChannel instance
    private MethodChannel methodChannel;

    // Declare an EventChannel instance
    private EventChannel eventChannel;


    // Method to invoke "gamedata" method

    private static final String EVENT_CHANNEL = "kaiyo.ezgodot/vgeneric";


    private FlutterEngine flutterEngine; // Define the FlutterEngine



    /**
     * Base constructor passing a {@link Godot} instance through which the plugin can access Godot's
     * APIs and lifecycle events.
     *
     * @param godot
     */
    public HelloWorld(Godot godot) {
        super(godot);
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "HelloWorld";
    }
    @UsedByGodot
    public void Hello(){
        getGodot().getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getGodot().getActivity(), "betch", Toast.LENGTH_LONG).show();
            }
        });
    }
    @UsedByGodot
    public void  thestrang(String text) {
        // THE EVENT CHANNEL SHOULD BE HERE, IT SHOULD SEND THE "text" variable
        // Initialize the EventChannel if it's not already initialized
        if (eventChannel == null) {
            eventChannel = new EventChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), EVENT_CHANNEL);
        }
        // Invoke the "gamedata" method
        // Set up a stream handler for receiving events from Flutter
        eventChannel.setStreamHandler(new EventChannel.StreamHandler() {
            @Override
            public void onListen(Object arguments, EventChannel.EventSink events) {
                // Here you can start sending events to Flutter
                // For example, you can send the "text" variable as an event
                events.success(text);
            }

            @Override
            public void onCancel(Object arguments) {
                // Clean up when event channel is canceled (e.g., if Flutter closes the channel)
            }
        });

    }
}