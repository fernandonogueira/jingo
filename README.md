# Jingo

Jingo is a lightweight Java API to make it easy to access Microsoft Bing Maps and Geocoding features.

 [![codecov](https://codecov.io/gh/fernandonogueira/jingo/branch/master/graph/badge.svg)](https://codecov.io/gh/fernandonogueira/jingo)

### Binaries

[![](https://jitpack.io/v/fernandonogueira/jingo.svg)](https://jitpack.io/#fernandonogueira/jingo)

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

### LICENSE
```
MIT License

Copyright (c) 2017 Fernando Nogueira

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```