# Moshi-Moshi

***Light and primitive StackWalker-esque API for Java 8 or below.***

#### For Developers:

```
repositories {
    maven {
        url "https://maven.cleanroommc.com"
    }
}

dependencies {
    compile ("com.cleanroommc:moshi-moshi:1.0")
}
```

- Recommended way to use this API is to shade it into your own application/jar. This API won't really update, therefore there shouldn't be any concerns of class conflicts.
- You can use the [Shadow Plugin](https://github.com/johnrengelman/shadow) to shade dependencies.
- For `Gradle 4.x` users, getting the plugin to work might be fiddly, here's a quick and dirty way to shade dependencies:

```
configurations {
    embed
    implementation.extendsFrom(embed)
}

...

dependencies {
    embed ("com.cleanroommc:moshi-moshi:1.0") // See embed here instead of compile as shown above.
}

jar {
    from (configurations.embed.collect { it.isDirectory() ? it : zipTree(it) })
}
```
