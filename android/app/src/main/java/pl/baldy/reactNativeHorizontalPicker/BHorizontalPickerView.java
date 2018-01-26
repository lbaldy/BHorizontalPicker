package pl.baldy.reactNativeHorizontalPicker;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.lukaszpicker.R;
import com.shawnlin.numberpicker.NumberPicker;

import java.util.Locale;

import javax.annotation.Nullable;

import static android.content.ContentValues.TAG;

/**
 * Created by lbaldy on 20/01/2018.
 */

public class BHorizontalPickerView extends LinearLayout {

    private Context context;

    public BHorizontalPickerView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public void init() {
        Log.d("BHorizontalPicker", "Inflating the layout");
        inflate(context, R.layout.content_main, this);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.horizontal_number_picker);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
                WritableMap event = Arguments.createMap();
                event.putString("selectedValue", Integer.toString(newVal));
                ReactContext reactContext = (ReactContext)getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        getId(),
                        "onSelect",
                        event);
            }
        });
    }

}
