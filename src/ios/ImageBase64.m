#import <UIKit/UIKit.h>
#import "ImageBase64.h"

@implementation ImageBase64

-(void)base64:(CDVInvokedUrlCommand *)command {
    NSString* imagePath = [command.arguments objectAtIndex:0];

    [self.commandDelegate runInBackground:^{
        UIImage* image = [UIImage imageWithContentsOfFile:imagePath];
        NSString* imageBase64 = [UIImageJPEGRepresentation(image, 100) base64EncodedStringWithOptions:0];

        CDVPluginResult* pluginResult = nil;
        if (imageBase64 != nil) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:imageBase64];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }

        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

    }];
}
@end