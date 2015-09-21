# cordova-imageBase64
A cordova plugin that provides the functionality to convert image to base64.

# Installing the plugin

```shell
cordova plugin add https://github.com/autobotsrocks/cordova-imageBase64
```

# Usage

#### Convert location image

```javascript
window.autobots.imageBase64.base64(
  '/storage/emulated/0/Pictures/hello.png',
  function(base64) {
    alert(base64);
  },
  function(error) {
    alert(error);
  }
);
```

#### Convert internet image

```javascript
window.autobots.imageBase64.base64FromUrl(
  'https://www.google.com/images/srpr/logo11w.png',
  function(base64) {
    alert(base64);
  },
  function(error) {
    alert(error);
  }
);
```


# License

MIT
