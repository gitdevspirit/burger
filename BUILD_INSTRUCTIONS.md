# Building Burger from Source

This guide explains how to build Burger from source code.

## Prerequisites

- **Java 21 or higher** ([Download](https://adoptium.net/))
- **Git** ([Download](https://git-scm.com/downloads))
- Internet connection (for downloading dependencies)

## Quick Build

```bash
# Clone the repository
git clone https://github.com/yourusername/burger.git
cd burger

# Make gradlew executable (Linux/Mac)
chmod +x gradlew

# Build the mod
./gradlew build

# Find your JAR
ls build/libs/
```

The built JAR will be at `build/libs/burger-1.0.0+1.21.jar`

## Step-by-Step Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/burger.git
cd burger
```

### 2. Verify Java Version

```bash
java -version
```

Should show Java 21 or higher.

### 3. Build

**Linux/Mac:**
```bash
chmod +x gradlew
./gradlew build
```

**Windows:**
```bash
gradlew.bat build
```

### 4. Locate the JAR

The compiled mod will be in:
```
build/libs/burger-1.0.0+1.21.jar
```

## Development Build

For development with IDE integration:

### IntelliJ IDEA

```bash
./gradlew idea genSources
```

Then:
1. Open IntelliJ IDEA
2. File → Open → Select the `burger` folder
3. Wait for Gradle sync
4. Run the `runClient` Gradle task

### Eclipse

```bash
./gradlew eclipse genSources
```

Then:
1. Open Eclipse
2. File → Import → Gradle → Existing Gradle Project  
3. Select the `burger` folder
4. Run the `runClient` Gradle task

### VS Code

```bash
./gradlew genSources
```

Then:
1. Open VS Code
2. Install "Extension Pack for Java"
3. Open the `burger` folder
4. Use the Gradle sidebar to run tasks

## Running in Development

To test the mod:

```bash
./gradlew runClient
```

This launches Minecraft with your mod loaded.

## Build Tasks

| Task | Description |
|------|-------------|
| `build` | Compiles and builds the JAR |
| `clean` | Removes build files |
| `runClient` | Runs Minecraft with the mod |
| `genSources` | Generates Minecraft source code |
| `idea` | Generates IntelliJ IDEA project files |
| `eclipse` | Generates Eclipse project files |

## Troubleshooting

### "Java version is too old"

Install Java 21 or higher from [Adoptium](https://adoptium.net/)

### "Permission denied: gradlew"

Run:
```bash
chmod +x gradlew
```

### "Could not resolve dependencies"

Check your internet connection and try:
```bash
./gradlew build --refresh-dependencies
```

### Build fails with errors

1. Clean the build:
   ```bash
   ./gradlew clean
   ```

2. Try again:
   ```bash
   ./gradlew build
   ```

3. If still failing, check:
   - Java version is 21+
   - Internet connection is working
   - No firewall blocking Gradle

### IDE not recognizing Minecraft classes

Run:
```bash
./gradlew genSources
```

Then reimport/refresh the project in your IDE.

## Clean Build

For a completely fresh build:

```bash
./gradlew clean build
```

## Build for Release

To build a release version:

```bash
./gradlew clean build
```

The JAR at `build/libs/burger-1.0.0+1.21.jar` is ready for distribution.

## Continuous Integration

The project includes GitHub Actions for automatic builds:

- Builds on every push to main/master
- Builds on pull requests
- Uploads artifacts
- Creates release assets on GitHub releases

See `.github/workflows/build.yml` for configuration.

## Next Steps

After building:

1. Test the JAR in Minecraft
2. Read [GETTING_STARTED.md](GETTING_STARTED.md) for development
3. Check [CONTRIBUTING.md](CONTRIBUTING.md) for contribution guidelines

---

**Happy building!** 🍔

If you encounter issues, please open an issue on [GitHub](https://github.com/yourusername/burger/issues).
