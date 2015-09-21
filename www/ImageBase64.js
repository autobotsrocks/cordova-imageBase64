var ImageBase64 = function() {
};

ImageBase64.prototype.base64 = function(filePath, success, fail) {
  return cordova.exec(success, fail, 'ImageBase64', 'base64', [filePath]);
};

module.exports = new ImageBase64();