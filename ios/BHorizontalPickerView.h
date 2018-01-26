//
//  BHorizontalPickerView.h
//  lukaszPicker
//
//  Created by Baldy, Lukasz (Consultant) on 24/01/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//
#import <UIKit/UIKit.h>
#import "AKPickerView.h"
#import <React/RCTComponent.h>

@protocol BHorizontalPickerOnSelectDelegate <NSObject>
@required
-(void) onSelect:(UIView *)pickerView;
@end

@interface BHorizontalPickerView : UIView <AKPickerViewDataSource, AKPickerViewDelegate> {
  __weak id<BHorizontalPickerOnSelectDelegate> _delegate; 
}
  @property (nonatomic, strong) AKPickerView *pickerView;
  @property (nonatomic, strong) NSArray *titles;

  @property (nonatomic, assign) NSInteger *startValue;
  @property (nonatomic, assign) NSInteger *endValue;

  @property (nonatomic, assign) NSInteger selected;
  @property (nonatomic, assign) NSUInteger defaultValue;
  @property (weak) id<BHorizontalPickerOnSelectDelegate> delegate;
  @property (nonatomic, copy) RCTBubblingEventBlock onSelect;

@end
