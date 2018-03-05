---
layout: page
title: Usage
---

Using DriveChain
================

DriveChain has several common components designed to work out of the
box, leveraging its approach to easy configuration and installation.

Core Components
---------------

DriveChain's core components are designed to make building Android libraries
easier. Some of the libraries are required to work, but others may only
be pulled in by libraries when needed.

Core components include:

 - [Activity Container]
 - [Android Services]
 - [Android Services for AndroidInjectors]
 - [App Config]
 - [Lifecycle]
 - [Logger]
 
[Activity Container]:/activity-container
[Android Services]:/android-services
[Android Services for AndroidInjectors]:/android-services-androidinjectors
[App Config]:/app-config
[Lifecycle]:/lifecycle
[Logger]:/logger

Bridges
-------

DriveChain bridges are designed to adapt existing libraries into modules
that can be included with the ease of any DriveChain component. Anyone can make
a bridge for DriveChain, the ones directly supported by this project include:

 - [Fresco Bridge]
 - [OkHTTP Bridge]
 - [Stetho Bridge]
 - [LeakCanary Bridge]
 - [Joda Bridge]
 - [DebugDrawer Bridge]

[Fresco Bridge]:/fresco-bridge
[OkHTTP Bridge]:/okhttp-bridge
[Stetho Bridge]:/stetho-bridge
[LeakCanary Bridge]:/leakcanary-bridge
[Joda Bridge]:/joda-bridge
[DebugDrawer Bridge]:/debugdrawer-bridge