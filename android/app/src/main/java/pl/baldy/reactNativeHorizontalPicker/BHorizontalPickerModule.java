package pl.baldy.reactNativeHorizontalPicker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/**
 * Created by lbaldy on 20/01/2018.
 */

public class BHorizontalPickerModule extends ReactContextBaseJavaModule {

    public BHorizontalPickerModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BHorizontalPickerView";
    }
}
