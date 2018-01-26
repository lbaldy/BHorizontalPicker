package pl.baldy.reactNativeHorizontalPicker;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.lukaszpicker.R;
import com.shawnlin.numberpicker.NumberPicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by lbaldy on 19/01/2018.
 */

public class BHorizontalPickerViewManager extends SimpleViewManager<BHorizontalPickerView> {

    public static final String REACT_CLASS = "BHorizontalPickerView";

    BHorizontalPickerView bHorizontalPickerView;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected BHorizontalPickerView createViewInstance(ThemedReactContext reactContext) {
        return new BHorizontalPickerView(reactContext);
    }

    public Map getExportedCustomBubblingEventTypeConstants(){
        return MapBuilder.builder()
                .put(
                        "onSelect",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onSelect")))
                .build();
    }

    @ReactProp(name = "defaultValue", defaultInt = 0)
    public void setDefaultValue(BHorizontalPickerView view, @Nullable Integer defaultValue) {
        NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.horizontal_number_picker);
        numberPicker.setValue(defaultValue);
    }

    @ReactProp(name = "startValue", defaultInt = 0)
    public void setStartValue(BHorizontalPickerView view, @Nullable Integer startValue) {
        NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.horizontal_number_picker);
        numberPicker.setMinValue(startValue);
    }


    @ReactProp(name = "endValue", defaultInt = 10)
    public void setEndValue(BHorizontalPickerView view, @Nullable Integer endValue) {
        NumberPicker numberPicker = (NumberPicker) view.findViewById(R.id.horizontal_number_picker);
        numberPicker.setMaxValue(endValue);
    }



}
