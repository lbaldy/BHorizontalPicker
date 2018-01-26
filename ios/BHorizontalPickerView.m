//
//  BHorizontalPickerView.m
//  lukaszPicker
//
//  Created by Baldy, Lukasz (Consultant) on 24/01/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BHorizontalPickerView.h"
#import "AKPickerView.h"
#import <React/UIView+React.h>

@implementation BHorizontalPickerView

- (NSString *)pickerView:(AKPickerView *)pickerView titleForItem:(NSInteger)item {
  return self.titles[item];
}

- (instancetype)initWithFrame:(CGRect)frame {
  self = [super initWithFrame:frame];
  return self;
}

- (void)reactSetFrame:(CGRect)frame
{
  CGFloat height = frame.size.height;
  CGFloat width = frame.size.width;
  
  self.pickerView = [[AKPickerView alloc] initWithFrame:CGRectMake(0, 0, width, height)];
  self.pickerView.delegate = self;
  self.pickerView.dataSource = self;
  self.pickerView.fisheyeFactor = 0.0;
  self.pickerView.pickerViewStyle = AKPickerViewStyleFlat;
  self.pickerView.interitemSpacing = 20.0;
  
  NSMutableArray *items = [NSMutableArray array];
  
  for(NSInteger i = self.startValue; i <= self.endValue;i++){
    NSString *inStr = [NSString stringWithFormat: @"%ld", (long)i];
    [items addObject:inStr];
  }
  
  self.titles = items;
  
  [self addSubview:self.pickerView];
  [self.pickerView reloadData];
  
  [self.pickerView selectItem:(self.defaultValue-1) animated:false];
  
  [super reactSetFrame: frame];
}

- (void)pickerView:(AKPickerView *)pickerView didSelectItem:(NSInteger)item{
  self.selected = item;
  [self.delegate onSelect:self];
}

- (NSUInteger)numberOfItemsInPickerView:(AKPickerView *)pickerView {
  return [self.titles count];
}

@end



