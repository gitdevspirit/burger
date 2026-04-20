# Burger Mod - Project Overview 🍔

## What is Burger?

Burger is a **clean, fresh Minecraft 1.21 Skyblock client** built from scratch using the Fabric mod loader. Unlike other Skyblock mods that come packed with dozens of features, Burger gives you a clean slate to build exactly what you need.

## Key Characteristics

✅ **Clean & Minimal** - No bloat, no unnecessary features  
✅ **Well-Documented** - Every file includes comments and documentation  
✅ **Beginner-Friendly** - Perfect for learning Minecraft modding  
✅ **Production-Ready** - Proper structure and best practices  
✅ **Extensible** - Easy to add new features and modules  

## Quick Start

### Prerequisites
- Java 21 or higher
- Git (optional)
- An IDE (IntelliJ IDEA recommended)

### Setup (Linux/Mac)
```bash
chmod +x setup.sh
./setup.sh
```

### Setup (Windows)
```bash
gradlew.bat wrapper --gradle-version 8.10.2
gradlew.bat genSources
```

### Run the Mod
```bash
./gradlew runClient       # Linux/Mac
gradlew.bat runClient     # Windows
```

## Project Structure Explained

### Core Files

#### `BurgerMod.java` - The Heart of Your Mod
This is the main entry point. When Minecraft loads, it calls:
1. `onInitializeClient()` - Initializes everything
2. `tick()` - Called every game tick (20 times per second)
3. `init()` - Initializes all your features

**Key methods:**
- `id(String)` - Creates ResourceLocations with the "burger" namespace
- Registers tick events
- Loads configuration

#### `BurgerConfig.java` - Configuration Management
Handles saving and loading mod settings to/from JSON.

**Features:**
- Automatic JSON serialization
- Saves to `config/burger.json`
- Easy to add new config fields

**Example usage:**
```java
if (BurgerConfig.getInstance().exampleFeatureEnabled) {
    // Do something
}
```

#### `Utils.java` - Helper Methods
Common utilities used throughout the mod.

**Includes:**
- `getPlayer()` - Get the local player
- `getLevel()` - Get the current world
- `isInGame()` - Check if in a world
- `sendMessage()` - Send chat messages
- `isOnHypixel()` - Detect Hypixel server
- `isOnSkyblock()` - Detect Skyblock (basic)

### Feature System

#### `features/WelcomeMessage.java` - Example Feature
Demonstrates how to create a feature.

**Key concepts:**
- Static `init()` method for initialization
- Event registration (ClientPlayConnectionEvents)
- Config integration
- Chat message formatting

**To create a new feature:**
1. Copy this file as a template
2. Rename the class
3. Implement your logic
4. Call `YourFeature.init()` in `BurgerMod.init()`

### Mixin System

#### `mixins/TitleScreenMixin.java` - Example Mixin
Shows how to inject code into Minecraft.

**What are mixins?**
Mixins let you modify Minecraft's code without directly editing it. You "inject" your code into Minecraft's methods.

**To create a mixin:**
1. Create a class in the `mixins` package
2. Add `@Mixin(TargetClass.class)` annotation
3. Use `@Inject` to inject into methods
4. Register in `burger.mixins.json`

**Example:**
```java
@Mixin(SomeClass.class)
public class SomeClassMixin {
    @Inject(method = "someMethod", at = @At("HEAD"))
    private void beforeSomeMethod(CallbackInfo ci) {
        // Runs before someMethod
    }
}
```

## Configuration Files

### `fabric.mod.json` - Mod Metadata
Defines your mod's identity.

**Important fields:**
- `id` - Mod ID (must be unique)
- `name` - Display name
- `version` - Replaced by Gradle at build time
- `entrypoints.client` - Points to `BurgerMod`
- `mixins` - Points to mixin config
- `depends` - Required dependencies

### `burger.mixins.json` - Mixin Configuration
Lists all your mixin classes.

**Sections:**
- `mixins` - Server-side mixins (empty for client-only mod)
- `client` - Client-side mixins

### `build.gradle` - Build Configuration
Defines how to build your mod.

**Key parts:**
- Dependencies (Minecraft, Fabric API)
- Java version (21)
- Build tasks

### `gradle.properties` - Project Properties
Version numbers and settings.

**Important values:**
- `minecraft_version` - 1.21
- `loader_version` - Fabric Loader version
- `fabric_api_version` - Fabric API version
- `mod_version` - Your mod's version

## Development Workflow

### 1. Adding a New Feature

```java
// 1. Create the feature class
package com.burger.features;

public class MyFeature {
    public static void init() {
        // Initialize your feature
    }
}

// 2. Add to BurgerMod.init()
private void init() {
    BurgerConfig.load();
    WelcomeMessage.init();
    MyFeature.init(); // Add this
}
```

### 2. Adding Configuration Options

```java
// 1. Add to BurgerConfig.java
public boolean myFeatureEnabled = true;
public int myFeatureSetting = 100;

// 2. Use in your feature
if (BurgerConfig.getInstance().myFeatureEnabled) {
    int value = BurgerConfig.getInstance().myFeatureSetting;
}

// 3. Save changes
BurgerConfig.save();
```

### 3. Creating a Mixin

```java
// 1. Create mixin class
package com.burger.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerClass.class)
public class PlayerClassMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        // Your code here
    }
}

// 2. Register in burger.mixins.json
{
  "client": [
    "TitleScreenMixin",
    "PlayerClassMixin"  // Add this
  ]
}
```

### 4. Testing Your Changes

```bash
./gradlew runClient
```

This launches Minecraft with your mod loaded.

### 5. Building for Release

```bash
./gradlew build
```

Find your mod JAR in `build/libs/burger-1.0.0+1.21.jar`

## Common Patterns

### Event Handling
```java
ClientTickEvents.END_CLIENT_TICK.register(client -> {
    // Runs every tick
});

ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
    // Runs when joining a server
});
```

### Scheduled Tasks
```java
new Thread(() -> {
    try {
        Thread.sleep(1000); // Wait 1 second
        doSomething();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}).start();
```

### Chat Messages
```java
// Simple text
Utils.sendMessage("Hello!");

// Formatted text
Component msg = Component.literal("Burger")
    .withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD));
Utils.sendMessage(msg);
```

## Debugging Tips

### 1. Use the Logger
```java
BurgerMod.LOGGER.info("Debug message");
BurgerMod.LOGGER.warn("Warning message");
BurgerMod.LOGGER.error("Error message", exception);
```

### 2. Check Logs
Logs are in `run/logs/latest.log`

### 3. Hot Reload
Some changes don't require restarting:
```
/reload
```

### 4. Breakpoints
Set breakpoints in your IDE and run in debug mode

## File Locations

- **Config**: `run/config/burger.json` (in dev), `config/burger.json` (production)
- **Logs**: `run/logs/`
- **Crash Reports**: `run/crash-reports/`
- **Screenshots**: `run/screenshots/`

## Version Information

- **Minecraft**: 1.21
- **Fabric Loader**: 0.16.5
- **Fabric API**: 0.102.0+1.21
- **Java**: 21
- **Gradle**: 8.10.2

## Resources

- [Fabric Wiki](https://fabricmc.net/wiki/) - Official Fabric documentation
- [Fabric API Docs](https://maven.fabricmc.net/docs/fabric-api-0.100.0+1.21/)
- [Mixin Docs](https://github.com/SpongePowered/Mixin/wiki)
- [Minecraft Wiki](https://minecraft.wiki/)

## Troubleshooting

### "Java version is too old"
Install Java 21 or higher

### "Could not find fabric-api"
Check your internet connection and `gradle.properties`

### Mod doesn't load
Check `fabric.mod.json` for errors

### Mixin doesn't work
1. Check class name is correct
2. Verify it's registered in `burger.mixins.json`
3. Check method signature matches

### Config not saving
Make sure to call `BurgerConfig.save()` after changes

## What's Next?

Now that you understand the project structure, you can:

1. **Learn by Example** - Study the WelcomeMessage feature
2. **Read GETTING_STARTED.md** - Step-by-step development guide
3. **Check FEATURES.md** - Ideas for new features
4. **Start Coding!** - Build your dream Skyblock client

## Philosophy

Burger follows these principles:

- **Simplicity First** - Keep it simple and readable
- **Document Everything** - Future you will thank present you
- **Quality Over Quantity** - Do one thing well
- **User Choice** - Config options for everything
- **Clean Code** - Follow Java best practices

## License

MIT License - Do whatever you want with this code!

---

**Built with ❤️ for the Hypixel Skyblock community**

Happy modding! 🍔
