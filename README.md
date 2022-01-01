# grand-node-java-client

**A JVM client for GrandNode2 API**

---

| Icon |                Item                 |
|:----:|:-----------------------------------:|
|  📺  |       [**Preview**](#Preview)       |
|  📱  | [**Compatibility**](#Compatibility) |
|  💻  |         [**Usage**](#Usage)         |
|  📩  |      [**Download**](#Download)      |
|  📋  |      [**Features**](#Features)      |
|  🧾  |     [**Changelog**](#Changelog)     |
|  ⚖️  |       [**License**](#License)       |

---

## Preview

grand-node-java-client is a JVM client for GrandNode2 API and aims to provide a high level of abstraction for using its
APIs.

This project is powered by [Retrofit](https://github.com/square/retrofit)
and [Project Lombok](https://github.com/projectlombok/lombok)
therefore it's easy to use if you are already familiar with them, but it's also limited by their constraints. However,
since `Retrofit` is a highly customizable library and this project doesn't prevent you from customizing it, you can form
a custom client by changing various properties of the Retrofit instance(like `OkHttpClient`, `baseUrl`, etc.).

This library uses a custom `CallAdapter` for its API calls (`CallX`) which is an extended version of Retrofit's `Call`
with some additional methods so this is an aspect of the library that is not customizable.

## Compatibility

**JVM11+**

## Usage

[![javadoc](https://javadoc.io/badge2/com.github.TradersTeam/grand-node-java-client/javadoc.svg)](https://javadoc.io/doc/com.github.TradersTeam/grand-node-java-client)

### Quick Guide

1. Create a client instance from `GrandNodeClient` class and customize it if you want with the help of `builder` method.
2. Create a service instance related to the API you want to use by calling `create` method on the client.
3. Call the service's methods(different type of API calls defined for each API service).
4. Handle the response using various callbacks that are provided by `Retrofit` and other custom callbacks(`CallX`).

---

### Java

```java

```

more examples [here](https://github.com/TradersTeam/grand-node-java-client/tree/master/example-java)

---

### Kotlin

```kotlin

```

more examples [here](https://github.com/TradersTeam/grand-node-java-client/tree/master/example-kotlin)

## Download

Find the latest version
from [Maven Artifact](https://repo1.maven.org/maven2/io/github/TradersTeam/grand-node-java-client/maven-metadata.xml)

### Gradle Groovy DSL

**Step 1.** Add the Maven repository to your build file  
Add it in your root build.gradle at the end of repositories:

```groovy
repositories {
    mavenCentral()
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    implementation 'io.github.TradersTeam:grand-node-java-client:$last_version'
}
```

### Maven

Add the dependency

```xml

<dependency>
    <groupId>io.github.TradersTeam</groupId>
    <artifactId>grand-node-java-client</artifactId>
    <version>$last_version</version>
    <type>aar</type>
</dependency>  
```

### Gradle Kotlin DSL

```groovy
dependencies {
    implementation("io.github.TradersTeam:grand-node-java-client:$last_version")
}
```

## Features

- Usable in JVM only (Java, Kotlin, etc.) projects
- Usable in Android projects
- Custom lambda callbacks for handling the response

### Supported APIs

- [ ] [BrandAPI](https://github.com/TradersTeam/grand-node-java-client/issues/28)
- [ ] BrandLayoutAPI
- [ ] [CategoryAPI](https://github.com/TradersTeam/grand-node-java-client/issues/33)
- [ ] CategoryLayoutAPI
- [ ] CollectionAPI
- [ ] CollectionLayoutAPI
- [ ] CountryAPI
- [ ] CurrencyAPI
- [ ] CustomerAPI
- [ ] CustomerGroupAPI
- [ ] DeliveryDateAPI
- [ ] LanguageAPI
- [ ] MetadataAPI
- [ ] PickupPointAPI
- [ ] PictureAPI
- [ ] ProductAPI
- [ ] ProductAttributeAPI
- [ ] ProductLayoutAPI
- [ ] ShippingMethodAPI
- [ ] SpecificationAttributeAPI
- [ ] StateProvinceAPI
- [ ] StoreAPI
- [ ] VendorAPI
- [ ] WarehouseAPI

## Changelog

- 1.0.0 - Initial alpha release
- 1.0.1 - WIP
- 1.0.2 - WIP
- 1.0.3 - WIP
- 1.0.4 - WIP

## License

> grand-node-java-client is licensed under the **[GNU General Public License v3.0](./LICENSE)**  
> Permissions of this strong copyleft license are conditioned on making  
> available complete source code of licensed works and modifications,  
> which include larger works using a licensed work, under the same  
> license. Copyright and license notices must be preserved. Contributors  
> provide an express grant of patent rights.
