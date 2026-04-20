# Getting Started with Burger 🍔

This guide will help you get started with developing features for Burger!

## Prerequisites

- Java 21 or higher
- A Java IDE (IntelliJ IDEA recommended, Eclipse also works)
- Basic knowledge of Java and Minecraft modding

## Setting Up Your Development Environment

### 1. Clone/Download the Project

If you haven't already, download or clone this repository.

### 2. Import into Your IDE

#### IntelliJ IDEA
1. Open IntelliJ IDEA
2. File → Open → Select the `Burger` folder
3. Wait for Gradle to sync
4. Run `genSources` Gradle task to generate Minecraft source code

#### Eclipse
1. Open Eclipse
2. File → Import → Gradle → Existing Gradle Project
3. Select the `Burger` folder
4. Wait for Gradle to sync

### 3. Run the Mod

Run the `runClient` Gradle task to launch Minecraft with your mod!

## Project Structure

```
Burger/
├── src/main/java/com/burger/
│   ├── BurgerMod.java          # Main mod class (entry point)
│   ├── config/
│   │   └── BurgerConfig.java   # Configuration system
│   ├── features/
│   │   └── WelcomeMessage.java # Example feature
│   ├── mixins/
│   │   └── package-info.java   # Mixin classes go here
│   └── utils/
│       └── Utils.java          # Utility methods
└── src/main/resources/
    ├── fabric.mod.json         # Mod metadata
    ├── burger.mixins.json      # Mixin configuration
    └── assets/burger/
        └── icon.png            # Mod icon
```

## Creating Your First Feature

### 1. Create a Feature Class

Create a new class in `src/main/java/com/burger/features/`:

```java
package com.burger.features;

import com.burger.BurgerMod;

public class MyFeature {
    
    public static void init() {
        BurgerMod.LOGGER.info("MyFeature initialized!");
        
        // Your initialization code here
    }
    
    // Add your feature methods here
}
```

### 2. Initialize Your Feature

Add it to `BurgerMod.init()`:

```java
private void init() {
    BurgerConfig.load();
    WelcomeMessage.init();
    MyFeature.init();  // Add this line
}
```

### 3. Test Your Feature

Run the `runClient` Gradle task and test your feature in-game!

## Common Tasks

### Adding a Config Option

1. Add a field to `BurgerConfig.java`:
```java
public boolean myFeatureEnabled = true;
```

2. Use it in your feature:
```java
if (BurgerConfig.getInstance().myFeatureEnabled) {
    // Do something
}
```

### Creating a Mixin

1. Create a mixin class in `src/main/java/com/burger/mixins/`:
```java
package com.burger.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SomeMinecraftClass.class)
public class SomeMinecraftClassMixin {
    
    @Inject(method = "someMethod", at = @At("HEAD"))
    private void onSomeMethod(CallbackInfo ci) {
        // Your code here
    }
}
```

2. Register it in `burger.mixins.json`:
```json
{
  "mixins": [],
  "client": [
    "SomeMinecraftClassMixin"
  ]
}
```

### Listening to Events

Use Fabric API's event system:

```java
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

ClientTickEvents.END_CLIENT_TICK.register(client -> {
    // Runs every tick
});
```

## Useful Resources

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Minecraft Forge Documentation](https://docs.minecraftforge.net/)
- [SpongePowered Mixin Docs](https://github.com/SpongePowered/Mixin/wiki)
- [Fabric API Javadocs](https://maven.fabricmc.net/docs/fabric-api-0.100.0+1.21/)

## Tips

1. **Use the logger**: `BurgerMod.LOGGER.info("message")` for debugging
2. **Check if in game**: Always use `Utils.isInGame()` before accessing player/world
3. **Test on Hypixel**: Use `Utils.isOnHypixel()` to check if on Hypixel
4. **Save your config**: Call `BurgerConfig.save()` after changing config values
5. **Hot reload**: Use `/reload` command in-game to reload some changes without restarting

## Building for Production

Run the build task:
```bash
./gradlew build
```

Your mod will be in `build/libs/burger-1.0.0+1.21.jar`

## Need Help?

- Check existing features for examples
- Read the Fabric Wiki
- Ask in Minecraft modding communities

Happy modding! 🍔
