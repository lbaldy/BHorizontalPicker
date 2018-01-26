/**
 * Created by lbaldy on 20/01/2018.
 */
import React from 'react'
import {requireNativeComponent, ViewPropTypes} from 'react-native';
import PropTypes from 'prop-types';

class BHorizontalPickerComponent extends React.Component {

    render() {
        return <BHorizontalPickerView
            {...this.props}
            onSelect={(params) => {
                console.log(params.nativeEvent.selectedValue);
                console.log("on select!")
            }} />
    }

}

BHorizontalPickerComponent.propTypes = {
    titles: PropTypes.array,
    onSelect: PropTypes.func,
    defaultValue: PropTypes.number,
    startValue: PropTypes.number,
    endValue: PropTypes.number
}

var BHorizontalPickerView = requireNativeComponent('BHorizontalPickerView', null);

module.exports = BHorizontalPickerComponent;

