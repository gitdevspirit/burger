# Burger Features 🍔

This document outlines what's included in the Burger client.

## Core Components

### Main Mod Class (`BurgerMod.java`)
- Entry point for the mod
- Initializes all features and systems
- Provides utility methods for creating ResourceLocations
- Handles client ticking

### Configuration System (`BurgerConfig.java`)
- JSON-based configuration
- Automatically saves and loads from `config/burger.json`
- Easy to extend with new config options
- Example config fields included

### Utilities (`Utils.java`)
- Common helper methods for mod development
- Player and world access
- Chat message sending
- Hypixel detection
- Skyblock detection (basic implementation)

## Included Features

### Welcome Message Feature
Located in: `com.burger.features.WelcomeMessage`

**What it does:**
- Sends a welcome message when you join a server
- Displays the mod version
- Detects if you're on Hypixel

**How to customize:**
Edit the `sendWelcomeMessage()` method to change the message

**Can be disabled:**
Set `exampleFeatureEnabled` to `false` in the config

## Example Mixin

### TitleScreenMixin
Located in: `com.burger.mixins.TitleScreenMixin`

**What it does:**
- Logs to console when the title screen loads
- Demonstrates how to create and register mixins

**How to add more mixins:**
1. Create a new class in the `mixins` package
2. Add the `@Mixin` annotation
3. Inject into methods using `@Inject`
4. Register in `burger.mixins.json`

## Project Structure

```
Burger/
├── gradle/                     # Gradle wrapper files
├── src/main/
│   ├── java/com/burger/
│   │   ├── BurgerMod.java     # Main mod class
│   │   ├── config/            # Configuration system
│   │   ├── features/          # Feature implementations
│   │   ├── mixins/            # Mixin classes
│   │   └── utils/             # Utility classes
│   └── resources/
│       ├── assets/burger/     # Mod assets
│       ├── burger.mixins.json # Mixin configuration
│       └── fabric.mod.json    # Mod metadata
├── build.gradle               # Build configuration
├── gradle.properties          # Project properties
├── settings.gradle            # Gradle settings
├── LICENSE                    # MIT License
├── README.md                  # Main readme
├── GETTING_STARTED.md         # Development guide
└── FEATURES.md               # This file
```

## What's NOT Included

This is a **clean slate** client. The following are intentionally NOT included:

- ❌ Dungeon features
- ❌ Mining helpers
- ❌ Combat utilities
- ❌ Item overlays
- ❌ Slayer features
- ❌ Economy trackers
- ❌ Custom GUIs/HUDs
- ❌ Waypoints
- ❌ Enchanting solvers
- ❌ Party/Guild features

**This is by design!** Start fresh and add only what you need.

## Adding Your Own Features

### Step 1: Create Feature Class
```java
package com.burger.features;

public class MyFeature {
    public static void init() {
        // Your initialization code
    }
}
```

### Step 2: Initialize in BurgerMod
```java
private void init() {
    BurgerConfig.load();
    WelcomeMessage.init();
    MyFeature.init(); // Add here
}
```

### Step 3: Add Config Options (Optional)
```java
// In BurgerConfig.java
public boolean myFeatureEnabled = true;
```

## Planned Features (Ideas)

Here are some ideas for features you could add:

### Skyblock Specific
- Dungeon map overlay
- Slayer tracker
- Mining helper (Powder, HotM, etc.)
- Fishing helper
- Foraging tracker
- Custom item tooltips

### Quality of Life
- Custom HUD elements
- Waypoint system
- Party/Guild management
- Economy tracker
- Bazaar/AH utilities

### Visual
- Custom overlays
- ESP for items/entities
- Coordinate display
- Performance monitor

### Combat
- Target helper
- DPS meter
- Cooldown tracker
- Combat stats display

## Building Your Feature

1. Plan what you want to create
2. Identify what Minecraft events/classes you need
3. Create mixins if needed
4. Implement your feature
5. Add config options
6. Test thoroughly!

## Contributing

Feel free to:
- Add new features
- Improve existing code
- Fix bugs
- Enhance documentation
- Share your fork!

## Version History

### v1.0.0 (Initial Release)
- Basic mod structure
- Configuration system
- Utilities
- Example feature (Welcome Message)
- Example mixin (Title Screen)
- Complete documentation

---

**Remember:** This is YOUR client. Make it exactly what YOU need! 🍔
