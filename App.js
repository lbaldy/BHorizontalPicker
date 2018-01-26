/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    Dimensions
} from 'react-native';
import BHorizontalPickerComponent from './BHorizontalPickerComponent';

const fullWidth = Dimensions.get('window').width;

export default class App extends Component<{}> {

    render() {

        return (
            <View style={{paddingTop: 80}}>
                <Text>Yo!</Text>
                    <BHorizontalPickerComponent style={{height: 100, width: fullWidth}} defaultValue={5} startValue={1} endValue={20}/>
            </View>
        );
    }
}
