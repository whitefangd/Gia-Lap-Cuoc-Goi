package com.boluclac.android.gialapcuocgoi.components.controls.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.format.Time;
import android.view.View;
import android.widget.AnalogClock;

import com.boluclac.android.gialapcuocgoi.common.CommonUtils;
import com.boluclac.android.gialapcuocgoi.components.controls.toolbar.IUCToolBarMenuClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * BroadcastReceiver for uc clock.
 * Gom cac thanh phan:
 * P1: constant
 * P2: field static
 * P3: field member
 * P4: static function
 * P5: constructor
 * P6: event function
 * P7: public function
 * P8: protected function
 * P9: private function
 * P10: properties function
 *
 * @author Le Thanh Dung
 */
public class UCClockBroadcastReceiver extends BroadcastReceiver {
    /** P1: constant */
    /** P2: field static */
    /** P3: field member */
    /* view clock. */
    private View viewClock = null;
    /* list event time tick. */
    private List<ITimeTickListener> timeTickListeners = new ArrayList<ITimeTickListener>();
    /** P4: static function */
    /** P5: constructor */
    public UCClockBroadcastReceiver(final View value) {
        this.viewClock = value;
    }
    /** P6: event function */
    public interface ITimeTickListener {
        /**
         * Broadcast Action: The current time has changed. Sent every minute.
         */
        public void TimeTicket();
    }
    /** P7: public function */
    /**
     * This method is called when the BroadcastReceiver is receiving an Intent
     * broadcast.  During this time you can use the other methods on
     * BroadcastReceiver to view/modify the current result values.  This method
     * is always called within the main thread of its process, unless you
     * explicitly asked for it to be scheduled on a different thread using
     * {@link Context#registerReceiver(BroadcastReceiver,
     * IntentFilter, String, Handler)}. When it runs on the main
     * thread you should
     * never perform long-running operations in it (there is a timeout of
     * 10 seconds that the system allows before considering the receiver to
     * be blocked and a candidate to be killed). You cannot launch a popup dialog
     * in your implementation of onReceive().
     * <p/>
     * <p><b>If this BroadcastReceiver was launched through a &lt;receiver&gt; tag,
     * then the object is no longer alive after returning from this
     * function.</b>  This means you should not perform any operations that
     * return a result to you asynchronously -- in particular, for interacting
     * with services, you should use
     * {@link Context#startService(Intent)} instead of
     * {@link Context#bindService(Intent, ServiceConnection, int)}.  If you wish
     * to interact with a service that is already running, you can use
     * {@link #peekService}.
     * <p/>
     * <p>The Intent filters used in {@link Context#registerReceiver}
     * and in application manifests are <em>not</em> guaranteed to be exclusive. They
     * are hints to the operating system about how to find suitable recipients. It is
     * possible for senders to force delivery to specific recipients, bypassing filter
     * resolution.  For this reason, {@link #onReceive(Context, Intent) onReceive()}
     * implementations should respond only to known actions, ignoring any unexpected
     * Intents that they may receive.
     *
     * @param context The Context in which the receiver is running.
     * @param intent  The Intent being received.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_TIMEZONE_CHANGED)) {
            String tz = intent.getStringExtra("time-zone");
            CommonUtils.setTimeZone(tz);
        }
        if(timeTickListeners != null) {
            for(ITimeTickListener listeners : timeTickListeners) {
                listeners.TimeTicket();
            }
        }
    }

    /**
     * add event cho event click button menu tren IUCToolBarMenu
     * @param listener interface cho event click button menu tren IUCToolBarMenu
     */
    public void addTimeTickListener(final ITimeTickListener listener) {
        // add event.
        timeTickListeners.add(listener);
    }
    /** P8: protected function */
    /** P9: private function */
    /** P10: properties function */
}
