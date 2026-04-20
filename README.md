# Burger 🍔

[![Build](https://github.com/yourusername/burger/actions/workflows/build.yml/badge.svg)](https://github.com/yourusername/burger/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Minecraft](https://img.shields.io/badge/minecraft-1.21-green.svg)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/mod%20loader-fabric-blue.svg)](https://fabricmc.net/)

A fresh, clean Minecraft 1.21 Skyblock client built from the ground up!

## ✨ Features

Currently a clean slate - ready for your custom modules and features!

- ✅ **Clean Architecture** - Well-organized, documented codebase
- ✅ **Configuration System** - JSON-based config management
- ✅ **Example Feature** - Welcome message demonstration
- ✅ **Example Mixin** - Title screen mixin example
- ✅ **Utility Classes** - Common helper methods included
- ✅ **Extensible** - Easy to add new features

## 📥 Installation

### For Players

1. Download the latest release from [Releases](https://github.com/yourusername/burger/releases)
2. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21
3. Download [Fabric API](https://modrinth.com/mod/fabric-api/versions?g=1.21)
4. Place both JARs in your `.minecraft/mods` folder
5. Launch Minecraft 1.21 with Fabric

### For Developers

See [GETTING_STARTED.md](GETTING_STARTED.md) for development setup.

## 🔧 Building

To build Burger from source:

```bash
git clone https://github.com/yourusername/burger.git
cd burger
./gradlew build
```

The built JAR will be in `build/libs/burger-1.0.0+1.21.jar`

## 📚 Documentation

- **[Getting Started](GETTING_STARTED.md)** - Development setup and tutorial
- **[Project Overview](PROJECT_OVERVIEW.md)** - Complete developer guide
- **[Features](FEATURES.md)** - Feature documentation and ideas
- **[Quick Reference](QUICK_REFERENCE.md)** - Developer cheat sheet
- **[Contributing](CONTRIBUTING.md)** - How to contribute
- **[Changelog](CHANGELOG.md)** - Version history

## 🚀 Quick Start for Developers

```bash
# Clone and setup
git clone https://github.com/yourusername/burger.git
cd burger
./setup.sh  # Linux/Mac
# or
gradlew.bat wrapper  # Windows

# Generate Minecraft sources
./gradlew genSources

# Run the mod
./gradlew runClient
```

## 🎯 What's Included

- **Core Mod System** - Entry point, tick handling, event system
- **Configuration** - JSON-based config with auto-save/load
- **Utilities** - Hypixel detection, chat helpers, player checks
- **Example Feature** - Welcome message feature
- **Example Mixin** - Title screen injection
- **Complete Docs** - 5 comprehensive documentation files

## 🎨 What's NOT Included

This is a **clean slate** by design. No bloat, no unnecessary features:

- No dungeon modules
- No mining helpers  
- No combat utilities
- No item overlays
- No slayer features

**Add only what YOU need!**

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

### Ways to Contribute

- 🐛 Report bugs
- 💡 Suggest features
- 📝 Improve documentation
- 🔧 Submit pull requests
- ⭐ Star this repository

## 📋 Requirements

- **Minecraft**: 1.21
- **Fabric Loader**: 0.16.5+
- **Fabric API**: 0.102.0+1.21
- **Java**: 21+

## 📜 License

This project is licensed under the MIT License - see [LICENSE](LICENSE) for details.

## 🙏 Credits

Built with inspiration from the Minecraft modding community.

## 📞 Support

- **Issues**: [GitHub Issues](https://github.com/yourusername/burger/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/burger/discussions)
- **Documentation**: See docs folder

## 🗺️ Roadmap

- [ ] Add example dungeon helper
- [ ] Create config GUI
- [ ] Add more utility classes
- [ ] Improve documentation
- [ ] Add more examples

See [CHANGELOG.md](CHANGELOG.md) for version history.

---

**Made with ❤️ for the Hypixel Skyblock community**

**Start building your perfect Skyblock client today!** 🍔
