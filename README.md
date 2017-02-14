# Potato Library

Easy to use Utility library for Android.

[ ![Download](https://api.bintray.com/packages/chipset95/maven/Potato-Library/images/download.svg?version=0.2.0) ](https://bintray.com/chipset95/maven/Potato-Library/0.2.0/link)
[![Travis-CI Build Status](https://travis-ci.org/kartikarora/Potato-Library.svg?branch=master)](https://travis-ci.org/kartikarora/Potato-Library)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Potato%20Library-blue.svg?style=flat)](http://android-arsenal.com/details/1/2205)

## Usage

### Gradle

To the module's `build.gradle` file, add

```groovy
dependencies {
    compile 'me.kartikarora.potato:potato:0.2.0'
}
```


Call the library using `Potato.potate(context)` and you will get following methods to use:

* Utils() - Utility methods to check Internet connection, methods on Bluetooth connection, methods for WiFi, get Battery level etc.
* Notifications() - Create a notification with or without sound
* Preferences() - Store and Retrieve data to/from `SharedPreferences` easily
* Intents() - Create Intents for email, call, sms and browser with ease


### Permissions

The following permissions need to be added to AndroidManifest.xml file of your project

#### For checking internet connection

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```

#### For placing a call
```xml
<uses-permission android:name="android.permission.CALL_PHONE" />
```

#### For sending SMS
```xml
<uses-permission android:name="android.permission.SEND_SMS" />
```

#### For bluetooth tools

```xml
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
```

#### For WiFi tools

```xml
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
```

#### For Mobile network tools

```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
```

#### For GPS tool
```xml
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```


#### For reading external storage
```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```
Please make sure to request appropriate [runtime permisions](http://developer.android.com/training/permissions/requesting.html) on Android Marshmallow (SDK 23) and above

## Further Development

Plan to add Android Wear support.

## Contribution

Feel free to fork the repo, add new methods, send in pull requests and add new issues. There's no license right now.

Thanks to
- [Saketh Kaparthi](https://github.com/sakethkaparthi) for adding Wifi tools, GPS tool and Bluetooth tools.
- [Anuraag Baishya](https://github.com/anuraag-baishya) for adding Mobile Data tools.
- [Jyotman Singh](https://github.com/jyotman94) for improving `Preferences` and `Bluetooth` methods.
