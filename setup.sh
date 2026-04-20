#!/bin/bash

echo "🍔 Burger Mod - Setup Script 🍔"
echo "================================"
echo ""

# Check if Java is installed
echo "Checking for Java 21..."
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed!"
    echo "Please install Java 21 or higher from: https://adoptium.net/"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 21 ]; then
    echo "❌ Java version is too old! Found Java $JAVA_VERSION"
    echo "Please install Java 21 or higher from: https://adoptium.net/"
    exit 1
fi

echo "✅ Java $JAVA_VERSION found!"
echo ""

# Setup Gradle
echo "Setting up Gradle..."
chmod +x gradlew
echo "✅ Gradle wrapper configured!"
echo ""

# Generate sources
echo "Generating Minecraft sources..."
echo "This may take a few minutes on first run..."
./gradlew genSources

if [ $? -eq 0 ]; then
    echo "✅ Sources generated successfully!"
else
    echo "❌ Failed to generate sources"
    echo "Please check your internet connection and try again"
    exit 1
fi

echo ""
echo "✅ Setup complete!"
echo ""
echo "Next steps:"
echo "1. Import the project into your IDE (IntelliJ IDEA or Eclipse)"
echo "2. Wait for the IDE to finish indexing"
echo "3. Run the 'runClient' Gradle task to launch Minecraft"
echo ""
echo "Read GETTING_STARTED.md for detailed instructions!"
echo ""
echo "Happy modding! 🍔"
