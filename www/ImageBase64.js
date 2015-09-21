var ImageBase64 = function() {
};

ImageBase64.prototype.base64FromUrl = function(url, success, fail) {
  var fileTransfer = new FileTransfer();

  fileTransfer.download(
    url,
    cordova.file.cacheDirectory + '/imageBase64Cache.jpg',
    function(entry) {
      var imagePath = entry.toURL().replace(/^file:\/\//i, '');
      return cordova.exec(success, fail, 'ImageBase64', 'base64', [imagePath]);
    },
    fail
  );
};

ImageBase64.prototype.base64 = function(filePath, success, fail) {
  return cordova.exec(success, fail, 'ImageBase64', 'base64', [filePath]);
};

module.exports = new ImageBase64();