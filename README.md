# Potato Library

Easy to use Utility library for Android.

![](https://img.shields.io/github/release/chipset95/Potato-Library.svg?label=JitPack)

## Usage
* Gradle

Add the following to your `build.gradle` file
```
repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}

dependencies {
	        compile 'com.github.chipset95:Potato-Library:0.1.1'
	}
```

* Maven
```
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.chipset95</groupId>
    <artifactId>Potato-Library</artifactId>
    <version>0.1.1</version>
</dependency>
```

Call the library using `Potato.potate()` and you will get following methods to use:

* Utils() - Utility methods to check Internet connection, Bluetooth connection, get Battery level etc.
* Notifications() - Create a notification with or without sound
* Preferences() - Store and Retrieve data to/from `SharedPreferences` easily
* Intents() - Create Intents for email, call and browser with ease


### Permissions

For checking internet connection, the following permissions need to be added to AndroidManifest.xml file of your project

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```
## Further Development

Plan to add Android Wear support.

## Contribution

Feel free to fork the repo, add new methods, send in pull requests and add new issues. There's no license right now.