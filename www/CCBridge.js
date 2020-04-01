var exec = require('cordova/exec');

exports.exit = function (success, error) {
  exec(success, error, 'CCBridge', 'exit', []);
};
exports.getAppVersion = function (success, error) {
  exec(success, error, 'CCBridge', 'getAppVersion', []);
};