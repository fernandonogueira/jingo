# Jingo

Jingo is a lightweight Java API to make it easy to access Microsoft Bing Maps and Geocoding features. 

### Dependency

#### Gradle
```groovy
repositories {
  jcenter()
  maven { url "https://jitpack.io" }
}
dependencies {
  compile 'com.github.fernandonogueira:jingo:x.y.z'
}
```

#### Maven

```xml
...
<dependencies>
    ...
    <dependency>
        <groupId>com.github.fernandonogueira</groupId>
        <artifactId>jingo</artifactId>
        <version>x.y.z</version>
    </dependency>
    ...
</dependencies>
...
<repositories>
    ...
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
    ...
</repositories>
...

```

### Example

```java
...
    public void simpleGeocoding() {
        JingoGeocoder jingo = new JingoGeocoder("yourKey");
        
        Query query = givenAnSimpleQuery();
        SimpleQuery query = new SimpleQuery();
        query.setQuery("Some Street Address, Some Country");
        JingoResult<GeocodeResource> result = jingo.geocode(query);
    }
...

```