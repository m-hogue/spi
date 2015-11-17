# spi
Really quick test of [java.util.ServiceLoader](http://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html) 
to determine how difficult it is for people writing plugins for your software.

Followed this [example](https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#define-the-service-provider-interface).

Requirements:

  Build jar that contains: 
 
- implementation for desired interfaces
- [registration for all service providers](https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#register-service-providers) 
in the META-INF/services directory, packaged with the plugin. This is specifying which class(es) in your plugin jar implement
which interfaces.
