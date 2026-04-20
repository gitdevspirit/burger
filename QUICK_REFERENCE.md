# Burger Quick Reference 🍔

## Essential Commands

```bash
# Setup (first time)
./setup.sh                    # Linux/Mac
gradlew.bat wrapper           # Windows

# Development
./gradlew runClient           # Run Minecraft with mod
./gradlew build               # Build release JAR
./gradlew clean               # Clean build files
./gradlew genSources          # Generate Minecraft sources

# IDE Setup
./gradlew idea                # IntelliJ IDEA
./gradlew eclipse             # Eclipse
```

## File Locations

| What | Where |
|------|-------|
| Main mod class | `src/main/java/com/burger/BurgerMod.java` |
| Features | `src/main/java/com/burger/features/` |
| Mixins | `src/main/java/com/burger/mixins/` |
| Config | `src/main/java/com/burger/config/` |
| Utils | `src/main/java/com/burger/utils/` |
| Mod metadata | `src/main/resources/fabric.mod.json` |
| Mixin config | `src/main/resources/burger.mixins.json` |
| Build config | `build.gradle` |
| Versions | `gradle.properties` |

## Code Snippets

### Create a Feature
```java
package com.burger.features;

public class MyFeature {
    public static void init() {
        // Initialize
    }
}

// Then add to BurgerMod.init()
```

### Add Config Option
```java
// In BurgerConfig.java
public boolean myOption = true;

// Use it
BurgerConfig.getInstance().myOption
```

### Send Chat Message
```java
Utils.sendMessage("Hello!");
```

### Listen to Events
```java
ClientTickEvents.END_CLIENT_TICK.register(client -> {
    // Every tick
});
```

### Create Mixin
```java
@Mixin(SomeClass.class)
public class SomeClassMixin {
    @Inject(method = "method", at = @At("HEAD"))
    private void onMethod(CallbackInfo ci) {
        // Your code
    }
}
// Register in burger.mixins.json
```

### Check Game State
```java
if (Utils.isInGame()) {
    if (Utils.isOnHypixel()) {
        if (Utils.isOnSkyblock()) {
            // Do Skyblock stuff
        }
    }
}
```

### Log Messages
```java
BurgerMod.LOGGER.info("Message");
BurgerMod.LOGGER.warn("Warning");
BurgerMod.LOGGER.error("Error", exception);
```

## Useful Fabric Events

```java
// Client tick
ClientTickEvents.END_CLIENT_TICK.register(...)

// Join server
ClientPlayConnectionEvents.JOIN.register(...)

// Leave server
ClientPlayConnectionEvents.DISCONNECT.register(...)

// Key input
ClientTickEvents.END_CLIENT_TICK.register(...)

// Chat message
ChatEvent.RECEIVED.register(...)
```

## Common Minecraft Classes

| Class | What it does |
|-------|-------------|
| `Minecraft` | Main game instance |
| `LocalPlayer` | The player |
| `ClientLevel` | The world |
| `ItemStack` | An item |
| `Component` | Chat text |
| `Screen` | GUI screen |

## Version Numbers

| Component | Version |
|-----------|---------|
| Minecraft | 1.21 |
| Fabric Loader | 0.16.5 |
| Fabric API | 0.102.0+1.21 |
| Java | 21 |
| Gradle | 8.10.2 |

## Troubleshooting

| Problem | Solution |
|---------|----------|
| Java too old | Install Java 21+ |
| Mod doesn't load | Check `fabric.mod.json` |
| Mixin doesn't work | Check `burger.mixins.json` |
| Build fails | Run `./gradlew clean` |
| IDE issues | Reimport project |

## Documentation Files

- `README.md` - Quick overview
- `PROJECT_OVERVIEW.md` - Complete guide
- `GETTING_STARTED.md` - Development tutorial
- `FEATURES.md` - Feature documentation
- `QUICK_REFERENCE.md` - This file

## Need Help?

1. Check the documentation files
2. Read the example code
3. Check Fabric Wiki
4. Ask in Minecraft modding communities

---

**Keep this handy while developing!** 🍔
