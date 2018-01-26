//
//  BHorizontalPickerManager.m
//  lukaszPicker
//
//  Created by Baldy, Lukasz (Consultant) on 24/01/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTViewManager.h>
#import "BHorizontalPickerView.h"

@interface BHorizontalPickerViewManager : RCTViewManager<BHorizontalPickerOnSelectDelegate>
@end

@implementation BHorizontalPickerViewManager

RCT_EXPORT_MODULE(BHorizontalPickerView)
RCT_EXPORT_VIEW_PROPERTY(defaultValue, NSUInteger)
RCT_EXPORT_VIEW_PROPERTY(startValue, NSUInteger)
RCT_EXPORT_VIEW_PROPERTY(endValue, NSUInteger)
RCT_EXPORT_VIEW_PROPERTY(onSelect, RCTBubblingEventBlock)

- (UIView *)view
{
  BHorizontalPickerView *bHorizontalPickerView;
  bHorizontalPickerView = [[BHorizontalPickerView alloc] init];
  bHorizontalPickerView.delegate = self;
  return bHorizontalPickerView;
}

#pragma mark BHorizontalPickerOnSelectDelegate

- (void)onSelect:(BHorizontalPickerView *)view {
  NSString *inStr = [NSString stringWithFormat:@"%ld", (long)view.selected ];
  view.onSelect(@{
      @"selectedValue": inStr
  });
}

@end
