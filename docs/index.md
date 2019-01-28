---
layout: page
---

An Easier way to use Android Libraries
======================================

DriveChain is an Android Framework focused on making libraries
more functional, easier to use, and with less boilerplate.

Philosophy
----------

The core idea of DriveChain is to reduce library installations
to as few lines of code as possible.

To do this, DriveChain leans on the new functionality provided by
[Dagger] and Android's [Architecture Components] to automatically create
components that know more about when you application starts up, eliminating
the need for adding code into your Application and Activity classes to start
using a Library.

[Dagger]: https://google.github.io/dagger/
[Architecture Components]: https://developer.android.com/topic/libraries/architecture/index.html

How Does it Work?
-----------------

DriveChain leverages Dagger2's Multibinds to create dynamic 
collections of dependencies and connect them to the Application's events.
This works like an event bus, allowing Libraries to automatically listen
to events in your application without the need to explicitly call anything.

Ready to Start?
---------------

Follow our [Setup Guide] to start using DriveChain.

[Setup Guide]:/start
