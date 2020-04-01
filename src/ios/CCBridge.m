/********* CCBridge.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface CCBridge : CDVPlugin {
  // Member variables go here.
}

- (void)exit:(CDVInvokedUrlCommand *)command;
- (void)getAppVersion:(CDVInvokedUrlCommand*)command;
@end

@implementation CCBridge

- (void)exit:(CDVInvokedUrlCommand *)command
{
    assert(0);
}

- (void)getAppVersion:(CDVInvokedUrlCommand *)command
{
    NSString *versionString = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"];
    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:versionString];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
